package com.hongghe.mysql.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author hongghe 2018/12/29
 */
@Slf4j
@WebListener
public class IndexListener implements ServletContextListener {

    /**
     * * Notification that the web application initialization process is starting.
     * All ServletContextListeners are notified of context initialization before
     * any filter or servlet in the web application is initialized.
     * The default implementation is a NO-OP.
     *
     * @param sce Information about the ServletContext that was initialized
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.error("[indexListener]Now is begin!");
    }

    /**
     * * Notification that the servlet context is about to be shut down. All
     * servlets and filter have been destroy()ed before any
     * ServletContextListeners are notified of context destruction.
     * The default implementation is a NO-OP.
     *
     * @param sce Information about the ServletContext that was destroyed
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
