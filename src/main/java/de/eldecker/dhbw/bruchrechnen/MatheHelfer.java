package de.eldecker.dhbw.bruchrechnen;

public class MatheHelfer {

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
    
}
