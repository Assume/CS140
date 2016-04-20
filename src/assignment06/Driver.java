package assignment06;

public class Driver {

	public static void main(String[] args) {
		Parent p = new Parent("Jennie");
		p.print();
		p = new Child("Jennie", "Jeff");
		p.print();
	}

}