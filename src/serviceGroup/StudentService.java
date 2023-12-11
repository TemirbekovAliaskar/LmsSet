package serviceGroup;

import models.Students;

public interface StudentService {


    void addNewStudents();
    void getAllStudents();
    void updateStudents();
    void findStudentsByName();
    void getAllStudentsGroupByName();
    void getAllStudentsLessonsName();
    void deleteStudentByEmail();
    int uniStudents(String email);

}
