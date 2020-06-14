// ******************************************************************************
//
// Copyright (c) 2020 by
// Scheidt & Bachmann System Technik GmbH, 24109 Melsdorf
//
// All rights reserved. The reproduction, distribution and utilisation of this document
// as well as the communication of its contents to others without explicit authorisation
// is prohibited. Offenders will be held liable for the payment of damages.
// All rights reserved in the event of the grant of a patent, utility model or design.
// (DIN ISO 16016:2007-12, Section 5.1)
//
// Alle Rechte vorbehalten. Weitergabe sowie Vervielfältigung dieses Dokuments,
// Verwertung und Mitteilung seines Inhalts sind verboten, soweit nicht ausdrücklich
// gestattet. Zuwiderhandlungen verpflichten zu Schadenersatz. Alle Rechte für den
// Fall der Patent-, Geschmacks- und Gebrauchsmustererteilung vorbehalten.
// (DIN ISO 16016:2007-12, Abschnitt 5.1)
//
// ******************************************************************************

package util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;

/**
 * Base-class of EMF adapters for target objects of a specific class.
 *
 * The target type is part of the type of adapters, and the getTarget method is
 * overridden with a more specific return type for type safe access of the
 * target. The notifyChanged method is overridden with an empty default
 * implementation, so it can be omitted for adapters that do not react to change
 * notifications.
 *
 * This class also provides static methods to access adapters of objects and
 * their contents. Specific object adapter classes may provide specialized
 * methods with a simpler interface.
 *
 * @param <T> target type
 *
 */
public class ObjectAdapter<T extends EObject> implements Adapter {

	private static final class ContainerIterator implements Iterator<EObject> {
		private EObject next;

		public ContainerIterator(final EObject object) {
			next = object.eContainer();
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public EObject next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			final EObject result = next;
			next = next.eContainer();
			return result;
		}
	}

	/**
	 * Provides access to object adapters registered with EMF objects.
	 *
	 * The type of the object passed as first argument must be compatible with the
	 * target type of the queried adapter. As a consequence, we cannot accidentally
	 * query an adapter on an object that does not match its target type.
	 *
	 * Specific object adapter classes may provide a specialized version with a
	 * simpler interface by calling this method with the appropriate class.
	 *
	 * @param <T>      target type of queried adapter
	 * @param <A>      type of queried adapter
	 * @param object   EMF object
	 * @param adapterC class representing the type of the queried adapter
	 *
	 * @return first adapter of specified type
	 *
	 * @throws NoSuchElementException if no such adapter exists
	 */
	public static <T extends EObject, A extends ObjectAdapter<? super T>> //
	A from(final T object, final Class<? extends A> adapterC) {
		return object.eAdapters().stream() //
				.filter(adapterC::isInstance) //
				.map(adapterC::cast) //
				.findFirst().orElseThrow();
	}

	/**
	 * Provides access to object adapters of EMF objects contained in the given root
	 * object.
	 *
	 * The target and adapter classes are used to find an appropriate adapter. The
	 * type of the target class needs to be compatible with the target type of the
	 * queried adapter.
	 *
	 * Specific object adapter classes may provide a specialized version with a
	 * simpler interface by calling this method with the appropriate classes.
	 *
	 * @param <T>      target type of queried adapter
	 * @param <A>      type of queried adapter
	 * @param root     EMF object containing other objects with queried adapters
	 * @param targetC  class representing the target type
	 * @param adapterC class representing the adapter type
	 *
	 * @return first adapter of specified type on any matching content object
	 *
	 * @throws NoSuchElementException if no such adapter exists
	 */
	public static <T extends EObject, A extends ObjectAdapter<? super T>> //
	A fromContents(final EObject root, final Class<? extends T> targetC, final Class<? extends A> adapterC) {
		return fromAny(root.eAllContents(), targetC, adapterC);
	}

	/**
	 * Provides access to object adapters of EMF objects that contain the given
	 * child object.
	 *
	 * The target and adapter classes are used to find an appropriate adapter. The
	 * type of the target class needs to be compatible with the target type of the
	 * queried adapter.
	 *
	 * Specific object adapter classes may provide a specialized version with a
	 * simpler interface by calling this method with the appropriate classes.
	 *
	 * @param <T>      target type of queried adapter
	 * @param <A>      type of queried adapter
	 * @param child    EMF object (directly or indirectly) contained in another
	 *                 object with queried adapters
	 * @param targetC  class representing the target type
	 * @param adapterC class representing the adapter type
	 *
	 * @return first adapter of specified type on any matching container object
	 *
	 * @throws NoSuchElementException if no such adapter exists
	 */
	public static <T extends EObject, A extends ObjectAdapter<? super T>> //
	A fromContainer(final EObject child, final Class<? extends T> targetC, final Class<? extends A> adapterC) {
		return fromAny(new ContainerIterator(child), targetC, adapterC);
	}

	/**
	 * Provides access to object adapters of any of the given objects.
	 *
	 * The target and adapter classes are used to find an appropriate adapter. The
	 * type of the target class needs to match the target type of the queried
	 * adapter.
	 *
	 * Specific object adapter classes may provide a specialized version with a
	 * simpler interface by calling this method with the appropriate classes.
	 *
	 * @param <T>      target type of queried adapter
	 * @param <A>      type of queried adapter
	 * @param iterator iterates over EMF objects with queried adapters
	 * @param targetC  class representing the target type
	 * @param adapterC class representing the adapter type
	 *
	 * @return first adapter of specified type on any matching object
	 *
	 * @throws NoSuchElementException if no such adapter exists
	 */
	public static <T extends EObject, A extends ObjectAdapter<? super T>> //
	A fromAny(final Iterator<EObject> iterator, final Class<? extends T> targetC, final Class<? extends A> adapterC) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false) //
				.filter(targetC::isInstance) //
				.map(targetC::cast) //
				.map(target -> from(target, adapterC)) //
				.findFirst().orElseThrow();
	}

	private final Class<T> targetC;
	private T target;

	/**
	 * Creates a typed adapter for EMF model instances of the given class.
	 *
	 * @param targetC class representing type of target objects
	 */
	public ObjectAdapter(final Class<T> targetC) {
		this.targetC = targetC;
		this.target = null;
	}

	@Override
	public void notifyChanged(final Notification notification) {
	}

	@Override
	public T getTarget() {
		return target;
	}

	@Override
	public void setTarget(final Notifier newTarget) {
		if (targetC.isInstance(newTarget)) {
			target = targetC.cast(newTarget);
		}
	}

	@Override
	public boolean isAdapterForType(final Object type) {
		return targetC.isInstance(type);
	}
}
