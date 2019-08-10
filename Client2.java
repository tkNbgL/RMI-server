package homeWork;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;




public class Client2 {
	public static void main(String[] args){
		
		for (int i = 0; i < 4; i++) {
			new Thread(new CuncurrentClient2(args)).start();
		}
	}
}
