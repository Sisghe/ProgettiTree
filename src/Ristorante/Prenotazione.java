package Ristorante;

public class Prenotazione {
    private String codPrenotazione;
    private int nPosti;


    public Prenotazione(String codPrenotazione, int nPosti) {
        this.codPrenotazione = codPrenotazione;
        this.nPosti = nPosti;
    }

    public int getnPosti(){
        return nPosti;
    }

    public String getCodPrenotazione() {
        return codPrenotazione;
    }
}
