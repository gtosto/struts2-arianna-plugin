package tests;

import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;

import xyz.timedrain.arianna.plugin.BreadCrumbTrail;
import xyz.timedrain.arianna.plugin.Crumb;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.util.profiling.UtilTimerStack;

public class TestRequestParameters extends BreadcrumbTestCase {

    @Override
    protected void setUp() throws Exception {
//        UtilTimerStack.setActive(true);
        System.setProperty("xwork.profile.activate", "true");
        super.setUp();
    }

    public void testSimpleParameters() throws Exception {

        sessionMap = new HashMap();

        request.setParameter("par1", "val1");
        request.setParameter("par2", "val2");
        request.setParameter("array1", new String[] {"a","b"});
        
        ActionProxy proxy = getActionProxy("/c-SimpleAction.do");
        
        String rc = proxy.execute();

        BreadCrumbTrail breadCrumbTrail = getBreadCrumbTrail(sessionMap);

        /*
         * assert that a breadcrumb trail has been stored and that it contains
         * at least a crumb
         */
        assertNotNull("No breadcrumb trail in session", breadCrumbTrail);
        assertTrue(breadCrumbTrail.getCrumbs().size() > 0);

        
        Crumb crumb = breadCrumbTrail.getCrumbs().get(0);
        
        assertNotNull(crumb.getParams());
        assertTrue(crumb.getParams().size() > 0);
        assertArrayEquals((Object[])crumb.getParams().get("par1"), new Object[] {"val1"});
        assertArrayEquals((Object[])crumb.getParams().get("par2"), new Object[] {"val2"});
        
        assertArrayEquals((Object[])crumb.getParams().get("array1"), new Object[] {"a","b"});
        
        System.out.printf("crumbs: %s", breadCrumbTrail.getCrumbs());
    }
    
    

}
