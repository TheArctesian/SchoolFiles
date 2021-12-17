public class CISitem {
    private String name;
    private String location;
    private int price;
    private String description;

    public CISitem(String name, String location, int price, String description) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    
    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CISitem{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
    
    
}
