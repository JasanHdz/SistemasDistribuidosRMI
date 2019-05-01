import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
  public Frame() {
    setSize(450, 280);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public void inciarComponentes() {
    JPanel panel = new JPanel(); //Creación de un panel
		panel.setLayout(null);
//  panel.setBackground(Color.GREEN); //Establecemos el color del panel
		this.getContentPane().add(panel); //Agregamos panel a la ventana
		
		JLabel etiqueta = new JLabel(); //Creamos una etiqueta
    etiqueta.setText("Hola mundo :)");
    etiqueta.setBounds(10, 10, 40, 20);
		etiqueta.setForeground(Color.blue); //Establecemos el color de la letra.
		etiqueta.setOpaque(true); //Establecemos pintar el fondo de la etiqueta.
		etiqueta.setBackground(Color.green); //Cambiamos el color del fondo de la etiqueta.
		panel.add(etiqueta); //Agregamos la etiqueta al panel
  }
}