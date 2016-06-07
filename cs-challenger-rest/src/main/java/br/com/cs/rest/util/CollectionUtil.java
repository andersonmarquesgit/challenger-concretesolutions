package br.com.cs.rest.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class CollectionUtil {
	public static boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}

	public static <T> Set<T> createSet(T... elementos) {
		Set<T> set = new HashSet<>();

		if (elementos != null && elementos.length != 0) {
			for (T element : elementos) {
				set.add(element);
			}
		}

		return set;
	}

	public static <T> List<T> createList(T... elementos) {

		List<T> list;

		if (elementos == null || elementos.length == 0) {
			list = new LinkedList<>();
		} else {

			list = new ArrayList<>(elementos.length);
			for (T element : elementos) {
				list.add(element);
			}

		}

		return list;
	}
}
