import java.rmi.Naming;

public class Cliente2 {
  public static void main(String []args) {
    try {
      System.setProperty("java.security.policy", "rmi.policy");
      System.setSecurityManager(new SecurityManager());
      IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup("rmi://"+args[0]+":2000/SistemasDistribuidos");
      objrem.Saludo("Hola mundo desde mi casa");
    } catch(Exception e) {  e.printStackTrace();  }
  }
}