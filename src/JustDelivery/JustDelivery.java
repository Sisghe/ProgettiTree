package JustDelivery;

import java.util.ArrayList;
import java.util.List;

/***
 * ## JustDelivery
 *
 * E' stata commissionata la realizzazione di un sistema per gestire un'app di food delivery
 *
 * Nell'app sono presenti
 * gli utenti
 * i ristoranti
 * ogni ristorante ha un menu e uno o più tipi di cucina
 * un utente può fare un ordine da un singolo ristorante scegliendo almeno uno dei prodotti nel menu
 *
 * # Funzioni 1
 * * Registrazione utente
 * * Registrazione ristorante
 * * Inserimento menu del ristorante
 * * Ricerca dei ristoranti per tipo di cucina
 * * Stampa del menu su console
 * * Aggiunta dei prodotti all'ordine
 * * Stampa del dettaglio dell'ordine (lista prodotti, prezzo totale calcolando le spese di consegna)
 * * Ottenere lo storico degli ordini di un utente
 *
 * # Funzioni 2
 * * Ottenere i ristoranti dai quali un utente ha effettuato un ordine, ordinati per quantità di ordini effettuati dall'utente
 * * Ottenere la cucina più apprezzata dall'utente (se ordino una volta da un ristorante con cucina "cinese" e due volte da un
 * ristorante con cucina "fast food", la cucina più apprezzata da me è "fast food")
 * * Dato un utente **u**, utilizzando la cucina più apprezzata dall'utente **u**, scegliere un ristorante che ha quel tipo di
 * cucina e dal quale l'utente **u** non ha mai ordinato
 */
public class JustDelivery {
    //Lista dei ristoranti
    List<Ristorante> ristoranti = new ArrayList<>();

    //Lista degli utenti
    List<Utente> utenti = new ArrayList<>();

    /**
     * Registrazione utente nell'app
     * @param utente utente da registrare
     */
    public void registrazioneUtente(Utente utente){
        utenti.add(utente);
    }

    /**
     * Registrazione ristorante nell'app
     * @param ristorante ristorante da registrare
     */
    public void registrazioneRistorante(Ristorante ristorante){
        ristoranti.add(ristorante);
    }

    /**
     * Setta il menu di un ristorante
     * @param ristorante ristorante specificato
     * @param prods prodotti da aggiungere al menu del ristorante
     */
    public void setMenu(Ristorante ristorante, List<Prodotto> prods){
        for (Ristorante rist : ristoranti) {
            if(rist.equals(ristorante)){
                rist.setMenu(prods);
            }
        }
    }


}
