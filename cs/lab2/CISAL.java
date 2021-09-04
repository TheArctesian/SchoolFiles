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

    public SomeType add(int Index, SomeType Element)
    {
        // SomeType[] newArray = new SomeType [length()+1];

        SomeType[] addedArray = (SomeType[])new Object[length()+1]; //Array of size 10
        for (int i = 0; i < length()+1; i++)
        {
            if(!(i>allTheObjects.length))
            {
                addedArray[i] = allTheObjects[i];
            }
            else
            {
                addedArray[i] = Element;
            }
        return (SomeType) addedArray;
    }


    public SomeType rm(int Index, SomeType Element)
    {

        SomeType[] rmArray = (SomeType[])new Object[length()-1]; //Array of size 10
        for (int i = 0; i < length()-1; i++)
        {
            if(!(i>allTheObjects.length))
            {
                rmArray[i] = allTheObjects[i];
            }
        return (SomeType) rmArray;
    }

    public SomeType clear()
    {
        return null;
    }

    public SomeType GetElement()
    {
        return null;

    }

    public SomeType SetElement()
    {
        return null;
    }
}
