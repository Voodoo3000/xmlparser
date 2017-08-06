package appliances;

import electronics.HouseHoldElectronic;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class Fridge extends HouseHoldElectronic {

    private int capacity;

    public Fridge(String modelName, double power, boolean onOff, int capacity) {
        this.setModelName(modelName);
        this.setPower(power);
        this.setOnOff(onOff);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Fridge " + getModelName()+ "; capacity " + this.capacity +
                "; consumption power: " + getPower() + "W, " +
                "on: " + isOnOff() + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fridge fridge = (Fridge) o;

        return capacity == fridge.capacity;
    }

    @Override
    public int hashCode() {
        return capacity;
    }
}
