package powerOperations;

import electronics.ApplianceList;
import electronics.HouseHoldElectronic;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class SortByPower {

    public void sorting(ApplianceList applianceList, double minPower, double maxPower) {
        for (HouseHoldElectronic i : applianceList.getAs())
            if (i.getPower() > minPower && i.getPower() <= maxPower) {
                System.out.println("Suitable consumption power: " + i);
            }
    }
}
