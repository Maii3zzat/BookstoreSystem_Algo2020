package bookstore;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private Book book;
    private Shelf shelf;

    public Manager() {
    }

    public Manager(Book book, Shelf shelf) {
        this.book = book;
        this.shelf = shelf;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }
    
 

    public void fillShelf(ArrayList<Book> Books, ArrayList<Shelf> Shelves, String genre){ //the fillshelf function takes the array of books and shelves and the desired genre
        List<Book> booklist = new ArrayList<Book>();
        Books.sort(new BookSort()); //sort property to sort the ArrayList of books based on its width in ascending order from the interface BookSort
        for(Shelf s: Shelves){      //This foreach loop iterates through an Arraylist of Shelves
         int availableSpace = s.getWidth();  //initializing a variable with an initial value of a shelf's wifth
         if(s.getGenre().equalsIgnoreCase(genre)){ //If condition checks the right shelf genre based on the genre entered
             for(Book b: Books){   //This foreach loop iterates through an Arraylist of Books
               
               if(b.getGenre().equalsIgnoreCase(genre)){ //If condition to check only the right genre of books that goes with the shelf genre
                   if(b.getWidth() <= availableSpace){  //If condition to check for available space left in the shelf before adding more books
                      booklist.add(b);
                      availableSpace = availableSpace - b.getWidth(); //Reassign the value of the available space after adding a book
                      System.out.print("A book has been added and the available space left is "+ availableSpace+" \n"); 
                   }  
                }
             }
             System.out.print("The list of books in "+s.getGenre()+" shelf is "+booklist+"\n");
             
         } 
        }
    }
    

    public int OptimalBookCombination( ArrayList<Book> book, List<Book> opt_choice, int x,int Swidth){
        if(Swidth == 0 || x==0 ){ // if there's no width or the list of books is empty 
            return 0;              // then returns Zero
        }
        if(book.get(x-1).getWidth()> Swidth) {  //Compares the width of the book to the entered width 
            List<Book> tempOptimal = new ArrayList<>(); //creates a new arraylist of book to be the temporary optimal choice
            int opt_weight = OptimalBookCombination( book, tempOptimal, x-1, Swidth); //Initialize the optimal weight and the function calls itself with less books in the list by 1
            opt_choice.addAll(tempOptimal); //adds the different books to the list
            return opt_weight; // returns the optimal weight
            
        }
        else{
            List<Book> inc_opt_selection = new ArrayList<>();  //an arraylist for considered optimal selection
            List<Book> exc_opt_selection = new ArrayList<>();  //an arraylist for out of competition optimal selection
            int inc_weight = book.get(x-1).getWidth() + OptimalBookCombination(book, inc_opt_selection, x-1,(Swidth-book.get(x-1).getWidth())); //recursive to try all optimal possibilities
            int exc_weight = OptimalBookCombination( book, exc_opt_selection, x-1, Swidth); //recursive to exlude possibilities 
         
            if(inc_weight > exc_weight){ //if condition to see if included weight is bigger than exlcuded weight
                opt_choice.addAll(inc_opt_selection); //adding the choice to the included optimal selection
                opt_choice.add(book.get(x-1));   
                return inc_weight;  //returns included weight
                
            }
            else{
                opt_choice.addAll(exc_opt_selection); //else, adds the choice to the excluded optimal selection
                return exc_weight;  //returns excluded weight
            }
        }
       
    }
    public void OptimalBookSelection(ArrayList<Book> blist, int Swidth) {
        ArrayList<Book> booklist = new ArrayList<>(); //initialize a book list
        OptimalBookCombination(blist, booklist, blist.size(),Swidth); //call the function to get the optimal combination 
        System.out.println("The Optimal Selection of Books for width " + Swidth + " is:");
        for(int i = 0; i < booklist.size(); i++) {  //loop through the list 
            System.out.println("Book " + (i+1) +" "+ booklist.get(i)); //to print out the optimal combination of the list of books
        }
    }

    
}
