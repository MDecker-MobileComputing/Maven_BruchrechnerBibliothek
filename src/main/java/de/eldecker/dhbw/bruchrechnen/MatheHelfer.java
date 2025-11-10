package de.eldecker.dhbw.bruchrechnen;


/**
 * Klasse mit Hilfsmethoden für mathematische Berechnungen.
 */
public class MatheHelfer {

    /**
     * Diese Klasse enthält nur statische Methoden, daher wird der
     * Konstruktor versteckt, damit nicht versehentlich Objekte von
     * dieser Klasse erzeugt werden können.
     */
    private MatheHelfer() {

        // absichtlich leer gelassen
    }


    /**
     * Berechnung größter gemeinsamer Teiler von {@code a} und {@code b},
     * wird für die Kürzung von Brüchen benötigt; verwendet den
     * Wechselwegnahme-Algorithmus, bei dem in jedem Schleifenlauf
     * die kleinere von der größeren Zahl abgezogen wird.
     * <br><br>
     *
     * Beispiel: {@code ggt( 12, 18 )} ergibt {@code 6}.
     *
     * @param a Erster Wert
     *
     * @param b Zweiter Wert
     *
     * @return Größter gemeinsamer Teiler
     */
    public static int ggt ( int a, int b ) {

        if ( a == 0 ) { return b; }

        if ( b == 0 ) { return a; }

        int x = Math.abs( a );
        int y = Math.abs( b );

        while ( x != y ) {

            if ( x > y ) {

                x = x - y;

            } else {

                y = y - x;
            }
        }

        return x;
    }


    /**
     * Methode prüft, ob eine Zahl eine Primzahl ist
     *
     * @param n Zahl, die auf Prim-Eigenschaft geprüft werden soll
     *
     * @return {@code true} gdw. {@code n} eine Primzahl ist
     */
    public static boolean istPrimzahl( int n ) {

        if ( n <= 1 ) {

            return false;
        }

        final int wurzelVonN = (int) Math.sqrt( n );
        for ( int i = 2; i <= wurzelVonN ; i++ ) {

            if ( n % i == 0 ) {

                return false;
            }
        }

        return true;
    }

}
