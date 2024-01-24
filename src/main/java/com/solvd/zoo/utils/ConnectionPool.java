package com.solvd.zoo.utils;

import com.solvd.zoo.threads.CustomThread;
import com.solvd.zoo.threads.MockConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

    private final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static volatile ConnectionPool instance = null;
    private static final int INITIAL_POOL_SIZE = 5;
    private final BlockingQueue<MockConnection> availableConnections;

    public ConnectionPool() {
        availableConnections = new LinkedBlockingQueue<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            availableConnections.add(new MockConnection());
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public MockConnection getConnection() throws InterruptedException {
        return availableConnections.take();
    }

    public void releaseConnection(MockConnection connection) {
        availableConnections.offer(connection);
        LOGGER.info("Released Connection: " + connection.getId());
    }
}


