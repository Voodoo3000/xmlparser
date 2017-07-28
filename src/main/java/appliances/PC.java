package appliances;

import electronics.HouseHoldElectronics;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public class PC extends HouseHoldElectronics {

    private int cpuGhz;
    private String gpu;

    public PC(String modelName, double power, boolean onOff, int cpuGhz, String gpu) {
        this.cpuGhz = cpuGhz;
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        return "Desktop computer " +
                getModelName() + "; CPU "
                + this.cpuGhz + "Ghz; " +
                "GPU " + this.gpu +
                "; consumption power: " + getPower() + "W, " +
                "on: " + isOnOff() + super.toString();
    }
}
