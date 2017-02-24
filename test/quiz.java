package test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class quiz {
	public static void main(String[]args)
	{
		class A {
		    public A( ) { System.out.println("constructing A"); }
		    public String toString( ) { return "A"; }
		}
		class B extends A {
		    public B( ) { System.out.println("constructing B"); }
		    public String toString( ) { return "B"; }
		}
		class C extends B {
		    public C( ) { System.out.println("constructing C"); }
		    public String toString( ) { return "C"; }
		}
		
	}

}
