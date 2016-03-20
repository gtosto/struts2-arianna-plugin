package tests;

import junit.framework.Assert;

import junit.framework.TestCase;
import org.apache.struts2.StrutsTestCase;
import xyz.timedrain.arianna.plugin.AriannaPlugin;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class AriannaPluginTest extends StrutsTestCase {


//    public void testVersion() throws Exception {
//        URI uri = new File("D:\\myprojects\\oss\\struts2-arianna-plugin\\struts2-arianna-plugin\\target\\struts2-arianna-plugin-REF1.jar").toURI();
//
//        URLClassLoader cl = new URLClassLoader(new URL[] {uri.toURL()});
//
//        Class<AriannaPlugin> aClass = (Class<AriannaPlugin>) cl.loadClass("xyz.timedrain.arianna.plugin.AriannaPlugin");
//
//        Package aPackage = aClass.getPackage();
//
//
//        AriannaPlugin plugin = aClass.newInstance();
//
//        int maxCrumbs = plugin.getDefaultMaxCrumbs();
//        assertTrue(maxCrumbs == 6);
//
//        String version = plugin.getVersion();
//        Assert.assertNotNull(version);
//    }

    public void testPluginVersion() {
        AriannaPlugin plugin = configuration.getContainer().getInstance(AriannaPlugin.class, "arianna");

        Assert.assertNotNull("AriannaPlugin NOT FOUND", plugin);

        int maxCrumbs = plugin.getDefaultMaxCrumbs();
        // assertTrue(maxCrumbs == 6);

        String version = plugin.getVersion();
        String name = plugin.getTitle();

        Assert.assertNotNull(version);
        Assert.assertNotNull(name);
    }
}
