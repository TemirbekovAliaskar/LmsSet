package models;

public class GenerateId {

    public static int groupId =0;
    public static int studentId =0;
    public static int lessonId =0;

    public static int groupIdGen(){
        return (++groupId);
    }
    public static int lessonIdGen(){
        return (++lessonId);
    }
    public static int studentIdGen(){
        return (++studentId);
    }
}
