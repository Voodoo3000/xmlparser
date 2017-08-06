package appliances;

import electronics.HouseHoldElectronic;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class TV extends HouseHoldElectronic {

    private int diagSize;
    private String dispResol;

    public TV(String modelName, double power, boolean onOff, int diagSize, String dispResol) {
        this.diagSize = diagSize;
        this.dispResol = dispResol;
        this.setModelName(modelName);
        this.setPower(power);
        this.setOnOff(onOff);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TV tv = (TV) o;

        if (diagSize != tv.diagSize) return false;
        return dispResol.equals(tv.dispResol);
    }

    @Override
    public int hashCode() {
        int result = diagSize;
        result = 31 * result + dispResol.hashCode();
        return result;
    }
}
