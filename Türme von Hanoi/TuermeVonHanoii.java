import java.math.*;
public class TuermeVonHanoii{
  public static BigInteger Rek(BigInteger Zahl){
    BigInteger eins, zwei, loesung;
    eins =  new BigInteger("1");
    zwei =  new BigInteger("2");
    if (Zahl.equals(eins)) {
      return eins;
    } // end of if
    loesung = Zahl;
    loesung = loesung.subtract(eins);
    loesung = Rek(loesung);
    loesung = loesung.multiply(zwei);
    loesung = loesung.add(eins);
    return loesung;
  }
  public static BigInteger pow(int exponent){
    return (new BigInteger("2").pow(exponent)).subtract(new BigInteger("1"));
  }
  public static void main(String[] arg) {
    System.out.println(Rek(new BigInteger("5")));
    System.out.println(pow(5));
    System.out.println(Rek(new BigInteger("10")));
    System.out.println(pow(10));
    System.out.println(Rek(new BigInteger("50")));
    System.out.println(pow(50));
    System.out.println(Rek(new BigInteger("100")));
    System.out.println(pow(100));
  }
} // Ende Spiel
