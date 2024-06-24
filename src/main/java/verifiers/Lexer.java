package verifiers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private StreamTokenizer input;

    public Lexer(Reader in) {
        input = new StreamTokenizer(in);
        input.resetSyntax();
        input.eolIsSignificant(false);
        input.wordChars('a', 'z');
        input.wordChars('A', 'Z');
        input.wordChars('0', '9');
        input.wordChars('.', '.');
        input.whitespaceChars('\u0000', ' ');
        input.ordinaryChar('(');
        input.ordinaryChar(')');
        input.ordinaryChar(',');
        input.quoteChar('"');
    }

    public List<String> getSemiTokens() {
        List<String> semiTokensList = new ArrayList<>();
        try {
            while (input.nextToken() != StreamTokenizer.TT_EOF) {
                switch (input.ttype) {
                    case StreamTokenizer.TT_WORD:
                        semiTokensList.add(input.sval);
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        semiTokensList.add(String.valueOf(input.nval));
                        break;
                    case '(':
                        semiTokensList.add("(");
                        break;
                    case ',':
                        semiTokensList.add(",");
                        break;
                    case ')':
                        semiTokensList.add(")");
                        break;
                    case '"':
                        semiTokensList.add(input.sval);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid character: " + (char) input.ttype);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return semiTokensList;
    }
}
