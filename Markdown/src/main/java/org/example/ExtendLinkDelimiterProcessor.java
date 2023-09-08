package org.example;

import org.commonmark.node.*;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

public class ExtendLinkDelimiterProcessor implements DelimiterProcessor {

    private final char openDelimiter;

    private final char closeDelimiter;

    public ExtendLinkDelimiterProcessor(char openDelimiter, char closeDelimiter) {
        this.openDelimiter = openDelimiter;
        this.closeDelimiter = closeDelimiter;
    }

    @Override
    public char getOpeningCharacter() {
        return this.openDelimiter;
    }

    /**
     * @return the character that marks the the ending of a delimited node, must not clash with any built-in special
     * characters. Note that for a symmetric delimiter such as "*", this is the same as the opening.
     */
    @Override
    public char getClosingCharacter() {
        return this.closeDelimiter;
    }

    /**
     * Minimum number of delimiter characters that are needed to activate this. Must be at least 1.
     */
    @Override
    public int getMinLength() {
        return 1;
    }

    /**
     * Process the delimiter runs.
     * <p>
     * The processor can examine the runs and the nodes and decide if it wants to process or not. If not, it should not
     * change any nodes and return 0. If yes, it should do the processing (wrapping nodes, etc) and then return how many
     * delimiters were used.
     * <p>
     * Note that removal (unlinking) of the used delimiter {@link Text} nodes is done by the caller.
     *
     * @param openingRun the opening delimiter run
     * @param closingRun the closing delimiter run
     * @return how many delimiters were used; must not be greater than length of either opener or closer
     */
    @Override
    public int process(DelimiterRun openingRun, DelimiterRun closingRun) {
        /**
         * @return the innermost opening delimiter, e.g. for {@code ***} this is the last {@code *}
         */
        final Text opener = openingRun.getOpener();
        final Text closer = closingRun.getCloser();

        String nodeSourcespans = opener.getNext().getSourceSpans().toString();
        System.out.println(nodeSourcespans);

        final SourceSpans sourceSpans = new SourceSpans();
        /**
         * Get the opening delimiter nodes for the specified length of delimiters. Length must be between 1 and
         * {@link #length()}.
         * <p>
         * For example, for a delimiter run {@code ***}, calling this with 1 would return the last {@code *}.
         * Calling it with 2 would return the second last {@code *} and the last {@code *}.
         */
        sourceSpans.addAllFrom(openingRun.getOpeners(1));

        // somehow fetch destination title id & put in constructor
        final Node delimiterNode = new ExtendLinkCustomNodeDelimited(String.valueOf(this.openDelimiter), String.valueOf(this.closeDelimiter));

        for (final Node node: Nodes.between(opener, closingRun.getCloser())){
            delimiterNode.appendChild(node);
            sourceSpans.addAll(node.getSourceSpans());
        }

        /**
         * Get the closing delimiter nodes for the specified length of delimiters. Length must be between 1 and
         * {@link #length()}.
         * <p>
         * For example, for a delimiter run {@code ***}, calling this with 1 would return the first {@code *}.
         * Calling it with 2 would return the first {@code *} and the second {@code *}.
         */
        sourceSpans.addAllFrom(closingRun.getClosers(1));

        /**
         * @return the source spans of this node if included by the parser, an empty list otherwise
         * @since 0.16.0
         */
        delimiterNode.setSourceSpans(sourceSpans.getSourceSpans());

        opener.insertAfter(delimiterNode);

        return 1;
    }
}


/**
 * A source span references a snippet of text from the source input.
 * <p>
 * It has a starting position (line and column index) and a length of how many characters it spans.
 * <p>
 * For example, this CommonMark source text:
 * <pre><code>
 * &gt; foo
 * </code></pre>
 * The {@link BlockQuote} node would have this source span: line 0, column 0, length 5.
 * <p>
 * The {@link Paragraph} node inside it would have: line 0, column 2, length 3.
 * <p>
 * If a block has multiple lines, it will have a source span for each line.
 * <p>
 * Note that the column index and length are measured in Java characters (UTF-16 code units). If you're outputting them
 * to be consumed by another programming language, e.g. one that uses UTF-8 strings, you will need to translate them,
 * otherwise characters such as emojis will result in incorrect positions.
 *
 * @since 0.16.0
 */