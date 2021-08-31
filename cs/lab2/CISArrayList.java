
public class CISArrayList<SomeType> {

    private SomeType [] allTheObjects;
    private static final int INITIAL_CAPACITY = 10;
    private int totalObjects;
    private int currIndex;


    public CISArrayList()
    {
            /*
                TODO 0: This constructor will initialize allTheObjects
                to an array of size 10.
            */

        allTheObjects = (SomeType[])new Object[INITIAL_CAPACITY]; //Array of size 10
        totalObjects = 0;

    }

    public int length() //Change to numberOfObjectsInArray in the future
    {
    	int GERTH = allTheObjects.length;
        return GERTH;
    }

    private SomeType[] grow(int GERTH)
    {
            /*
                TODO 2: Create a private method called grow, which doubles
                the internal array's capacity.
            */
    	SomeType[] newObjects;
    	int newSize = GERTH*2; 
    	newObjects = (SomeType[])new Object[newSize];
    	return newObjects; 
    	

    }

    public void add(SomeType objectToStore)
    {
            /*
                TODO 3: Method add, which will takes in a Object and add
                to the next available index in the array. It returns nothing.
                If array is full, grow it.
            */
    	
    }

    public SomeType getElement(int idx)
    {
            /*
                TODO 4: Method getElement, which takes in an int as the index,
                and returns the Object at that index.
                If index is out of bounds (less than 0 or >number of objects),
                return null.
            */
            return null;
    }

    public SomeType setElement(int idx, SomeType objectToStore)
    {
            /* TODO 5: Method setElement, takes in an int as the index
               and an object, and replaces the object at that index in the
               allTheObjects array. This should return the old object, which
               was replaced as is no longer in the array. If index is out of
               bounds (less than 0 or >number of objects), return null.
            */
            return null;
    }
}
