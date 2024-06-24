package costants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TokenSigns {

    public final static  String CREATE="new";
    public final static String REMOVE="del";
    public final static String MOVE="mv";
    public final static String SCALE="scale";
    public final static String LIST="ls";
    public final static String GROUP = "grp";
    public final static String UNGROUP = "ungrp";
    public final static String AREA="area";
    public final static String PERIMETER="perimeter";

    public final static String MVOFF="mvoff";
    public final static String ALL="all";
    public final static String GRP="grp";
    public final static String CIRCLE="circle";
    public final static String RECTANGLE="rectangle";
    public final static String IMG="img";
    public final static String LPAR="(";
    public final static String RPAR=")";
    public final static String COMMA=",";

    public static List<String> commandsToken(){
        List<String> commandsTokenList = new ArrayList<>();
        commandsTokenList.add(CREATE);
        commandsTokenList.add(REMOVE);
        commandsTokenList.add(MOVE);
        commandsTokenList.add(MVOFF);
        commandsTokenList.add(SCALE);
        commandsTokenList.add(LIST);
        commandsTokenList.add(GROUP);
        commandsTokenList.add(UNGROUP);
        commandsTokenList.add(AREA);
        commandsTokenList.add(PERIMETER);
        return commandsTokenList;
    }

    public TokenSigns() {
    }

}
