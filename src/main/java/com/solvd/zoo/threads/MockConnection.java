package com.solvd.zoo.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MockConnection {

    private static final Logger LOGGER = LogManager.getLogger(MockConnection.class);
    private static int count = 0;
    private int id;

    public MockConnection() {
        this.id = ++count;
    }

    public void use() {
        LOGGER.info("Using MockConnection " + id);
    }

    public int getId() {
        return id;
    }
}

