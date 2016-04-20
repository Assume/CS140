package assignment05;

public class Child extends Parent {

	
	public static void main(String[] args) {
		Parent p = new Parent();
		p.setpName("Tom");
		p.print();
		p = new Child(); 
		p.setpName("Dick"); 
		((Child)p).setcName("Harry"); 
		p.print(); 
	}
	
	
	private String cName;

	public void setcName(String name) {
		this.cName = name;
	}

	@Override
	public void print() {
		System.out.println(cName);
		super.print();
	}

	
	
}
