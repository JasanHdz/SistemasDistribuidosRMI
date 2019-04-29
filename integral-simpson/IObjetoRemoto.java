import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IObjetoRemoto extends Remote
{
    public double Simpson(double a, double b, double n) throws RemoteException;
    public double EvaluaFuncion(double x) throws RemoteException;

}  // Fin interfaz IObjetoRemoto
