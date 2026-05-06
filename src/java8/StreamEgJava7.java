package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamEgJava7 {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("Rat", "Cat", "Bat", "", "Lion", "Tiger", "Elephant");
		System.out.println(strList);

		long count = getStringCountLengthwith3(strList);
		System.out.println("Count " + count);

		List<String> str3 = getStringsWithLength3(strList);
		System.out.println("StringsWithLength3 " + str3);

		long escount = getCountOfEmptyString(strList);
		System.out.println("ESCount " + escount);

		List<Integer> intList = Arrays.asList(1, 3, 8, 4, 6, 9, 7, 2);
		System.out.println(intList);

		int max = getTheMaxNumber(intList);
		System.out.println("Max number " + max);
	}

	private static int getTheMaxNumber(List<Integer> intList) {
		int max = intList.get(0);
		for (int i = 0; i < intList.size(); i++) {

			Integer num = intList.get(i);
			if (num.intValue() > max) {
				max = num.intValue();
			}
		}
		return max;
	}

	private static long getCountOfEmptyString(List<String> strList) {
		long count = 0;
		for (String str : strList) {
			if (str.isEmpty()) {
				count++;
			}
		}
		return count;
	}

	private static List<String> getStringsWithLength3(List<String> strList) {
		List<String> lstr = new ArrayList<String>();
		for (String str : strList) {
			if (str.length() == 3) {
				lstr.add(str);
			}
		}
		return lstr;
	}

	private static long getStringCountLengthwith3(List<String> strList) {
		long count = 0;
		for (String str : strList) {
			System.out.println(str);
			if (str.length() == 3) {
				count++;
			}
		}
		return count;
	}

}
