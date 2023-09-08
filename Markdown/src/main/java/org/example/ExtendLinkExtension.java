package org.example;

import org.commonmark.Extension;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlRenderer;

public class ExtendLinkExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension {
    public static Extension create() {
        return new ExtendLinkExtension();
    }

    @Override
    public void extend(Parser.Builder builder) {
        //builder.customDelimiterProcessor(new ExtendLinkDelimiterProcessor('{', '}'));
        //builder.inlineParserFactory(ExtendLinkParser::new);
    }

    @Override
    public void extend(HtmlRenderer.Builder builder) {
        //builder.attributeProviderFactory(ExtendLinkAttributeProvider::new);
        builder.nodeRendererFactory(ExtendLinkHtmlNodeRenderer::new);
    }
}
