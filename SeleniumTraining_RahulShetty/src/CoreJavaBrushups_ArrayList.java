import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushups_ArrayList {

	public static void main(String[] args) {
		
		ArrayList al= new ArrayList();  // This is generic ArrayList
		al.add(1);
		al.add("Yash");
		System.out.println(al.get(1));
		
		System.out.println("***********");
		
		ArrayList<String> a= new ArrayList<String>();  // This is ArrayList of String type
		a.add("Selenium");
		a.add("Java");
		a.add("TestNG");
		a.add("Log4j");
		
		System.out.println("Value is "+a.get(3));
		
		System.out.println("***********");
		
		//Traverse elements of an array
		
		for (int i=0; i< a.size(); i++)
		{
			System.out.println(a.get(i));
		}

		System.out.println("***********");
		//Advance for loop method
		
		for ( String val:a)
		{
			System.out.println(val);
		}

		System.out.println("***********");
		
		//Check Item is present in arrayList
		System.out.println(a.contains("Selenium"));
		
		System.out.println("***********");
		
		//Check Item present in array--then first convert array to arrayList
	
		String[] name= {"Earth", "Mars", "Jupiter"};
		 List<String> nameArrayList = Arrays.asList(name);
		 nameArrayList.contains("Earth");
		 System.out.println(nameArrayList.contains("Earth"));
		

	}
}

/*
Output-

Yash
***********
Value is Log4j
***********
Selenium
Java
TestNG
Log4j
***********
Selenium
Java
TestNG
Log4j
***********
true
***********
true

*/