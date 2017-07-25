package runner;

import appliances.Fridge;
import appliances.PC;
import appliances.Router;
import appliances.TV;
import electronics.ApplianceList;
import powerOperations.PowerCalc;
import powerOperations.SortByPower;
import validator.XMLValidator;

import java.util.Arrays;

/**
 * Created by VladislavYTsa on 21.07.2017.
 */
public class Runner {
    private static final String XML = "src/main/java/xmlAndXsd/appliance.xml";
    private static final String XSD = "src/main/java/xmlAndXsd/appschema.xsd";

    public static void main(String[] args) {

        XMLValidator xmlValidator = new XMLValidator();
        boolean valid = xmlValidator.validation(XML, XSD);
        System.out.println(valid);

        PC pc = new PC();
        pc.setModelName("ROG G20CB");
        pc.setOnOff(true);
        pc.setPower(500);
        TV tv = new TV();
        tv.setModelName("Sony XE94");
        tv.setOnOff(true);
        tv.setPower(240);
        Router router = new Router();
        router.setModelName("HP R120");
        router.setOnOff(true);
        router.setPower(50);
        Fridge fridge = new Fridge();
        fridge.setModelName("Bosch KDD74AL20N");
        fridge.setOnOff(false);
        fridge.setPower(150);

        ApplianceList applianceList = new ApplianceList(pc, tv, router, fridge);
        Arrays.sort(applianceList.getAs());

        SortByPower sortByPower = new SortByPower();
        sortByPower.sorting(applianceList,100d,500d);

        PowerCalc powerCalc = new PowerCalc();
        powerCalc.powerSum(applianceList,0);
    }
}
