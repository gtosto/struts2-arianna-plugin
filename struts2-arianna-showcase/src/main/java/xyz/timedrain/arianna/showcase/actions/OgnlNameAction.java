package xyz.timedrain.arianna.showcase.actions;


import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import xyz.timedrain.arianna.plugin.BreadCrumb;



public class OgnlNameAction extends ShowcaseAction {

    private String name;

    @RequiredStringValidator(message = "a name is required")
    @RequiredFieldValidator(message = "a crumb name is required !")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @BreadCrumb("%{name}")
    public String execute() {
        return "success";
    }

}
