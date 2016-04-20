package assignment06;

public class Child extends Parent {

	private String cName;

	public Child(String pName, String cName) {
		super(pName);
		this.cName = cName;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(cName);
	}

}
