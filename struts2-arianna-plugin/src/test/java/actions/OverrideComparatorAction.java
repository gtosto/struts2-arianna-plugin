package actions;

import xyz.timedrain.arianna.plugin.BreadCrumb;

import comparators.TrueComparator;

@BreadCrumb(value = "OverrideComparatorAction", comparator = TrueComparator.class)
public class OverrideComparatorAction {

    public String execute() {
        return null;
    }
}
