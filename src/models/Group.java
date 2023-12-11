package models;

import java.util.ArrayList;
import java.util.LinkedList;

public class Group {

    private int id;
    private String name;
    private String description;
    private ArrayList<Students> students = new ArrayList<>();
    private LinkedList<Lesson> lessonLinkedList = new LinkedList<>();

    public Group(int id, String name, String description, ArrayList<Students> students, LinkedList<Lesson> lessonLinkedList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.students = students;
        this.lessonLinkedList = lessonLinkedList;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Students> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Students> students) {
        this.students = students;
    }

    public LinkedList<Lesson> getLessonLinkedList() {
        return lessonLinkedList;
    }

    public void setLessonLinkedList(LinkedList<Lesson> lessonLinkedList) {
        this.lessonLinkedList = lessonLinkedList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", students=" + students +
                ", linkedList=" + lessonLinkedList +
                '}';
    }
}
