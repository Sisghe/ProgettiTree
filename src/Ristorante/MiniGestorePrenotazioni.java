package Ristorante;

/**
 * Scrivere un programma in grado di modellare la gestione delle prenotazioni di un ristorante.
 * Il ristorante può ricevere 2 tipi di prenotazione: singola o di gruppo.
 * Progettare la classe GestorePrenotazioni a partire da due interi m e n che determinano rispettivamente
 * il numero di posti disponibili all’interno e all’esterno nel ristorante.
 * Ad ogni Prenotazione sono associati un codice univoco. Una prenotazione singola può anche esprimere una
 * preferenza tra interno ed esterno, La prenotazione di gruppo, invece,
 * ha anche un attributo che specifica il numero di posti da riservare.
 * <p>
 * La classe prevede i seguenti metodi:
 * - prenota: data una Prenotazione p in input, se c’è posto nel ristorante viene accettata
 * restituendo true (dando precedenza alla preferenza indicata), altrimenti viene rifiutata
 * restituendo false
 * <p>
 * - terminaPrenotazione: data una Prenotazione p in input, termina la prenotazione eliminandola
 * e liberando i posti associati.
 * <p>
 * PLUS🏍: Se presenti prenotazioni singole la cui preferenza può ora essere soddisfatta in virtù
 * dei nuovi posti liberi, modificare la prenotazione di conseguenza.
 * <p>
 * Esempio: ci sono 2 posti disponibili all’esterno e 2 prenotazioni p1 e p2, entrambe da 2 persone
 * all’esterno; nel momento in cui viene terminata la prenotazione p1, se p2 è ancora in corso, va spostata all’esterno.
 * <p>
 * - prenotazioniAttualiEsterno: ritorna un array con le attuali prenotazioni per l’esterno del ristorante
 * <p>
 * - prenotazioniAttualiInterno: ritorna un array con le attuali prenotazioni per l’interno del ristorante
 */
public class MiniGestorePrenotazioni {
    private int m, n;    //numero di posti disponibili all’interno e all’esterno nel ristorante

    private Prenotazione[] prenotazioniInterno;
    private Prenotazione[] prenotazioniEsterno;

    public MiniGestorePrenotazioni(int postiInterni, int postiEsterni) {
        this.m = postiInterni;
        this.n = postiEsterni;
        prenotazioniInterno = new Prenotazione[m];
        prenotazioniEsterno = new Prenotazione[n];
    }

    public boolean prenota(Prenotazione p) {
        if (Math.max(m, n) >= p.getnPosti()) {
            if (p instanceof PrenotazioneGruppo) {

                if ((n > p.getnPosti())) {
                    prenotazioniEsterno[prenotazioniEsterno.length - n] = p;
                    n -= p.getnPosti();
                } else {
                    prenotazioniInterno[prenotazioniInterno.length - m] = p;
                    m -= p.getnPosti();
                }
                return true;

            } else if (p instanceof PrenotazioneSingola) {

                if (((((PrenotazioneSingola) p).getPref()) == Preferenza.ESTERNO && n >= p.getnPosti())
                        || (((PrenotazioneSingola) p).getPref()) == Preferenza.INTERNO && m <= p.getnPosti()) {
                    prenotazioniEsterno[prenotazioniEsterno.length - n] = p;
                    n--;
                } else {
                    prenotazioniInterno[prenotazioniInterno.length - m] = p;
                    m--;
                }
                return true;
            }
        }
        return false;
    }/*data una Prenotazione p in input, se c’è posto nel ristorante viene accettata restituendo true (dando precedenza
     alla preferenza indicata), altrimenti viene rifiutata restituendo false*/


    private void assegnaPosto(Prenotazione[] prenArr, Prenotazione prenotazione, int x) {
        prenArr[prenArr.length - prenotazione.getnPosti()] = prenotazione;
        x -= prenotazione.getnPosti();
    }

    public void terminaPrenotazione(Prenotazione p) {

        for (int i = 0; i < prenotazioniInterno.length; i++) {
            if (prenotazioniInterno[i] != null && prenotazioniInterno[i].getCodPrenotazione().equals(p.getCodPrenotazione())) {
                prenotazioniInterno[i] = null;
                m += p.getnPosti();
                aggiornaPrenotazioni(prenotazioniEsterno, true);
                break;
            }
        }
        for (int i = 0; i < prenotazioniEsterno.length; i++) {
            if (prenotazioniEsterno[i] != null && prenotazioniEsterno[i].getCodPrenotazione().equals(p.getCodPrenotazione())) {
                prenotazioniEsterno[i] = null;
                n += p.getnPosti();
                aggiornaPrenotazioni(prenotazioniInterno, false);
                break;
            }
        }

    } //data una Prenotazione p in input, termina la prenotazione eliminandola e liberando i posti associati.


    private void aggiornaPrenotazioni(Prenotazione[] prenArr, boolean where) {    //Trovo prenotazioni non soddisfatte
        if (where) {
            for (int i = 0; i < prenArr.length; i++) {
                if (prenArr[i]!=null && ((PrenotazioneSingola) prenArr[i]).getPref().equals(Preferenza.INTERNO)) {
                    Prenotazione pren = prenArr[i];
                    terminaPrenotazione(pren);
                    this.prenota(pren);

                    break;
                }
            }
        } else {
            for (int i = 0; i < prenArr.length; i++) {
                if (prenArr[i]!=null &&((PrenotazioneSingola) prenArr[i]).getPref().equals(Preferenza.ESTERNO)) {
                    Prenotazione pren = prenArr[i];
                    terminaPrenotazione(pren);
                    this.prenota(pren);
                    break;
                }
            }
        }
    }

    public Prenotazione[] prenotazioniAttualiEsterno() {
        return prenotazioniEsterno;
    } //ritorna un array con le attuali prenotazioni per l’esterno del ristorante

    public Prenotazione[] prenotazioniAttualiInterno() {
        return prenotazioniInterno;
    } //ritorna un array con le attuali prenotazioni per l’interno del ristorante


}
