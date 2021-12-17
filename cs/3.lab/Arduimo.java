public class Arduimo extends ElectronicItem{
    private String version;

    public Arduimo(String title, String author, String publisher, String version) {
        super(title, author, publisher);
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Arduimo{" +
                "version='" + version + '\'' +
                '}';
    }
    
}
