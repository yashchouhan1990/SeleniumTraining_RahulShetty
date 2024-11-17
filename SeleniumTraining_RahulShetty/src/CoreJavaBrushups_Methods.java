
public class CoreJavaBrushups_Methods {

	public static void main(String[] args) {
		
		//To call method-1, create object of the class to call it
		CoreJavaBrushups_Methods m= new CoreJavaBrushups_Methods();
		m.getData();
		
		System.out.println("**********");
		
		//To call method-2, create object of the class to call it
		CoreJavaBrushups_Methods m2= new CoreJavaBrushups_Methods();
		//m2.getData2();
		String result=m2.getData2();
		System.out.println(result);
		
		System.out.println("**********");
		
		//To call method-3 created outside/separate class, create object of the class to call it
		CoreJavaBrushups_Methods2 m3= new CoreJavaBrushups_Methods2();  //This object is from another class
		m3.getData3();
	}
	
	//Method-1 in same class with No return type
	public void getData(){
		
		System.out.println("Inside Method-1");
	}
	
	//Method-2 in same class with return type
	public String getData2(){
		
		System.out.println("Inside Method-2");
		return "Method-2 returned value";
	}
}

/*

Output--
Inside Method-1
**********
Inside Method-2
Method-2 returned value
**********
Inside Method-3

*/
