package pr2.pu3;

/**
 * Ein Knoten einer verketteten Liste, der beliebige Elemente aufnehmen kann.
 * 
 * @author Markus Gumbel (m.gumbel@hs-mannheim.de)
 */
public class ListNode<E> {
	/**
	 * Wert, den dieser Knoten aufnimmt.
	 */
	public E value;

	/**
	 * Nachfolger dieses Knotens. null bedeutet: kein Nachfolger.
	 */
	public ListNode<E> next = null;

	// Konstruktoren

	/**
	 * Erzeugt einen neuen Knoten.
	 *
	 * @param value Wert dieses Knotens
	 * @param n     Nachfolger-Knoten
	 */
	public ListNode(E value, ListNode<E> n) {
		this.value = value;
		next = n;
	}

	/**
	 * Erzeugt einen neuen Knoten (neue Liste).
	 *
	 * @param value int-Wert dieses Knotens
	 */
	public ListNode(E value) {
		this.value = value;
	}

	/**
	 * @return Den Wert des ersten Knotens der Liste.
	 */
	public E getHead() {
		return value;
	}

	/**
	 * @return Die Restliste.
	 */
	public ListNode<E> getTail() {
		return next;
	}

	/**
	 * Erzeugt einen neuen Listenknoten und lässt ihn auf diese Liste zeigen.
	 *
	 * @param value Wert des neuen Listenknotens.
	 * @return Die neue Liste mit neuem Knoten am Anfang.
	 */
	public ListNode<E> addFirst(E value) {
		return new ListNode<>(value, this);
	}

	/**
	 * @return Die Anzahl der Elemente in der Liste.
	 */
	public int size() {
		if (getTail() == null) { // Kein Nachfolger-Knoten vorhanden?
			return 1; // Liste hat genau ein Element.
		} else {
			return 1 + getTail().size();
		}
	}

	/**
	 * Gibt das Element auf die Console aus (ohne Zeilenumbruch).
	 */
	public void print() {
		System.out.print(value + " ");
	}

	public String toString() {
		return value + " ";
	}

	/*
	 * AUFGABE 1: Gibt Elemente der verketteten Liste in runde Klammern eingefasst
	 * und durch Kommas von einander getrennt auf die Konsole aus.
	 */
	public String toListString() {
		var element = this;
		var list = "";

		if (this.size() == 1)
			return "(" + this.getHead() + ")";
		else {
			while (element.getTail() != null) {
				list += element.getHead() + ", ";
				element = element.getTail();
			}
			return "(" + list + element.getHead() + ")";
		}
	}

	/*
	 * AUFGABE 2
	 * 
	 */
	public boolean containsIter(E e) {
		var element = this;

		while (element.getHead() != e) {
			if (element.getTail() == null)
				return false;
			element = element.getTail();
		}

		return true;
	}

	/*
	 * AUFGABE 3
	 * 
	 */
	public boolean contains(E e) {		

		if (this.getHead() == e)
			return true;

		if (this.getTail() != null)
			return this.getTail().contains(e);

		return false;
	}
}