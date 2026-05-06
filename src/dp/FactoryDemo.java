package dp;

interface Payment {
	public void pay(double amount);
}

class CreditCard implements Payment {

	@Override
	public void pay(double amount) {

		System.out.println("Paid " + amount + " using CC");
	}

}

class Gpay implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using Gpay");

	}

}

class PaymentFactory {

	public static Payment getPayment(String type) {

		if (type == null)
			return null;

		switch (type.toUpperCase()) {
		case "CC": {
			return new CreditCard();

		}
		case "GPAY": {

			return new Gpay();

		}
		default: {
			throw new IllegalArgumentException("Invalid Payment Type");

		}
		}

	}
}

public class FactoryDemo {

	public static void main(String[] args) {
		Payment pa = PaymentFactory.getPayment("cc");
		pa.pay(4500);

		Payment pb = PaymentFactory.getPayment("Gpay");
		pb.pay(500);
	}
}


