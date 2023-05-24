package Classifica;

import java.util.Arrays;
import java.util.Random;

public class TestClassifica {
    public static void main(String[] args) {

        Giocatore[] giocatori = new Giocatore[110];
        for (int i = 0; i < giocatori.length; i++) {
            int id = i + 1;
            String nome = "Giocatore " + id;
            String squadra = "Squadra " + ((i % 10) + 1);
            giocatori[i] = new Giocatore(id, nome, squadra);
        }

        // Generazione di squadre
        Squadra[] squadre = new Squadra[10];
        for (int i = 0; i < squadre.length; i++) {
            int id = i + 1;
            String nome = "Squadra " + id;
            Giocatore[] rosa = Arrays.copyOfRange(giocatori, i * 11, (i + 1) * 11);
            squadre[i] = new Squadra(id, nome, rosa);
        }

        // Generazione di una classifica
        Classifica classifica = new Classifica(squadre);

        System.out.println(classifica.toString());


        System.out.println("\nSimulazione partite:");
        Random random = new Random();
        for (int i = 0; i < squadre.length - 1; i++) {
            for (int j = i + 1; j < squadre.length; j++) {
                Squadra squadraCasa = squadre[i];
                int goalCasa = random.nextInt(11);
                Squadra squadraOspite = squadre[j];
                int goalOspite = random.nextInt(11);
                System.out.println("******************************************************************");
                System.out.println("Squadra in Casa:\t" +squadraCasa + "\ngoal Fatti:\t" + goalCasa + "\nSquadra Ospite:\t" + squadraOspite + "\ngoal Fatti:\t" + goalOspite);
                classifica.esitoPartita(squadraCasa, goalCasa, squadraOspite, goalOspite);
            }
        }

        System.out.println(classifica.toString());
        System.out.println("Miglior attacco:\t" + classifica.getMigliorAttacco() + " con " + classifica.getMigliorAttacco().getGoalFatti());
        System.out.println("Peggior difesa: \t" + classifica.getPeggiorDifesa() + " con " + classifica.getPeggiorDifesa().getGoalSubiti());

        System.out.println("\nGoals squadre :");
        for (int i = 0; i < squadre.length; i++) {
            System.out.println("Squadra in Casa:\t" +squadre[i].getNome() + "\tGoal Fatti:\t" + squadre[i].getGoalFatti() + "\tGoal Subiti:\t" + squadre[i].getGoalSubiti());
        }



    }
}
