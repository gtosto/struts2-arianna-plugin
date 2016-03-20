package xyz.timedrain.arianna.showcase.actions;

import xyz.timedrain.arianna.plugin.BreadCrumb;
import xyz.timedrain.arianna.plugin.RewindMode;

//@BreadCrumb(value="Home",rewind=RewindMode.NEVER)
public class HomeAction extends ShowcaseAction {

    @BreadCrumb("Home")
    public String execute() {
        return SUCCESS;
    }


    public String getPluginInfo() {
        Package pkg = Package.getPackage("xyz.timedrain.arianna");
        return String.format("%s - %s", pkg.getSpecificationTitle(), pkg.getSpecificationVersion());
    }

}
