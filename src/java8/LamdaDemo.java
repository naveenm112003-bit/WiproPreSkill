package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class LamdaDemo {

	public static void main(String[] args) {
		// Java 8 -- way 1

//		Runnable r = () -> {
//			Task t = new Task();
//			t.print();
//
//		};
//		Thread t1 = new Thread(r);
//		t1.start();
//
//		// Java 8 -- way 2 -- Lambda As a Parameter
//		Thread t2 = new Thread(() -> {
//			Task t = new Task();
//			t.print();
//
//		});
//		t2.start();
//
//		// Java 8 -- way 3
//		new Thread(() -> {
//			Task t = new Task();
//			t.print();
//
//		}).start();
//
//		// Java 8 -- way 4
//		new Thread(() -> {
//			new Task().print();
//
//		}).start();
//		
//		// Java 8 -- way 5 -- Method Reference
//		new Thread(new Task()::print).start();

		Product p1 = new Product(11, "TV");
		Product p2 = new Product(51, "AC");
		Product p3 = new Product(8, "WM");

		List<Product> prList = new ArrayList<Product>();
		prList.add(p1);
		prList.add(p2);
		prList.add(p3);

		System.out.println(prList);

		List<Product> pList = Arrays.asList(p1, p2, p3);
		System.out.println(pList);

//		Iterator<Product> itr = pList.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
//		
		pList.forEach((li) -> System.out.println(li));

		BiPredicate<String, String> pr = (un, pwd) -> {
			return un.equals("Deeps") && pwd.equals("pass");
		};
		System.out.println(pr.test("Deeps", "pass"));

		Supplier<Product> s = () -> {
			return new Product(15, "Desktop");
		};
		System.out.println(s.get());

		Function<Integer, String> res = (i) -> {
			if (i % 2 == 0) {
				return "Even";
			} else {
				return "Odd";
			}
		};
		System.out.println(res.apply(52));

		// Way -1 -- Java 7
//		Task t = new Task();
//		t.print();

		// Way -2 -- Java 7
//		MyThread mt = new MyThread();
//		Thread t1 = new Thread(mt);
//		t1.start();

		// Way -3 -- Java 7
//		Runnable r = new Runnable() {
//
//			@Override
//			public void run() {
//				Task t = new Task();
//				t.print();
//
//			}
//		};
//		Thread t2 = new Thread(r);
//		t2.start();
	}

}