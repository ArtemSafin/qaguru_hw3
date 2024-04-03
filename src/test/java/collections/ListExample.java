package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

    public final List<String> books = new ArrayList<>();

    public void getElements(List<String> books) {
    int i = 0;
    do {
        System.out.println("Book: " + books.get(i));
        i++;
    } while (i < books.size());
}
    public void addBook(String value) {
        books.add(value);
    }
    public void removeBook(String value) {
        books.remove(value);
    }

    public final LinkedList<String> linkedBooks = new LinkedList<>();
    public void getLinkedBooks(LinkedList<String> linkedBooks) {
        int i = 0;
        while (i < linkedBooks.size()) {
            System.out.println("linkedBooks: " + linkedBooks.get(i));
            i++;
        }
    }
    public void addLinkedBook(String value) {
        linkedBooks.add(value);
    }
    public void removeLinkedBook(String value) {
        linkedBooks.remove(value);
    }

    public static void main(String[] args) {

        ListExample listExample = new ListExample();
        listExample.addBook("Bram Stoker");
        listExample.addBook("Edgar Poe");
        listExample.addBook("Howard Lovecraft");
        listExample.addBook("Franz Kafka");
        listExample.addBook("Oscar Wilde");
        listExample.addBook("Oscar Wilde");
        listExample.removeBook("Franz Kafka");
        listExample.getElements(listExample.books);

        listExample.addLinkedBook("Clive Barker");
        listExample.addLinkedBook("Neil Gaiman");
        listExample.addLinkedBook("Mary Shelley");
        listExample.addLinkedBook("Dan Simmons");
        listExample.addLinkedBook("Mary Shelley");
        listExample.removeLinkedBook("Mary Shelley");
        listExample.getLinkedBooks(listExample.linkedBooks);

    }
}