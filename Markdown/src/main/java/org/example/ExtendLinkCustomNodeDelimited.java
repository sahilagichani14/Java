package org.example;

import org.commonmark.node.CustomNode;
import org.commonmark.node.Delimited;

public class ExtendLinkCustomNodeDelimited extends CustomNode implements Delimited {

    private final String openDelimiter;
    private final String closeDelimiter;

    public ExtendLinkCustomNodeDelimited(String openDelimiter, String closeDelimiter) {
        this.openDelimiter = openDelimiter;
        this.closeDelimiter = closeDelimiter;
    }

    public String getOpenDelimiter() {
        return openDelimiter;
    }

    public String getCloseDelimiter() {
        return closeDelimiter;
    }

    @Override
    public String getOpeningDelimiter() {
        return this.getOpeningDelimiter();
    }

    @Override
    public String getClosingDelimiter() {
        return this.getClosingDelimiter();
    }

}
