package java8;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEgJava8 {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("Rat", "Cat", "Bat", "", "Lion", "Tiger", "Elephant");
		System.out.println(strList);

		long count  = strList.stream().filter((str)->str.length() == 3).count();
		System.out.println("Count " + count);
		
		List<String> str3 = strList.stream().filter((str)->str.length() == 3).collect(Collectors.toList());
		System.out.println("StringsWithLength3 " + str3);
		
		long escount = strList.stream().filter((str)->str.isEmpty()).count();
		System.out.println("ESCount " + escount);
		
		
		List<Integer> intList = Arrays.asList(1, 3, 8, 4, 6, 9, 7, 2);
		System.out.println(intList);
		
		IntSummaryStatistics stat = intList.stream().mapToInt((i) -> i).summaryStatistics();
		System.out.println("Max :" +stat.getMax());
		System.out.println("Min :" +stat.getMin());
		System.out.println("Sum:" +stat.getSum());
		System.out.println("Count:" +stat.getCount());
	}

}
