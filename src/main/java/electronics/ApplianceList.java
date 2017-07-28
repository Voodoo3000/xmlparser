package electronics;


import appliances.Fridge;
import appliances.PC;
import appliances.Router;
import appliances.TV;

import java.util.Arrays;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class ApplianceList {

    private HouseHoldElectronics as [] = new HouseHoldElectronics[]{};

    public ApplianceList(Fridge fridge, PC pc, Router router, TV tv) {
        this.as = new HouseHoldElectronics[]{fridge, pc, router, tv};
    }



    public void setAs(HouseHoldElectronics[] as) {
        this.as = as;
    }

    public HouseHoldElectronics[] getAs() {
        return as;
    }

    @Override
    public String toString() {
        return "ApplianceList{" +
                "as=" + Arrays.toString(as) +
                '}';
    }
}
