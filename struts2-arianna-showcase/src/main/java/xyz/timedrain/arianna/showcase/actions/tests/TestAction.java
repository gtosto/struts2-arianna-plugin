package xyz.timedrain.arianna.showcase.actions.tests;

import com.opensymphony.xwork2.ActionSupport;

import xyz.timedrain.arianna.plugin.BreadCrumb;

public class TestAction extends ActionSupport {

	@Override
	@BreadCrumb("%{#attr['struts.actionMapping'].name}")
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

}
