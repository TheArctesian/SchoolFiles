public class Book extends ReadingItem{
    private String isBN;
    private String edition;
    private String tile;

    public Book(String name, String location, int price, String description, int wordCount, String datePublished, String author, String isBN, String edition, String tile) {
        super(name, location, price, description, wordCount, datePublished, author);
        this.isBN = isBN;
        this.edition = edition;
        this.tile = tile;
    }

    public String getIsBN() {
        return isBN;
    }

    public String getEdition() {
        return edition;
    }

    public String getTile() {
        return tile;
    }

    public void setIsBN(String isBN) {
        this.isBN = isBN;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isBN='" + isBN + '\'' +
                ", edition='" + edition + '\'' +
                ", tile='" + tile + '\'' +
                '}';
    }
}
