package de.eldecker.dhbw.bruchrechnen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class BruchTest {
     
    @Test
    public void getUndSetter() {

        final Bruch bruch1 = new Bruch( 2, 3 );
        
        assertEquals( 2, bruch1.getZaehler() );
        assertEquals( 3, bruch1.getNenner()  );
        
        
        final Bruch bruch2 = new Bruch( 5 );
        
        assertEquals( 5, bruch2.getZaehler() );
        assertEquals( 1, bruch2.getNenner()  );                
    }
    
    
    @Test
    public void stringRepraesentation() {
        
        final Bruch bruch1 = new Bruch( 2, 3 );
        String str = bruch1.toString();
        
        assertEquals( "2/3", str );
    }

    
    @Test
    public void kehrwert() {
        
        final Bruch bruch1 = new Bruch( 2, 3 );
        
        final Bruch bruch2 = bruch1.kehrwert();
        
        assertEquals( 3, bruch2.getZaehler() );
        assertEquals( 2, bruch2.getNenner()  );        
    }
    
    
    @Test
    public void negieren() {
        
        final Bruch bruch1 = new Bruch( 2, 3 );
        
        final Bruch bruch2 = bruch1.negieren();
        
        assertEquals( -2, bruch2.getZaehler() );
        assertEquals(  3, bruch2.getNenner()  );        
    }    
    
    
    @Test
    public void kuerzen() {
        
        final Bruch bruch1 = new Bruch( 8, 12 );
        
        final Bruch bruch2 = bruch1.kuerze();
        
        assertEquals( 2, bruch2.getZaehler() );
        assertEquals( 3, bruch2.getNenner()  );                
    }
    
}
