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

        boolean present = false;
        int i = 0;

        while(i< tableau.length && !present){
            if(tableau[i] == valeur){
                present = true;
            }
            i++;
        }
        return present;
    }


    public static boolean rechercheDichotomique(int[] tableau, int valeur) {
        /* le tableau doit etre trié  */

        int debut = 0;
        int fin = tableau.length - 1;
        boolean present = false;

        while (debut <= fin) { // on Verifie que la valeur de debut reste inferieur a la valeur de fin
            int milieu = debut + (fin - debut) / 2;
            //System.out.println(milieu);

            if (tableau[milieu] == valeur) {
                present=true;
                return present; // La valeur a été trouvée,
            } else if (tableau[milieu] < valeur) {
                debut = milieu + 1; // La valeur est à fin du milieu
            } else {
                fin = milieu - 1; // La valeur est à debut du milieu
            }
        }

        return present; // La valeur n'a pas été trouvée dans le tableau
    }

    public static int recherchePlusProcheValeur(int[] tableau, int valeur) {
        /* le tableau doit etre non vide

        if (tableau.length == 0) {
            System.out.println("Erreur: Le tableau ne peut pas être vide. ( en cas d'erreur l'algorithme affiche - 9999999");
            return -9999999;
        }

        */

        int plusProche = tableau[0]; // Initialiser avec la première valeur du tableau
        int distanceMin = Math.abs(valeur - plusProche); //On prend la valeur absolue de la distance entre les valeurs

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

        int debut = 0;
        int fin = tableauTrié.length - 1;

        // Initialisation des indices de la valeur la plus proche
        int indicePlusProche = debut;
        int distanceMin = Math.abs(valeurRecherche - tableauTrié[debut]);

        while (debut <= fin) {
            int milieu = debut+(fin - debut) / 2;

            // Mise à jour de la valeur la plus proche
            int distanceActuelle = Math.abs(valeurRecherche - tableauTrié[milieu]);
            if (distanceActuelle < distanceMin || (distanceActuelle == distanceMin && tableauTrié[milieu] > tableauTrié[indicePlusProche])) {
                indicePlusProche = milieu;
                distanceMin = distanceActuelle;
            }

            // Ajuster les indices pour continuer la recherche
            if (tableauTrié[milieu] < valeurRecherche) {
                debut = milieu + 1;
            } else {
                fin = milieu - 1;
            }
        }

        return tableauTrié[indicePlusProche];
    }


    public static void main(String[] args){
        int[] tabTest = {5,2,8,6,9,2,5};
        triInsertion(tabTest);

        for(int var : tabTest){
            System.out.print(var + ".");
        }System.out.println();

        System.out.println(rechercheSimple(tabTest,5));

        System.out.println(rechercheDichotomique(tabTest,2));

        System.out.println(recherchePlusProcheValeur(tabTest,0));

        System.out.println(recherchePlusProcheValeurDico(tabTest,7));
        System.out.println(recherchePlusProcheValeurDico(tabTest,11));






    }
}






