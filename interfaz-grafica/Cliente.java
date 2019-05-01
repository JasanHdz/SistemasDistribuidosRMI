import java.rmi.Naming;
import java.util.Scanner;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class Cliente {
  public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		String aux = "";
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine()) != null) {
			aux += cadena;
		}
		b.close();
		// System.out.println(aux);
		String[] parts = aux.split(":");
		int index = 0;
		// for (String string : parts) {
		// 	System.out.println(string);
		// 	index++;
		// }
		int numcuenta = Integer.parseInt(parts[1]);
		String cliente = parts[3];
		int saldo = Integer.parseInt(parts[5]);
		int nip = Integer.parseInt(parts[7]);
		int movimientos = Integer.parseInt(parts[9]);

    /** Vamos a crear el ObjetoRemoto */
     // Aquí vamos a ejecutar nuestro objeto remoto.
      ObjetoRemoto cliente1 = new ObjetoRemoto(numcuenta, cliente, saldo, movimientos);
      cliente1.setNip(nip);
      cliente1.showIngresar();

      ObjetoRemoto cliente2 = new ObjetoRemoto(100, "Pedro Salazar", 40000, 10);
      cliente2.setNip(2344);
      cliente2.showIngresar();
	}

  public static void main(String []args) {
    try {
      System.setProperty("java.security.policy", "rmi.policy");
      System.setSecurityManager(new SecurityManager());
      IObjetoRemoto objrem = (IObjetoRemoto) Naming.lookup("rmi://"+args[0]+":2000/SistemasDistribuidos");

      muestraContenido("archivo.txt");

    } catch(Exception e) {
        e.printStackTrace();
    }
  }
}