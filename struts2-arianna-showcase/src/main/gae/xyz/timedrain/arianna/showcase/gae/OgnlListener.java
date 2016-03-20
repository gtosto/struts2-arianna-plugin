package xyz.timedrain.arianna.showcase.gae;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ognl.OgnlRuntime;

public class OgnlListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent event) {
    }

    public void contextInitialized(ServletContextEvent event) {
        OgnlRuntime.setSecurityManager(null);
    }

}
