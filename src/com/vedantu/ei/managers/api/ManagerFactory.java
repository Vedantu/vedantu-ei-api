package com.vedantu.ei.managers.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class ManagerFactory {

	public static final ManagerFactory INSTANCE = new ManagerFactory();

	/* <String, IManager> */
	private Map managersMap;

	private ManagerFactory() {
		managersMap = new HashMap();
		Properties prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("managers.properties"));

			Iterator propEntryIterator = prop.entrySet().iterator();
			while (propEntryIterator.hasNext()) {
				Map.Entry entry = (Map.Entry)propEntryIterator.next();
				managersMap.put(entry.getKey().toString().trim(), Class
						.forName(entry.getValue().toString().trim())
						.newInstance());
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public IUserManager getUserManager() {
		return (IUserManager) managersMap.get("user.manager.class");
	}

	public IUploadManager getUploadManager() {
		return (IUploadManager) managersMap.get("upload.manager.class");
	}

}
