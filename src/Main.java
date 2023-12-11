import db.Database;
import models.Group;
import role.Role1;
import serviceGroup.GroupService;
import serviceGroup.LessonService;
import serviceGroup.RoleService;
import serviceGroup.StudentService;
import serviceGroup.impl.GroupImpl;
import serviceGroup.impl.LessonImpl;
import serviceGroup.impl.RoleImpl;
import serviceGroup.impl.StudentImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Database database = new Database();
        Role1 role1 = new Role1();
        RoleService roleService = new RoleImpl();
        GroupService groupService = new GroupImpl(database);
        StudentService studentService = new StudentImpl(database);
        LessonService lessonService = new LessonImpl(database);


        innerLoop:
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("""
                    1. Sign Account
                    2. Create Account
                    3. Exit
                    """);
            switch (scanner.nextLine()) {
                case "1" -> {
                    if (roleService.login(role1) != null) {
                        boolean isTrue = true;
                        while (isTrue) {
                            System.out.println("""
                                    1. ADD GROUP 📚
                                    2. GET GROUP 🧑‍🎓
                                    3. UPDATE 🔄
                                    4. GET ALL 🌐
                                    5. ADD STUDENTS 👫
                                    6. UPDATE STUDENTS ✏️
                                    7. FIND STUDENTS BY NAME 🔍
                                    8. GET ALL STUDENTS GROUP BY NAME 🧑‍🤝‍🧑
                                    9. GET ALL STUDENTS LESSON 🎓
                                    10. DELETE EMAIL 📭
                                    11. ADD NEW LESSON TO GROUP ➕
                                    12. GET LESSON BY NAME 📖
                                    13. GET ALL LESSON BY GROUP NAME 🧑‍🏫
                                    14. DELETE LESSON BY ID ❌f
                                    15. DELETE GROUP BY NAME ❌
                                    16. GET ALL STUDENTS
                                    0. RETURN
                                                      
                                                     """);

                            switch (scanner.nextLine()) {
                                case "1" -> {
//                                    database.arrayList = groupService.addGroup();
                                    Set<Group> groups = new HashSet<>(groupService.addGroup());
                                }
                                case "2" -> {
                                    groupService.getGroup();
                                }
                                case "3" -> {
                                    System.out.println(groupService.updateGroup());
                                }
                                case "4" -> {
                                    groupService.getAllGroup();
                                }
                                case "5" -> {
                                    studentService.addNewStudents();
                                }
                                case "6" -> {
                                    studentService.updateStudents();
                                }
                                case "7" -> {
                                    studentService.findStudentsByName();
                                }
                                case "8" -> {
                                    studentService.getAllStudentsGroupByName();
                                }
                                case "9" -> {
                                    studentService.getAllStudentsLessonsName();
                                }
                                case "10" -> {
                                    studentService.deleteStudentByEmail();
                                }
                                case "11" -> {
                                    lessonService.addNewLessonToGroup();
                                }
                                case "12" -> {
                                    lessonService.getLessonByName();
                                }
                                case "13" -> {
                                    lessonService.getAllLessonGroupByName();
                                }
                                case "14" -> {
                                    lessonService.deleteLessonById();
                                }
                                case "15" -> {
                                    groupService.deleteGroupByName();
                                }
                                case "16" -> {
                                    studentService.getAllStudents();
                                }
                                case "0" -> {
                                    return;
                                }
                            }

                        }
                    }
                }
                case "2" -> role1 = roleService.addLogin(role1);
                case "3"->{break innerLoop;}
            }
        }
    }

}
