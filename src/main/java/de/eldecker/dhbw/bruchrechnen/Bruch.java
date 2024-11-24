package de.eldecker.dhbw.bruchrechnen;

import java.util.Objects;


/**
 * Klasse für Bruchrechnen.
 */
class Bruch {

    /** Zähler des Bruchs. */
    private int _zaehler;
    
    /** Nenner des Bruchs, darf nicht 0 sein. */
    private int _nenner;


    /**
     * Bruch nur mit Zähler erzeugen (Nenner ist 1).
     * 
     * @param zaehler Zähler-Wert
     */
    public Bruch( int zaehler ) {

        this( zaehler, 1 );
    }

    
    /**
     * Konstruktor, um neuen Bruch mit Zähler und Nenner erzeugen.
     *
     * @param zaehler Zähler-Wert
     *
     * @param nenner Nenner, darf nicht 0 sein
     */
    public Bruch( int zaehler, int nenner ) {

        _zaehler = zaehler;
        _nenner  = nenner;
    }


    /**
     * Getter für Zähler-Wert.
     * 
     * @return Zähler-Wert.
     */
    public int getZaehler() {
        
        return _zaehler;
    }

    
    /**
     * Getter für Nenner-Wert.
     * 
     * @return Nenner-Wert.
     */
    public int getNenner() {
        
        return _nenner;
    }

    
    /**
     * Gibt gekürzten Bruch des aufgerufenen Objekts zurück,
     * z.B. {@code 1/2} für {@code 2/4}.
     *
     * @return Gekürzter Bruch
     */
    public Bruch kuerze() {

        int ggt = ggt( _zaehler, _nenner );

        int zaehlerNeu = _zaehler / ggt;
        int nennerNeu  = _nenner  / ggt;

        return new Bruch( zaehlerNeu, nennerNeu );
    }


    /**
     * Kehrwert des Bruchs zurückgeben, bspw. {@code 2/3} für {@code 3/2}.
     *
     * @return Kehrwert (Zähler und Nenner vertauscht)
     */
    public Bruch kehrwert() {

        return new Bruch( _nenner, _zaehler );
    }


    /**
     * Negiert den Bruch (negiert den Zähler-Wert).
     *
     * @return Negierter Bruch
     */
    public Bruch negieren() {

        return new Bruch( -_zaehler, _nenner );
    }
    
    
    /**
     * Addiert den Bruch mit einem anderen Bruch.
     *
     * @param b Bruch, mit dem addiert werden soll
     *
     * @return Gekürzte Summe
     */
    public Bruch addieren( Bruch b ) {

        int zaehlerNeu = _zaehler*b._nenner + b._zaehler*_nenner;
        int nennerNeu  = _nenner*b._nenner;

        return new Bruch( zaehlerNeu, nennerNeu ).kuerze();
    }


    /**
     * Subtrahiert den Bruch mit einem anderen Bruch.
     *
     * @param b Bruch, von dem subtrahiert werden soll
     *
     * @return Gekürztes Differenz
     */
    public Bruch subtrahieren( Bruch b ) {

        Bruch bNegiert = b.negieren();

        return addieren( bNegiert );
    }    


    /**
     * Multipliziert den Bruch mit einem anderen Bruch.
     * Rechenregel: Zähler mal Zähler, Nenner mal Nenner.
     *
     * @param b Bruch, mit dem multipliziert werden soll
     *
     * @return Produkt, gekürzt
     */
    public Bruch multiplizieren( Bruch b ) {

        int zaehlerNeu = b._zaehler * _zaehler;
        int nennerNeu  = b._nenner  * _nenner;

        Bruch produkt = new Bruch( zaehlerNeu, nennerNeu );

        return produkt.kuerze();
    }

    
    /**
     * Dividiert den Bruch durch einen anderen Bruch
     * (durch Multiplikation mit dem Kehrwert).
     *
     * @param b Bruch, durch den dividiert werden soll
     *
     * @return Gekürztes Ergebnis
     */
    public Bruch dividieren( Bruch b ) {

        Bruch bKehrwert = b.kehrwert();

        return multiplizieren( bKehrwert );
    }
    
    
    /**
     * Dezimalwert für Bruch zurückgeben, z.B. {@code 0.5} für {@code 1/2}.
     *
     * @return Dezimalwert
     */
    public double wert() {

        return (double) _zaehler / _nenner;
    }    


    /**
     * String-Darstellung des Bruchs zurückgeben.
     *
     * @return String-Darstellung des Bruchs, z.B. {@code 3/4}
     */
    @Override
    public String toString() {

        return _zaehler + "/" + _nenner;
    }
    
    
    /**
     * Methode berechnet Hash-Wert ("Fingerabdruck), berücksichtigt 
     * dafür Wert von Zähler und Nenner.
     * 
     * @return Hash-Wert
     */
    @Override
    public int hashCode() {
        
        return Objects.hash( _zaehler , _nenner );
    }


    /**
     * Vergleich aufrufendes Objekt mit dem als Argument {@code obj} übergeben.
     * 
     * @return {@code true} gdw, wenn {@code obj} auch ein Objekt der Klasse
     *         {@code Bruch} oder einer Unterklasse von {@code Bruch} ist
     *        
     */
    @Override
    public boolean equals( Object obj ) {
        
        if ( this == obj ) { return true; }
            
        if ( obj == null ) { return false; }
        
        if ( obj instanceof Bruch andererBruch ) {
            
            return _zaehler == andererBruch._zaehler && 
                   _nenner  == andererBruch._nenner;
            
        } else { 
         
            return false;
        }           
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

}

