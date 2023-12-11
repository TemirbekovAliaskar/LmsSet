package serviceGroup.impl;

import db.Database;
import models.GenerateId;
import models.Lesson;
import serviceGroup.LessonService;

import java.util.Scanner;

public class LessonImpl implements LessonService {

   private final Database database;

    public LessonImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addNewLessonToGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Group name : ");
        String name = scanner.nextLine();
        for (int i = 0; i < database.arrayList.size(); i++) {
            if (database.arrayList.get(i).getName().equals(name)){
                Lesson lesson = new Lesson();
                System.out.println("Write lesson name : ");
                lesson.setLessonName(scanner.nextLine());
                System.out.println("Write description : ");
                lesson.setTaskDescription(scanner.nextLine());
                lesson.setId(GenerateId.lessonIdGen());

                database.arrayList.get(i).getLessonLinkedList().add(lesson);
                System.out.println("successful ! ");
            }
        }
    }

    @Override
    public void getLessonByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lesson name : ");
        String lesson = scanner.nextLine();
        try {
            boolean isTrue = false;
            for (int i = 0; i < database.arrayList.size(); i++) {
                for (int l = 0; l < database.arrayList.get(i).getLessonLinkedList().size(); l++) {
                    if (database.arrayList.get(i).getLessonLinkedList().get(l).getLessonName().equals(lesson)) {
                        System.out.println(database.arrayList.get(i).getLessonLinkedList().get(l));
                        System.out.println("Successful !");
                        isTrue = true;
                        break;
                    }
                    }
                }
            if (!isTrue){
                throw new Exception("Нет такой урок !");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAllLessonGroupByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Group name : ");
        String name = scanner.nextLine();
        for (int i = 0; i < database.arrayList.size(); i++) {
            if (database.arrayList.get(i).getName().equals(name)){
                System.out.println(database.arrayList.get(i).getLessonLinkedList());
                System.out.println("Successful !");
            }
        }
    }

    @Override
    public void deleteLessonById() {
        System.out.println("ID  :");
        int id = new Scanner(System.in).nextInt();
        for (int i = 0; i < database.arrayList.size(); i++) {
            for (int l = 0; l < database.arrayList.get(i).getLessonLinkedList().size(); l++) {
                if (database.arrayList.get(i).getLessonLinkedList().get(l).getId() == id){
                    database.arrayList.get(i).getLessonLinkedList().remove(l);
                    System.out.println("Successful !");
                }
            }
        }
    }
}
