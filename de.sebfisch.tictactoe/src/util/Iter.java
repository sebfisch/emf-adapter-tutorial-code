package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides static methods creating iterable collections.
 */
public class Iter {

	/**
	 * Creates an iterable collection of non-negative integers below the given
	 * limit.
	 *
	 * @param size number of non-negative integers below size
	 * @return integers from 0 to size-1
	 */
	public static Iterable<Integer> range(final int size) {
		return () -> new Range(size);
	}

	/**
	 * Implementation of a range iterator.
	 */
	public static class Range implements Iterator<Integer> {
		private final int size;
		private int next;

		public Range(final int size) {
			this.size = size;
			next = 0;
		}

		@Override
		public boolean hasNext() {
			return next < size;
		}

		@Override
		public Integer next() {
			if (hasNext()) {
				return next++;
			} else {
				throw new NoSuchElementException();
			}
		}
	}
}
