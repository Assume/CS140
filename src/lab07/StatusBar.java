package lab07;

public class StatusBar extends Buffer {

	private Buffer attached_to;

	public StatusBar(Buffer attached_to) {
		this.attached_to = attached_to;
	}
	
	public String getText(){
		return "----- "+attached_to.getNumLines()+" -----";	
	}
	
	
	

}
