package org.example;

import org.commonmark.node.Node;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.SourceLines;

public class ExtendLinkParser implements InlineParser {
    private InlineParserContext context;

    public ExtendLinkParser(InlineParserContext context){
        this.context = context;
    }

    @Override
    public void parse(SourceLines sourceLines, Node node) {

    }
}
