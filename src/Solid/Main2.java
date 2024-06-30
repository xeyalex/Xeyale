package Solid;

public class Main2 {
           public static void main(String[] args) {
            Book book = new Book("Clean Code", "J.Gosling");

            BookDatabase bookDatabase = new BookDatabase();
            bookDatabase.saveToDatabase(book);

            BookPrinter bookPrinter = new BookPrinter();
            bookPrinter.printBookDetails(book);
        }
    }


