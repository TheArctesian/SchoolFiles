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

    public SomeType[] add(int Index, SomeType Element)
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
        }
        return addedArray;
    }


    public void remove(int index) {
        int newLength = allTheObjects.length - 1;
        SomeType[] newObjects = (SomeType[]) new Object[newLength];
        for (int i = 0; i < newLength; i++) {
            if (i >= index) {
                newObjects[i] = allTheObjects[i + 1];
            } else {
                newObjects[i] = allTheObjects[i];
            }
        }
        allTheObjects = newObjects;
    }

    public void remove(SomeType obj) {
        int index = -1;
        for (int i = 0; i < allTheObjects.length; i++) {
            if (allTheObjects[i] == obj) {
                index = i;
                break;
            }
        }
        if (index == -1) {

            System.out.println("Fuking idiot, can't element inside the arrayList.");
            return;
        }
        int newLength = allTheObjects.length - 1;
        SomeType[] newObjects = (SomeType[]) new Object[newLength];

        for (int i = 0; i < newLength; i++) {
            if (i >= index) {
                newObjects[i] = allTheObjects[i + 1];
            } else {
                newObjects[i] = allTheObjects[i];
            }
        }
        
        allTheObjects = newObjects;
    }

    public SomeType GetElement(int index)
    {
        return allTheObjects[index];

    }

    public void SetElement(int index, SomeType value)
    {
        allTheObjects[index] = value;
    }

    public void clear()
    {
        allTheObjects = (SomeType[])new Object[INITIAL_CAPACITY]; //Array of size 10
    }
}
