package appliances;

import electronics.HouseHoldElectronic;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class Router extends HouseHoldElectronic {

    private int linkSpeed;
    private String vlanFeature;

    public Router(String modelName, double power, boolean onOff, int linkSpeed, String vlanFeature) {
        this.linkSpeed = linkSpeed;
        this.vlanFeature = vlanFeature;
        this.setModelName(modelName);
        this.setPower(power);
        this.setOnOff(onOff);
    }

    @Override
    public String toString() {
        return "Network router " +
                getModelName() + "; 802.11ac "
                + this.linkSpeed + "Mbit/s; " +
                "Features " + this.vlanFeature +
                "; consumption power: " + getPower() + "W, " +
                "on: " + isOnOff() + super.toString();
    }
}
