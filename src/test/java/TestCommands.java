import commands.specific_Commands.*;
import costants.CostantValues;
import myUtils.Group;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCommands {

    @Test
    public void testCreateCommand() {
        CreateCommand cc = new CreateCommand();
        assertThrows(IllegalArgumentException.class, () -> {
            cc.execute(Arrays.asList("TESTING"));
        });
    }

    @Test
    public void testGroupCommand() {
        GroupCommand gc = new GroupCommand();
        assertThrows(IllegalArgumentException.class, () -> {
            gc.execute(Arrays.asList("TESTING"));
        });
        assert CostantValues.groups.isEmpty();
        assertThrows(IllegalArgumentException.class, () -> {
            Group g = new Group(Arrays.asList("TEST1, TEST2"));
        });
    }

    @Test
    public void testListCommand() {
        ListCommand lc = new ListCommand();
        assertThrows(IllegalArgumentException.class, () -> {
            lc.execute(Arrays.asList("TESTING"));
        });
    }

    @Test
    public void testMoveCommand() {
        MoveCommand mc = new MoveCommand();
        assertThrows(IllegalArgumentException.class, () -> {
            mc.execute(Arrays.asList("TESTING"));
        });
    }

    @Test
    public void testmoveOffCommand() {
        MoveOffCommand mc = new MoveOffCommand();
        assertThrows(IllegalArgumentException.class, () -> {
            mc.execute(Arrays.asList("TESTING"));
        });
    }

    @Test
    public void testRemoveCommand() {
        RemoveCommand rc = new RemoveCommand();
        assertThrows(IllegalArgumentException.class, () -> {
            rc.execute(Arrays.asList("TESTING"));
        });
    }

    @Test
    public void testScaleCommand(){
        ScaleCommand sc = new ScaleCommand();
        assertThrows(IllegalArgumentException.class, () -> {
            sc.execute(Arrays.asList("TESTING"));
        });
    }

    @Test
    public void testUngroupCommand(){
        UngroupCommand uc = new UngroupCommand();
        assertThrows(IllegalArgumentException.class, () -> {
            uc.execute(Arrays.asList("TESTING"));
        });
    }

}
