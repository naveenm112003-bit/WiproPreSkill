package java8;

import java.util.Arrays;
import java.util.List;

public class Java7Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>list= Arrays.asList(1,6,3,8,2,10);
		int count=0;
		for(int num : list) {
			if(num>5) {
				count++;
			}
		}
		System.out.println("Count > 5:"+ count);
		
		if(!list.isEmpty()) {
			System.out.println("First Element:" + list.get(0));
		}
		
		System.out.println("Squares:");
		for(int num : list) {
		
		}

	}
}

