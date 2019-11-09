package Device;
import java.util.*;
import static java.lang.Thread.sleep;
public class Router {

	public Router() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	 public boolean[] pumparray;
	    public int nPumps;
	    public Semaphore pump;
	    public int nOccupied;


	   Router(int x) { //gets the number of pumps and create a semaphore with these pumps (shared resource)
	        //we have pumparray to check if a place is available or not.
	        nPumps = x;
	        pump = new Semaphore(nPumps);
	        pumparray = new boolean[nPumps];
	    }


	    //methods
	    public synchronized int occupy(DEVICE ob) throws InterruptedException {

	        for (int i = 0; i < nPumps; i++) {
	            if (pumparray[i] == false) { /* means It's available for being occupied */
	                nOccupied++;
	                ob.assignedPump = i+1;
	                System.out.println("pump " + ob.assignedPump + ": " + ob.getName() + " occupied");
	                pumparray[i] = true;
	                sleep(1000);
	                break;
	            }
	        }
	        return ob.assignedPump;
	    }
	    public String serve() throws InterruptedException {
	        String val = " being served";
	        sleep(1000);
	        return val;
	    }
	    public String pay() throws InterruptedException {
	        sleep(1000);
	        return (" paying");
	    }
	    public synchronized String leave(DEVICE ob) {

	        { /* means It's available for being occupied */
	            nOccupied--;
	            pumparray[ob.assignedPump-1] = false;
	        }
	       //no need for notify here as it already called from the client after finishing the leave function
	        notify();
	        return " leave";
	    }


}
