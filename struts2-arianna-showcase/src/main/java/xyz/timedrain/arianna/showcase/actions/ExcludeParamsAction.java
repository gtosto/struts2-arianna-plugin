package xyz.timedrain.arianna.showcase.actions;

import xyz.timedrain.arianna.plugin.BreadCrumb;


public class ExcludeParamsAction extends ShowcaseAction {

    String p;

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    @BreadCrumb(value="DiscardQ", dropParams={"q.+"})
    public String discardQ() {
    	return SUCCESS;
    }

//    @BreadCrumb(value="KeepP", keepParams={"p.+"})
//    public String keepP() {
//    	return SUCCESS;
//    }
    
}
