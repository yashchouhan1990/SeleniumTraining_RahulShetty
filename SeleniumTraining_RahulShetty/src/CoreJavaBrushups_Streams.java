import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CoreJavaBrushups_Streams {
	
	//Count the number of names starting with alphabet A in list
//	@Test
	public void regular() {
		
	ArrayList<String> names= new ArrayList<String>();
	names.add("Abhijeet");
	names.add("Don");
	names.add("Alekhya");
	names.add("Adam");
	names.add("Ram");
	
	int count=0;
	//1. Print count oof names starting with A
	for(int i=0; i<names.size(); i++)
	{
		String actualName=names.get(i);
		
		if(actualName.startsWith("A"))
		{
			count++;
		}
	}
	System.out.println("Count of Names Starting with Letter A: "+count);
	}
	
//	@Test
	public void streamFilter()
	{
		ArrayList<String> names= new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");

		//Using concept of Stream & Lambda Expression
		
		/* Explaination
		 feed list into stream : names.stream()
		 Then apply filter condition on it using filter method : names.stream().filter()
		 Now use the lambda expression to filter out the result. In lambda expression we use operator'->'
		 the left side of the operator is paramter and right side we give action.. So in below example
		 s is paramter (which iterate threw the complete list in parallel)and startsWith("A") is action.
		 And after filter method we have to perform terminal operation on the final stream like count or anything.
		 
		 Note-- there is no life for intermediate operation if there is no terminal operation
		 Termination operation will execute only if Intermediate Operation(filter) return TRUE
		 We can create stream
		 How to use filter in Stream API 
		 
		 */
		
		Long count1= names.stream().filter(s->s.startsWith("A")).count();
		System.out.println("Count is:"+count1);
		
		//We can also create light weight Stream instead of creating collection and converting into stream
		
		Long d= Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->
			{
				s.startsWith("D");
				return true;
			}).count();
		
		System.out.println(d);
	
		//Print all the names of ArrayList having length more then 4
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		System.out.println("********");
		//limit the result to 1
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}

//	@Test
	public void StreamMap()
	{
		ArrayList<String> names= new ArrayList<String>();
		names.add("Yash");
		names.add("Harsh");
		names.add("John");
		names.add("man");
		names.add("Don");

		//Print names which has last letter as "a" with upper case
		Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
		System.out.println("********");
		
		//Print names which has first letter as "a" with uppercase and sorted
		List<String> names1= Arrays.asList("Abhijeet","Don","Alekhya","Adam","Rama");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("********");
		
		//Merging 2 different list
		Stream<String> newStream=Stream.concat(names.stream(), names1.stream());
	//	newStream.sorted().forEach(s->System.out.println(s));
		
		//To check if given name is present in String Array
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect()
	{
		List<String> ls=Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		System.out.println(ls.get(1));
		
		System.out.println("********");
		
		List<Integer> val=Arrays.asList(3,2,2,5,1,9,7);
		//Print unique number from this array
	//	val.stream().distinct().forEach(s->System.out.println(s));
		
		//Print unique numbers and sort the array-- 3rd index - 1,2,3,5,7,9
		List<Integer> li=val.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(3));
	}
}
