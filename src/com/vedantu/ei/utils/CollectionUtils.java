package com.vedantu.ei.utils;

import java.util.Collection;
import java.util.Map;

public class CollectionUtils {

	public static boolean isEmpty(Collection collection) {
		return null == collection || collection.isEmpty();
	}
	
	public static boolean isEmpty(Map map) {
		return null == map || map.isEmpty();
	}

}
