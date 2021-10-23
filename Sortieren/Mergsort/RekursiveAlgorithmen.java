/**
 * Beschreibung
 *
 * @version 1.0 vom 24.08.2021
 * @author Benjamin Reichelt
 */
import java.util.Random;

import javax.swing.*;


public class RekursiveAlgorithmen {
  // Anfang Attribute
  private int[] zahlen;

  // Ende Attribute

  /*
   * Erzeugt ein neues Array der L?nge 50 und gelebt es mit ganzen Zufallszahlen
   * zwischen 1 und 100.
   */
  public RekursiveAlgorithmen() {
    erzeugeNeuesArray(50, 1, 100);
  }

  public void erzeugeNeuesArray(int pAnzahl, int pMinWert, int pMaxWert) {
    zahlen = new int[pAnzahl];

    Random zufallsgenerator = new Random();

    // Array mit Zufallszahlen belegen
    for (int j = 0; j < zahlen.length; j++) {
      zahlen[j] = zufallsgenerator.nextInt(pMaxWert - pMinWert + 1) + pMinWert;
    }
  }

  /*
   * Pr?ft, ob das Array zahlen an Position pStelle die gesuchte Zahl pGesZahl
   * enth?lt. Gibt true zur?ck, falls pStelle == -1.
   */
  public boolean pruefeWert(int pGesZahl, int pStelle) {
    if (pStelle == -1) {
      return true;
    } else {
      if (zahlen[pStelle] == pGesZahl) {
        return true;
      } else {
        return false;
      } // end of if-else
    } // end of if-else
  }

  /* Gibt die Elemente des Arrays als String aus, jeweils 10 Zahlen pro Zeile */
  public String arrayAusgeben() {
    String res = zahlen[0] + "\t";

    for (int i = 1; i < zahlen.length; i++) {
      if ((i % 10) == 0) {
        res = res + "\n";
      } // end of if

      res = res + zahlen[i] + "\t";
    } // end of for

    return res;
  }

  // Anfang Methoden
  public int binSucheRek(int pGesZahl) {
    return binSucheRek(pGesZahl, 0, this.zahlen.length - 1);
  }

  private int binSucheRek(int pGesZahl, int pLPos, int pRPos) {
    int mitte = (pLPos + pRPos) / 2;

    // Rekursionsbasis
    // Fall: Gesuchte Zahl befindet sich an mittlerer Position des Suchbereichs
    if (zahlen[mitte] == pGesZahl) {
      return mitte;
    } // end of if

    // Fall: Suchbereich enth?lt nur ein Element, das nicht die gesuchte Zahl ist
    if (pLPos == pRPos) {
      return -1;
    } // end of if-else

    // Rekursionsschritt
    else {
      // Fall: Gesuchte Zahl ist gr??er als Zahl in der Mitte des Suchbereichs
      if (pGesZahl > zahlen[mitte]) {
        // Rekursiver Aufruf auf rechte H?lfte des Suchbereichs
        return binSucheRek(pGesZahl, mitte + 1, pRPos);
      } // end of if
      else {
        // Rekursiver Aufruf auf linke H?lfte des Suchbereichs
        return binSucheRek(pGesZahl, pLPos, mitte - 1);
      } // end of if-else
    } // end of if-else
  }

  // Elementare Sortierverfahren

  // Bubblesort rekursiv
  public void bubblesortRek() {
    bubblesortRek(zahlen.length);
  }

  // Bubblesort rekursiv
  private void bubblesortRek(int pEndIndex) { // pEndIndex markiert das Ende des unsortierten Bereichs    
  
    if (pEndIndex == 0) {
    } else {
      for (int j = 0; j < (pEndIndex - 1); j++) {
        if (zahlen[j] > zahlen[j + 1]) {
          int temp = zahlen[j];
          zahlen[j] = zahlen[j + 1];
          zahlen[j + 1] = temp;
        }
      }
  
      bubblesortRek(pEndIndex - 1);
    } // end of if-else
  }

  // Insertionsort rekursiv
  public void insertionSortRek() {
    insertionSort(zahlen.length);
  }

  public void Mergesort() {
    Mergesort(0, zahlen.length-1);
  }
  
  private void Mergesort(int Pl, int Pr) {
    if (Pl < Pr) {
      int mitte = (Pl + Pr) / 2;
      Mergesort(Pl, mitte);  
      Mergesort(mitte+1, Pr);
      merge(Pl,Pr); 
      return;
    } // end of if

    return;
  }

  private void merge(int pLow, int pHigh) {
    int center = (pLow + pHigh) / 2;
    int[] tempA = new int[(center + 1) - pLow];
    int temp = 0;

    for (int index = pLow; index <= center; index++) {
      tempA[temp] = zahlen[index];
      temp++;
    } // end of for

    int l = pLow;
    int r = center + 1;
    temp = 0;

    while ((l < r) && (r <= pHigh)) {
      if (tempA[temp] <= zahlen[r]) {
        zahlen[l] = tempA[temp];
        l++;
        temp++;
      } else {
        zahlen[l] = zahlen[r];
        l++;
        r++;
      } // end of if-else      
    } // end of while

    while (temp < tempA.length) {
      zahlen[l] = tempA[temp];
      l++;
      temp++;
    } // end of while 
    return;
  }

  private void insertionSort(int pEndIndex) { // pEndIndex markiert das Ende des zu sortierenen Bereichs
  
    if (!(pEndIndex < 1)) {
      //zu sortierender Bereich besteht nur aus einem Element => ist schon sortiert
      insertionSort(pEndIndex - 1); //zu sortierenden Bereich wird um eins verkleinert und sortiert 
  
      int value = zahlen[pEndIndex - 1]; //Zahl die eingefügt werden soll
      int pos = pEndIndex - 2; //setzt die positzion des ersten zu vergleichenen Arry indexes
  
      while ((pos >= 0) && (zahlen[pos] > value)) { // alle Elemente nach rechts schieben 
        zahlen[pos + 1] = zahlen[pos]; // bis die Richtige Position für den Wert gefunden ist
        pos--;
      }
  
      zahlen[pos + 1] = value; //setze den einzusetzenden Wert an die richtige Position
    }
  }

  // Selectionsort (Minsort) rekursiv
  public void selectionsSortRek() {
    selectionsortRek(0);
  }

  public void selectionsortRek(int pStartIndex) { // pStartIndex markiert den Beginn des unsortierten Bereichs
  
    if (pStartIndex > (zahlen.length - 1)) {
    } else {
      int low = pStartIndex;
  
      for (int i = pStartIndex + 1; i < zahlen.length; i++) {
        if (zahlen[i] < zahlen[low]) {
          low = i;
        }
      }
  
      int temporer = zahlen[low];
      zahlen[low] = zahlen[pStartIndex];
      zahlen[pStartIndex] = temporer;
  
      selectionsortRek(pStartIndex + 1);
    } // end of if-else
  }

  // Ende Methoden
} // end of Suche
