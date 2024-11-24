package de.eldecker.dhbw.bruchrechnen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static de.eldecker.dhbw.bruchrechnen.MatheHelfer.ggt;

import org.junit.jupiter.api.Test;


/**
 * Diese Klasse enthält Unit-Tests für die statische Methode {@link Bruch#ggt(int, int)}
 * (Bestimmung größter gemeinsamer Teiler).
 */
public class GgtTest {
    
    @Test
    void happyPath() {
        
        final int ergebnis = ggt( 18, 24 ); 

        assertEquals( 6, ergebnis );
    }
    
    
    @Test
    void gleicheZahlen() {
        
        final int ergebnis = ggt( 24, 24 );
        
        assertEquals( 24, ergebnis );
    }

    
    @Test
    void ersteZahlNull() {
        
        final int ergebnis = ggt( 0, 10 );
        
        assertEquals( 10, ergebnis );        
    }
    
    
    @Test
    void zweiteZahlNull() {
        
        final int ergebnis = ggt( 10, 0 );
        
        assertEquals( 10, ergebnis );        
    }
    
}
