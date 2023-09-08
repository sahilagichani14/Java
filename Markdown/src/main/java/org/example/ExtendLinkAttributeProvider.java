package org.example;

import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;

import java.util.Map;

public class ExtendLinkAttributeProvider implements AttributeProvider {

    private AttributeProviderContext context;

    public ExtendLinkAttributeProvider(AttributeProviderContext context){
        this.context = context;
    }

    @Override
    public void setAttributes(Node node, String s, Map<String, String> map) {
        if (node instanceof Link) {
            String id = ((Text)node.getNext().getFirstChild()).getLiteral();
            map.put("id", id.replace("#", ""));
            //map.put("href", extendLinkCustomNodeDelimited.getDestination());
            //map.put("title", extendLinkCustomNodeDelimited.getTitle());
            //map.put("id", extendLinkCustomNodeDelimited.getId());
        }
    }
}
