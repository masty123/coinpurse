package test;

public class Student extends Person {
    private long id;
    public Student(String aname, long id) {
        super(aname);
        this.id = id;
    }
    public String toString() { return "Student named "+name; }
    public static void main(String[]args)
    {
    	  Person p = new Student("Peewee",100L);
    		System.out.println(p.toString());
    }
}