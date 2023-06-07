package JustDelivery;

import java.util.Comparator;
import java.util.HashMap;

public class NumOrdiniComparator implements Comparator<Ristorante> {
    private Utente utente;
    private HashMap<Ristorante, Integer> cacheNumOrdini;

    public NumOrdiniComparator(Utente utente) {
        this.utente = utente;
    }

    @Override
    public int compare(Ristorante o1, Ristorante o2) {
        int countO1 = 0, countO2 = 0;
        if (cacheNumOrdini.containsKey(o1)) {
            countO1 = cacheNumOrdini.get(o1);
        }
        if (cacheNumOrdini.containsKey(o2)) {
            countO2 = cacheNumOrdini.get(o2);
        }
        //caching
        //controllo nella mappa se ho già calcolato e effettuo li il confronto
        //altrimenti entro nel for

        if (countO1 == 0 || countO2 == 0) {
            for (Ordine o : utente.getOrdini()) {

                //System.out.println(o1 + o2);
                if (o.getRistorante().equals(o1)) {
                    countO1++;
                }
                else if(o.getRistorante().equals(o2)){
                    countO2++;
                }
            }
            cacheNumOrdini.put(o1,countO1);
            cacheNumOrdini.put(o2,countO2);
        }
        //countO1>countO2 = -1, countO1<countO2 = 1, altrimenti 0
        return Integer.compare(countO1,countO2);
    }

    /*public static void main(String[] args) {
        List<Ristorante> list = new ArrayList<>();
        list.sort(new NumOrdiniComparator());
    }*/
}
