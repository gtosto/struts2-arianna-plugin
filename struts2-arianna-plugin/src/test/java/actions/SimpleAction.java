package actions;

import xyz.timedrain.arianna.plugin.BreadCrumb;

@BreadCrumb("simple")
public class SimpleAction {

	public String execute() throws Exception {
		System.out.printf("executing action: %s", SimpleAction.class.getName());
		return null;
	}

}
