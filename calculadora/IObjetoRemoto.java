import java.rmi.RemoteException;
import java.rmi.Remote;

public interface IObjetoRemoto extends Remote {
  // Firmas de los métodos Calculadora
  public double Suma(float num1, float num2) throws RemoteException; 
  public double Resta(float num1, float num2) throws RemoteException; 
  public double Multiplicacion(float num1, float num2) throws RemoteException; 
  public double Division(float num1, float num2) throws RemoteException; 
}