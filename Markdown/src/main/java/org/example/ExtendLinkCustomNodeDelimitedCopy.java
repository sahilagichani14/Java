package org.example;

import org.commonmark.node.CustomNode;
import org.commonmark.node.Delimited;
import org.commonmark.node.Visitor;

public class ExtendLinkCustomNodeDelimitedCopy extends CustomNode implements Delimited {

    private String destination;
    private String title;
    private String id;

    private final String openDelimiter;
    private final String closeDelimiter;

    public ExtendLinkCustomNodeDelimitedCopy(String openDelimiter, String closeDelimiter) {
        this.openDelimiter = openDelimiter;
        this.closeDelimiter = closeDelimiter;
        this.destination = destination;
        this.title = title;
        this.id = id;
    }
    @Override
    public String getOpeningDelimiter() {
        return this.getOpeningDelimiter();
    }

    @Override
    public String getClosingDelimiter() {
        return this.getClosingDelimiter();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    protected String toStringAttributes() {
        return "destination=" + this.getDestination() + ", title=" + this.getTitle() + ", id=" + this.getId();
    }
}
