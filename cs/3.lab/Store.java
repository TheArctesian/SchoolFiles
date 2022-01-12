import java.util.ArrayList;

public class Store
{
    ArrayList <CISitem> lagosItem = new ArrayList<CISitem>();
    public ArrayList<CISitem> addBook(ArrayList<CISItem> ar, Book book){
        ar.put(book);
    }
    /*
     * TODO 4: Create a test for addBook. The test is called addBookTest.
     *  0. Create an instance of Store
     *  1. Create a Book object
     *  2. Add the book with .addBook() Your program should not crash when you do this
     *  3. You can use assertTrue(true) at the end of the method
     */
    public static void main(String[] args) {
        

        // Book testBook = new Book("Brave new World", "London", 69, "Dystopian Future", 696969, "20/4/20", "Huxley", "idk what is BN is", "First Edition", "BNW");
        Book testBook = new Book();
        addBook(testBook);
    }
    /*
     * TODO 5: Create a method addPhone which takes in a Phone as an argument
     *  and adds it to the arrayList lagosItems.
     */
    public void addPhone(Phone book){
        lagosItem.put(book);
    }
    /*
     * TODO 6: Create a test that calls addBook AND addPhone
     *  0. Create an instance of Store
     *  1. Create a Book object
     *  2. Create a Phone object
     *  3. Add the objects with their appropriate method. Your program should not crash
     *  4. You can use assertTrue(true) at the end of the method
     */

    Store nStore = new Store();
    Book nBook = new Book();
    Phone nPhone = new Phone();
    newStore.addBook(newBook);
    newStore.addPhone(newPhone);


    /*
     * TODO 7: Lagos wants to move all Phones to a new location. Create a method
     *  called updatePhonesLocation() which takes in a location as an argument and
     *  changes the location of all Phones in the Store
     */
    public void updatePhonesLocation(String location){
        for(CISitem item: lagosItem){
            item.setLocation(location);
            // assertEquals(item.getLocation(), "location");
        }
    }
    /*
     * TODO 8: create a method called getAllPhones() that returns an arrayList with
     *  all the phones in the store.
     */

    public ArrayList<phone> GetAllPhones(){
        return lagosItem;
    }

    /*
     * TODO 9: Create a test for updatePhonesLocation() and getAllPhones()
     *  This test will update all phones to be in "Room 514".
     *  0. Create an instance of Store
     *  1. Create some Phones and add them to the store.
     *  2. Update all phones to be at location "Room 514"
     *  3. Call getAllPhones()
     *  4. Check each phone and make sure that their location equals "Room 514"
     *  5. Use assertEquals(somePhone.getLocation(), "Room 514") on each phone
     *  Take a look at tests from other labs to see how assertEquals() is used.
     */

        Store room514 = new store();
        Phone one = new Phone();
        Phone two = new Phone();
        Phone three = new Phone();
        room514.addPhone(one);
        room514.addPhone(two);
        room514.addPhone(three);
        room514.updatePhonesLocation("Room 514");
        for (Phone phone: room514.getAllPhones()){
            assertEquals(phone.getLocation(), "Room 514");
        }
    /*
     * TODO  10: You can see how creating a method for each specific thing that you
     *  can do with each device will get incredibly tedious. Let's make a method called
     *  getItems(String itemType) where itemType is a the type of object the user wants
     *  as a String. getItems("phone") will return all phones in the store. getItems("book")
     *  will return all books in the store.
     */

        public ArrayList<CISitem> getItems(String type){
            ArrayList<CISitem> items = new ArrayList<CISitem>();
            for(CISitem item: lagosItem){
                if(item.getType().equals(type)){
                    items.add(item);
                }
            }
            return items;
        }
    /*
     * TODO 11: Write a test that makes sure that getItems() works correctly. Test it with
     *  with more than one type of CISItem
     */
            
            Store newStore = new Store();
            Book newBook = new Book();
            Phone newPhone = new Phone();
            newStore.addBook(newBook);
            newStore.addPhone(newPhone);
            ArrayList<CISitem> newItems = newStore.getItems("phone");
            assertEquals(newItems.size(), 1);
            assertEquals(newItems.get(0).getType(), "phone");
            ArrayList<CISitem> newItems = newStore.getItems("book");
            assertEquals(newItems.size(), 1);
            assertEquals(newItems.get(0).getType(), "book");
    /*
     * TODO 12: Create a method updateItems(String itemType, String property, String value) where itemType
     *  is the type of item the user wants to update. updateItem("phone", "location", "Room513")
     *  will update all phones' location to "Room 513"
     */
        public String updateItems(String type, String property, String value){
            for(CISitem item: lagosItem){
                if(item.getType().equals(type)){
                    item.setProperty(property, value);
                }
            }
            return value;
        }
    /*
     * TODO 12: Make a test for updateItems that makes sure it works correctly. Try a variety of
     *  combinations.
     */
        Store newStore = new Store();
        Book newBook = new Book();
        Phone newPhone = new Phone();
        newStore.addBook(newBook);
        newStore.addPhone(newPhone);
        newStore.updateItems("phone", "location", "Room513");
        for (CISitem item: newStore.getItems("phone")){
            assertEquals(item.getLocation(), "Room 513");
        }
    /*
     * TODO 13: Make method showAllInfo() that prints the information for all items in the store.
     *  You don't need to write a test for this, just verify it manually. Take a look at the console and
     *  make sure things are working correctly.
     */

     public void showAllInfo(){
        for(CISitem item: lagosItem){
            System.out.println(item.toString());
        }
}