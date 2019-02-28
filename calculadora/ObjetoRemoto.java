import java.rmi.*;
import java.rmi.server.*;

public class ObjetoRemoto extends UnicastRemoteObject implements IObjetoRemoto {
  public ObjetoRemoto() throws RemoteException {
    super();
  }
  public double Suma(float num1, float num2) throws RemoteException {
    return num1 + num2;
  } 
  public double Resta(float num1, float num2) throws RemoteException {
    return num1 - num2;
  }
  public double Multiplicacion(float num1, float num2) throws RemoteException {
    return num1 * num2;
  }
  public double Division(float num1, float num2) throws RemoteException {
    if(num2 != 0) {
      return num1 / num2;
    } else {
      return 0;
    }
  }
}