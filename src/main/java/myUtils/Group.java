package myUtils;

import costants.CostantValues;

import java.util.ArrayList;
import java.util.List;

public class Group extends ArrayList<String> {
    private String gid;
    private static int cnt = 0;

    public Group(List<String> toGroupList) {
        for (String token : toGroupList) {
            if (!CostantValues.figuresID.contains(token))
                throw new IllegalArgumentException("You have to create the figure before grouping it");
        }
        addAll(toGroupList);
        this.gid = "Group" + (++cnt);
        System.out.println("Created group with id: " + gid + ", containing: " + toGroupList);
    }

    public String getGid() {
        return gid;
    }

    public List<String> getGroupComponents() {
        return new ArrayList<>(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        for (Object o : this) {
            sb.append(o + ", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}
