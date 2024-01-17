package janv2024;

import java.util.Arrays;
import java.util.Random;

public class Sae2 {

    public static void main(String[] args) {

        int[] tab = générerTabAleatoire(10000000);

        long tempsDébut = System.nanoTime();

        Arrays.sort(tab); // trie le tableau en utilisant un algorithme de type Quicksort

        long tempsFin = System.nanoTime();

        System.out.println("Temps de calcul en millisecondes: " + ((tempsFin - tempsDébut) / 1000000) );

        int[] tabTest = générerTabAleatoire(300000);


        tempsDébut = System.nanoTime();

        Arrays.sort(tab); // trie le tableau en utilisant un algorithme de type Quicksort

        tempsFin = System.nanoTime();

        System.out.println("Temps de calcul en millisecondes: " + ((tempsFin - tempsDébut) / 1000000) );

        //System.out.println(Arrays.toString(tab));

    }


    /*
        Retourne un tableau de int rempli avec des valeurs aléatoires.
        La longueur du tableau est reçue en paramètre.
        (Valeurs comprises entre Integer.MIN_VALUE=-2^31 et Integer.MAX_VALUE=2^31-1 inclus).
    */
    public static int[] générerTabAleatoire(int longueur) {
        Random random = new Random();
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(); // tirage aléatoire d'un int quelconque (compris entre -2^31 et 2^31-1)
        return t;
    }

    /*
        Retourne un tableau de int rempli avec des valeurs aléatoires comprises entre min et max inclus.
        La longueur du tableau est reçue en paramètre.
    */
    public static int[] générerTabAleatoireEntreBornes(int longueur, int min, int max) {
        Random random = new Random();
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(max-min+1)+min; // nextInt(borne) retourne un int compris entre 0 inclus et borne exclus.
        return t;
    }

    public static int[] générerTableauTriéParOrdreCroissant (int longueur) {
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = i;
        return t;
    }

    public static int[] générerTableauTriéParOrdreDecroissant (int longueur) {
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = t.length-1-i;
        return t;
    }

    /*
        Retourne un tableau contenant les multiples de 4 à partir de 0 ({0, 4, 8, 16...}).
        Utile pour faire des essais de recherche dans un tableau trié.
     */
    public static int[] générerTabMultiplesDe4(int longueur) {
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = 4*i;
        return t;
    }

}