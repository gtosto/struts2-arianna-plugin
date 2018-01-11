package xyz.timedrain.arianna.showcase.actions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.config.entities.ActionConfig;
import com.opensymphony.xwork2.config.entities.InterceptorMapping;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;

import xyz.timedrain.arianna.plugin.*;

public class Controls extends ShowcaseAction implements SessionAware {
    private static final long serialVersionUID = 1L;

    static final Logger LOG = LogManager.getLogger(Controls.class);

    private Map<String, Object> session;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void setSession(Map session) {
        this.session = session;
    }

    private Boolean clear = true;

    String comparatorKey;

    RewindMode rewindMode;

    Integer maxCrumbs;

    //
    public String reconfigure() {

        BreadCrumbInterceptor interceptor = getBreadCrumbInterceptor();
        if (interceptor != null) {
            BreadCrumbTrail breadCrumbTrail = getBreadCrumbTrail();
            LOG.info("reconfiguring trail " + breadCrumbTrail.getName());

            LOG.info("maxcrumbs = " + breadCrumbTrail.getMaxCrumbs());

            // update maxcrumbs
            breadCrumbTrail.setMaxCrumbs(maxCrumbs);

            // update default comparator
            Comparator<Crumb> comparator = getAllComparators().get(comparatorKey);
            interceptor.setDefaultComparator(comparator);

            // update default rewindMode
            interceptor.setDefaultRewindMode(rewindMode);

            if (clear == true) {
                breadCrumbTrail.rewindAt(-1);
                LOG.info("breadcrumb trial cleared, size: " + breadCrumbTrail.getCrumbs().size());
            }

            addActionMessage("Breadcrumb has been reconfigured");
            
            /*
             * Fix some strange replication issue when running on
             * google GAE infrastructure.
             */
            session.put(BreadCrumbInterceptor.CRUMB_KEY, breadCrumbTrail);

            LOG.info("stored trail in session" + breadCrumbTrail);

            return SUCCESS;
        }

        return ERROR;
    }

    @SkipValidation
    public String clearTrail() {
        // rewinding at -1 is equivalent to a clear
        BreadCrumbTrail trail = getBreadCrumbTrail();
        trail.rewindAt(-1);

        /*
         * Fix some some strange replication issue when running on 
         * google GAE infrastructure.
         */
        session.put(BreadCrumbInterceptor.CRUMB_KEY, trail);

        return SUCCESS;
    }

    @SkipValidation
    public String init() {
        Map<String, Comparator<Crumb>> allComparators = (Map<String, Comparator<Crumb>>) session
                .get("allComparators");
        if (allComparators == null) {
            allComparators = new HashMap<String, Comparator<Crumb>>();
            allComparators.put("Name Comparator", new NameComparator());
            allComparators.put("Action Comparator", new ActionComparator());
            allComparators.put("Request Comparator", new RequestComparator());
            session.put("allComparators", allComparators);
        }

        rewindMode = getBreadCrumbInterceptor().getDefaultRewindMode();

        Comparator<Crumb> defaultComparator = getBreadCrumbInterceptor().getDefaultComparator();
        for (Map.Entry<String, Comparator<Crumb>> entry : allComparators.entrySet()) {
            if (defaultComparator.getClass() == entry.getValue().getClass()) {
                comparatorKey = entry.getKey();
            }
        }

        return null;
    }

    // Helpers and utilities
    ///////////////////////////////////////////////////////////////////////////

    /**
     * lookup the BreadCrumbInterceptor
     *
     * @return the BreadCrumbInterceptor or <code>null</code> if not found
     */
    protected BreadCrumbInterceptor getBreadCrumbInterceptor() {

        ActionConfig config = ActionContext.getContext().getActionInvocation()
                .getProxy().getConfig();

        for (InterceptorMapping mapping : config.getInterceptors()) {
            Interceptor interceptor = mapping.getInterceptor();

            if (interceptor instanceof BreadCrumbInterceptor && "breadCrumbs".equals(mapping.getName())) {
                return (BreadCrumbInterceptor) interceptor;
            }
        }

        return null;
    }

    /**
     * Retrieve the BreadCrumbTrail
     *
     * @return
     */
    public BreadCrumbTrail getBreadCrumbTrail() {
        if (session != null)
            return (BreadCrumbTrail) session
                    .get(BreadCrumbInterceptor.CRUMB_KEY);

        return null;
    }

    public Map<String, Comparator<Crumb>> getAllComparators() {
        return (Map<String, Comparator<Crumb>>) session.get("allComparators");
    }

    // Others getters and setters
    ///////////////////////////////////////////////////////////////////////////

    public String getComparatorKey() {
        return comparatorKey;
    }

    public void setComparatorKey(String comparatorKey) {
        this.comparatorKey = comparatorKey;
    }

    public RewindMode getRewindMode() {
        return rewindMode;
    }

    public void setRewindMode(RewindMode rewindMode) {
        this.rewindMode = rewindMode;
    }

    public Boolean isClear() {
        return clear;
    }

    public void setClear(Boolean clear) {
        this.clear = clear;
    }

    @ExpressionValidator(
            expression = "maxCrumbs > 0 and maxCrumbs < 20",
            message = "Sorry, in this showcase application, maxCrumbs must be between 1 and 20")
    public Integer getMaxCrumbs() {
        return maxCrumbs;
    }

    public void setMaxCrumbs(Integer maxCrumbs) {
        this.maxCrumbs = maxCrumbs;
    }

}
