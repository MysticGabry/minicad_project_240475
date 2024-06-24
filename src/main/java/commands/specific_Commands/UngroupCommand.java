package commands.specific_Commands;

import commands.GenericCommand;
import costants.CostantValues;
import myUtils.Group;

import java.util.Iterator;
import java.util.List;

public class UngroupCommand implements GenericCommand {
    @Override
    public void execute(List<String> tokensList) {
        if (tokensList.size() != 1)
            throw new IllegalArgumentException("The arguments provided are invalid");
        String groupToRemoveID = tokensList.get(0);
        Iterator<Group> iterator = CostantValues.groups.iterator();
        while (iterator.hasNext()) {
            Group g = iterator.next();
            if (g.getGid().equals(groupToRemoveID)) {;
                iterator.remove();
                g.clear();
                System.out.println(groupToRemoveID + " has been ungrouped");
                break;
            }
        }
        throw new IllegalArgumentException("Group " + groupToRemoveID + " not found");
    }
}
