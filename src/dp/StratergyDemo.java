package dp;

import java.util.Arrays;

interface SortingStratergy {

	void sort(int[] array);

}

class Sorter {

	SortingStratergy st;

	public Sorter(SortingStratergy st) {
		this.st = st;

	}

	public void setSt(SortingStratergy st) {
		this.st = st;
	}

	public void sort(int[] array) {
		st.sort(array);
	}

}

class BubbleSortStratergy implements SortingStratergy {

	@Override
	public void sort(int[] array) {
		System.out.println("BB SORT");
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i -1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;

				}
			}
		}
	}

}

class InsertionSortStratergy implements SortingStratergy {

	@Override
	public void sort(int[] a) {
		System.out.println("IN SORT");
		
		for (int i = 1; i < a.length; i++) {
			int value = a[i];
			int j;
			for (j = i-1; j >= 0 && a[j] > value; j--)
				a[j+1] = a[j];
			a[j+1] = value;
		}
		System.out.println(a);
	}

}

public class StratergyDemo {

	public static void main(String[] args) {
		int[] array = { 5, 3, 8, 4, 2 };

		SortingStratergy st1 = new BubbleSortStratergy();
		SortingStratergy st2 = new InsertionSortStratergy();

//		Sorter sorter1 = new Sorter(st1);
//		sorter1.sort(array);
//		System.out.println(Arrays.toString(array));

		Sorter sorter2 = new Sorter(st2);
		sorter2.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
