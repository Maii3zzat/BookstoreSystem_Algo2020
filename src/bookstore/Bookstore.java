package bookstore;
import java. util. Collection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

public class Bookstore {
    
    public static ArrayList <Book> ReadFromFile(String fileName) {
        ArrayList <String> BooksAsStrings = new ArrayList();  //initialize an Arraylist
        BufferedReader reader; //make a Buffered Reader object
	try { //throught an exception 
            reader = new BufferedReader(new FileReader(fileName)); 
            String line = reader.readLine(); //read line by line
            while (line != null) {
                BooksAsStrings.add(line); //add the line to the arraylist 
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) { 
        
        }
        ArrayList <Book> BookList = new ArrayList();
        for (String b : BooksAsStrings) { //foreach loop to iterate through the BooksAsStrings arraylist
            String delimiter = "-"; //initializing delimiter
            String [] attr = b.split(delimiter); //split the array of string with a delimiter 
            int id = parseInt((String)attr[0]);
            String title = attr[1];
            String author = attr[2];
            String genre = attr[3];
            int width = parseInt((String)attr[4]);
            int price = parseInt((String)attr[5]);

            BookList.add(new Book(id, title, author, genre, width, price)); //adding the data from file into the arraylist
        }
        return BookList;
    }
    
    public static ArrayList <Shelf> ReadFile(String fileName) {
        ArrayList <String> ShelfAsStrings = new ArrayList();
        BufferedReader reader;
	try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                ShelfAsStrings.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) { 
        
        }
        ArrayList <Shelf> ShelfList = new ArrayList();
        for (String s : ShelfAsStrings) {
            String delimiter = "-";
            String [] attr = s.split(delimiter);
            int id = parseInt((String)attr[0]);
            String genre = attr[1];
            int width = parseInt((String)attr[2]);
            ShelfList.add(new Shelf(id, genre, width));
        }
        return ShelfList;
    }
    
    public static void main(String[] args) {
        
        ArrayList <Shelf> Shelves = ReadFile("Shelves.txt");
        ArrayList <Book> Books = ReadFromFile("Books.txt");
        Manager M = new Manager();
        M.fillShelf(Books,Shelves,"Thriller");
        M.OptimalBookSelection(Books,7);
    }
    
}
