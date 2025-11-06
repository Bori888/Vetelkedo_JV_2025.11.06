package modell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModell {
    private List<DoorModell> ajtok;
    private int nyeroAjtoIndex;
    private Random rnd;

    public GameModell() {
        rnd = new Random();
        ujJatek();
    }

    public void ujJatek() {
        ajtok = new ArrayList<>();
        nyeroAjtoIndex = rnd.nextInt(3);
        for (int i = 0; i < 3; i++) {
            ajtok.add(new DoorModell(i == nyeroAjtoIndex, false));
        }
    }

    public int musorvezetoKinyit(int valasztottAjto) {
        int kinyitott = -1;
        for (int i = 0; i < ajtok.size(); i++) {
            if (i != valasztottAjto && i != nyeroAjtoIndex) {
                ajtok.get(i).setAllapot(true);
                kinyitott = i;
                break;
            }
        }
        return kinyitott;
    }

    public boolean jatekosVegsoValaszt(int valasztottAjto) {
        ajtok.get(valasztottAjto).setAllapot(true);
        return ajtok.get(valasztottAjto).isNyeremeny();
    }

    public List<DoorModell> getAjtok() {
        return ajtok;
    }

    public int getNyeresAjtoIndex() {
        return nyeroAjtoIndex;
    }
}
