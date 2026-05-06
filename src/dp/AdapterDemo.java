package dp;

interface MicroUSB{
	public void chargeWithMicroUSB();
}

class TypeCCharger {
	public void chargeWithTypeC() {
		System.out.println("Charging using Type-C Charger");
	}
}

class TypeBCharger{
	public void chargeWithTypeB() {
		System.out.println("Charging using Type-B Charger");
	}
}

class TypeCToMicroUSB implements MicroUSB{

	private TypeCCharger typec;
	
	public TypeCToMicroUSB(TypeCCharger typec) {
		super();
		this.typec = typec;
	}

	@Override
	public void chargeWithMicroUSB() {
		System.out.println("Adapter converts Type-C to MicroUSB");
		typec.chargeWithTypeC();
		
	}	
}

class TypeBToMicroUSB implements MicroUSB{

	private TypeBCharger typeb;
	
	public TypeBToMicroUSB(TypeBCharger typeb) {
		super();
		this.typeb = typeb;
	}

	@Override
	public void chargeWithMicroUSB() {
		System.out.println("Adapter converts Type-B to MicroUSB");
		typeb.chargeWithTypeB();
		
	}	
}


public class AdapterDemo {

	public static void main(String[] args) {
		TypeCCharger laptopCharger = new TypeCCharger();
		MicroUSB  phone1  = new TypeCToMicroUSB(laptopCharger);

		TypeBCharger powerbankCharger = new TypeBCharger();
		MicroUSB phone2 = new TypeBToMicroUSB(powerbankCharger);
		
		phone1.chargeWithMicroUSB();
		
		phone2.chargeWithMicroUSB();
		
		
	}

}