package com.vedantu.ei.managers.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class ManagerFactory {

	public static final ManagerFactory INSTANCE = new ManagerFactory();

	private Map<String, IManager> managersMap;

	private ManagerFactory() {
		managersMap = new HashMap<String, IManager>();
		Properties prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("managers.properties"));

			for (Entry<Object, Object> entry : prop.entrySet()) {

				managersMap.put(
						entry.getKey().toString().trim(),
						(IManager) Class.forName(
								entry.getValue().toString().trim())
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
