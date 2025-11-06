
package modell;


public class DoorModell {
    private boolean nyeremeny;//true ha benne van
    private boolean allapot;//true nyitott

    public DoorModell(boolean nyeremeny, boolean allapot) {
        this.nyeremeny = nyeremeny;
        this.allapot = allapot;
    }

    public boolean isNyeremeny() {
        return nyeremeny;
    }

    public boolean isAllapot() {
        return allapot;
    }

    public void setNyeremeny(boolean nyeremeny) {
        this.nyeremeny = nyeremeny;
    }

    public void setAllapot(boolean allapot) {
        this.allapot = allapot;
    }

    @Override
    public String toString() {
        return "DoorModell{" + "nyeremeny=" + nyeremeny + ", allapot=" + allapot + '}';
    }
    
}
