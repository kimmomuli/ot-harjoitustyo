# Tetris
Sovelluksen tarkotus on kerätä mahdollisimman paljon pisteitä. Pelissä tippuu 7 erilaista neljästä laatikosta (tetrominoja) koostuvia paloja. Mikäli pelaaja saa rivin täyteen eli 10 palaa, poistuu rivi ja ylemmät palat tippuvat alas yhden rivin. Rivejä on mahdollista saada useita kerralla.

- [x] Käyttäjä voi aloittaa ja lopettaa pelaamisen
- [x] Pelissä tippuu vuorotellen ja sattumanvaraisesti yksi seitsemästä palasta
- [x] Palanen jää siihen kohtaa mihin se ensimmäisenä koskettaa
- [x] Paloja voi siirrellä vasemmalla ja oikealle
- [x] Paloja voi käännellä
- [x] Pisteet lisäntyy täytetyistä riveistä
- [x] Mikäli palanen on ylärivillä peli loppuu

Ohjelman voi suorittaa komennoilla 
```
git clone https://github.com/kimmomuli/ot-harjoitustyo.git
```
```
cd Tetris
```
```
mvn compile exec:java -Dexec.mainClass=tetris.Main
```

 - [työaikakirjanpito](https://github.com/kimmomuli/ot-harjoitustyo/blob/master/dokumentaatio/ty%C3%B6aikakirjanpito.md)
 - [arkkitehtuuri](https://github.com/kimmomuli/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)
