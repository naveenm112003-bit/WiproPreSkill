package java8;

interface Calculate {

	public void add(int a, int b);
	
	public default void display() {
		System.out.println("From display...");
	}
}

public class LambdaDemo {

	public static void main(String[] args) {
		Calculate c = (a, b) -> System.out.println(a + b);
		c.add(44, 10);

		Calculate c1 = (a, b) -> System.out.println(a - b);
		c1.add(44, 10);
		
		c.display();
	}
}


