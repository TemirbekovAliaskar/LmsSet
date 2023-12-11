package serviceGroup;

import models.Group;

import java.util.ArrayList;

public interface GroupService {


    ArrayList<Group> addGroup();
    void getGroup();
    String updateGroup();
    ArrayList<Group> getAllGroup();
    void deleteGroupByName();
    int uni(String name);


}
