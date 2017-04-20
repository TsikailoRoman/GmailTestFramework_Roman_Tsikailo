package com.epam.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerManager {
    private static Logger LOGGER = LogManager.getRootLogger();

    static void log(String message) {
        LOGGER.error(message);
    }
}
