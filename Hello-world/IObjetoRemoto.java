import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IObjetoRemoto extends Remote {
  // Recuerda que una Interfaz solo tiene la firma del método.
  public void Saludo(String mensaje) throws RemoteException;
}