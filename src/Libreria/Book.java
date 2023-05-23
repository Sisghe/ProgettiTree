package Libreria;

/**
 * Sarà perciò necessario creare anche una classe Libro con delle proprie caratteristiche, tra cui ad esempio, un indice,
 * nome, autore, categoria, ecc.
 */
public class Book {
    private int index;
    private String name;
    private String author;

    //COSTRUTTORE  : crea un istanza dell' oggetto Book
    public Book(int index, String name, String author) {
        this.index = index;
        this.name = name;
        this.author = author;
    }

    public int getIndex() {
        return index;
    }
}
