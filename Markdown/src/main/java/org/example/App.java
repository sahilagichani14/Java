package org.example;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.List;

public class App {

    public static void main(String[] args) {
        // Define your custom extension
        //MyCustomLinkExtension customLinkExtension = new MyCustomLinkExtension();

        // Create a CommonMark parser with the custom extension
        Parser parser = Parser.builder()
                .customDelimiterProcessor(new ExtendLinkDelimiterProcessor('{','}'))
                //.extensions(List.of(ExtendLinkExtension.create()))
                .build();

        // Parse the Markdown content
        String markdown = "[Sample Link](http://example.com 'title'){#hellotest}";

        Node document = parser.parse(markdown);

        // Create an HTML renderer
        HtmlRenderer renderer = HtmlRenderer.builder()
                .attributeProviderFactory(ExtendLinkAttributeProvider::new)
                .nodeRendererFactory(ExtendLinkHtmlNodeRenderer::new)
                //.extensions(List.of(ExtendLinkExtension.create()))
                .build();

        // Render the HTML with the custom attributes
        String html = renderer.render(document);
        System.out.println(html);
    }
}

//class MyCustomLinkExtension implements CustomNode, Visitor {
//    @Override
//    public void accept(Visitor visitor) {
//        Node node = this;
//        while (node != null) {
//            if (node instanceof Link) {
//                // Modify the Link node to add an 'id' attribute
//                Link linkNode = (Link) node;
//                linkNode.setAttr("id", "custom-id"); // Change "custom-id" to your desired ID value
//            }
//            node = node.getNext();
//        }
//    }
//}
