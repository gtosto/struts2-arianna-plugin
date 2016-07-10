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

import java.util.Comparator;

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
    private Version version;

    public AriannaPlugin() {
        LOG.info("Initializing Arianna Plugin : " + this);

//        // load plugin version from pom file,
//        // for some reason, the API Package doesn't seem work to me
//        try {
//            Properties p = new Properties();
//            InputStream is = getClass().getResourceAsStream("/META-INF/MANIFEST.MF");
//            p.load(is);
//            specificationVersion = p.getProperty("Specification-Version");
//            specificationTitle = p.getProperty("Specification-Title");
//        } catch (Exception e) {
//            LOG.warn("Unable to set plugin's version infos (reason: " + e.getMessage() + ")");
//        }
    }

    public static void main(String[] args) {
        System.out.println("This is the Struts2 Arianna Plugin");
        AriannaPlugin plugin = new AriannaPlugin();
        String version = plugin.getVersion();
        System.out.println("Version: " + version);
    }

    @Inject("arianna:maxCrumbs")
    protected void setMaxCrumbs(String v) {
        maxCrumbs = Integer.parseInt(v);
    }

    public String getVersion() {
        return version.VERSION;
    }

    public String getTitle() {
        return version.ARTIFACT_ID;
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
