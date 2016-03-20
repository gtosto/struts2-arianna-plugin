package xyz.timedrain.arianna.showcase.actions;

import xyz.timedrain.arianna.plugin.BreadCrumb;

@BreadCrumb("P-Action")
public class ParameterizedAction extends ShowcaseAction {

    String p;

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

}
