import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Ejercicio4_LinkedList {
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();

        // Altas básicas
        lista.add("B");
        lista.addFirst("A");   // insertar al inicio
        lista.addLast("C");    // insertar al final
        lista.add("D");        // agregar al final

        System.out.println("LinkedList tras inserciones: " + lista);
        System.out.println("size(): " + lista.size());
        System.out.println("getFirst(): " + lista.getFirst());
        System.out.println("getLast(): " + lista.getLast());
        System.out.println("contains(\"C\"): " + lista.contains("C"));

        // Operaciones tipo cola
        lista.offer("E");                // agrega al final
        System.out.println("offer(\"E\"): " + lista);
        System.out.println("peek(): " + lista.peek());  // ver primero sin quitar
        System.out.println("poll(): " + lista.poll());  // quitar primero
        System.out.println("Después de poll(): " + lista);

        // Operaciones tipo pila
        lista.push("TOP");               // push = addFirst
        System.out.println("push(\"TOP\"): " + lista);
        System.out.println("pop(): " + lista.pop());    // pop = removeFirst
        System.out.println("Después de pop(): " + lista);

        // Remociones en extremos
        String primero = lista.removeFirst();
        String ultimo  = lista.removeLast();
        System.out.println("removeFirst()->" + primero + ", removeLast()->" + ultimo);
        System.out.println("Actual: " + lista);

        // Iteraciones
        System.out.print("Iterator: ");
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) System.out.print(it.next() + " ");
        System.out.println();

        System.out.print("ListIterator adelante: ");
        ListIterator<String> lit = lista.listIterator();
        while (lit.hasNext()) System.out.print(lit.next() + " ");
        System.out.println();

        System.out.print("ListIterator atrás: ");
        while (lit.hasPrevious()) System.out.print(lit.previous() + " ");
        System.out.println();

        // Limpieza
        lista.clear();
        System.out.println("clear(); isEmpty(): " + lista.isEmpty());
    }
}
