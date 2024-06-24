package costants;

import myUtils.Group;
import undo.History;

import java.util.ArrayList;
import java.util.List;

public class CostantValues {
    public static int frameWidth = 1000;
    public static int frameHeight = 500;
    public static List<Object> allFiguresList = new ArrayList<>();
    public static List<String> figuresID = new ArrayList<>();
    private static List<Object> figureListBackup = new ArrayList<>();
    private static List<String> figuresIDBackup = new ArrayList<>();
    public static History history = new History();
    public static List<Group> groups = new ArrayList<>();
    public static final int deltaMaxforScalingPanel = 1;
    public static final int consentedDeltaMaxBounds = 2;
}
