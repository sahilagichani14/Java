package org.example;

import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlWriter;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class ExtendLinkHtmlNodeRenderer implements NodeRenderer {

    private final HtmlNodeRendererContext context;

    private final HtmlWriter html;

    public ExtendLinkHtmlNodeRenderer(final HtmlNodeRendererContext context){
        this.context = context;
        this.html = context.getWriter();
    }
    @Override
    public Set<Class<? extends Node>> getNodeTypes() {
        return Collections.singleton(ExtendLinkCustomNodeDelimited.class);
    }

    @Override
    public void render(Node node) {
        if (node instanceof ExtendLinkCustomNodeDelimited) {
            //ExtendLinkVisitor extendLinkVisitor = new ExtendLinkVisitor();
            //node.accept(extendLinkVisitor);
            final String tag = "a";

//            Node previous = node.getParent().getFirstChild();
//            if (previous instanceof Link) {
//                final Map<String, String> previousAttributes = this.context.extendAttributes(previous, tag, Collections.emptyMap());
//                previousAttributes.put("id", ((Text)node.getFirstChild()).getLiteral());
//            }

            final Map<String, String> attributes = this.context.extendAttributes(node, tag, Collections.emptyMap());
            //attributes.put("href", ((ExtendLinkCustomNodeDelimited)node).getDestination());
            //attributes.put("title", ((ExtendLinkCustomNodeDelimited)node).getTitle());
            //attributes.put("id", ((ExtendLinkCustomNodeDelimited)node).getId());
            this.html.tag(tag, attributes);
            renderChildren(node);
            this.html.tag("/" + tag);
        }
    }

    private void renderChildren(Node parent) {
        Node node = parent.getFirstChild();
        while (node!=null){
            final Node next = node.getNext();
            this.context.render(node);
            node = next;
        }
    }
}
