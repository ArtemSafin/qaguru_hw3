package collections;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public final List<String> books = new ArrayList<>();
    public void getElements(List<String> books) {
        for (String book : books) {
            System.out.println("List: " + book);
        }
    }
    public void addBook(String value) {
        books.add(value);
    }
    public void removeBook(String value) {
        books.remove(value);
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

    }
}