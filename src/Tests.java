import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    public void testTriInsertion() {
        int[] tableau = {5, 2, 8, 6, 9, 2, 5};
        Algorithme.triInsertion(tableau);
        int[] attendu = {2, 2, 5, 5, 6, 8, 9};
        assertArrayEquals(attendu, tableau);

        // Test avec un tableau déjà trié
        int[] tableauTrié = {1, 2, 3, 4, 5};
        Algorithme.triInsertion(tableauTrié);
        assertArrayEquals(tableauTrié, tableauTrié);

        // Test avec un tableau en ordre inverse
        int[] tableauInverse = {5, 4, 3, 2, 1};
        Algorithme.triInsertion(tableauInverse);
        int[] attenduInverse = {1, 2, 3, 4, 5};
        assertArrayEquals(attenduInverse, tableauInverse);

        int[] tableauVide = {};
        Algorithme.triInsertion(tableauVide);
        assertArrayEquals(new int[]{}, tableauVide);
    }

    @Test
    public void testRechercheSimple() {
        int[] tableau = {2, 4, 6, 8, 10};
        assertTrue(Algorithme.rechercheSimple(tableau, 8));
        assertFalse(Algorithme.rechercheSimple(tableau, 5));

        // Test avec un tableau à un seul élément
        int[] tableauUnElement = {42};
        assertTrue(Algorithme.rechercheSimple(tableauUnElement, 42));
        assertFalse(Algorithme.rechercheSimple(tableauUnElement, 99));

        // Test avec une valeur qui n'est pas dans le tableau
        assertFalse(Algorithme.rechercheSimple(tableau, 5));

        // Test avec une valeur aux extrémités
        assertTrue(Algorithme.rechercheSimple(tableau, 2));
        assertTrue(Algorithme.rechercheSimple(tableau, 10));

        // Test avec un tableau vide
        int[] tableauVide = {};
        assertFalse(Algorithme.rechercheSimple(tableauVide, 42));
    }

    @Test
    public void testRechercheDichotomique() {
        int[] tableau = {2, 4, 6, 8, 10};
        assertTrue(Algorithme.rechercheDichotomique(tableau, 8));
        assertFalse(Algorithme.rechercheDichotomique(tableau, 5));

        // Test avec un tableau à un seul élément
        int[] tableauUnElement = {42};
        assertTrue(Algorithme.rechercheDichotomique(tableauUnElement, 42));
        assertFalse(Algorithme.rechercheDichotomique(tableauUnElement, 99));

        // Test avec une valeur qui n'est pas dans le tableau
        assertFalse(Algorithme.rechercheDichotomique(tableau, 5));

        // Test avec une valeur aux extrémités
        assertTrue(Algorithme.rechercheDichotomique(tableau, 2));
        assertTrue(Algorithme.rechercheDichotomique(tableau, 10));

        // Test avec un tableau vide
        int[] tableauVide = {};
        assertFalse(Algorithme.rechercheDichotomique(tableauVide, 42));

    }

    @Test
    public void testRecherchePlusProcheValeur() {
        int[] tableau = {2, 4, 6, 8, 10};
        assertEquals(8, Algorithme.recherchePlusProcheValeur(tableau, 7));

        // Test avec un tableau à un seul élément
        int[] tableauUnElement = {42};
        assertEquals(42, Algorithme.recherchePlusProcheValeur(tableauUnElement, 99));

        // Test avec une valeur aux extrémités
        assertEquals(2, Algorithme.recherchePlusProcheValeur(tableau, 1));
        assertEquals(10, Algorithme.recherchePlusProcheValeur(tableau, 11));

        // Test avec un tableau vide
       /* int[] tableauVide = {};
        assertEquals(-999999, Algorithme.recherchePlusProcheValeur(tableauVide, 42));*/
    }


    @Test
    public void testRecherchePlusProcheValeurDico() {
        int[] tableau = {2, 4, 6, 8, 10};
        assertEquals(8, Algorithme.recherchePlusProcheValeurDico(tableau, 7));

        // Test avec un tableau à un seul élément
        int[] tableauUnElement = {42};
        assertEquals(42, Algorithme.recherchePlusProcheValeurDico(tableauUnElement, 99));

        // Test avec une valeur aux extrémités
        assertEquals(2, Algorithme.recherchePlusProcheValeurDico(tableau, 1));
        assertEquals(10, Algorithme.recherchePlusProcheValeurDico(tableau, 11));

        // Test avec un tableau vide
        /*int[] tableauVide = {};
        assertEquals(-9999999, Algorithme.recherchePlusProcheValeurDico(tableauVide, 42));*/
    }
}
