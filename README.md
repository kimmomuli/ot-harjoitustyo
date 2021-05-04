# Tetris
Sovelluksen tarkotus on kerätä mahdollisimman paljon pisteitä. Pelissä tippuu 7 erilaista neljästä laatikosta (tetrominoja) koostuvia paloja. Mikäli pelaaja saa rivin täyteen eli 10 palaa, poistuu rivi ja ylemmät palat tippuvat alas yhden rivin. Rivejä on mahdollista saada useita kerralla.

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
## Testaus
Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Voit generoida jarin komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```

Javadoc generointi
```
mvn javadoc:javadoc
```
 - [työaikakirjanpito](https://github.com/kimmomuli/ot-harjoitustyo/blob/master/dokumentaatio/ty%C3%B6aikakirjanpito.md)
 - [arkkitehtuuri](https://github.com/kimmomuli/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)
 - [vaatimusmäärittely](https://github.com/kimmomuli/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)
