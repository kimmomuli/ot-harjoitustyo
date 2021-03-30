package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {
    Kassapaate kassapaate;
    Maksukortti maksukortti;
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        maksukortti = new Maksukortti(500);
    }
    
    @Test
    public void rahamaaraKassapaatteessaOnOikea() {
        assertTrue(kassapaate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void myytyjenMaukkautteinMaaraOnOikea() {
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 0);
    }
    
    @Test
    public void myytyjenEdullistenMaaraOnOikea() {
        assertTrue(kassapaate.edullisiaLounaitaMyyty()== 0);
    }
    
    @Test
    public void kateisOstonJalkeenRahaMaaraKasvaaOikeinEdulliset() {
        kassapaate.syoEdullisesti(500);
        assertTrue(kassapaate.kassassaRahaa() == 100240);
    }
    
    @Test
    public void kateisOstonJalkeenRahaMaaraKasvaaOikeinMaukkaat() {
        kassapaate.syoMaukkaasti(500);
        assertTrue(kassapaate.kassassaRahaa() == 100400);
    }
    
    @Test
    public void vaihtorahanSuuruusOnOikeinKateisostossaEdulliset() {
        assertTrue(kassapaate.syoEdullisesti(500) == 260);
    }
    
    @Test
    public void vaihtorahanSuuruusOnOikeinKateisostossaMaukkaat() {
        assertTrue(kassapaate.syoMaukkaasti(500) == 100);
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaaEdulliset() {
        kassapaate.syoEdullisesti(500);
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaaMaukkaat() {
        kassapaate.syoMaukkaasti(500);
        kassapaate.syoMaukkaasti(500);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 2);
    }
    
    @Test
    public void kassanRahamaaraEiMuutuJosMaksuEiRiittavaEdulliset() {
        kassapaate.syoEdullisesti(100);
        assertTrue(kassapaate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void kassanRahamaaraEiMuutuJosMaksuEiRiittavaMaukkaat() {
        kassapaate.syoMaukkaasti(100);
        assertTrue(kassapaate.kassassaRahaa() == 100000);
    }

    @Test
    public void kaikkiRahatPalautetaanJosEiRiittavastiRahaaEdulliset() {
        assertTrue(kassapaate.syoEdullisesti(100) == 100);
    }
    
    @Test
    public void kaikkiRahatPalautetaanJosEiRiittavastiRahaaMaukkaat() {
        assertTrue(kassapaate.syoEdullisesti(200) == 200);
    }
    
    @Test
    public void myytyjenMaaraEiMuutuJosEiRahaaEdulliset() {
        kassapaate.syoEdullisesti(100);
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void myytyjenMaaraEiMuutuJosEiRahaaMaukkaat() {
        kassapaate.syoMaukkaasti(100);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 0);
    }
    
    @Test
    public void kortillaTarpeeksiRahaaJaVeloitetaanOikeinEdulliset() {
        kassapaate.syoEdullisesti(maksukortti);
        assertTrue(maksukortti.saldo() == 260);
    }
    
    @Test
    public void kortillaTarpeeksiRahaaJaVeloitetaanOikeinMaukkat() {
        kassapaate.syoMaukkaasti(maksukortti);
        assertTrue(maksukortti.saldo() == 100);
    }
    
    @Test
    public void kortillaTarpeeksiRahaaJaPalauttaaOikeinEdulliset() {
        assertTrue(kassapaate.syoEdullisesti(maksukortti) == true);
    }
    
    @Test
    public void kortillaTarpeeksiRahaaJaPalauttaaOikeinMaukkat() {
        assertTrue(kassapaate.syoMaukkaasti(maksukortti) == true);
    }
    
    @Test
    public void kortillaTarpeeksiRahaaJaMyytyjenMaaraKasvaaEdulliset() {
        kassapaate.syoEdullisesti(maksukortti);
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void kortillaTarpeeksiRahaaJaMyytyjenMaaraKasvaaMaukkat() {
        kassapaate.syoMaukkaasti(maksukortti);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 1);
    }

    @Test
    public void kaikkiRahatPalautetaanJosEiRiittavastiRahaaKortillaEdulliset() {
        kassapaate.syoMaukkaasti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        assertTrue(maksukortti.saldo() == 100);
    }
    
    @Test
    public void kaikkiRahatPalautetaanJosEiRiittavastiRahaaKortillaMaukkaat() {
        kassapaate.syoMaukkaasti(maksukortti);
        kassapaate.syoMaukkaasti(maksukortti);
        assertTrue(maksukortti.saldo() == 100);
    }
    
    @Test
    public void myytyjenMaaraEiMuutuJosEiRahaaKortillaEdulliset() {
        kassapaate.syoMaukkaasti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void myytyjenMaaraEiMuutuJosEiRahaaKortillaMaukkaat() {
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoMaukkaasti(maksukortti);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 0);
    }
    
    @Test
    public void kortillaTarpeeksiRahaaJaKassassaOikeaMaaraRahaaEdulliset() {
        kassapaate.syoEdullisesti(maksukortti);
        assertTrue(kassapaate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void kortillaTarpeeksiRahaaJaKassassaOikeaMaaraRahaaMaukkat() {
        kassapaate.syoMaukkaasti(maksukortti);
        assertTrue(kassapaate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void rahaaLadattaessaSaldoKassassaMuuttuu() {
        kassapaate.lataaRahaaKortille(maksukortti, 300);
        assertTrue(kassapaate.kassassaRahaa() == 100300);
    }
    
    @Test
    public void rahaaLadattaessaSaldoKortissaMuuttuu() {
        kassapaate.lataaRahaaKortille(maksukortti, 300);
        assertTrue(maksukortti.saldo() == 800);
    }
    
    @Test
    public void ladataanNegatiivinenSummaJaKassanSaldoEiMuutu() {
        kassapaate.lataaRahaaKortille(maksukortti, -300);
        assertTrue(kassapaate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void ladataanNegatiivinenSummaJaKortinSaldoEiMuutu() {
        kassapaate.lataaRahaaKortille(maksukortti, -300);
        assertTrue(maksukortti.saldo() == 500);
    }
}
