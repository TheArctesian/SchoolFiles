public class ReadingItem extends CISitem { 
    private int wordCount;
    private String datePublished;
    private String author;

    public ReadingItem(String name, String location, int price, String description, int wordCount, String datePublished, String author) {
        super(name, location, price, description);
        this.wordCount = wordCount;
        this.datePublished = datePublished;
        this.author = author;
    }

    public int getWordCount() {
        return wordCount;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public String getAuthor() {
        return author;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ReadingItem{" +
                "wordCount=" + wordCount +
                ", datePublished='" + datePublished + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}