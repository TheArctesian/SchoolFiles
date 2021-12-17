public class ElectronicItem extends CISitem{
    private String model;
    private String os;
    private String maker;
    private int storageCap;

    public ElectronicItem(String name, String location, int price, String description, String model, String os, String maker, int storageCap) {
        super(name, location, price, description);
        this.model = model;
        this.os = os;
        this.maker = maker;
        this.storageCap = storageCap;
    }

    public String getModel() {
        return model;
    }

    public String getOs() {
        return os;
    }

    public String getMaker() {
        return maker;
    }

    public int getStorageCap() {
        return storageCap;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setStorageCap(int storageCap) {
        this.storageCap = storageCap;
    }

    @Override
    public String toString() {
        return "ElectronicItem{" +
                "model='" + model + '\'' +
                ", os='" + os + '\'' +
                ", maker='" + maker + '\'' +
                ", storageCap=" + storageCap +
                '}';
    }
}
