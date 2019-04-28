import java.rmi.Naming;
import java.util.Scanner;

public class Cliente1 {
  public static void main(String []args) {
    try {
      System.setProperty("java.security.policy", "rmi.policy");
      System.setSecurityManager(new SecurityManager());
      IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup("rmi://"+args[0]+":2000/SistemasDistribuidos");

      // Invocación a todos los métodos remotos
      Scanner sc = new Scanner(System.in);
      String cadena;
      System.out.println("Escribe el mensaje (Cliente 1)");
      cadena = sc.nextLine();
      objrem.Saludo(cadena);
    } catch(Exception e) {  e.printStackTrace();  }
  }
}