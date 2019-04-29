import java.rmi.Naming;
import java.util.Scanner;

public class Cliente
{
    public static void main(String []args){
        try{
            System.setProperty("java.security.policy", "rmi.policy");
            System.setSecurityManager(new SecurityManager());
            IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup("rmi://localhost:2320/SistemasDistribuidos");
            
            Scanner leer = new Scanner(System.in);
            double a,b,n;

            System.out.println("--Simpson--\n");
            System.out.print("Proporciona el valor de n: ");
            n=leer.nextDouble();
            System.out.print("Proporciona el valor de a: ");
            a=leer.nextDouble();
            System.out.print("Proporciona el valor de b: ");
            b=leer.nextDouble();

           
            System.out.println("Resultado de la integral= " + objrem.Simpson(a,b,n));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    } // Fin main
}  // Fin Clase Cliente
