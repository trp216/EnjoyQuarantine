package model;

public class Reminder {
	
	private String text;
	
	private Reminder next;
	
	private Reminder prev;
	
	private boolean keepRunning;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Reminder getNext() {
		return next;
	}

	public void setNext(Reminder next) {
		this.next = next;
	}

	public Reminder getPrev() {
		return prev;
	}

	public void setPrev(Reminder prev) {
		this.prev = prev;
	}
		
	
	public void advanceTimer(int maxmin) {
		int minutos = 0 ; 
        int segundos = 0; 
        int milesimas = 0;
		
	   
	        
            //Incrementamos 1 milesimas de segundo
            milesimas++;

            //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
            //y las milesimas de segundo de nuevo a 0
            if( milesimas == 1000 ){
                milesimas = 0;
                segundos += 1;
                //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                //y los segundos vuelven a 0
                if( segundos == 60 ) {
                    segundos = 0;
                    minutos++;
                }
            }

            if(minutos ==maxmin) {
            	keepRunning = false;
            }
		
	}

	public boolean isKeepRunning() {
		return keepRunning;
	}

	public void setKeepRunning(boolean keepRunning) {
		this.keepRunning = keepRunning;
	}

}
