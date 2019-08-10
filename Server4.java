package homeWork;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



public class Server4 implements remoteMethods{
	Matrix[] maxArray;
	int index=0;
	double determinant=1;
	public Server4(){
		maxArray=new Matrix[4];
		Matrix max;
		for(int i=0; i<4; i++){
			max=new Matrix();
			maxArray[i]=max;
		}
	}
	
	
	
	public double getDeterminant() {
		return determinant;
	}



	public Matrix[] getMaxArray() {
		return maxArray;
	}



	@Override
	public synchronized double[][] sendMatrix() throws RemoteException {
		// TODO Auto-generated method stub
		double arr[][]=maxArray[index].getMatrix();
		index++;
		return arr;
	}

	
	@Override
	public synchronized void takeAnswer(double answ) throws RemoteException {
		// TODO Auto-generated method stub
		determinant=determinant*answ;
		System.out.println(determinant);
	}

	public static void main(String args[]){
			try{
				Server4 obj=new Server4();
				remoteMethods stub=(remoteMethods) UnicastRemoteObject.exportObject(obj, 0);
				//remoteMethods stub1=(remoteMethods) UnicastRemoteObject.exportObject(obj, 0);
				Registry registry=LocateRegistry.getRegistry();
				registry.bind("calculate", stub);
				//registry.bind("swear", stub1);
				System.err.println("Server ready");
			}catch(Exception e){
				System.err.println("Server exception: "+e.toString());
				e.printStackTrace();
			}
		}
	
}
