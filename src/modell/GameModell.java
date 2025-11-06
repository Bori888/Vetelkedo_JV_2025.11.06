package modell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModell {
    private List<DoorModell> ajtok;
    private PlayerModell jatekos;

    public GameModell() {
        ajtok = new ArrayList<>();
        jatekos = new PlayerModell();
        ujJatek();
    }

    public void ujJatek() {
        ajtok.clear();
        Random rnd = new Random();
        int nyeremenyIndex = rnd.nextInt(3);
        for (int i = 0; i < 3; i++) {
            ajtok.add(new DoorModell(i == nyeremenyIndex, false));
        }
        jatekos.setValasztottAjto(-1);
        jatekos.setValtott(false);
    }

    public List<DoorModell> getAjtok() {
        return ajtok;
    }

    public PlayerModell getJatekos() {
        return jatekos;
    }

    public int getMusorvezetoAjto() {
        for (int i = 0; i < ajtok.size(); i++) {
            if (i != jatekos.getValasztottAjto() && !ajtok.get(i).isNyeremeny()) {
                return i;
            }
        }
        return -1;
    }

    public boolean isNyeres() {
        int valasztott = jatekos.getValasztottAjto();
        if (valasztott >= 0 && valasztott < ajtok.size()) {
            return ajtok.get(valasztott).isNyeremeny();
        }
        return false;
    }

    @Override
    public String toString() {
        return "GameModell{" + "ajtok=" + ajtok + ", jatekos=" + jatekos + '}';
    }
}
