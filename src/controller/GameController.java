package controller;

import modell.GameModell;
import modell.DoorModell;
import view.GameViewGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class GameController {

    private GameModell modell;
    private GameViewGui nezet;
    private int kor;
    private boolean valasztott;
    private int jatekosValasztas;
    private int musorvezetoAjto;

    public GameController(GameViewGui nezet) {
        this.nezet = nezet;
        this.modell = new GameModell();
        ujJatek();

        nezet.getBtnValaszt1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ajtoValasztas(0);
            }
        });

        nezet.getBtnValaszt2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ajtoValasztas(1);
            }
        });

        nezet.getBtnValaszt3().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ajtoValasztas(2);
            }
        });

        nezet.getBtnUjJatek().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ujJatek();
            }
        });

        nezet.getMniKilepes().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void ujJatek() {
        modell.ujJatek();
        kor = 1;
        valasztott = false;
        jatekosValasztas = -1;
        musorvezetoAjto = -1;
        nezet.getTxtaKiiras().setText(
            "Üdv a Vetélkedőben!\n\n" +
            "A Monty Hall játékban három ajtó van, az egyik mögött autó, a többin kecskék.\n" +
            "Válassz egy ajtót, majd a műsorvezető kinyit egy kecskés ajtót!\n" +
            "Ezután dönthetsz: maradsz, vagy váltasz.\n"
        );
        frissitAjtoAllapotok("Zárva", "Zárva", "Zárva");
    }

    private void ajtoValasztas(int index) {
        if (!valasztott) {
            jatekosValasztas = index;
            musorvezetoAjto = modell.musorvezetoKinyit(index);
            valasztott = true;
            nezet.getTxtaKiiras().setText(
                "A műsorvezető kinyitotta a(z) " + (musorvezetoAjto + 1) + ". ajtót (kecske volt mögötte).\n" +
                "Most dönthetsz: maradsz az eredeti választásnál, vagy váltasz a másik zárt ajtóra."
            );
            frissitAjtoAllapotok();
        } else {
            boolean nyert = modell.jatekosVegsoValaszt(index);
            kor++;
            if (nyert) {
                nezet.getTxtaKiiras().setText("Gratulálok, nyertél az " + kor + ". körben! 🚗");
            } else {
                nezet.getTxtaKiiras().setText("Sajnálom, kecskét választottál az " + kor + ". körben. 🐐");
            }
            frissitAjtoAllapotok();
        }
    }

    private void frissitAjtoAllapotok() {
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

    private void frissitAjtoAllapotok(String a1, String a2, String a3) {
        nezet.getTxtfAjtoAllapot1().setText(a1);
        nezet.getTxtfAjtoAllapot2().setText(a2);
        nezet.getTxtfAjtoAllapot3().setText(a3);
    }
}
