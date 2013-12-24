package com.vedantu.ei.utils;

import java.util.Collection;

public class StringUtils {

	public static final String EMPTY = "";

	public static boolean isEmpty(String input) {

		return null == input || input.isEmpty();

	}

	public static <E> boolean isEmpty(Collection<E> inputList) {

		return null == inputList || inputList.isEmpty();

	}
}
