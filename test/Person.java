package test;
import java.util.*;

public class Person implements Comparable<Person> {
	
	    protected String name;
	    public Person(String aname) {
	        this.name = aname;
	    }
	    public String toString( ) { return "Person named "+name; }
	    // other methods not shown
		@Override
		public int compareTo(Person arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	


