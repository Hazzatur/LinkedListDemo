/**
 * Clase para demostrar operaciones con una lista enlazada.
 * Incluye métodos para invertir la lista, encontrar el elemento medio,
 * y eliminar duplicados.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        // Creación y manipulación de una lista enlazada.
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3); // Duplicado
        head.next.next.next = new ListNode(3); // Duplicado
        head.next.next.next.next = new ListNode(4); // Medio
        head.next.next.next.next.next = new ListNode(5); // Duplicado
        head.next.next.next.next.next.next = new ListNode(5); // Duplicado
        head.next.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next.next = new ListNode(7); // Duplicado
        head.next.next.next.next.next.next.next.next.next = new ListNode(7); // Duplicado

        System.out.println("Lista original:");
        printList(head);

        // Los otros métodos se llaman aquí para demostrar su funcionalidad.

        // Invertir la lista
        head = reverseList(head);
        System.out.println("Lista invertida:");
        printList(head);

        // Encontrar el elemento del medio
        ListNode middle = findMiddleElement(head);
        System.out.println("Elemento medio de la lista invertida: " + middle.val);

        // Restablecer la lista a su forma original y eliminar duplicados
        head = reverseList(head);
        System.out.println("Lista original restaurada:");
        printList(head);

        head = removeDuplicates(head);
        System.out.println("Lista original sin duplicados:");
        printList(head);

        ListNode unordered = new ListNode(1);
        unordered.next = new ListNode(17);
        unordered.next.next = new ListNode(5);
        unordered.next.next.next = new ListNode(3);
        unordered.next.next.next.next = new ListNode(17);
        unordered.next.next.next.next.next = new ListNode(5);
        unordered.next.next.next.next.next.next = new ListNode(1);
        unordered.next.next.next.next.next.next.next = new ListNode(2);
        unordered.next.next.next.next.next.next.next.next = new ListNode(3);
        unordered.next.next.next.next.next.next.next.next.next = new ListNode(4);

        System.out.println("Lista desordenada:");
        printList(unordered);

        unordered = removeDuplicates2(unordered);
        System.out.println("Lista desordenada sin duplicados:");
        printList(unordered);
    }

    /**
     * Imprime todos los elementos de una lista enlazada.
     *
     * @param head El primer nodo de la lista enlazada.
     */
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Invierte una lista enlazada.
     *
     * @param head El primer nodo de la lista enlazada.
     * @return El nuevo primer nodo de la lista enlazada invertida.
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

        // Se usuan tres punteros para invertir la lista.
        // El puntero prev apunta al nodo anterior al nodo actual.
        // El puntero current apunta al nodo actual.
        // El puntero next apunta al nodo siguiente al nodo actual.
        // En cada iteración, el puntero current se mueve al siguiente nodo.
        // El puntero current.next se establece en el nodo anterior.
        // El puntero prev se mueve al nodo actual.
        // El puntero next se mueve al siguiente nodo.
        // Cuando current es null, prev apunta al último nodo de la lista.
        // Por lo tanto, prev es el nuevo primer nodo de la lista invertida.

        // La complejidad de tiempo es O(n) donde n es el número de nodos en la lista.
        // La complejidad de espacio es O(1) porque no se utiliza espacio adicional.
    }

    /**
     * Encuentra el elemento medio de una lista enlazada.
     * Si la lista tiene un número par de elementos, devuelve el segundo de los dos elementos medios.
     *
     * @param head El primer nodo de la lista enlazada.
     * @return El nodo que se encuentra en medio de la lista enlazada.
     */
    public static ListNode findMiddleElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

        // Se usan dos punteros para encontrar el elemento medio.
        // El puntero lento se mueve un nodo a la vez.
        // El puntero rápido se mueve dos nodos a la vez.
        // Cuando el puntero rápido llega al final de la lista, el puntero lento está en el elemento medio.
        // Si la lista tiene un número par de elementos, el puntero lento está en el segundo de los dos elementos medios.
        // Si la lista tiene un número impar de elementos, el puntero lento está en el elemento medio.

        // La complejidad de tiempo es O(n) donde n es el número de nodos en la lista.
        // La complejidad de espacio es O(1) porque no se utiliza espacio adicional.
    }

    /**
     * Elimina todos los elementos duplicados de una lista enlazada.
     * Los duplicados se identifican cuando dos nodos consecutivos tienen el mismo valor.
     *
     * @param head El primer nodo de la lista enlazada.
     * @return El primer nodo de la lista enlazada después de eliminar duplicados.
     */
    public static ListNode removeDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;

        // Se usa un puntero para recorrer la lista.
        // Si el valor del nodo actual es igual al valor del siguiente nodo,
        // el siguiente nodo se elimina de la lista.
        // Si el valor del nodo actual no es igual al valor del siguiente nodo,
        // el puntero se mueve al siguiente nodo.
        // Cuando el puntero llega al final de la lista, se han eliminado todos los duplicados.

        // La complejidad de tiempo es O(n) donde n es el número de nodos en la lista.
        // La complejidad de espacio es O(1) porque no se utiliza espacio adicional.

        // Nota: Este método solo funciona si la lista está ordenada.
        // Si la lista no está ordenada, se debe ordenar primero.
    }

    private static ListNode removeDuplicates2(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;

        // Se usa un puntero para recorrer la lista.
        // Se usa un segundo puntero para recorrer la lista desde el nodo actual hasta el final.
        // Si el valor del nodo actual es igual al valor del siguiente nodo,
        // el siguiente nodo se elimina de la lista.
        // Si el valor del nodo actual no es igual al valor del siguiente nodo,
        // el puntero se mueve al siguiente nodo.
        // Cuando el puntero llega al final de la lista, se han eliminado todos los duplicados.

        // La complejidad de tiempo es O(n^2) donde n es el número de nodos en la lista.
        // La complejidad de espacio es O(1) porque no se utiliza espacio adicional.

        // Este método funciona para listas ordenadas y desordenadas.
        // Originalmente, sólo tome en cuenta listas ordenadas.
        // Decidí conservar el método original también.
        // Si la lista está ordenada, este método es menos eficiente que el método anterior
        // dado que la lista se recorre dos veces.
    }
}
