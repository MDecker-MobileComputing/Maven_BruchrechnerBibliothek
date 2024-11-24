package de.eldecker.dhbw.bruchrechnen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class BruchTest {
     
    @Test
    void getUndSetter() {

        final Bruch bruch1 = new Bruch( 2, 3 );
        
        assertEquals( 2, bruch1.getZaehler() );
        assertEquals( 3, bruch1.getNenner()  );
        
        
        final Bruch bruch2 = new Bruch( 5 );
        
        assertEquals( 5, bruch2.getZaehler() );
        assertEquals( 1, bruch2.getNenner()  );                
    }
    
    
    @Test
    void stringRepraesentation() {
        
        final Bruch bruch1 = new Bruch( 2, 3 );
        String str = bruch1.toString();
        
        assertEquals( "2/3", str );
    }

    
    @Test
    void kehrwert() {
        
        final Bruch bruch1 = new Bruch( 2, 3 );
        
        final Bruch bruch2 = bruch1.kehrwert();
        
        assertEquals( 3, bruch2.getZaehler() );
        assertEquals( 2, bruch2.getNenner()  );        
    }
    
    
    @Test
    void negieren() {
        
        final Bruch bruch1 = new Bruch( 2, 3 );
        
        final Bruch bruch2 = bruch1.negieren();
        
        assertEquals( -2, bruch2.getZaehler() );
        assertEquals(  3, bruch2.getNenner()  );        
    }    
    
    
    @Test
    void kuerzen_happyPath() {
        
        final Bruch bruch1 = new Bruch( 8, 12 );
        
        final Bruch bruch2 = bruch1.kuerze();
        
        assertEquals( 2, bruch2.getZaehler() );
        assertEquals( 3, bruch2.getNenner()  );                
    }

    
    @Test
    void kuerzen_gehtNicht() {
        
        final Bruch bruch1 = new Bruch( 2, 3 ); // Bruch ist schon gekürzt 
        
        final Bruch bruch2 = bruch1.kuerze();
        
        assertEquals( 2, bruch2.getZaehler() );
        assertEquals( 3, bruch2.getNenner()  );                
    }

    
    @Test
    void addieren() {
        
        final Bruch bruch1 = new Bruch( 1, 4 );
        final Bruch bruch2 = new Bruch( 2, 3 );
        
        final Bruch bruchSumme = bruch1.addieren( bruch2 );
        
        assertEquals( 11, bruchSumme.getZaehler() );
        assertEquals( 12, bruchSumme.getNenner()  );
    }

    
    @Test
    void multiplizieren() {

        final Bruch bruch1 = new Bruch( 2, 3 );
        final Bruch bruch2 = new Bruch( 3, 4 );
        
        final Bruch bruchProdukt = bruch1.multiplizieren( bruch2 );

        assertEquals( 1, bruchProdukt .getZaehler() );
        assertEquals( 2, bruchProdukt .getNenner()  );
    }
    
    
    @Test
    void dividieren() {

        final Bruch bruch1 = new Bruch( 1, 3 );
        final Bruch bruch2 = new Bruch( 2, 5 );
        
        final Bruch bruchProdukt = bruch1.dividieren( bruch2 );

        assertEquals( 5, bruchProdukt .getZaehler() );
        assertEquals( 6, bruchProdukt .getNenner()  );
    }
    
    
    @Test
    void subtrahieren() {
        
        final Bruch bruch1 = new Bruch( 1, 4 );
        final Bruch bruch2 = new Bruch( 2, 3 );
        
        final Bruch bruchSumme = bruch1.subtrahieren( bruch2 );
        
        assertEquals( -5, bruchSumme.getZaehler() );
        assertEquals( 12, bruchSumme.getNenner()  );
    }

    
    @Test
    void wert() {
        
        final Bruch bruch1 = new Bruch( 1, 4 );
        
        final double wert = bruch1.wert();
        assertEquals( 0.25, wert, 0.0001 ); // delta=0.0001 für max Ungenauigkeit Fließkommavergleich  
    }
        
    
    @SuppressWarnings("unlikely-arg-type")
    @Test
    void equals() {

        final Bruch bruch1 = new Bruch( 1, 2 );
        final Bruch bruch2 = new Bruch( 1, 2 );
        final Bruch bruch3 = new Bruch( 3, 4 );
        final Bruch bruch4 = new Bruch( 1, 5 );

        assertTrue( bruch1.equals( bruch1 ) ); // Objekt mit sich selber verglichen
        assertTrue( bruch1.equals( bruch2 ) );
        
        assertFalse( bruch1.equals( bruch3 ) ); // Zähler und Nenner unterschiedlich        
        assertFalse( bruch1.equals( bruch4 ) ); // Zähler gleich, aber Nenner unterschiedlich 
        
        assertFalse( bruch1.equals( "objekt-mit-falschen-typ" ) );
        assertFalse( bruch1.equals( null) );
    }
    
    
    @Test
    void hashWert() {
     
        final Bruch bruch1 = new Bruch( 1, 2 );
        final Bruch bruch2 = new Bruch( 1, 2 );
        final Bruch bruch3 = new Bruch( 3, 4 );

        assertEquals(    bruch1.hashCode(), bruch2.hashCode() );
        assertNotEquals( bruch1.hashCode(), bruch3.hashCode() );
    }
    
}
