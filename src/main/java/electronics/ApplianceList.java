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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplianceList appliance = (ApplianceList) o;
        if(appliance.getAs().equals(appliance.getAs()));

        return as.equals(appliance.as);
    }

    @Override
    public int hashCode() {
        return as.hashCode();
    }
}
