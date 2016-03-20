import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;


public class RewindAction implements SessionAware {
    private Map<String, Object> session;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void setSession(Map session) {
        this.session = session;
    }

    public String execute() {
        BreadCrumbTrail trail = session.get(BreadCrumbInterceptor.CRUMB_KEY);
        trail.rewindAt(-1);
    }
}
