import java.rmi.Naming;1
import java.util.Scanner;
import java.util.Date;

public class Cliente {
  public static void main(String []args) {
    try {
      System.setProperty("java.security.policy", "rmi.policy");
      System.setSecurityManager(new SecurityManager());
      IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup("rmi://localhost:2000/SistemasDistribuidos");

      // Aquí vamos a ejecutar nuestro objeto remoto.
      ObjetoRemoto cliente1 = new ObjetoRemoto(1001, "Jorge Ramos", 20000, 0);
      // Creando Nip
      cliente1.setNip(2244);
      showIngresar(cliente1);

    } catch(Exception e) {
        e.printStackTrace();
      }
  }
  public static void showIngresar(ObjetoRemoto cliente) {
    System.out.println("::Bienvenido a Cajero Automatico Santander::");
    System.out.println("Ingresa Tu NIP porfavor");
    Scanner sc = new Scanner(System.in);
    int consulta = sc.nextInt();
    if(consulta == cliente.getNip()) {
      showMenu(cliente);
    } else {
      System.out.println("Lo sentimos tu NIP no es valido\n");
      showIngresar(cliente);
    }
  }
  public static void showMenu(ObjetoRemoto cliente) {
    int exit = 0;
    do {
      System.out.println("::Bienvenido señor: " + cliente.getTitular() + "Nos Da gusto tenerlo por aquí");
      System.out.println("Eliga alguna de la siguientes Opciones");
      System.out.println("0. Salir de la Cuenta");
      System.out.println("1. Consultar Saldo ");
      System.out.println("2. Depositar ");
      System.out.println("3. Retirar ");

      // leer respuesta del usuario
      Scanner sc = new Scanner(System.in);
      int response = sc.nextInt();

      switch(response) {
        case 1:
          System.out.println("Haz elegido la opción de Consultar Saldo");
          System.out.println("Tu Saldo Actual es: " + cliente.getSaldo());
          showMenu(cliente);
        break;
        case 2: 
          try {
          System.out.println("Haz elegido la opción para Depositar Dinero");
          System.out.println("Ingrese los Billetes porfavor");
          System.out.println("¿Que Cantidad desea ingresar?, favor de escribirla para guardar el efectivo");
          Scanner sc1 = new Scanner(System.in);
          int money = sc1.nextInt();
          cliente.Depositar(money);
          System.out.println("Gracias por su Deposito.\n");
          Scanner sc2 = new Scanner(System.in); 
          System.out.println("0. Para regresar al menú anterior");
          if(sc2.nextInt() == 0) {
            showMenu(cliente);
          }
          break;
          } catch(Exception e) {
            e.printStackTrace();
          }
        case 3: 
          try {
          System.out.println("Haz elegido la opción para Retirar Dinero");
          System.out.println("Porfavor ingrese la cantidad que desee retirar: ");
          Scanner sc2 = new Scanner(System.in);
          int money2 = sc2.nextInt();
          cliente.Retirar(money2);
          System.out.println("A continuación puede recoger su dinero en la bandeja...");
          System.out.println("Transacción realizada Correctamente!! Vuelva proto!");
          Scanner sc4 = new Scanner(System.in); 
          System.out.println("0. Para regresar al menú anterior");
          if(sc4.nextInt() == 0) {
            showMenu(cliente);
          }
          break;
        } catch(Exception e) {
          e.printStackTrace();
        }
        default: 
          System.out.println("¡¡¡Por favor Seleccione alguna Opción!!!");
          showMenu(cliente);
          break;
      } 
    } while(exit != 0);
  }
  

}