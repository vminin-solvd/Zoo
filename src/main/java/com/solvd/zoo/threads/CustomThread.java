package com.solvd.zoo.threads;

import com.solvd.zoo.utils.ConnectionPool;

public class CustomThread extends Thread {
    @Override
    public void run() {
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            MockConnection conn = pool.getConnection();
            conn.use();
            pool.releaseConnection(conn);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
