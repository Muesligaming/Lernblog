 /**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2018
 * </p>
 * <p>
 * Generische Klasse Stack<ContentType>
 * </p>
 * <p>
 * Objekte der generischen Klasse Stack (Keller, Stapel) verwalten beliebige
 * Objekte vom Typ ContentType nach dem Last-In-First-Out-Prinzip, d.h., das
 * zuletzt abgelegte Objekt wird als erstes wieder entnommen. Alle Methoden
 * haben eine konstante Laufzeit, unabhaengig von der Anzahl der verwalteten
 * Objekte.
 * </p>
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule
 * @version Generisch_02 2014-02-21
 */
public class Stack<ContentType> {
  private Node head;

  /* --------- Anfang der privaten inneren Klasse -------------- */

  private class Node{
    private ContentType content;
    private Node nextNode;
    

    public Node(ContentType pContent){
      setContent(pContent);
    }

    public ContentType getContent(){
      return this.content;
    }

    public void setContent(ContentType pContent){
      this.content = pContent;
    }

    public Node getNextNode(){
      return this.nextNode;
    }

    public void setNextNode(Node pNode) {
      this.nextNode = pNode;
    }
  }
  /* ----------- Ende der privaten inneren Klasse -------------- */


  /**
   * Ein leerer Stapel wird erzeugt. Objekte, die in diesem Stapel verwaltet
   * werden, muessen vom Typ ContentType sein.
   */
   public Stack(){
     head = null;
   }


  /**
   * Die Anfrage liefert den Wert true, wenn der Stapel keine Objekte
   * enthaelt, sonst liefert sie den Wert false.
   *
   * @return true, falls der Stapel leer ist, sonst false
   */
   public boolean isEmpty(){
    return (head == null);
   }


  /**
   * Das Objekt pContentType wird oben auf den Stapel gelegt. Falls
   * pContentType gleich null ist, bleibt der Stapel unveraendert.
   *
   * @param pContent
   *        das einzufuegende Objekt vom Typ ContentType
   */
   public void push(ContentType pContent){
     if(pContent != null) {
      Node neu = new Node(pContent);
      neu.setNextNode(head);
      head = neu;
     } 
    
   }

  /**
   * Das zuletzt eingefuegte Objekt wird von dem Stapel entfernt. Falls der
   * Stapel leer ist, bleibt er unveraendert.
   */
   public void pop(){
    if (head!=null) head = head.getNextNode();
    
   }


  /**
   * Die Anfrage liefert das oberste Stapelobjekt. Der Stapel bleibt
   * unveraendert. Falls der Stapel leer ist, wird null zurueckgegeben.
   *
   * @return das oberste Stackelement vom Typ ContentType oder null, falls
   *         der Stack leer ist
   */
   public ContentType top(){
     if (head!=null) {
      return head.getContent(); 
     } // end of if
    return null; 
    
   }

}
