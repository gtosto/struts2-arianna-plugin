package xyz.timedrain.arianna.showcase.gae;

import ognl.OgnlRuntime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by gtosto on 10-Apr-16.
 */
public class Struts2Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    public void contextInitialized(ServletContextEvent sce) {
        OgnlRuntime.setSecurityManager(null);
    }

//    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

//    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
    }

//    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
    }

//    @Override
    public void attributeAdded(HttpSessionBindingEvent arg0) {
    }

//    @Override
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
    }

//    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
    }
}
