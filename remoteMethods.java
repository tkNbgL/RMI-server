package homeWork;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface remoteMethods extends Remote{
	double[][] sendMatrix() throws RemoteException;
	void takeAnswer(double answ) throws RemoteException;
}
