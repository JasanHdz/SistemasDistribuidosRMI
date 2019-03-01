import java.rmi.Naming;
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
      System.out.println("::Bienvenido a Cajero Automatico Santander::");
      System.out.println("Ingresa Tu NIP porfavor");
      Scanner sc1 = new Scanner(System.in);
      int consulta = sc1.nextInt();
      if(consulta == cliente1.getNip()) {
        System.out.println("::Bienvenido señor: " + cliente1.getTitular() + "Nos Da gusto tenerlo por aquí");
        System.out.println("Eliga alguna de la siguientes Opciones");
        int exit = 0;
        do {
          System.out.println("0. Salir de la Cuenta");
          System.out.println("1. Consultar Saldo ");
          System.out.println("2. Depositar ");
          System.out.println("3. Retirar ");

          // leer respuesta del usuario
          Scanner sc2 = new Scanner(System.in);
          int response = sc2.nextInt();

          switch(response) {
            case 1:
              System.out.println("Haz elegido la opción de Consultar Saldo");
              System.out.println("Tu Saldo Actual es: " + cliente1.getSaldo());
            break;
            case 2: 
              System.out.println("Haz elegido la opción para Depositar Dinero");
              System.out.println("Ingrese los Billetes porfavor");
              System.out.println("¿Que Cantidad desea ingresar?, favor de escribirla para guardar el efectivo");
              Scanner sc3 = new Scanner(System.in);
              int money = sc3.nextInt();
              cliente1.Depositar(money);
              System.out.println("Gracias por su Deposito.");
              break;
            case 3: 
              System.out.println("Haz elegido la opción para Retirar Dinero");
              System.out.println("Porfavor ingrese la cantidad que desee retirar: ");
              Scanner sc4 = new Scanner(System.in);
              int money2 = sc4.nextInt();
              cliente1.Retirar(money2);
              System.out.println("A continuación puede recoger su dinero en la bandeja...");
              System.out.println("Transacción realizada Correctamente!! Vuelva proto!");
            break;
            default: 
              System.out.println("¡¡¡Por favor Seleccione alguna Opción!!!");
              break;
          } 
        } while(exit != 0);
      } else {
        System.out.println("Error con el Nip");
      }

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
  // public static void showIngresar() {
  //   ObjetoRemoto cliente1 = new ObjetoRemoto(1001, "Jorge Ramos", 20000, 0);
  //     // Creando Nip
  //   cliente1.setNip(2244);
  //   System.out.println("::Bienvenido a Cajero Automatico Santander::");
  //   System.out.println("Ingresa Tu NIP porfavor");
  //   Scanner sc = new Scanner(System.in);
  //   int consulta = sc.nextInt();
  //   if(consulta == cliente1.getNip()) {
  //     System.out.println("::Bienvenido señor: " + cliente1.getTitular() + "Nos Da gusto tenerlo por aquí");
  //     System.out.println("Eliga alguna de la siguientes Opciones");
  //     showMenu();
  //   }
  // }
//   public static void showMenu() {
//     ObjetoRemoto cliente1 = new ObjetoRemoto(1001, "Jorge Ramos", 20000, 0);
//       // Creando Nip
//     cliente1.setNip(2244);
//     int exit = 0;
//     do {
//       System.out.println("0. Salir de la Cuenta");
//       System.out.println("1. Consultar Saldo ");
//       System.out.println("2. Depositar ");
//       System.out.println("3. Retirar ");

//       // leer respuesta del usuario
//       Scanner sc = new Scanner(System.in);
//       int response = sc.nextInt();

//       switch(response) {
//         case 1:
//           System.out.println("Haz elegido la opción de Consultar Saldo");
//           System.out.println("Tu Saldo Actual es: " + cliente1.getSaldo());
//         break;
//         case 2: 
//           System.out.println("Haz elegido la opción para Depositar Dinero");
//           System.out.println("Ingrese los Billetes porfavor");
//           System.out.println("¿Que Cantidad desea ingresar?, favor de escribirla para guardar el efectivo");
//           Scanner sc1 = new Scanner(System.in);
//           int money = sc1.nextInt();
//           cliente1.Depositar(money);
//           System.out.println("Gracias por su Deposito.");
//           break;
//         case 3: 
//           System.out.println("Haz elegido la opción para Retirar Dinero");
//           System.out.println("Porfavor ingrese la cantidad que desee retirar: ");
//           Scanner sc2 = new Scanner(System.in);
//           int money2 = sc2.nextInt();
//           cliente1.Retirar(money2);
//           System.out.println("A continuación puede recoger su dinero en la bandeja...");
//           System.out.println("Transacción realizada Correctamente!! Vuelva proto!");
//         break;
//         default: 
//           System.out.println("¡¡¡Por favor Seleccione alguna Opción!!!");
//           break;
//       } 
//     } while(exit != 0);
//   }

// }