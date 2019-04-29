import java.rmi.RemoteException;
import java.rmi.Remote;
import java.util.Date;

public interface IObjetoRemoto extends Remote {
  // Firmas de los métodos de Cajero Automatico.
  Date lastMove(Date dateI) throws RemoteException;
  String Retirar(float cantidad) throws RemoteException;
  void Depositar(int cantidad) throws RemoteException;
}