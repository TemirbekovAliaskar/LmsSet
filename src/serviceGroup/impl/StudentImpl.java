package serviceGroup.impl;

import db.Database;
import models.GenerateId;
import models.Group;
import models.Students;
import serviceGroup.StudentService;

import java.util.Scanner;

public class StudentImpl implements StudentService {

    private final Database database;

    public StudentImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addNewStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Group Write :");
        String name = scanner.nextLine();
        for (int i = 0; i < database.arrayList.size(); i++) {
            if (database.arrayList.get(i).getName().equals(name)){
                Students students = new Students();
                System.out.println("Name : ");
                String name2 = scanner.nextLine();
                students.setFirstName(name2);
                System.out.println("Last name : ");
                String lastName = scanner.nextLine();
                students.setLastName(lastName);
                while (true){
                    try {
                        System.out.println("Email : ");
                        String email = scanner.nextLine();
                        if (uniStudents(email) == 0 && email.endsWith("@gmail.com")){
                            students.setEmail(email);
                            break;
                        }else throw new Exception("Не корректно !");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Password: ");
                        String pass = scanner.nextLine();
                        if (pass.length() >= 5) {
                            students.setPassword(pass);
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Не корректный пароль !");
                    }

                }
                while (true) {
                    try {
                        System.out.println("Gender : ");
                        String gender = scanner.nextLine();
                        if (gender.equals("Male".toLowerCase())){
                            students.setGender("Male");
                            System.out.println("Man !");
                            break;
                        }else if (gender.equals("Female".toLowerCase())){
                            students.setGender("Female");
                            System.out.println("Woman !");
                            break;
                        }
                        else throw new Exception("Не корректно ! ");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                students.setId(GenerateId.studentIdGen());
                database.arrayList.get(i).getStudents().add(students);
                System.out.println("Successful !");

            }
        }
    }
    @Override
    public void getAllStudents() {
        for (Group group : database.arrayList) {
            System.out.println(group.getStudents());
        }
    }
    @Override
    public void updateStudents() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < database.arrayList.size(); i++) {
            for (int s = 0; s < database.arrayList.get(i).getStudents().size(); s++) {
                System.out.println("Email : ");
                String email = scanner.nextLine();
                if (database.arrayList.get(i).getStudents().get(s).getEmail().equals(email)){
                    System.out.print("New password : ");
                    String newPassword = scanner.nextLine();
                    database.arrayList.get(i).getStudents().get(s).setPassword(newPassword);
                    return;
                }
            }System.out.println("Not found !");
        }
    }

    @Override
    public void findStudentsByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name : ");
        String name = scanner.nextLine();
        for (int i = 0; i < database.arrayList.size(); i++) {
            for (int s = 0; s < database.arrayList.get(i).getStudents().size(); s++) {
                if (database.arrayList.get(i).getStudents().get(s).getFirstName().equals(name)){
                    System.out.println(database.arrayList.get(i).getStudents().get(s));
                    System.out.println("Successful !");
                    return;
                }
            }
        }System.out.println("Not found !");

    }

    @Override
    public void getAllStudentsGroupByName() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < database.arrayList.size(); i++) {
            for (int s = 0; s < database.arrayList.get(i).getStudents().size(); s++) {
                System.out.println("Name : ");
                String groupName = scanner.nextLine();
                if (database.arrayList.get(i).getName().equals(groupName)){
                    System.out.println(database.arrayList.get(i).getStudents());
                    System.out.println(" Successful !");
                    break;
                }
            }System.out.println("Not Found Group !");
        }

    }

    @Override
    public void getAllStudentsLessonsName() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < database.arrayList.size(); i++) {
            for (int l = 0; l < database.arrayList.get(i).getLessonLinkedList().size(); l++) {
                System.out.println("Lesson write :");
                String lessonName = scanner.nextLine();
                if (database.arrayList.get(i).getLessonLinkedList().get(l).getLessonName().equals(lessonName)){
                    System.out.println(database.arrayList.get(i).getStudents());
                    System.out.println("Successful !");
                    break;
                }
            }
        }
    }

    @Override
    public void deleteStudentByEmail() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < database.arrayList.size(); i++) {
            for (int d = 0; d < database.arrayList.get(i).getStudents().size(); d++) {
                System.out.println("Email : ");
                String email = scanner.nextLine();
                if (database.arrayList.get(i).getStudents().get(d).getEmail().equals(email)){
                    database.arrayList.get(i).getStudents().remove(d);
                    System.out.println("Successful !");
                }
            }
        }
    }


    public  int uniStudents(String email){
        for (int i = 0; i < database.arrayList.size(); i++) {
            for (int j = 0; j < database.arrayList.get(i).getStudents().size(); j++) {
                if (database.arrayList.get(i).getStudents().get(j).getEmail().equals(email)){
                    return 1;
            }
            }
        }return 0;
    }

}
