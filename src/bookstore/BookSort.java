
package bookstore;
import java.util.Comparator;

public class BookSort implements Comparator <Book> {  //an interface to sort books using comparator
    
   @Override 
   public int compare(Book b1, Book b2) {  //overriding the compare method to compare between book objects
        return Integer.compare(b1.getWidth(), b2.getWidth()); //specify the comparing to the width of the book in an ascending order 
    }
}
