package appliances;

import electronics.HouseHoldElectronics;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class Fridge extends HouseHoldElectronics {

    private int capacity;

    public Fridge(String modelName, double power, boolean onOff, int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "capacity=" + capacity +
                '}' + super.toString();
    }
}
