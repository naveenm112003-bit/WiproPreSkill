package java8;
import java.util.*;
import java.util.stream.*;

public class Java8Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>list = Arrays.asList(1,6,3,8,2,10);
		long count = list.stream().filter(n -> n>5).count(); 
		System.out.println("Count>5:"+ count);
		
		list.stream().findFirst().ifPresent(n -> System.out.println("First Element:" + n));
		
		System.out.println("Squares:");
		list.stream().map(n -> n*n).forEach(System.out::println);
		

	}

}
