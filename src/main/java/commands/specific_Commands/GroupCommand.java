package commands.specific_Commands;

import commands.GenericCommand;
import costants.CostantValues;
import myUtils.Group;

import java.util.List;

public class GroupCommand implements GenericCommand {
    @Override
    public void execute(List<String> tokensList) {
        if (tokensList.size() <= 1)
            throw new IllegalArgumentException("You have to group at least 2 elements");
        for (String token : tokensList) {
            if (!CostantValues.figuresID.contains(token))
                throw new IllegalArgumentException("You have to create the figure before grouping it");
        }
        Group group = new Group(tokensList);
        CostantValues.groups.add(group);
        System.out.println("Group created: " + tokensList);
    }
}
