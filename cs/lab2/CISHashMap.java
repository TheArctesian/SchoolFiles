public class CISHashMap<SomeTypeKey, SomeTypeVal> {
    private SomeTypeKey [] key;
    private SomeTypeVal [] value;
    private static final int INITIAL_CAPACITY = 1;
    private int totalObjects;

    public CISHashMap()
    {
        key = (SomeTypeKey[]) new Object [INITIAL_CAPACITY];
        value = (SomeTypeVal[]) new Object [INITIAL_CAPACITY];
        totalObjects = 0;
    }

    public int length() //Change to numberOfObjectsInArray in the future
    {
        int length = key.length;
        return length;
    }
    
    public void add(SomeTypeKey key, SomeTypeVal value)
    {
        SomeTypeKey[] addedKeyArray = (SomeTypeKey[])new Object[length()+1]; //Array of size 10
        for (int i = 0; i < length()+1; i++)
        {
            if(!(i>this.key.length))
            {
                addedKeyArray[i] = this.key[i];
            }
            else
            {
                addedKeyArray[i] = key;
            }
        }
        this.key = addedKeyArray;

        SomeTypeVal[] addedValArray = (SomeTypeVal[])new Object[length()+1]; //Array of size 10
        for (int i = 0; i < length()+1; i++)
        {
            if(!(i>this.value.length))
            {
                addedValArray[i] = this.value[i];
            }
            else
            {
                addedValArray[i] = value;
            }
        }
        this.value = addedValArray;
    }

    public SomeTypeVal getElement(SomeTypeKey key) {       
        int keyCode = Math.abs(key.hashCode()); //could be neg
        int index = -1;
        for (int i = 0; i < this.key.length; i++){
            if (Math.abs(this.key[i].hashCode()) == keyCode) {
                index = i;
                break;
            }
        }
        if (index != -1){
            return this.value[index];
        }
        return null;
    }
}
