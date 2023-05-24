package Classifica;

public class Squadra {
    private int id;
    private String nome;
    private Giocatore[] rosa;
    private int punteggio;
    private int goalFatti;
    private int golSubiti;

    public Squadra(int id, String nome, Giocatore[] rosa) {
        this.id = id;
        this.nome = nome;
        this.rosa = rosa;
    }


    public void setGoalFatti(int goalFatti) {
        this.goalFatti += goalFatti;
    }

    public void setGoalSubiti(int golSubiti) {
        this.golSubiti += golSubiti;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio += punteggio;
    }

    public int getId() {
        return id;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public int getGoalFatti() {
        return goalFatti;
    }

    public int getGoalSubiti() {
        return golSubiti;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Squadra{" + "nome='" + nome +  '}';
    }
}
