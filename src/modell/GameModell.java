package modell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModell {
    private List<DoorModell> ajtok;
    private boolean jatekFolyamatban;

    public GameModell() {
        ujJatek();
    }

    public void ujJatek() {
        ajtok = new ArrayList<>();
        Random rnd = new Random();
        int nyeroAjto = rnd.nextInt(3);

        for (int i = 0; i < 3; i++) {
            boolean nyeremeny = (i == nyeroAjto);
            ajtok.add(new DoorModell(nyeremeny, false));
        }

        jatekFolyamatban = true;
    }

    public boolean jatekosValaszt(int index) {
        if (!jatekFolyamatban) {
            return false;
        }

        DoorModell valasztott = ajtok.get(index);
        valasztott.setAllapot(true);
        jatekFolyamatban = false;

        return valasztott.isNyeremeny();
    }

    public List<DoorModell> getAjtok() {
        return ajtok;
    }
}
