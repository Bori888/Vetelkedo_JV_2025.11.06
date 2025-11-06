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
* Lehetővé kell tenni a játék újraindítását.
* A programban legyen menü, amely tartalmazza a **kilépés** lehetőségét.

### 2.2 Nem-funkcionális követelmények

* **Platform:** Java (NetBeans IDE kompatibilis)
* **Felhasználói felület:** Egyszerű, áttekinthető grafikus GUI
* **Tesztelhetőség:** Moduláris felépítés, unit tesztek írhatók
* **Megbízhatóság:** Stabil, hibamentes, könnyen futtatható program
* **Kódstílus:** JavaBeans konvenciók betartása
* **Kivételkezelés:** Saját kivételosztály megléte
* **Adatkezelés:** Text fájlok használata az eredmények vagy statisztikák mentéséhez
* **MVC architektúra:** Model–View–Controller szerkezet alkalmazása

---

## 3. Tervezési szempontok

### Architektúra

A program az **MVC (Model-View-Controller)** mintát követi:

* **Model:** A játék logikája (ajtók, nyeremény, játékos választása)
* **View:** A grafikus felhasználói felület (GUI)
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
    │   ├── PlayerModell.java       // A játékos választását és döntésváltását kezeli
    │   └── SajátKivetel.java       // Egyedi kivételosztály, hibakezeléshez

    ├── view/
    │   └── GameView.java           // Grafikus felület (ajtók, gombok, eredmény, menü, elrendezés)

    ├── controller/
    │   └── GameController.java     // A játék menetét irányítja, összeköti a Model-t és a View-t

    └── data/
        └── eredmenyek.txt          // Eredmények, statisztikák tárolása
```

---

## 4. GUI követelmények

* A GUI **egyetlen `JPanel`-ben** legyen elhelyezve, minden vizuális elem ezen belül.
* Legyen **újraindító gomb**, amely azonnal új játékot indít.
* Tartalmazzon **menüt** a program tetején, ahol megtalálható:

  * „Fájl” menüpont → „Kilépés” opció
* Az ablak **áttekinthető**, jól rendezett legyen – ne legyenek üres területek.
* Az ajtók, gombok és szövegek legyenek **középre igazítva és egységesen elhelyezve**.
* A GUI tartalmazzon **képet vagy grafikát** (pl. ajtók, háttérkép).
* A kezelőfelület **egyszerűen és egyértelműen használható** legyen.
* Betartja az **OOP elveket** (encapsuláció, egy felelősség elve, objektumorientált szerkezet).

---

## 5. Funkcionális és nem-funkcionális összefoglaló

### Funkcionális követelmények

* Véletlenszerű nyeremény-elhelyezés
* Játékos választása és döntésváltoztatása
* Műsorvezető ajtónyitási logikája
* Eredmény kiírása (nyert / nem nyert)
* Új játék indítása
* Menü és kilépési lehetőség

### Nem-funkcionális követelmények

* Java nyelv, NetBeans-kompatibilis
* Letisztult, egységes, grafikus GUI
* JavaBeans konvenciók és OOP elvek betartása
* Saját kivételosztály megléte
* Text fájlokban tárolt adatok
* Moduláris, jól tesztelhető architektúra
* Stabil, hibamentes működés
* MVC struktúra szerint megvalósítva

---

## 6. Játékélmény és GUI

* Letisztult, áttekinthető, középre rendezett felület
* Egyértelmű utasítások a játékos számára
* Visszajelzés minden lépésnél (választás, nyitás, eredmény)
* Új játék gombbal bármikor újraindítható
* Menüvel zárható (Kilépés opció)
* Grafikai elemek (ajtók, háttérkép) javítják a játékélményt

---

## 7. Példa GUI kinézet
<img width="1024" height="1536" alt="image" src="https://github.com/user-attachments/assets/558e2341-8287-4125-bfc7-ffe34b37d8aa" />

---

## 8. Fejlesztési irányelvek

* MVC mintára épített, szigorúan rétegezett szerkezet
* A Model réteg nem tartalmazhat GUI elemeket
* A View réteg nem tartalmazhat logikai számításokat
* A Controller kapcsolja össze a kettőt
* Minden osztály külön fájlban, JavaBeans névkonvenció szerint
* Saját kivételkezelés és text fájlos adatmentés kötelező

---

Ez a dokumentáció teljesíti az **OOP**, **MVC**, **GUI**, és **fejlesztési** követelményeket, és ideális NetBeans-projekt README.md fájlként.
A mellékelt képet a GUI vizuális megjelenítésének példájaként tartalmazza.
