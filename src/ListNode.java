/**
 * Clase para representar un nodo en una lista enlazada.
 * Cada nodo de la lista contiene un valor entero y una referencia al siguiente nodo en la lista.
 */
public class ListNode {
    // Valor entero almacenado en este nodo.
    int val;

    // Referencia al siguiente nodo en la lista. Es null si no hay siguiente nodo.
    ListNode next;

    /**
     * Constructor para crear un nuevo nodo con un valor entero específico.
     *
     * @param val El valor entero para este nodo.
     */
    ListNode(int val) {
        this.val = val;
    }
}
