
public class CoreJavaBrushups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int myNum=5;
		String website = "Rahul Shetty Academy";
		
		char letter = 'y';
		double dec = 5.55;
		boolean myCard = true;
		
		System.out.println(myNum+" is the value stored in myNum variable");
		System.out.println(website);
		
		//Arrays
		
		int[] arr= new int[5];   // Array declaration
		arr[0]=1;       // Array Initialization
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		arr[4]=5;
		
		System.out.println("Array value "+arr[3]);
		//OR
		
		int[] arr2= {1,2,3,4,5,6,7,8,9,10,123};   // Array declaration and Initialization
		
		for (int i=0; i< arr[4]; i++)
		{
			System.out.println(arr[i]);
		}
		
		System.out.print("************");
		System.out.println("************");
		
		for (int i=0; i< arr2.length; i++)
		{
			System.out.println(arr2[i]);
		}

		System.out.print("************");
		System.out.println("************");
		
		String[] name= {"Yash","Rahul", "Jonty"};
		for (int i=0; i< name.length; i++)
		{
			System.out.println(name[i]);
		}
				
	}

}

/*
Output-

5 is the value stored in myNum variable
Rahul Shetty Academy
Array value 4
1
2
3
4
5
************************
1
2
3
4
5
6
7
8
9
10
123
************************
Yash
Rahul
Jonty

*/
