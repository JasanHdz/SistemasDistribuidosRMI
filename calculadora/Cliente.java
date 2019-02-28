import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
  public static void main(String []args) {
    try {
      System.setProperty("java.security.policy", "rmi.policy");
      System.setSecurityManager(new SecurityManager());
      IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup("rmi://localhost:2000/SistemasDistribuidos");
      // Aquí vamos a ejecutar nuestro ObjetoRemoto
      showMenu();
    } 
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public static void showMenu() {
    int exit = 1;
    do {
      System.out.println("::: Bienvenidos a Calculadora :::");
      System.out.println("Elige alguna de las siguientes Opciones...");
      System.out.println("1. Sumar");
      System.out.println("2. Restar");
      System.out.println("3. Multiplicar");
      System.out.println("4. Dividir");
      System.out.println("5. Residuo de una division no excata");
      System.out.println("0. Salir.....");

      // Leer la respuesta del Usuario
      Scanner sc = new Scanner(System.in);
      int response = sc.nextInt();

      switch(response) {
        case 0:
          System.out.println("Estamos Saliendo de la aplicación"); 
          System.out.println("................................."); 
          exit = 0;
          System.out.println("Ya Salimos, esto vale exit: "+ exit + "\n"); 
        break;
        case 1:
          showSumar();
          break;
        case 2:
          showRestar();
          break;
        case 3:
          showMultiplicar();
          break;
        case 4:
          showDividir();
          break;
        case 5:
          showResiduo();
          break;
        default:
          System.out.println();
					System.out.println("....¡¡Selecciona una opción!!....");
					System.out.println();
          break;
      }
    } while(exit != 0);
  }

  public static void showSumar() {
    int exit = 0;
    do {
      System.out.println("\n Haz elegido la opción de Sumar");
      System.out.println("Ingresa el Primer Número: ");
			
      // Leer Primer Número
			Scanner sc1 = new Scanner(System.in);
			float num1 = sc1.nextFloat();

			System.out.println("Ingresa el Segundo Número: ");
      // Leer Segundo Número
			Scanner sc2 = new Scanner(System.in);
			float num2 = sc2.nextFloat();
      // Resultado
      // double resultado = objrem.Suma(num1, num2));
      double res = num1 + num2;
			System.out.print("El resultado de Sumar " + num1 + " + " + num2 + " es: " + res);
      
      System.out.println();
      System.out.println("\n0. Regresar al menú anterior...");
      // Leer resouesta del usuario
			Scanner sc3 = new Scanner(System.in);
			int salir = sc3.nextInt();
      if(salir == 0) {
				showMenu();
			}
    } while(exit != 0);
  }

  public static void showRestar() {
    int exit = 0;
    do {
      System.out.println("\n Haz elegido la opción de Restar");
      System.out.println("Ingresa el Primer Número: ");
			
      // Leer Primer Número
			Scanner sc1 = new Scanner(System.in);
			float num1 = sc1.nextFloat();

			System.out.println("Ingresa el Segundo Número: ");
      // Leer Segundo Número
			Scanner sc2 = new Scanner(System.in);
			float num2 = sc2.nextFloat();
      // Resultado
      // double resultado = objrem.Restar(num1, num2));
      double res = num1 - num2;
			System.out.print("El resultado de Restar " + num1 + " - " + num2 + " es: " + res);
      
      System.out.println();
      System.out.println("\n0. Regresar al menú anterior...");
      // Leer resouesta del usuario
			Scanner sc3 = new Scanner(System.in);
			int salir = sc3.nextInt();
      if(salir == 0) {
				showMenu();
			}
    } while(exit != 0);
  }

  public static void showMultiplicar() {
    int exit = 0;
    do {
      System.out.println("\n Haz elegido la opción de Multiplicar");
      System.out.println("Ingresa el Primer Número: ");
			
      // Leer Primer Número
			Scanner sc1 = new Scanner(System.in);
			float num1 = sc1.nextFloat();

			System.out.println("Ingresa el Segundo Número: ");
      // Leer Segundo Número
			Scanner sc2 = new Scanner(System.in);
			float num2 = sc2.nextFloat();
      // Resultado
      // double resultado = objrem.Multiplicar(num1, num2));
      double res = num1 * num2;
			System.out.print("El resultado de Multiplicar " + num1 + " * " + num2 + " es: " + res);
      
      System.out.println();
      System.out.println("\n0. Regresar al menú anterior...");
      // Leer resouesta del usuario
			Scanner sc3 = new Scanner(System.in);
			int salir = sc3.nextInt();
      if(salir == 0) {
				showMenu();
			}
    } while(exit != 0);
  }

  public static void showDividir() {
    int exit = 0;
    do {
      System.out.println("\n Haz elegido la opción de Dividir");
      System.out.println("Ingresa el Primer Número: ");
			
      // Leer Primer Número
			Scanner sc1 = new Scanner(System.in);
			float num1 = sc1.nextFloat();

			System.out.println("Ingresa el Segundo Número: ");
      // Leer Segundo Número
			Scanner sc2 = new Scanner(System.in);
			float num2 = sc2.nextFloat();
      // Division por Cero.
      if(num2 != 0) {
        double res = num1 / num2;
        // Resultado
        // double resultado = objrem.Dividir(num1, num2));
			  System.out.print("El resultado de Dividir " + num1 + " / " + num2 + " es: " + res);
      } else {
        System.out.println("Error, no podemos hacer una división entre Cero");
        System.out.println("¡......................Volver a intentar.................!");
        showDividir();
      }      
      System.out.println();
      System.out.println("\n0. Regresar al menú anterior...");
      // Leer resouesta del usuario
			Scanner sc3 = new Scanner(System.in);
			int salir = sc3.nextInt();
      if(salir == 0) {
				showMenu();
			}
    } while(exit != 0);
  }

  public static void showResiduo() {
    int exit = 0;
    do {
      System.out.println("\n Haz elegido la opción de Obtener el Residuo de una División");
      System.out.println("Ingresa el Primer Número: ");
			
      // Leer Primer Número
			Scanner sc1 = new Scanner(System.in);
			float num1 = sc1.nextFloat();

			System.out.println("Ingresa el Segundo Número: ");
      // Leer Segundo Número
			Scanner sc2 = new Scanner(System.in);
			float num2 = sc2.nextFloat();
      // Resultado
      // double resultado = objrem.Residuo(num1, num2));
      double res = num1 % num2;
			System.out.print("El Residuo de dividir " + num1 + " / " + num2 + " es: " + res);
      
      System.out.println();
      System.out.println("\n0. Regresar al menú anterior...");
      // Leer resouesta del usuario
			Scanner sc3 = new Scanner(System.in);
			int salir = sc3.nextInt();
      if(salir == 0) {
				showMenu();
			}
    } while(exit != 0);
  }
}