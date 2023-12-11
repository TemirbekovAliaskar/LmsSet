package serviceGroup.impl;

import db.Database;
import models.GenerateId;
import models.Group;
import serviceGroup.GroupService;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GroupImpl implements GroupService {

    private final Database database;

    public GroupImpl(Database database) {
        this.database = database;
    }

    @Override
    public ArrayList<Group> addGroup() {
        Scanner sc = new Scanner(System.in);
        Group group = new Group();
        while (true) {
            System.out.print("Жаны группа: ");
            String newGroup = sc.nextLine();
            if (uni(newGroup) == 0) {
                group.setName(newGroup);
                break;
            }
        }
        System.out.println("Description :");
        String newDesc = sc.nextLine();
        group.setDescription(newDesc);
        group.setId(GenerateId.groupIdGen());
        database.arrayList.add(group);
        return database.arrayList;
    }

    @Override
    public void getGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name :");
        String name = scanner.nextLine();
        for (int i = 0; i < database.arrayList.size(); i++) {
            if (database.arrayList.get(i).getName().equals(name)) {
                System.out.println(database.arrayList.get(i));
                return;
            }
        }
    }

    @Override
    public String updateGroup() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Name group :");
            String name = scanner.nextLine();
            for (int i = 0; i < database.arrayList.size(); i++) {
                if (database.arrayList.get(i).getName().equals(name)) {
                    System.out.println("New group name : ");
                    String newName = scanner.nextLine();
                    database.arrayList.get(i).setName(newName);
                    return database.arrayList.get(i).getName();
                }
            }
        } catch (Exception e) {
            System.out.println("Нет такой группы !");
        }
        return null;
    }

    @Override
    public ArrayList<Group> getAllGroup() {
        System.out.println(database.arrayList);
        return database.arrayList;
    }

    @Override
    public void deleteGroupByName() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Name group : ");
            String name = scanner.nextLine();
            for (int i = 0; i < database.arrayList.size(); i++) {
                if (database.arrayList.get(i).getName().equals(name)) {
                    database.arrayList.remove(database.arrayList.get(i));
                    System.out.println("Successful !");
                }
            }
        } catch (Exception e) {
            System.out.println("Нет такой группы !");
        }
    }

    @Override
    public int uni(String name) {
        for (int i = 0; i < database.arrayList.size(); i++) {
            if (database.arrayList.get(i).getName().equals(name)) {
                return 1;

            }
        }
        return 0;
    }
}


