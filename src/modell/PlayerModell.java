package modell;

public class PlayerModell {
    private int valasztottAjto;//-1 ha nincs
    private boolean valtott;//true ha változtatott

    public PlayerModell() {
        this.valasztottAjto = -1;
        this.valtott = false;
    }

    public PlayerModell(int valasztottAjto, boolean valtott) {
        this.valasztottAjto = valasztottAjto;
        this.valtott = valtott;
    }

    public int getValasztottAjto() {
        return valasztottAjto;
    }

    public boolean isValtott() {
        return valtott;
    }

    public void setValasztottAjto(int valasztottAjto) {
        this.valasztottAjto = valasztottAjto;
    }

    public void setValtott(boolean valtott) {
        this.valtott = valtott;
    }

    @Override
    public String toString() {
        return "PlayerModell{" + "valasztottAjto=" + valasztottAjto + ", valtott=" + valtott + '}';
    }
}
