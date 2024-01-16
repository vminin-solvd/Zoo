package com.solvd.zoo.threads;

import com.solvd.zoo.utils.ConnectionPool;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            MockConnection conn = pool.getConnection();
            conn.use();
            Thread.sleep(1000);
            pool.releaseConnection(conn);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}