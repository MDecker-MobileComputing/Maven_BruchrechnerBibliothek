package de.eldecker.dhbw.bruchrechnen;

import static de.eldecker.dhbw.bruchrechnen.MatheHelfer.istPrimzahl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class PrimzahlTest {

    @Test
    void istPrim() {
        
        final boolean istPrim1 = istPrimzahl( 11 );  
        assertTrue( istPrim1 );
        
        final boolean istPrim2 = istPrimzahl( 3 );
        assertTrue( istPrim2 );
    }
    
    
    @Test
    void nichtPrim() {
        
        final boolean istPrim1 = istPrimzahl( 4 );  
        assertFalse( istPrim1 );
        
        final boolean istPrim2 = istPrimzahl( -4 );
        assertFalse( istPrim2 );
    }    

}
