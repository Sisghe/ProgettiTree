package Ristorante;

public class PrenotazioneSingola extends Prenotazione{
    private Preferenza pref;
    public PrenotazioneSingola(String codPrenotazione,Preferenza pref) {
        super(codPrenotazione, 1);
        this.pref = pref;

    }

    public Preferenza getPref() {
        return pref;
    }
}
