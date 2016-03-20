package xyz.timedrain.arianna.showcase.actions;


import xyz.timedrain.arianna.plugin.*;

public class OverridingActions extends ShowcaseAction {

    @BreadCrumb("Test")
    public String useTest() {
        return SUCCESS;
    }

    @BreadCrumb(
            value = "Test",
            rewind = RewindMode.NEVER)
    public String useRewindModeNEVER() {
        return SUCCESS;
    }

    @BreadCrumb(
            value = "Test",
            rewind = RewindMode.AUTO)
    public String useRewindModeAUTO() {
        return SUCCESS;
    }

    @BreadCrumb(
            value = "Test",
            comparator = NameComparator.class)
    public String useNameComparator() {
        return SUCCESS;
    }

    @BreadCrumb(
            value = "Test",
            comparator = ActionComparator.class)
    public String useActionComparator() {
        return SUCCESS;
    }

    @BreadCrumb(
            value = "Test",
            comparator = RequestComparator.class)
    public String useRequestComparator() {
        return SUCCESS;
    }

}
