package com.visa.prj.dao;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DbConfig {
    private static final String BUNDLE_NAME = "database"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private DbConfig() {
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
