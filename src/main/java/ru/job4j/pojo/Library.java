package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        Book coldBook = new Book("Clean code");
        books[0] = coldBook;
        Book warBook = new Book("War and Peace", 100500);
        books[1] = warBook;
        Book historyBook = new Book("New history");
        books[2] = historyBook;
        Book masterBook = new Book("Master and Margarita");
        books[3] = masterBook;

        showBook(books);

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        showBook(books);

        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book);
            }
        }
    }

    private static void showBook(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
    }
}
