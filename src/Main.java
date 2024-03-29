import janv2024.Sae2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Question 1 : Tester le tri par insertion
        //testerTriInsertion(300000);
        //testerTriInsertion(10000000); en commentaire car ce cas est beaucoup trop lent ( tri par insertion non efficace)

        // Question 2 : Tester les algorithmes de recherche
        testerAlgorithmesRecherche();

        // Question 3 : Tester la recherche de la valeur la plus proche
        testerRecherchePlusProche();

    }

    public static void testerTriInsertion(int longueur) {
        int[] tableauAleatoire = Sae2.générerTabAleatoire(longueur);

        long tempsDébut = System.nanoTime();
        Algorithme.triInsertion(tableauAleatoire);
        long tempsFin = System.nanoTime();

        System.out.println("Temps de tri par insertion pour une longueur de " + longueur + ": " + ((tempsFin - tempsDébut) / 1000000) + " millisecondes");
    }

    public static void testerAlgorithmesRecherche() {
        int[] tableauTrié = Sae2.générerTableauTriéParOrdreCroissant(10000000);
        int valeurRecherche = 50000;

        long tempsDébutSimple = System.nanoTime();
        boolean trouvéSimple = Algorithme.rechercheSimple(tableauTrié, valeurRecherche);
        long tempsFinSimple = System.nanoTime();

        long tempsDébutDichotomique = System.nanoTime();
        boolean trouvéDichotomique = Algorithme.rechercheDichotomique(tableauTrié, valeurRecherche);
        long tempsFinDichotomique = System.nanoTime();

        System.out.println("Temps de recherche (Simple) : " + ((tempsFinSimple - tempsDébutSimple) / 1000000) + " millisecondes");
        System.out.println("Temps de recherche (Dichotomique) : " + ((tempsFinDichotomique - tempsDébutDichotomique) / 1000000) + " millisecondes");
    }

    public static void testerRecherchePlusProche() {
        int[] tableauAleatoire = Sae2.générerTabAleatoire(100);
        int valeurRecherche = 25;

        int plusProcheSimple = Algorithme.recherchePlusProcheValeur(tableauAleatoire, valeurRecherche);
        Arrays.sort(tableauAleatoire); // trie le tableau en utilisant un algorithme de type Quicksort
        int plusProcheDichotomique = Algorithme.recherchePlusProcheValeurDico(tableauAleatoire, valeurRecherche);

        System.out.println("Valeur la plus proche (Simple) : " + plusProcheSimple);
        System.out.println("Valeur la plus proche (Dichotomique) : " + plusProcheDichotomique);
    }

}
