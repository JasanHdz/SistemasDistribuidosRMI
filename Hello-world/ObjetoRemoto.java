import java.rmi.*;
import java.rmi.server.*;

public class ObjetoRemoto extends UnicastRemoteObject implements IObjetoRemoto {
  // Constructor Implicito sin Párametros.
  public ObjetoRemoto() throws RemoteException { 
    super();
  }
  public void Saludo(String mensaje) throws RemoteException {
    System.out.println(mensaje);
  }
}