import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;


/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 31.08.2021
 * @author Benjamin Reichelt
 */
public class RekursiveAlgorithmenGUI extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JTextArea jtxtAusgabe = new JTextArea("");
  private JScrollPane jtxtAusgabeScrollPane = new JScrollPane(jtxtAusgabe);
  private JButton btnSuche = new JButton();
  private JLabel jLabel2 = new JLabel();
  private JNumberField jnbfZahl = new JNumberField();
  private JButton btnErzeugeArray = new JButton();
  private RekursiveAlgorithmen algo = new RekursiveAlgorithmen();
  private JLabel lblAusgabe = new JLabel();
  private JLabel jlblNBild = new JLabel();
  private ImageIcon kreuz = new ImageIcon("images/Kreuz.PNG");
  private ImageIcon haken = new ImageIcon("images/Haken.PNG");
  private JButton btnSelectionsort = new JButton();
  private JButton btnInsertionssort = new JButton();
  private JButton btnBubblesort = new JButton();
  private JButton btnMergesort = new JButton();
  private JButton btnquicksort = new JButton();
  

  // Ende Attribute
  public RekursiveAlgorithmenGUI(String title) {
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    int frameWidth = 513;
    int frameHeight = 499;
    setSize(frameWidth, frameHeight);

    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);

    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    jLabel1.setBounds(8, 8, 482, 33);
    jLabel1.setText("Rekursive Algorithmen");
    jLabel1.setFont(new Font("Dialog", Font.BOLD, 24));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLabel1);
    jtxtAusgabeScrollPane.setBounds(8, 48, 481, 177);
    jtxtAusgabe.setEnabled(true);
    jtxtAusgabe.setEditable(false);
    jtxtAusgabe.setTabSize(3);
    jtxtAusgabe.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jtxtAusgabeScrollPane);
    btnSuche.setBounds(128, 232, 81, 33);
    btnSuche.setText("Suche");
    btnSuche.setMargin(new Insets(2, 2, 2, 2));
    btnSuche.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          btnSuche_ActionPerformed(evt);
        }
      });
    btnSuche.setEnabled(false);
    cp.add(btnSuche);
    jLabel2.setBounds(216, 232, 43, 33);
    jLabel2.setText("Zahl:");
    jLabel2.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(jLabel2);
    jnbfZahl.setBounds(264, 232, 41, 33);
    jnbfZahl.setText("");
    jnbfZahl.setFont(new Font("Dialog", Font.PLAIN, 16));
    jnbfZahl.setEnabled(false);
    jnbfZahl.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jnbfZahl);
    btnErzeugeArray.setBounds(8, 232, 105, 33);
    btnErzeugeArray.setText("Erzeuge Werte");
    btnErzeugeArray.setMargin(new Insets(2, 2, 2, 2));
    btnErzeugeArray.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          btnErzeugeArray_ActionPerformed(evt);
        }
      });
    cp.add(btnErzeugeArray);
    lblAusgabe.setBounds(8, 272, 395, 49);
    lblAusgabe.setText("");
    lblAusgabe.setHorizontalAlignment(SwingConstants.LEFT);
    lblAusgabe.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(lblAusgabe);
    jlblNBild.setBounds(416, 264, 60, 60);
    jlblNBild.setText("");
    jlblNBild.setIcon(null);
    cp.add(jlblNBild);
    btnSelectionsort.setBounds(8, 416, 145, 33);
    btnSelectionsort.setText("Selectionsort");
    btnSelectionsort.setMargin(new Insets(2, 2, 2, 2));
    btnSelectionsort.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          btnSelectionsort_ActionPerformed(evt);
        }
      });
    cp.add(btnSelectionsort);
    btnInsertionssort.setBounds(8, 376, 145, 33);
    btnInsertionssort.setText("Insertionsort");
    btnInsertionssort.setMargin(new Insets(2, 2, 2, 2));
    btnInsertionssort.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          btnInsertionssort_ActionPerformed(evt);
        }
      });
    cp.add(btnInsertionssort);
    btnBubblesort.setBounds(8, 336, 145, 33);
    btnBubblesort.setText("Bubblesort");
    btnBubblesort.setMargin(new Insets(2, 2, 2, 2));
    btnBubblesort.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          btnBubblesort_ActionPerformed(evt);
        }
      });
    cp.add(btnBubblesort);
    btnMergesort.setBounds(160, 336, 145, 33);
    btnMergesort.setText("Mergesort");
    btnMergesort.setMargin(new Insets(2, 2, 2, 2));
    btnMergesort.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          btnMergesort_ActionPerformed(evt);
        }
      });
    cp.add(btnMergesort);
    btnquicksort.setBounds(160, 376, 145, 33);
    btnquicksort.setText("Quicksort");
    btnquicksort.setMargin(new Insets(2, 2, 2, 2));
    btnquicksort.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          btnquicksort_ActionPerformed(evt);
        }
      });
    cp.add(btnquicksort);    
    // Ende Komponenten
    setVisible(true);
  } // end of public BinaereSuche

  // Anfang Methoden
  public static void main(String[] args) {
    new RekursiveAlgorithmenGUI("Rekursive Algorithmen");
  } // end of main

  public void btnSuche_ActionPerformed(ActionEvent evt) {
    int eingabe = jnbfZahl.getInt();
    int stelle = algo.binSucheRek(eingabe);

    if (stelle != -1) {
      lblAusgabe.setText("Die gesuchte Zahl befindet sich an der Stelle: " +
                         stelle + ".");
      jlblNBild.setIcon(haken);
    } else {
      lblAusgabe.setText("Die gesuchte Zahl ist im Array nicht enthalten!");
      jlblNBild.setIcon(kreuz);
    } // end of if-else
  } // end of btnSuche_ActionPerformed

  public void btnErzeugeArray_ActionPerformed(ActionEvent evt) {
    algo.erzeugeNeuesArray(40, 0, 100);
    jtxtAusgabe.setText(algo.arrayAusgeben());
    lblAusgabe.setText("");
    jnbfZahl.setInt(0);
    jlblNBild.setIcon(null);
    btnSuche.setEnabled(true);
    jnbfZahl.setEnabled(true);
  } // end of btnErzeugeArray_ActionPerformed

  public void btnBubblesort_ActionPerformed(ActionEvent evt) {
    algo.bubblesortRek();
    jtxtAusgabe.setText(algo.arrayAusgeben());
    lblAusgabe.setText("");
    jnbfZahl.setInt(0);
    jlblNBild.setIcon(null);
    btnSuche.setEnabled(true);
    jnbfZahl.setEnabled(true);
  } // end of btnBubblesort_ActionPerformed

  public void btnInsertionssort_ActionPerformed(ActionEvent evt) {
    algo.insertionSortRek();
    jtxtAusgabe.setText(algo.arrayAusgeben());
    lblAusgabe.setText("");
    jnbfZahl.setInt(0);
    jlblNBild.setIcon(null);
    btnSuche.setEnabled(true);
    jnbfZahl.setEnabled(true);
  } // end of btnInsertionssort_ActionPerformed

  public void btnSelectionsort_ActionPerformed(ActionEvent evt) {
    algo.selectionsSortRek();
    jtxtAusgabe.setText(algo.arrayAusgeben());
    lblAusgabe.setText("");
    jnbfZahl.setInt(0);
    jlblNBild.setIcon(null);
    btnSuche.setEnabled(true);
    jnbfZahl.setEnabled(true);
  } // end of btnSelectionsort_ActionPerformed
  
  public void btnMergesort_ActionPerformed(ActionEvent evt) {
    algo.Mergesort();
    jtxtAusgabe.setText(algo.arrayAusgeben());
    lblAusgabe.setText("");
    jnbfZahl.setInt(0);
    jlblNBild.setIcon(null);
    btnSuche.setEnabled(true);
    jnbfZahl.setEnabled(true);    
  } 
  public void btnquicksort_ActionPerformed(ActionEvent evt) {
    algo.Mergesort();
    jtxtAusgabe.setText(algo.arrayAusgeben());
    lblAusgabe.setText("");
    jnbfZahl.setInt(0);
    jlblNBild.setIcon(null);
    btnSuche.setEnabled(true);
    jnbfZahl.setEnabled(true);    
  }   
  // Ende Methoden
} // end of class BinaereSuche
