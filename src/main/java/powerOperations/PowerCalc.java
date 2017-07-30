package powerOperations;

import electronics.ApplianceList;
import electronics.HouseHoldElectronic;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class PowerCalc {

    public void powerSum(ApplianceList applianceList, double sum) {
        for (HouseHoldElectronic i : applianceList.getAs()) {
            if (i.isOnOff()) {
                sum = sum + i.getPower();
            }
        }
        System.out.println("Running devices summary consumption power: " + sum + "W");
    }
}
