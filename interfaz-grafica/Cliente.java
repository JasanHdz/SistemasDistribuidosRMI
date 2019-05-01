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
		// int index = 0;
		// for (String string : parts) {
		// 	System.out.println(string);
		// 	index++;
		// }
		int numcuenta = Integer.parseInt(parts[1]);
		String nameCliente1 = parts[3];
		float saldo = Float.parseFloat(parts[5]);
		int nip = Integer.parseInt(parts[7]);
		int movimientos = Integer.parseInt(parts[9]);
		
		int numcuenta2 = Integer.parseInt(parts[11]);
		String nameCliente2 = parts[13];
		float saldo2 = Float.parseFloat(parts[15]);
		int nip2 = Integer.parseInt(parts[17]);
		int movimientos2 = Integer.parseInt(parts[19]);
		
		int numcuenta3 = Integer.parseInt(parts[21]);
		String nameCliente3 = parts[23];
		float saldo3 = Float.parseFloat(parts[25]);
		int nip3 = Integer.parseInt(parts[27]);
		int movimientos3 = Integer.parseInt(parts[29]);

    /** Vamos a crear el ObjetoRemoto */
     // Aquí vamos a ejecutar nuestro objeto remoto.
      ObjetoRemoto cliente1 = new ObjetoRemoto(numcuenta, nameCliente1, saldo, movimientos);
      cliente1.setNip(nip);
      cliente1.showIngresar();

      ObjetoRemoto cliente2 = new ObjetoRemoto(numcuenta2, nameCliente2, saldo2, movimientos);
      cliente2.setNip(nip2);
      cliente2.showIngresar();
      
			ObjetoRemoto cliente3 = new ObjetoRemoto(numcuenta3, nameCliente3, saldo2, movimientos3);
      cliente2.setNip(nip3);
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