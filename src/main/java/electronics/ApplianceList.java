package electronics;


import appliances.Fridge;
import appliances.PC;
import appliances.Router;
import appliances.TV;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class ApplianceList {

    private HouseHoldElectronics as [] = new HouseHoldElectronics[]{};

    public ApplianceList(PC pc, TV tv, Router router, Fridge fridge) {
        this.as = new HouseHoldElectronics[]{pc, tv, router, fridge};
    }

    public HouseHoldElectronics[] getAs() {
        return as;
    }
}
