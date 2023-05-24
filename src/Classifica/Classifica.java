package Classifica;

/**
 * Progettare una classe Classifica che permetta di gestire la classifica di Serie A costruita a partire da
 * 20 squadre di calcio. Ogni squadra di calcio ha i seguenti attributi:
 * <p>
 * - id
 * - nome
 * - rosa di giocatori
 * - punteggio
 * - gol fatti
 * - gol subiti
 * <p>
 * Ogni giocatore ha un id, un nome e un cognome.
 * In particolare, deve essere possibile gestire le seguenti operazioni:
 * <p>
 * - esitoPartita(squadraCasa, golCasa, squadraOspite, golOspite): gestisce il punteggio delle due squadre
 * in base all'esito
 * - getClassifica(): ritorna la classifica attuale, ordinata per punteggio
 * - getMigliorAttacco(): ritorna la squadra che ha segnato più gol
 * - getPeggiorDifesa(): ritorna la squadra che ha concesso più gol
 */
public class Classifica {
    public final int win = 3;
    public final int draw = 1;

    private Squadra[] classifica;
    private Squadra topGoals = new Squadra(0, "", null);
    private Squadra downGoals = new Squadra(0, "", null);

    public Classifica(Squadra[] squadre) {
        this.classifica = squadre;
        getClassifica();
    }

    public void esitoPartita(Squadra squadraCasa, int goalCasa, Squadra squadraOspite, int goalOspite) {   //gestisce il punteggio delle due squadre
        if (goalCasa > goalOspite) {
            squadraCasa.setPunteggio(win);
        } else if (goalCasa < goalOspite) {
            squadraOspite.setPunteggio(win);
        } else {
            squadraCasa.setPunteggio(draw);
            squadraOspite.setPunteggio(draw);
        }
        squadraCasa.setGoalFatti(goalCasa);
        squadraCasa.setGoalSubiti(goalOspite);
        squadraOspite.setGoalFatti(goalOspite);
        squadraOspite.setGoalSubiti(goalCasa);

        topGoals = topGoals.getGoalFatti()>squadraOspite.getGoalFatti() ? topGoals : squadraOspite;
        topGoals = topGoals.getGoalFatti()>squadraCasa.getGoalFatti() ? topGoals : squadraCasa;
        downGoals = downGoals.getGoalSubiti()>squadraCasa.getGoalSubiti() ? downGoals : squadraCasa;
        downGoals = downGoals.getGoalSubiti()>squadraCasa.getGoalSubiti() ? downGoals : squadraCasa;

    }


    public Squadra[] getClassifica() {          //ritorna la classifica attuale, ordinata per punteggio
        Squadra squadraVar;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < classifica.length - 1; i++) {
                if (classifica[i].getPunteggio() < classifica[i + 1].getPunteggio()) {
                    squadraVar = classifica[i];
                    classifica[i] = classifica[i + 1];
                    classifica[i + 1] = squadraVar;
                    flag = true;
                }
            }
        }
        return classifica;
    }


    public Squadra getMigliorAttacco() {         //ritorna la squadra che ha segnato più gol
        return topGoals;
    }


    public Squadra getPeggiorDifesa() {          //ritorna la squadra che ha concesso più gol
        return downGoals;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        System.out.println("Classifica Serie A:\n");
        Squadra[] squadreClassifica = getClassifica();
        for (int i = 0; i < squadreClassifica.length; i++) {
            Squadra squadra = squadreClassifica[i];
            sb.append((i + 1) + ". " + squadra.getNome()+ "\n");
        }
        return "\n" + sb;
    }
}
