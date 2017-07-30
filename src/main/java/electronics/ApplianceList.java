package electronics;



import java.util.ArrayList;


/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class ApplianceList {
    private ArrayList<HouseHoldElectronic> as = new ArrayList<>();

    public ArrayList<HouseHoldElectronic> getAs() {
        return as;
    }

    @Override
    public String toString() {
        return "ApplianceList " +
                "as = " + as.toString();
    }
}
