package controller;

import modell.GameModell;
import modell.DoorModell;
import view.GameViewGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class GameController {

    private GameViewGui nezet;
    private GameModell modell;
    private int kor;

    public GameController(GameViewGui nezet) {
        this.nezet = nezet;
        this.modell = new GameModell();
        this.kor = 1;

        initEventek();
        ujJatek();
    }

    private void initEventek() {
        nezet.getBtnUjJatek().addActionListener(e -> ujJatek());
        nezet.getMniKilepes().addActionListener(e -> kilepes());
        nezet.getBtnValaszt1().addActionListener(e -> ajtoValasztas(0));
        nezet.getBtnValaszt2().addActionListener(e -> ajtoValasztas(1));
        nezet.getBtnValaszt3().addActionListener(e -> ajtoValasztas(2));
    }

    private void ujJatek() {
        modell.ujJatek();
        kor = 1;
        nezet.getTxtaKiiras().setText("Válassz egy ajtót! Csak az egyik mögött van nyeremény.\n");
        frissitAllapotok();
    }

    private void ajtoValasztas(int index) {
        boolean nyert = modell.jatekosValaszt(index);
        frissitAllapotok();

        if (nyert) {
            nezet.getTxtaKiiras().setText("Gratulálok, nyertél a(z) " + kor + ". körben!");
        } else {
            nezet.getTxtaKiiras().setText("Sajnálom, nem nyertél ebben a körben!");
        }

        kor++;
    }

    private void frissitAllapotok() {
        for (int i = 0; i < modell.getAjtok().size(); i++) {
            DoorModell ajto = modell.getAjtok().get(i);
            String allapot = ajto.isAllapot() ? "Nyitva" : "Zárva";

            switch (i) {
                case 0 -> nezet.getTxtfAjtoAllapot1().setText(allapot);
                case 1 -> nezet.getTxtfAjtoAllapot2().setText(allapot);
                case 2 -> nezet.getTxtfAjtoAllapot3().setText(allapot);
            }
        }
    }

    private void kilepes() {
        int valasz = JOptionPane.showConfirmDialog(nezet, "Biztosan kilépsz?", "Kilépés", JOptionPane.YES_NO_OPTION);
        if (valasz == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
