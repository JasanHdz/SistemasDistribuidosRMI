import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.util.Scanner;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObjetoRemoto extends UnicastRemoteObject implements IObjetoRemoto {
  private int numeroCuenta;
  private int nip;
  private String titular;
  private float saldo;
  private int numeroMovientos;

  private int consultaNip;
  private int response;
  private int exit = 0;
  private float cantidad = 0;
  
  public ObjetoRemoto() throws RemoteException {
    super();
  }

  public float getCantidad() {
    return cantidad;
  }
  public void setCantidad(float cantidad) {
    this.cantidad = cantidad;
  }
  public int getExit() {
    return exit;
  }
  public void setExit(int exit) {
    this.exit = exit;
  }

  public int getConsultaNip() {
    return consultaNip;
  }
  public void setConsultaNip(int consultaNip) {
    this.consultaNip = consultaNip;
  }
  public int getResponse() {
    return response;
  }
  public void setResponse(int response) {
    this.response = response;
  }

  public int getNumeroCuenta() {
    return numeroCuenta;
  }
  public void setNumeroCuenta(int numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }
  public String getTitular() {
    return titular;
  }
  public void setTitular(String titular) {
    this.titular = titular;
  }
  public float getSaldo() {
    return saldo;
  }
  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }
  public int getNumeroMovientos() {
    return numeroMovientos;
  }
  public int getNip() {
    return nip;
  }
  public void setNip(int nip) {
    this.nip = nip;
  }
  
  public ObjetoRemoto(int numeroCuenta, String titular, float saldo, int numeroMovientos) throws RemoteException{
    super();
    this.numeroCuenta = numeroCuenta;
    this.titular = titular;
    this.saldo = saldo;
    this.numeroMovientos = numeroMovientos;
  }
  // @Override
  public Date lastMove(Date dateI) {
    return dateI;
  }
  @Override
  public String toString() {
    return "\n:: ObjetoRemoto ::" +
           "\nCliente: " + getTitular() +
           "\nNumero de Cuenta: " + getNumeroCuenta() +
           "\nNIP Actual: " + getNip() +
           "\nSaldo Actual: " + getSaldo() +
           "\nNumeroMovientos: " + getNumeroMovientos();

  }
  // @Override 
  public String Retirar(float cantidad) throws RemoteException {
    if(cantidad > getSaldo()) {
      return "Lo sentimos usted no puede retirar esta cantidad de" + cantidad + 
      "Porque no cuenta con Saldo sufiencte para realizar la transacción";
    } else {
      float saldoActual = getSaldo() - cantidad;
      setSaldo(saldoActual);
      return ""+saldoActual;
    }
  }
  // @Override
  public void Depositar(float cantidad) throws RemoteException {
    if(cantidad > 0) {
        float saldoActual = getSaldo() + cantidad;
        setSaldo(saldoActual);
    }
  }

  public void showIngresar() {
    // showFrame("::Bienvenido a Cajero Automatico Santander::", "Ingresa Tu NIP porfavor");
    Frame ventana = new Frame();
    ventana.setTitle("Cajero Automático");
		ventana.setVisible(true);

    JPanel panel = new JPanel();
    panel.setLayout(null);
    ventana.getContentPane().add(panel);

    JLabel etiqueta = new JLabel(); //Creamos una etiqueta
    etiqueta.setText("::Bienvenido a Cajero Automatico Santander::");
    etiqueta.setBounds(0, 0, 400, 30);
    etiqueta.setOpaque(true); //Establecemos pintar el fondo de la etiqueta.
    etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(etiqueta);

    JLabel etiqueta2 = new JLabel(); //Creamos una etiqueta2
    etiqueta2.setText("Ingresa Tu NIP porfavor");
    etiqueta2.setBounds(0, 30, 400, 30);
    etiqueta2.setOpaque(true); //Establecemos pintar el fondo de la etiqueta2.
    etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(etiqueta2);

    JTextField cajaTexto = new JTextField();
		cajaTexto.setBounds(100, 80, 200, 30);
    cajaTexto.setOpaque(true);
    panel.add(cajaTexto);

    JButton btn = new JButton();
		btn.setBounds(150, 140, 100, 40);
    btn.setText("click");
		panel.add(btn);

    JLabel saludo = new JLabel();
    saludo.setBounds(10,200,300,40);
    panel.add(saludo);

    //Agregando Evento de tipo ActionListener
	    ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				saludo.setText("Hola "+ cajaTexto.getText());
        setConsultaNip(Integer.parseInt(cajaTexto.getText()));

        if(getConsultaNip() == getNip()) {
          ventana.dispose();
          showMenu();
        } else {
            saludo.setText("Lo sentimos tu NIP no es valido\n");
            ventana.dispose();
            showIngresar();
        }
			}

		};
		
		btn.addActionListener(action);

  }

  public void showMenu() {
    do {
      Frame ventana = new Frame();
      ventana.setTitle("Cajero Automático");
      ventana.setVisible(true);

      JPanel panel = new JPanel();
      panel.setLayout(null);
      ventana.getContentPane().add(panel);

      JLabel etiqueta = new JLabel(); //Creamos una etiqueta
      etiqueta.setText("::Bienvenido señor: " + getTitular() + "Nos Da gusto tenerlo por aquí");
      etiqueta.setBounds(0, 0, 400, 30);
      etiqueta.setOpaque(true); //Establecemos pintar el fondo de la etiqueta.
      etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(etiqueta);

      JLabel etiqueta2 = new JLabel(); //Creamos una etiqueta2
      etiqueta2.setText("Eliga alguna de la siguientes Opciones");
      etiqueta2.setBounds(0, 20, 400, 30);
      etiqueta2.setOpaque(true); //Establecemos pintar el fondo de la etiqueta2.
      etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(etiqueta2);
      
      JLabel etiqueta3 = new JLabel(); //Creamos una etiqueta2
      etiqueta3.setText("0. Salir de la Cuenta");
      etiqueta3.setBounds(0, 40, 400, 30);
      etiqueta3.setOpaque(true); //Establecemos pintar el fondo de la etiqueta3.
      etiqueta3.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(etiqueta3);
      
      JLabel etiqueta4 = new JLabel(); //Creamos una etiqueta2
      etiqueta4.setText("1. Consultar Saldo ");
      etiqueta4.setBounds(0, 60, 400, 30);
      etiqueta4.setOpaque(true); //Establecemos pintar el fondo de la etiqueta4.
      etiqueta4.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(etiqueta4);
      
      JLabel etiqueta5 = new JLabel(); //Creamos una etiqueta2
      etiqueta5.setText("2. Depositar  ");
      etiqueta5.setBounds(0, 80, 400, 30);
      etiqueta5.setOpaque(true); //Establecemos pintar el fondo de la etiqueta5.
      etiqueta5.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(etiqueta5);
      
      JLabel etiqueta6 = new JLabel(); //Creamos una etiqueta2
      etiqueta6.setText("3. Retirar ");
      etiqueta6.setBounds(0, 100, 400, 30);
      etiqueta6.setOpaque(true); //Establecemos pintar el fondo de la etiqueta6.
      etiqueta6.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(etiqueta6);

      JTextField cajaTexto = new JTextField();
      cajaTexto.setBounds(100, 140, 200, 30);
      cajaTexto.setOpaque(true);
      panel.add(cajaTexto);

      JButton btn = new JButton();
      btn.setBounds(150, 190, 100, 40);
      btn.setText("click");
      panel.add(btn);

      JLabel saludo = new JLabel();
      saludo.setBounds(10,200,300,40);
      panel.add(saludo);


      // etiqueta.setText("::Bienvenido señor: " + getTitular() + "Nos Da gusto tenerlo por aquí");
      // System.out.println("::Bienvenido señor: " + getTitular() + "Nos Da gusto tenerlo por aquí");
      // System.out.println("Eliga alguna de la siguientes Opciones");
      // System.out.println("0. Salir de la Cuenta");
      // System.out.println("1. Consultar Saldo ");
      // System.out.println("2. Depositar ");
      // System.out.println("3. Retirar ");

       //Agregando Evento de tipo ActionListener
	    ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ventana.dispose();
        setResponse(Integer.parseInt(cajaTexto.getText()));


          switch(getResponse()) {
          case 0: {
            setExit(0);
            break;
          }
          case 1:

            Frame ventana = new Frame();
            ventana.setTitle("Cajero Automático");
            ventana.setVisible(true);

            JPanel panel = new JPanel();
            panel.setLayout(null);
            ventana.getContentPane().add(panel);

            JLabel etiqueta = new JLabel("Haz elegido la opción de Consultar Saldo"); //Creamos una etiqueta
            etiqueta.setBounds(0, 0, 400, 30);
            etiqueta.setOpaque(true); //Establecemos pintar el fondo de la etiqueta.
            etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(etiqueta);

            JLabel etiqueta1 = new JLabel( "Tu Saldo Actual es: " + getSaldo() ); //Creamos una etiqueta1
            etiqueta1.setBounds(0, 30, 400, 30);
            etiqueta1.setOpaque(true); //Establecemos pintar el fondo de la etiqueta1.
            etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(etiqueta1);
            
            JButton btn = new JButton();
            btn.setBounds(150, 80, 100, 40);
            btn.setText("Regresar Menú");
            panel.add(btn);

            ActionListener action = new ActionListener() {
			
              @Override
              public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                ventana.dispose();
                showMenu();                
              }
            };
            
            btn.addActionListener(action);
   
          break;
          case 2: 

            Frame ventana1 = new Frame();
            ventana1.setTitle("Cajero Automático");
            ventana1.setVisible(true);

            JPanel panel1 = new JPanel();
            panel1.setLayout(null);
            ventana1.getContentPane().add(panel1);

            JLabel etiqueta3 = new JLabel("Haz elegido la opción para Depositar Dinero"); //Creamos una etiqueta3
            etiqueta3.setBounds(0, 0, 400, 30);
            etiqueta3.setOpaque(true); //Establecemos pintar el fondo de la etiqueta3.
            etiqueta3.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(etiqueta3);

            JLabel etiqueta4 = new JLabel("Ingrese los Billetes porfavor..."); //Creamos una etiqueta4
            etiqueta4.setBounds(0, 30, 400, 30);
            etiqueta4.setOpaque(true); //Establecemos pintar el fondo de la etiqueta4.
            etiqueta4.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(etiqueta4);
            
            JLabel etiqueta2 = new JLabel("¿Que Cantidad desea ingresar?, favor de escribirla."); //Creamos una etiqueta2
            etiqueta2.setBounds(0, 55, 400, 50);
            etiqueta2.setOpaque(true); //Establecemos pintar el fondo de la etiqueta2.
            etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(etiqueta2);

            JTextField cajaTexto = new JTextField();
            cajaTexto.setBounds(100, 100, 200, 30);
            cajaTexto.setOpaque(true);
            panel1.add(cajaTexto);

            JButton btn1 = new JButton();
            btn1.setBounds(150, 140, 100, 40);
            btn1.setText("click");
            panel1.add(btn1);

            ActionListener action2 = new ActionListener() {
			
              @Override
              public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
               
                setCantidad(Float.parseFloat(cajaTexto.getText()));
                if(getCantidad() > 0) {
                  ventana1.dispose();
                  try {
                    Depositar(getCantidad());
                    Frame ventana1 = new Frame();
                    ventana1.setTitle("Cajero Automático");
                    ventana1.setVisible(true);

                    JPanel panel1 = new JPanel();
                    panel1.setLayout(null);
                    ventana1.getContentPane().add(panel1);

                    JLabel etiqueta = new JLabel("Gracias por su deposito :) "); //Creamos una etiqueta
                    etiqueta.setBounds(0, 30, 400, 30);
                    etiqueta.setOpaque(true); //Establecemos pintar el fondo de la etiqueta.
                    etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
                    panel1.add(etiqueta);

                    JButton btn = new JButton();
                    btn.setBounds(100, 80, 200, 40);
                    btn.setText("Regresar Menú");
                    panel1.add(btn);

                    ActionListener action = new ActionListener() {
			
                      @Override
                      public void actionPerformed(ActionEvent arg0) {
                        // TODO Auto-generated method stub
                        ventana1.dispose();
                        showMenu();                
                      }
                    };
                    
                    btn.addActionListener(action);


                  } catch(Exception e) {
                    e.printStackTrace();
                  }
                } else {
                    Frame ventana1 = new Frame();
                    ventana1.setTitle("Cajero Automático");
                    ventana1.setVisible(true);

                    JPanel panel1 = new JPanel();
                    panel1.setLayout(null);
                    ventana1.getContentPane().add(panel1);

                    JLabel etiqueta = new JLabel("No pongas número negativos solo pon un número"); //Creamos una etiqueta
                    etiqueta.setBounds(0, 30, 400, 30);
                    etiqueta.setOpaque(true); //Establecemos pintar el fondo de la etiqueta.
                    etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
                    panel1.add(etiqueta);

                    JButton btn1 = new JButton();
                    btn1.setBounds(100, 80, 200, 40);
                    btn1.setText("Regresar Menú");
                    panel1.add(btn1);

                    ActionListener action2 = new ActionListener() {
      
                      @Override
                      public void actionPerformed(ActionEvent arg0) {
                        // TODO Auto-generated method stub
                        ventana1.dispose();
                        showMenu();                
                      }
                    };
                    
                    btn1.addActionListener(action2);
                }             
              }
            };
            
            btn1.addActionListener(action2);
            
            break;
            
          case 3: 
            
            Frame ventana2 = new Frame();
            ventana2.setTitle("Cajero Automático");
            ventana2.setVisible(true);

            JPanel panel2 = new JPanel();
            panel2.setLayout(null);
            ventana2.getContentPane().add(panel2);

            JLabel etiqueta5 = new JLabel("Haz elegido la opción para Retirar Dinero"); //Creamos una etiqueta3
            etiqueta5.setBounds(0, 0, 400, 30);
            etiqueta5.setOpaque(true); //Establecemos pintar el fondo de la etiqueta5.
            etiqueta5.setHorizontalAlignment(SwingConstants.CENTER);
            panel2.add(etiqueta5);

            JLabel etiqueta6 = new JLabel("Porfavor ingrese la cantidad que desee retirar:"); //Creamos una etiqueta6
            etiqueta6.setBounds(0, 30, 400, 30);
            etiqueta6.setOpaque(true); //Establecemos pintar el fondo de la etiqueta6.
            etiqueta6.setHorizontalAlignment(SwingConstants.CENTER);
            panel2.add(etiqueta6);

            JTextField cajaTexto1 = new JTextField();
            cajaTexto1.setBounds(100, 80, 200, 30);
            cajaTexto1.setOpaque(true);
            panel2.add(cajaTexto1);

            JButton btn2 = new JButton();
            btn2.setBounds(150, 140, 100, 40);
            btn2.setText("click");
            panel2.add(btn2);

            //Agregando Evento de tipo ActionListener
            ActionListener action3 = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
              // TODO Auto-generated method stub
              setCantidad(Float.parseFloat(cajaTexto1.getText()));
              ventana2.dispose();
              if(getCantidad() > 0) {
                if(getCantidad() < getSaldo()) {
                  try {
                    Retirar(getCantidad());
                    Frame ventana1 = new Frame();
                    ventana1.setTitle("Cajero Automático");
                    ventana1.setVisible(true);

                    JPanel panel1 = new JPanel();
                    panel1.setLayout(null);
                    ventana1.getContentPane().add(panel1);

                    JLabel etiqueta = new JLabel("A continuación puede recoger su dinero en la bandeja..."); //Creamos una etiqueta
                    etiqueta.setBounds(0, 30, 400, 30);
                    etiqueta.setOpaque(true); //Establecemos pintar el fondo de la etiqueta.
                    etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
                    panel1.add(etiqueta);
                    
                    JLabel etiqueta1 = new JLabel("Transacción realizada Correctamente!! Vuelva proto!"); //Creamos una etiqueta1
                    etiqueta1.setBounds(0, 60, 400, 30);
                    etiqueta1.setOpaque(true); //Establecemos pintar el fondo de la etiqueta1.
                    etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
                    panel1.add(etiqueta1);

                    JButton btn1 = new JButton();
                    btn1.setBounds(100, 100, 200, 40);
                    btn1.setText("Regresar Menú");
                    panel1.add(btn1);

                    ActionListener action2 = new ActionListener() {
      
                      @Override
                      public void actionPerformed(ActionEvent arg0) {
                        // TODO Auto-generated method stub
                        ventana1.dispose();
                        showMenu();                
                      }
                    };
                    
                    btn1.addActionListener(action2);


                  } catch(Exception e) {
                    e.printStackTrace();
                  }
                } else {
                    Frame ventana1 = new Frame();
                    ventana1.setTitle("Cajero Automático");
                    ventana1.setVisible(true);

                    JPanel panel1 = new JPanel();
                    panel1.setLayout(null);
                    ventana1.getContentPane().add(panel1);

                    JLabel etiqueta = new JLabel("Saldo Insuficiente :("); //Creamos una etiqueta
                    etiqueta.setBounds(0, 30, 400, 30);
                    etiqueta.setOpaque(true); //Establecemos pintar el fondo de la etiqueta.
                    etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
                    panel1.add(etiqueta);

                    JButton btn1 = new JButton();
                    btn1.setBounds(100, 80, 200, 40);
                    btn1.setText("Regresar Menú");
                    panel1.add(btn1);

                    ActionListener action2 = new ActionListener() {
      
                      @Override
                      public void actionPerformed(ActionEvent arg0) {
                        // TODO Auto-generated method stub
                        ventana1.dispose();
                        showMenu();                
                      }
                    };
                    
                    btn1.addActionListener(action2);
                }
              } else {
                  Frame ventana1 = new Frame();
                  ventana1.setTitle("Cajero Automático");
                  ventana1.setVisible(true);

                  JPanel panel1 = new JPanel();
                  panel1.setLayout(null);
                  ventana1.getContentPane().add(panel1);

                  JLabel etiqueta = new JLabel("No pongas número negativos solo pon un número"); //Creamos una etiqueta
                  etiqueta.setBounds(0, 30, 400, 30);
                  etiqueta.setOpaque(true); //Establecemos pintar el fondo de la etiqueta.
                  etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
                  panel1.add(etiqueta);

                  JButton btn1 = new JButton();
                  btn1.setBounds(100, 80, 200, 40);
                  btn1.setText("Regresar Menú");
                  panel1.add(btn1);

                  ActionListener action2 = new ActionListener() {
    
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                      // TODO Auto-generated method stub
                      ventana1.dispose();
                      showMenu();                
                    }
                  };
                  
                  btn1.addActionListener(action2);
              }
            }

          };
          
          btn2.addActionListener(action3);
          break;  

          default: 
            System.out.println("¡¡¡Por favor Seleccione alguna Opción!!!");
            showMenu();
            break;
        } 

			}

		};
		
		btn.addActionListener(action);
  
    } while(getExit() != 0);
  }

}