import java.rmi.registry.*;

public class Servidor {
  public static void main(String []args) {
    try {
      Registry registro = LocateRegistry.createRegistry(2000);
      registro.rebind("SistemasDistribuidos", new ObjetoRemoto());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}