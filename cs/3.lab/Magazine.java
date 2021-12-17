public class Magazine extends ReadingItem{
    private String coverStoryTitle;
    private String printDate;

    public Magazine(String title, String author, String publisher, String coverStoryTitle, String printDate) {
        super(title, author, publisher);
        this.coverStoryTitle = coverStoryTitle;
        this.printDate = printDate;
    }

    public String getCoverStoryTitle() {
        return coverStoryTitle;
    }

    public void setCoverStoryTitle(String coverStoryTitle) {
        this.coverStoryTitle = coverStoryTitle;
    }

    public String getPrintDate() {
        return printDate;
    }

    public void setPrintDate(String printDate) {
        this.printDate = printDate;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "coverStoryTitle='" + coverStoryTitle + '\'' +
                ", printDate='" + printDate + '\'' +
                '}';
    }

}
