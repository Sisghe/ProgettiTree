package JustDelivery;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class TestDelivery {
    public static void main(String[] args) {
        //Crea l'app
        JustDelivery app = new JustDelivery();

        //Creazione dei ristoranti
        Ristorante ristorante1 = new Ristorante("McDonald's", UUID.randomUUID(), Arrays.asList(TipoCucina.FASTFOOD), 1);
        Ristorante ristorante2 = new Ristorante("Sushi", UUID.randomUUID(), Arrays.asList(TipoCucina.CINESE, TipoCucina.GIAPPONESE), 1);
        Ristorante ristorante3 = new Ristorante("World Restaurant", UUID.randomUUID(), Arrays.asList(TipoCucina.THAILANDESE, TipoCucina.ARABO, TipoCucina.INDIANO), 1);

        //Creazione degli utenti
        Utente utente1 = new Utente("Andrea", UUID.randomUUID());
        Utente utente2 = new Utente("Filippo", UUID.randomUUID());
        Utente utente3 = new Utente("Tommaso", UUID.randomUUID());
        Utente utente4 = new Utente("Nicola", UUID.randomUUID());
        Utente utente5 = new Utente("Lorenzo", UUID.randomUUID());
        Utente utente6 = new Utente("Michele", UUID.randomUUID());

        //Creazione prodotti
        Prodotto prodotto1 = new Prodotto("Mela", 12);
        Prodotto prodotto2 = new Prodotto("Pizza", 45);
        Prodotto prodotto3 = new Prodotto("Pasta", 11);
        Prodotto prodotto4 = new Prodotto("Carbonara", 17);
        Prodotto prodotto5 = new Prodotto("Vino", 67);
        Prodotto prodotto6 = new Prodotto("Birra", 16);
        Prodotto prodotto7 = new Prodotto("Tagliata", 23);


        //Registrazione Utenti
        app.registrazioneUtente(utente1);
        app.registrazioneUtente(utente2);
        app.registrazioneUtente(utente3);
        app.registrazioneUtente(utente4);
        app.registrazioneUtente(utente5);
        app.registrazioneUtente(utente6);

        //Registrazione Ristoranti
        app.registrazioneRistorante(ristorante1);
        app.registrazioneRistorante(ristorante2);
        app.registrazioneRistorante(ristorante3);

        //Stampa ristoranti e utenti
        System.out.println("*** RISTORANTI REGISTRATI ***");
        System.out.println(app.getRistoranti());
        System.out.println("*** UTENTI REGISTRATI ***");
        System.out.println(app.getUtenti());

        //Setta il menu dei ristoranti
        app.setMenu(ristorante1, Arrays.asList(prodotto1, prodotto3, prodotto2));
        app.setMenu(ristorante2, Arrays.asList(prodotto4, prodotto5, prodotto6));
        app.setMenu(ristorante3, Arrays.asList(prodotto1, prodotto2, prodotto7));

        System.out.println("*** RICERCA RISTORANTI FASTFOOD");
        System.out.println(app.cercaRistorantiCucina(TipoCucina.FASTFOOD));

        app.stampaMenu(ristorante1);
        app.stampaMenu(ristorante2);
        app.stampaMenu(ristorante3);

        //aggiunta prodotti all'ordine
        app.addProdotto(prodotto1, utente1,ristorante1);
        app.addProdotto(prodotto2,utente2,ristorante2);
        app.addProdotto(prodotto3,utente3,ristorante3);
        
        List<Utente> ut = app.getUtenti();
        for (Utente utente : ut) {
            System.out.println(utente.getOrdineCorrente());
        }
        

/*
        app.addProdotto(prodotto4);
        app.addProdotto(prodotto5);
        app.addProdotto(prodotto6);*/

    }
}
