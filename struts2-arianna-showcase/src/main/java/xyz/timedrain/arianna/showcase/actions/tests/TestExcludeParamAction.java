package xyz.timedrain.arianna.showcase.actions.tests;

import com.opensymphony.xwork2.ActionSupport;

import xyz.timedrain.arianna.plugin.BreadCrumb;

public class TestExcludeParamAction extends ActionSupport {

	/** This breadcrumb doesn't store parameters matching the excludedParams regexps 
	 * 
	 */
	@BreadCrumb(value="%{#attr['struts.actionMapping'].name}", dropParams = {"p.+","q.+(o|a)"} )
	public String execute() throws Exception {
		// TODO Auto-generated method stub		
		return super.execute();
	}

}
