import java.lang.reflect.Array;

public class CISAL<SomeType> {
    
    private SomeType [] allTheObjects;
    private static final int INITIAL_CAPACITY = 10;
    private int totalObjects;
    private int currIndex;

    public CISAL()
    {
        
        allTheObjects = (SomeType[])new Object[INITIAL_CAPACITY]; //Array of size 10
        totalObjects = 0;

        
    }
    
    
    public int length() //Change to numberOfObjectsInArray in the future
    {
        int length = allTheObjects.length;
        return length;
    }

    public SomeType[] add()
    {
        return null;
    }


    public SomeType[] rm()
    {

        return null;
    }

    public SomeType[] clear()
    {
        return null;
    }
}
