# Vetekedő (Monty Hall) Játék

## 1. Feladat leírása

A Vetekedő egy egyszerű szerencsejáték-szimuláció, amely a klasszikus Monty Hall-problémán alapul.
A játék célja, hogy a játékos kitalálja, melyik ajtó mögött található a nyeremény.

### Játékmenet

1. Három ajtó közül az egyik mögött van a nyeremény, a másik kettő üres.
2. A műsorvezető tudja, hol található a nyeremény.
3. A játékos kiválaszt egy ajtót.
4. A műsorvezető kinyit egy másik, üres ajtót.
5. A játékos dönthet úgy, hogy változtatja a választását, vagy marad az eredetinél.
6. A választott ajtó kinyílik, és kiderül, nyert-e a játékos.

---

## 2. Követelmények

### 2.1 Funkcionális követelmények

A programnak az alábbi funkciókat kell biztosítania:

* Véletlenszerűen helyezze el a nyereményt az egyik ajtó mögé.
* A játékos kiválaszthasson egy ajtót.
* A műsorvezető automatikusan nyisson ki egy üres ajtót.
* A játékos dönthessen arról, hogy változtatja-e a választását.
* A program jelenítse meg az eredményt (nyert / nem nyert).
* Lehetővé kell tenni a játék újraindítását (opcionális).

### 2.2 Nem-funkcionális követelmények

* **Platform:** Java (NetBeans IDE kompatibilis)
* **Felhasználói felület:** Egyszerű, áttekinthető grafikus GUI
* **Tesztelhetőség:** Moduláris felépítés, unit tesztek írhatók
* **Megbízhatóság:** Stabil, hibamentes, könnyen futtatható program

---

## 3. Tervezési szempontok

### Architektúra

A program az **MVC (Model-View-Controller)** mintát követi:

* **Model:** A játék logikája (ajtók, nyeremény, játékos választása)
* **View:** A grafikus felhasználói felület
* **Controller:** A játék vezérlése, események kezelése és a model–view kommunikáció

---

### Osztályszerkezet

```
src/
└── vetelkedo/
    ├── main/
    │   └── Vetelkedo.java          // Program belépési pontja (main metódus)

    ├── modell/
    │   ├── DoorModell.java         // Egy ajtó adatait tárolja (nyeremény, nyitott/zárt állapot)
    │   ├── GameModell.java         // A játék logikáját kezeli (ajtók, nyeremény, eredmény)
    │   └── PlayerModell.java       // A játékos választását és döntésváltását kezeli

    ├── view/
    │   └── GameView.java           // Grafikus felület (ajtók, információk, eredmény megjelenítése)

    └── controller/
        └── GameController.java     // A játék menetét irányítja, összeköti a Model-t és a View-t
```

---

## 4. Funkcionális és nem-funkcionális összefoglaló

### Funkcionális követelmények

* Véletlenszerű nyeremény-elhelyezés
* Játékos választása és döntésváltoztatása
* Műsorvezető ajtónyitási logikája (nem nyitja a nyereményes ajtót)
* Eredmény kiírása (nyert / nem nyert)

### Nem-funkcionális követelmények

* Java nyelv, NetBeans-kompatibilis
* Egyszerű, letisztult GUI
* Moduláris, jól tesztelhető felépítés
* Stabil, hibamentes működés

---

## 5. Játékélmény és GUI

* Letisztult, áttekinthető felület
* Egyértelmű utasítások a játékos számára
* Visszajelzés minden lépésnél
* Új játék indításának lehetősége
