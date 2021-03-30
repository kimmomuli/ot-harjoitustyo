package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertTrue(kortti.saldo() == 10);
    }
    
    @Test
    public void rahanLataaminenToimiiOikein() {
        kortti.lataaRahaa(20);
        assertTrue(kortti.saldo() == 30);
    }
    
     @Test
     public void saldoVaheneeOikein() {
         kortti.otaRahaa(5);
         assertTrue(kortti.saldo() == 5);
     }
     
     @Test
     public void saldoEiMuutuJosEiOleRahaa() {
         kortti.otaRahaa(7);
         kortti.otaRahaa(5);
         assertTrue(kortti.saldo() == 3);
     }
     
     @Test
     public void palauttaaTrue() {
         assertTrue(kortti.otaRahaa(5) == true);
     }
     
     @Test 
     public void palauttaaFalse() {
         assertTrue(kortti.otaRahaa(15) == false);
     }
     
     @Test
     public void tulostusTesti() {
         assertEquals("saldo: 0.10", kortti.toString());
     }
}
