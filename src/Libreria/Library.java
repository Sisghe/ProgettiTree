package Libreria;

/**
 * Scrivere un programma che permetta di gestire una Biblioteca semplificata, in grado di gestire un array
 * dei libri che contiene. La Biblioteca può essere creata a partire da un array di libri.
 * In particolare, implementare almeno i seguenti metodi:
 * - `esisteLibro`: prende l'indice di un libro e restituisce true se nella biblioteca esiste un libro con questo indice, false altrimenti
 * - `getLibriOrdinati`: ritorna la lista di libri presenti nella biblioteca, in ordine ascendente
 */
public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public boolean isBook(int indice) {
        for (Book book : books) {
            if (book.getIndex() == indice) {
                return true;
            }
        }
        return false;
    }

    public Book[] getBookSorted() {
        Book copyBook;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < books.length - 1; i++) {
                if (books[i].getIndex() > books[i + 1].getIndex()) {
                    copyBook = books[i];        //copio il libro da far avanzare
                    books[i] = books[i + 1];      //inserisco il secondo libro nella cella precedente
                    books[i + 1] = copyBook;      //inserisco il primo libro nella cella successiva
                    flag = true;
                }
            }
        }
        return books;
    }
}
