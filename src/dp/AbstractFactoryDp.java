package dp;

abstract class Employee {
	String name;
	double salary;

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public abstract void paySalary();
}

class FullTimeEmployee extends Employee {

	public FullTimeEmployee(String name, double salary) {
		super(name, salary);

	}

	@Override
	public void paySalary() {
		System.out.println("Paying FTE " + name + " has salary " + salary);

	}

}

class PartTimeEmployee extends Employee {

	public PartTimeEmployee(String name, double salary) {
		super(name, salary);

	}

	@Override
	public void paySalary() {
		System.out.println("Paying PTE " + name + " has salary " + salary);

	}

}

interface EmployeeFactory {

	public Employee createEmployee(String name, double salary);

}

class FTEFactory implements EmployeeFactory {

	@Override
	public Employee createEmployee(String name, double salary) {

		return new FullTimeEmployee(name, salary);
	}

}

class PTEFactory implements EmployeeFactory {

	@Override
	public Employee createEmployee(String name, double salary) {

		return new PartTimeEmployee(name, salary);
	}

}

class EmployeePayroll {
	EmployeeFactory factory;

	public EmployeePayroll(EmployeeFactory factory) {
		super();
		this.factory = factory;
	}
	
	public void paySalary(String name, double salary) {
		Employee emp = factory.createEmployee(name, salary);
		emp.paySalary();
	}

}

public class AbstractFactoryDp {

	public static void main(String[] args) {
		EmployeeFactory ftef = new FTEFactory();
		EmployeeFactory ptef = new PTEFactory();

		EmployeePayroll ftep = new EmployeePayroll(ftef);
		ftep.paySalary("Ram", 5000.00);
		EmployeePayroll ptep = new EmployeePayroll(ptef);
		ptep.paySalary("Seetha", 4500.00);

	}

}
