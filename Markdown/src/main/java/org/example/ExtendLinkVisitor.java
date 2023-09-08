package org.example;

import org.commonmark.node.AbstractVisitor;

import java.util.regex.Pattern;

public class ExtendLinkVisitor extends AbstractVisitor {

    private static final Pattern regex_pattern = Pattern.compile("");

    //some logic with regex to set Destination. title, id  before we visit our all node
    public void visit(ExtendLinkCustomNodeDelimited extendLinkCustomNodeDelimited){
        this.visitChildren(extendLinkCustomNodeDelimited);
    }
}
