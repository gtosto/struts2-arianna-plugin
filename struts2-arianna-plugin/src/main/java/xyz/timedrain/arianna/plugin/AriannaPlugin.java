/*
 *  Copyright 2011 - Giovanni Tosto
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package xyz.timedrain.arianna.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Properties;
import java.util.jar.Manifest;

import com.opensymphony.xwork2.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Arianna plugin struts2 bean.
 *
 * @author Giovanni Tosto
 */
public class AriannaPlugin {

    private static final Logger LOG = LogManager.getLogger(BreadCrumbInterceptor.class);

    int maxCrumbs = 6;

	Properties p = new Properties();
	Package packageInfo;
    
    public AriannaPlugin() {
        LOG.info("Initializing Arianna Plugin {} ...",this);

        // FIXME the package API seems work only when packaged in a jar/war archive 
        packageInfo = getClass().getPackage();
        LOG.info("{} : {}", getTitle(), getVersion());
    }
    
    public static void main(String[] args) {
        System.out.println("This is the Struts2 Arianna Plugin");
        AriannaPlugin plugin = new AriannaPlugin();
        System.out.println("Package Info = " + plugin.getTitle() + " " + plugin.getVersion());
    }

    @Inject("arianna:maxCrumbs")
    protected void setMaxCrumbs(String v) {
        maxCrumbs = Integer.parseInt(v);
    }

    final public String getVersion() {
        return "" + packageInfo.getImplementationVersion();
    }

    final public String getTitle() {
        return "" + packageInfo.getImplementationTitle();
    }

    public int getDefaultMaxCrumbs() {
        return maxCrumbs;
    }

    /**
     * Returns an instance of a comparatator of the required <var>class</var>.
     * <p>
     * Despite its name this method does not perform any lookup, it instead will
     * try to create a new instance using the clazz.newInstance().
     *
     * @param clazz
     * @return an instance of the desired Crumb Comparator or null if a such
     * comparator cannot be created.
     * <p>
     * TODO garbage collector is very fairy but we really need a way to
     * reuse / pool comparator instances. Using the struts2
     * ObjectFactory could be helps.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected Comparator<Crumb> lookupComparatorByClass(Class clazz) {

        try {
            Comparator instance = (Comparator) clazz.newInstance();
            return instance;
        } catch (ClassCastException e) {
            LOG.error(clazz + " is not assignable to " + Comparator.class, e);
        } catch (InstantiationException e) {
            LOG.error("Cannot create comparator of class " + clazz, e);
        } catch (IllegalAccessException e) {
            LOG.error("Cannot create comparator of class " + clazz, e);
        }

        return null;

    }

    protected Comparator<Crumb> lookupComparatorByClass(String className) {

        try {
            Class<?> clazz = Class.forName(className);
            return lookupComparatorByClass(clazz);
        } catch (ClassNotFoundException e) {
            LOG.error("Cannot create comparator of class " + className, e);
            return null;
        }
    }
    
    
}
