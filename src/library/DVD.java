package library;

/**
 * Created by Alexander Bazo on 16/11/15.
 */
public class DVD extends Media {
    private int runTimeInMinutes;
    private boolean hasBonusMaterial;

    public DVD(int year, String title, int runTimeInMinutes, boolean hasBonusMaterial) {
        super(year, title);
        this.runTimeInMinutes = runTimeInMinutes;
        this.hasBonusMaterial = hasBonusMaterial;
    }

    public int getRunTimeInMinutes() {
        return runTimeInMinutes;
    }

    public boolean hasBonusMaterial() {
        return hasBonusMaterial;
    }

    @Override
    public String toString() {
        String extras = "";
        if(hasBonusMaterial) {
            extras = ", with bonus material";
        }
        return super.toString() + ", " + runTimeInMinutes + "min" + extras;
    }
}
