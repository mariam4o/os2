package Device;
import java.util.*;
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	 public static void main(String [] args) throws InterruptedException {

	        Scanner input = new Scanner(System.in);

	        System.out.println("What is the Number of Pumps?");
	        int nPumps = input.nextInt();
	        Router MyStation = new Router(nPumps); //object of PetrolStation

	        System.out.println("What is the Number of Clients?");
	        int nClients = input.nextInt();
	        DEVICE[] client = new DEVICE[nClients];

	        System.out.println("What is the Client's Name?");
	        input=new Scanner(System.in);
	        for (int j = 0; j < nClients; j++) {
	            String a = input.nextLine();
	            client[j] = new DEVICE(a, MyStation);
	        }
	        /* Starting all the client threads */
	        for (int j = 0; j < nClients; j++) {
	            Thread.sleep(1000);
	            client[j].start();}
	    }



}
