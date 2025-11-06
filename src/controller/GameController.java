package controller;

import modell.GameModell;
import view.GameViewGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class GameController {

    private GameViewGui nezet;
    private GameModell modell;

    public GameController(GameViewGui nezet) {
        this.nezet = nezet;
        this.modell = new GameModell();

        initEventek();
        ujJatek();
    }

    private void initEventek() {
        nezet.getBtnUjJatek().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ujJatek();
            }
        });

        nezet.getMniKilepes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kilepes();
            }
        });

        nezet.getBtnValaszt1().addActionListener(e -> ajtoValasztas(0));
        nezet.getBtnValaszt2().addActionListener(e -> ajtoValasztas(1));
        nezet.getBtnValaszt3().addActionListener(e -> ajtoValasztas(2));
    }

    private void ujJatek() {
        modell = new GameModell();
        nezet.getTxtaKiiras().setText("Új játék indult! Válassz egy ajtót...");
    }

    private void ajtoValasztas(int index) {
        boolean nyert = modell.jatekosValaszt(index);
        if (nyert) {
            nezet.getTxtaKiiras().setText("Gratulálok, nyertél!");
        } else {
            nezet.getTxtaKiiras().setText("Sajnálom, nem nyertél. Próbáld újra!");
        }
    }

    private void kilepes() {
        int valasz = JOptionPane.showConfirmDialog(nezet, "Biztosan kilépsz?", "Kilépés", JOptionPane.YES_NO_OPTION);
        if (valasz == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
