public class Algorithme {
    public static void triInsertion(int[] tab) {
        int pivot;
        for (int i = 1; i < tab.length; i++) {
            pivot = tab[i];
            int j = i - 1;
            while (j >= 0 && pivot < tab[j]) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = pivot;
        }
    }

    public static boolean rechercheSimple(int[] tableau, int valeur) {
        for (int element : tableau) {
            if (element == valeur) {
                return true;
            }
        }
        return false;
    }


    public static boolean rechercheDichotomique(int[] tableau, int valeur) {
        int gauche = 0;
        int droite = tableau.length - 1;
        boolean present = false;

        while (gauche <= droite) {
            int milieu = gauche + (droite - gauche) / 2;

            if (tableau[milieu] == valeur) {
                present=true;
                return present; // La valeur a été trouvée,
            } else if (tableau[milieu] < valeur) {
                gauche = milieu + 1; // La valeur est à droite du milieu
            } else {
                droite = milieu - 1; // La valeur est à gauche du milieu
            }
        }

        return present; // La valeur n'a pas été trouvée dans le tableau
    }

    public static int recherchePlusProcheValeur(int[] tableau, int valeur) {
        if (tableau.length == 0) {
            System.out.println("Le tableau ne peut pas être vide.");
        }

        int plusProche = tableau[0]; // Initialiser avec la première valeur du tableau
        int distanceMin = Math.abs(valeur - plusProche);

        for (int i = 1; i < tableau.length; i++) {
            int distanceActuelle = Math.abs(valeur - tableau[i]);

            if (distanceActuelle < distanceMin || (distanceActuelle == distanceMin && tableau[i] > plusProche)) {
                // Si la nouvelle valeur est plus proche ou égale et plus grande
                plusProche = tableau[i];
                distanceMin = distanceActuelle;
            }
        }

        return plusProche;
    }

    public static int recherchePlusProcheValeurDico(int[] tableauTrié, int valeurRecherche) {

        int gauche = 0;
        int droite = tableauTrié.length - 1;

        // Initialisation des indices de la valeur la plus proche
        int indicePlusProche = gauche;
        int distanceMin = Math.abs(valeurRecherche - tableauTrié[gauche]);

        while (gauche <= droite) {
            int milieu = gauche + (droite - gauche) / 2;

            // Mise à jour de la valeur la plus proche
            int distanceActuelle = Math.abs(valeurRecherche - tableauTrié[milieu]);
            if (distanceActuelle < distanceMin || (distanceActuelle == distanceMin && tableauTrié[milieu] > tableauTrié[indicePlusProche])) {
                indicePlusProche = milieu;
                distanceMin = distanceActuelle;
            }

            // Ajuster les indices pour continuer la recherche
            if (tableauTrié[milieu] < valeurRecherche) {
                gauche = milieu + 1;
            } else {
                droite = milieu - 1;
            }
        }

        return tableauTrié[indicePlusProche];
    }


    public static void main(String[] args){
        int[] tabTest = {5,2,8,6,9,2};
        triInsertion(tabTest);

        for(int var : tabTest){
            System.out.print(var + ".");
        }System.out.println();

        System.out.println(rechercheSimple(tabTest,5));

        System.out.println(rechercheDichotomique(tabTest,2));

        System.out.println(recherchePlusProcheValeur(tabTest,0));

        System.out.println(recherchePlusProcheValeurDico(tabTest,7));





    }
}






