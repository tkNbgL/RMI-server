package homeWork;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CuncurrentClient2 implements Runnable{
	String[] args;
	public CuncurrentClient2(String[] args2) {
		// TODO Auto-generated constructor stub
		args=args2;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String host=(args.length<1)?null : args[0];
		Determinant det=new Determinant();
		try{
			Registry registry=LocateRegistry.getRegistry(host);
			remoteMethods stub=(remoteMethods)registry.lookup("calculate");
			double[][] response=stub.sendMatrix();
			/*for(int i=0; i<100; i++){
				for(int j=0; j<100; j++){
					System.out.println(response[i][j]);
				}
			}*/
			double asd=det.dete(response);
			stub.takeAnswer(asd);
		}catch(Exception e){
			System.err.println("Client exception : "+e.toString());
			e.printStackTrace();
		}
	}

}
