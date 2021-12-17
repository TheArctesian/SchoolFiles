public class Phone extends ElectronicItem {
    private String networkType;
    private int screenSize;
    
    public Phone(String title, String author, String publisher, String networkType, int screenSize) {
        super(title, author, publisher);
        this.networkType = networkType;
        this.screenSize = screenSize;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "networkType='" + networkType + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }
}   
