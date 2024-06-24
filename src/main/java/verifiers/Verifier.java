package verifiers;

import commands.specific_Commands.*;
import costants.TokenSigns;
import java.io.StringReader;
import java.util.List;

public class Verifier {
    private String input;
    private Lexer lexer;
    private Parser parser;

    public Verifier(String input) {
        this.input = input;
    }

    public void checkAndExecute() {
        lexer = new Lexer(new StringReader(input));
        List<String> semiTokensList = lexer.getSemiTokens();
        if (semiTokensList.contains("-")) throw new IllegalArgumentException("Values can't negative");

        parser = new Parser(semiTokensList);
        List<String> finalTokensList = parser.generateFinalTokens(semiTokensList);
        switch (finalTokensList.getFirst()) {
            case TokenSigns.CREATE:
                finalTokensList.removeFirst();
                CreateCommand cc = new CreateCommand();
                cc.execute(finalTokensList);
                break;
            case TokenSigns.REMOVE:
                finalTokensList.removeFirst();
                RemoveCommand del = new RemoveCommand();
                del.execute(finalTokensList);
                break;
            case TokenSigns.MOVE:
                finalTokensList.removeFirst();
                MoveCommand mc = new MoveCommand();
                mc.execute(finalTokensList);
                break;
            case TokenSigns.MVOFF:
                finalTokensList.removeFirst();
                MoveOffCommand moc = new MoveOffCommand();
                moc.execute(finalTokensList);
                break;
            case TokenSigns.SCALE:
                finalTokensList.removeFirst();
                ScaleCommand sc = new ScaleCommand();
                sc.execute(finalTokensList);
                break;
            case TokenSigns.LIST:

                ListCommand ls = new ListCommand();
                ls.execute(finalTokensList);
                break;
            case TokenSigns.GRP:
                finalTokensList.removeFirst();
                GroupCommand grp = new GroupCommand();
                grp.execute(finalTokensList);
                break;
            case TokenSigns.UNGROUP:
                finalTokensList.removeFirst();
                UngroupCommand ungrp = new UngroupCommand();
                ungrp.execute(finalTokensList);
                break;
            case TokenSigns.AREA:
                finalTokensList.removeFirst();
                AreaCommand area = new AreaCommand();
                area.execute(finalTokensList);
                break;
            case TokenSigns.PERIMETER:
                finalTokensList.removeFirst();
                PerimeterCommand perimeter = new PerimeterCommand();
                perimeter.execute(finalTokensList);
                break;
        }
    }
}
