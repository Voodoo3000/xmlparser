package powerOperations;

import electronics.ApplianceList;
import electronics.HouseHoldElectronics;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class SortByPower {

    public void sorting(ApplianceList applianceList, double minPower, double maxPower) {
        for (HouseHoldElectronics i : applianceList.getAs())
            if (i.getPower() > minPower && i.getPower() <= maxPower) {
                System.out.println("Suitable consumption power: " + i);
            }
    }
}
