import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 20.08.2021
 * @author 
 */

public class erste_Gui__Temperaturumrechner extends JFrame {
  // Anfang Attribute
  private JTextField tfTemperaturinC = new JTextField();
  private JTextField tfTemperaturinF = new JTextField();
  private JLabel lTemperaturumrechner = new JLabel();
  private JLabel lTemperaturinC = new JLabel();
  private JLabel lTemperaturinF = new JLabel();
  // Ende Attribute
  
  
  
  public erste_Gui__Temperaturumrechner() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Temperaturumrechner");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    cp.setBackground(Color.YELLOW);
    tfTemperaturinC.setBounds(32, 104, 217, 33);
    tfTemperaturinC.setText("");
    tfTemperaturinC.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        tfTemperaturinC_ActionPerformed(evt);
      }
    });
    cp.add(tfTemperaturinC);
    tfTemperaturinF.setBounds(32, 192, 217, 33);
    tfTemperaturinF.setText("");
    tfTemperaturinF.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        tfTemperaturinF_ActionPerformed(evt);
      }
    });
    cp.add(tfTemperaturinF);
    lTemperaturumrechner.setBounds(32, 16, 217, 33);
    lTemperaturumrechner.setText("Temperaturumrechner");
    lTemperaturumrechner.setHorizontalTextPosition(SwingConstants.CENTER);
    lTemperaturumrechner.setHorizontalAlignment(SwingConstants.CENTER);
    lTemperaturumrechner.setIconTextGap(4);
    cp.add(lTemperaturumrechner);
    lTemperaturinC.setBounds(32, 72, 105, 25);
    lTemperaturinC.setText("Temperatur in C°");
    cp.add(lTemperaturinC);
    lTemperaturinF.setBounds(32, 160, 105, 25);
    lTemperaturinF.setText("Temperatur in F°");
    cp.add(lTemperaturinF);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public erste_Gui__Temperaturumrechner
  
  // Anfang Methoden
  public void zuTemperaturC() {
    double TemperaturF = Double.parseDouble(tfTemperaturinF.getText());//Nimmt den Text aus dem Eingabefeld wandelt es in einen Double um und speichert es in TemperaturF
    double TemperaturC = (TemperaturF-32)/1.8;                         //Nimmt TemperaturF und Rechnet die Fahrenheit Temperatur in Celsius um und speichert das Ergebniss in TemperaturC
    TemperaturC = Math.round(100.0 * TemperaturC) / 100.0;             //Nimmt TemperaturC und rundet die Zahl auf 2 Nachkommastellen
    String Ergebniss =  String.valueOf(TemperaturC);                   //Nimmt TemperaturC und wandelt es wieder in einen String um und speichert es in Ergebniss  
    tfTemperaturinC.setText(Ergebniss);                                //Nimmt Ergebniss und fühgt es in Temperatur in C° hinzu um es für den/die Benutzer/in sichtbar zu machen
  }
  public void zuTemperaturF() {
    double TemperaturC = Double.parseDouble(tfTemperaturinC.getText()); //Nimmt den Text aus dem Eingabefeld wandelt es in einen Double um und speichert es in TemperaturC
    double TemperaturF = TemperaturC*1.8+32;                            //Nimmt TemperaturC und Rechnet die Celsius Temperatur in Fahrenheit um und speichert das Ergebniss in TemperaturF
    TemperaturF = Math.round(100.0 * TemperaturF) / 100.0;              //Nimmt TemperaturF und rundet die Zahl auf 2 Nachkommastellen
    String Ergebniss =  String.valueOf(TemperaturF);                    //Nimmt TemperaturF und wandelt es wieder in einen String um und speichert es in Ergebniss
    tfTemperaturinF.setText(Ergebniss);                                 //Nimmt Ergebniss und fühgt es in Temperatur in F° hinzu um es für den/die Benutzer/in sichtbar zu machen
  }
  public static void main(String[] args) {
    new erste_Gui__Temperaturumrechner();
  } // end of main
  
  public void tfTemperaturinC_ActionPerformed(ActionEvent evt) {
    zuTemperaturF();
    } // end of tfTemperaturinC_ActionPerformed

  public void tfTemperaturinF_ActionPerformed(ActionEvent evt) {
    zuTemperaturC();
  } // end of tfTemperaturinF_ActionPerformed

  // Ende Methoden
} // end of class erste_Gui__Temperaturumrechner

