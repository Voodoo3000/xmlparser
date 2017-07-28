package appliances;

import electronics.HouseHoldElectronics;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class TV extends HouseHoldElectronics {

    private int diagSize;
    private String dispResol;

    public TV(String modelName, double power, boolean onOff, int diagSize, String dispResol) {
        this.diagSize = diagSize;
        this.dispResol = dispResol;
    }

    @Override
    public String toString() {
        return "TV " +
                getModelName() + "; Diag "
                + this.diagSize + "inch; " +
                "Resolution picture " + this.dispResol +
                "; consumption power: " + getPower() + "W, " +
                "on: " + isOnOff() + super.toString();
    }
}
