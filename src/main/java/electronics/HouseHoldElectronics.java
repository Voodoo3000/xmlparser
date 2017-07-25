package electronics;

/**
 * Created by Voodoo3000 on 25.07.2017.
 */
public abstract class HouseHoldElectronics implements Comparable {

    private String modelName;
    private double power;
    private boolean onOff;

    @Override
    public int compareTo(Object o) {
        if (o instanceof HouseHoldElectronics) {
            if (power < ((HouseHoldElectronics) o).power) {
                return 1;
            } else if (power == ((HouseHoldElectronics) o).power) {
                return 0;
            } else return -1;
        } else System.out.println("Unacceptable inbound object");
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }
}
