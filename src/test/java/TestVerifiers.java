
import org.junit.jupiter.api.Test;
import verifiers.Lexer;
import verifiers.Parser;
import verifiers.Verifier;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestVerifiers {

    @Test
    public void testLexer() {
        Lexer lexer = new Lexer(new StringReader("-1 , \\|| !! &%$"));
        assertThrows(IllegalArgumentException.class, () -> {
            List<String> l = lexer.getSemiTokens();
        });
    }

    @Test
    public void parserVerifier(){
        Parser p=new Parser(Arrays.asList("new", "circle", "(10.0)","(100.0,100.0)"));
        p.generateFinalTokens(Arrays.asList("new", "circle", "(10.0)","(100.0,100.0)"));
        assertThrows(RuntimeException.class, () -> {
            Parser parser=new Parser(Arrays.asList(" THIS", "IS","-"," TEST"));
            parser.generateFinalTokens(Arrays.asList(" THIS", "IS","-A"," TEST"));
        });
    }

    @Test
    public void testVerifier() {
        Verifier verifier = new Verifier("- THIS //  I|S A  ()TESTING STRING");
        assertThrows(IllegalArgumentException.class, () -> {
            verifier.checkAndExecute();
        });
    }
}
