
public class CoreJavaBrushups_Strings {

	public static void main(String[] args) {
		
		//String is an Object in java which stores sequence of characters
		// String can be defined in 2 ways- 
		// a. BY String Literal --> If value already exist it won't create new object, it will refer to existing value
		// b. By New keyword  -->If value already exist, it will still create new object.
		// String by Literal
		String s1 = "Yash Chouhan";   
		String s2= "Yash Chouhan";   //s2 will point to s1 object.
									//As "Yash Chouhan" already exist so s2 object will not be created
		
		// String create by new keyword-- It always creates object
		
		String s3 = new String("Welcome");
		String s4 = new String("Welcome");
		
		//To access methods of string class, create object of string class
		String s = "Rahul Shetty Academy";
		// Split String
		String[] SplittedString=s.split(" ");  // Value stored into string array   
		
		System.out.println(SplittedString[0]);
		System.out.println(SplittedString[1]);
		System.out.println(SplittedString[2]);
		
		
		System.out.println("************");
		
		String ss = "Rahul Shetty Academy";
		// Split String
		String[] SplittedStrng=ss.split("Shetty");  // Value stored into string array   
		
		System.out.println(SplittedStrng[0]);
		System.out.println(SplittedStrng[1]);
		
		// Remove White spaces
		System.out.println(SplittedStrng[1].trim());
		
		//Print character by character
		String profile= "Automation Engineer";
		System.out.println(profile.length());
	
		for (int i=0; i<profile.length(); i++)
		{
			
			System.out.println(profile.charAt(i));
		}
		
		System.out.println("***************");
		
		// Print string character in reverse order
		
		String stringreverse="Yash Chouhan";
		
		for (int i=stringreverse.length()-1; i>=0; i--)
		{
			System.out.println(stringreverse.charAt(i));
		}
		
	
	}

}

/*
 Output--
 
 
 Rahul
Shetty
Academy
************
Rahul 
 Academy
Academy
19
A
u
t
o
m
a
t
i
o
n
 
E
n
g
i
n
e
e
r
***************
n
a
h
u
o
h
C
 
h
s
a
Y

*/
