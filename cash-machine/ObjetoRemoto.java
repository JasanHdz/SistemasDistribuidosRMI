import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;

public class ObjetoRemoto extends UnicastRemoteObject implements IObjetoRemoto {
  private int numeroCuenta;
  private int nip;
  private String titular;
  private float saldo;
  private int numeroMovientos;
  
  public ObjetoRemoto() throws RemoteException {
    super();
  }

  public int getNumeroCuenta() {
    return numeroCuenta;
  }
  public void setNumeroCuenta(int numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }
  public String getTitular() {
    return titular;
  }
  public void setTitular(String titular) {
    this.titular = titular;
  }
  public float getSaldo() {
    return saldo;
  }
  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }
  public int getNumeroMovientos() {
    return numeroMovientos;
  }
  public int getNip() {
    return nip;
  }
  public void setNip(int nip) {
    this.nip = nip;
  }
  
  public ObjetoRemoto(int numeroCuenta, String titular, float saldo, int numeroMovientos) throws RemoteException{
    super();
    this.numeroCuenta = numeroCuenta;
    this.titular = titular;
    this.saldo = saldo;
    this.numeroMovientos = numeroMovientos;
  }
  // @Override
  public Date lastMove(Date dateI) {
    return dateI;
  }
  @Override
  public String toString() {
    return "\n:: ObjetoRemoto ::" +
           "\nCliente: " + getTitular() +
           "\nNumero de Cuenta: " + getNumeroCuenta() +
           "\nNIP Actual: " + getNip() +
           "\nSaldo Actual: " + getSaldo() +
           "\nNumeroMovientos: " + getNumeroMovientos();

  }
  // @Override 
  public String Retirar(float cantidad) throws RemoteException {
    if(cantidad > getSaldo()) {
      return "Lo sentimos usted no puede retirar esta cantidad de" + cantidad + 
      "Porque no cuenta con Saldo sufiencte para realizar la transacción";
    } else {
      float saldoActual = getSaldo() - cantidad;
      setSaldo(saldoActual);
      return ""+saldoActual;
    }
  }
  // @Override
  public void Depositar(int cantidad) throws RemoteException {
    float saldoActual = getSaldo() + cantidad;
    setSaldo(saldoActual);
  }
}