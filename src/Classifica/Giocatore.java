package Classifica;

public class Giocatore {
    private int id;
    private String nome;
    private String squadra;

    public Giocatore(int id, String nome, String squadra) {
        this.id = id;
        this.nome = nome;
        this.squadra = squadra;
    }

    public int getId() {
        return id;
    }

    public String getSquadra() {
        return squadra;
    }
}
