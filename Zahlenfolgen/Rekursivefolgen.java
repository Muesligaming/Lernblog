/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 31.08.2021
 * @author 
 */

public class Rekursivefolgen {
  
  public static void main(String[] args) {   //Mainmethode
    int Stelle=10;                           //die Stellen die man haben will
    Stoppuhr uhr = new Stoppuhr();           //Stopuhr wird initialisiert
    uhr.start();                             //Zeit wird gestartet
    System.out.println(fibRek(Stelle));      //Methode wird aufgerufen und ausgegeben
    uhr.stopp();                             //Zeit wird gestopt
    System.out.println("Die Zeit beträgt " + uhr.gestoppteZeit() + " Sekunden.");          //Zeit die das Programm gebraucht hat wird ausgegeben
    
    Stoppuhr uhr2 = new Stoppuhr();          //selbes wie oben aber für den Iterativen lösungsweg
    uhr2.start();
    long[] loesung=fibIter(Stelle);
    uhr2.stopp();
    for (int i=0;i<loesung.length;i++ ) {    //Da es ein Iteratives Programm ist, und so den gesammten Array zurück bekommt, brauchen wir eine Schleife um alles auszugeben
      System.out.print(loesung[i]+",");
    } // end of for
    System.out.println();
    System.out.println("Die Zeit beträgt " + uhr2.gestoppteZeit() + " Sekunden.");
    
    Stoppuhr uhr3 = new Stoppuhr();          //selbes wie oben aber für die Hofstadter Funktion als Iterativer alorithmus
    uhr3.start();
    int[] hofloesung=hofit(100);
    uhr3.stopp();
    for (int i=1;i<hofloesung.length;i++ ) { //wie oben 
      System.out.print(hofloesung[i]+"\t");
    } // end of for
    System.out.println();
    System.out.println("Die Zeit beträgt " + uhr3.gestoppteZeit() + " Sekunden.");
    
    Stoppuhr uhr4 = new Stoppuhr();        //selbes wie oben aber für die Hofstadter Funktion als Rekursiver alorithmus
    uhr4.start();
    uhr4.stopp();
    System.out.println(hofRek(10));
    uhr4.stopp();
    System.out.println("Die Zeit beträgt " + uhr4.gestoppteZeit() + " Sekunden.");
  } // end of main
  
  
  public static long fibRek( long pN){    //Methode wird eröffnet als long wil die Zahlen so riesig werden
  if (pN<=1) return pN;                   //überprüft ob die Rekursionsbasis erfüllt ist und gibt wen ja die Zahl zurück die gegeben wurde (1 oder 0)
  System.out.print(".");                  //Gibt einen Punkt aus, damit der User ein Feedback bekommt, dass das Programm noch läuft
  return fibRek(pN-1)+fibRek(pN-2);       //Wenn die Basis nich erfüllt ist geht es zum nächsten Rekursionsschritt
  }
  
  public static long[] fibIter( int pN){ 
    long[] fibonasci = new long[pN+1];
    fibonasci[0]=(long)0;
    fibonasci[1]=(long)1;
    for (int i=2;i<fibonasci.length;i++) {
      fibonasci[i]=fibonasci[i-1]+fibonasci[i-2];
    }// end of for
    return fibonasci;
  }
  
  public static int[] hofit(int pN){
    int[]hofint = new int[pN+1];
    hofint[1] = 1;
    hofint[2] = 1;
    for (int i=3;i<hofint.length ;i++ ) {
        hofint[i] = hofint[i-hofint[i-1]]+hofint[i-hofint[i-2]];
    } // end of for
    return hofint;
  }
  public static int hofRek(int pN){
    int loesung = 0;
    if (pN<=2) return 1;
    loesung = hofRek(pN-hofRek(pN-1))+hofRek(pN-hofRek(pN-2));
    return loesung; 
  }
} // end of class Rekursivefolgen

