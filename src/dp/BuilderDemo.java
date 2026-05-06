package dp;

class Student {
	private int id;
	private String name;
	private String email;

	private Student(Builder builder) {
		super();
		this.id = builder.id;
		this.name = builder.name;
		this.email = builder.email;
	}

	public static class Builder {
		private int id;
		private String name;
		private String email;

		

		public Builder setId(int id) {
			this.id = id;
			return this;
		}

		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public Student build() {
			return new Student(this);
		}

	}
	
	public void display() {
		System.out.println(" Id :" + id + " Name : " + name + " Email : " + email);
	}

}

public class BuilderDemo {

	public static void main(String[] args) {
		Student s = new Student.Builder()
				.setId(1)
				.setName("Naveen")
				.setEmail("Naveen@gmail.com")
				.build();
		
		s.display();

	}

}