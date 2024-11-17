
public class CoreJavaBrushups_Loops {

	public static void main(String[] args) {
		
		String[] name= {"Yash","Rahul", "Jonty"};   // Array declaration and Initialization
		for (int i=0; i< name.length; i++)
		{
			System.out.println(name[i]);
		}

		System.out.print("************");
		System.out.println("************");
		
		//Enhanced for loops
		
		for (String s : name)
		{
			System.out.println(s);
		}
		
		System.out.print("************");
		System.out.println("************");
		
		int[] arr2= {1,2,3,4,5,6,7,8,9,10,123,144};
		
		// Print even numbers- 2,4,6,8,10
		for (int i=0; i< arr2.length; i++)
		{
			if(arr2[i] % 2 == 0)
			{
			System.out.println(arr2[i]);
			}
			
			else
			{
				System.out.println(arr2[i]+ "is not multiple of 2");
			}
		}

		System.out.print("************");
		System.out.println("************");
		
		//Print the first even number from array
		
	for( int i=0; i< arr2.length; i++)
	{
		if( arr2[i] % 2 == 0 )
		{
			System.out.println("First even number from array"+arr2[i]);
			break;
		}
	}
  }
}

/*
 Output-
 
 
 Yash
Rahul
Jonty
************************
Yash
Rahul
Jonty
************************
1is not multiple of 2
2
3is not multiple of 2
4
5is not multiple of 2
6
7is not multiple of 2
8
9is not multiple of 2
10
123is not multiple of 2
144
************************
First even number from array2
  
*/