// El comando rmiregistry inicia un registro de objetos remotos en el puerto especificado en el host actual.
/*

LocateRegistry se utiliza para obtener una referencia a un registro de objetos remotos de arranque en un host particular (incluido el host local), 
o para crear un registro de objetos remotos que acepte llamadas en un puerto específico.
Tenga en cuenta que una llamada a getRegistry no realiza realmente una conexión al host remoto. 
Simplemente crea una referencia local al registro remoto y tendrá éxito incluso si no se está ejecutando ningún registro en el host remoto.
Por lo tanto, una invocación de método posterior a un registro remoto devuelto como resultado de este método puede fallar.

*/
import java.rmi.registry.*;

public class Servidor {

  public static void main(String []args) {
    try {
      Registry registro = LocateRegistry.createRegistry(2320);
      registro.rebind("SistemasDistribuidos", new ObjetoRemoto());
    } catch(Exception e) {  e.printStackTrace();  }
  }
}