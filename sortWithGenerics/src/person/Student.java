package person;

public class Student<T extends Comparable<T>> implements Comparable<Student<T>> {

    public Student(String id, T grade) {
        this.id = id;
        this.grade = grade;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private T grade;

    public T getGrade() {
        return grade;
    }

    public void setGrade(T grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student<T> student) {
        return this.getGrade().compareTo(student.getGrade());
    }

    @Override
    public String toString() {
        return this.id + ": " + this.grade.toString();
    }

}