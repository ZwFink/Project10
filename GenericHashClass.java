package p10_Package;

/**
 * Class to represent hash table
 *
 * @author Zane Fink
 */
public class GenericHashClass< GenericData extends  Comparable< GenericData > >
{
    /**
     * Default number of characters of data string to use in hash calculation
     */
    private static final int DEFAULT_NUM_HASH_DIGITS = 6;


    /**
     * Table size default
     */
    private static final int DEFAULT_TABLE_SIZE = 10;

    /**
     * Constant for returning item not found with search
     */
    private static final int ITEM_NOT_FOUND = -1;

    /**
     * Constant for setting linear probing
     */
    public static final int LINEAR_PROBING = 101;

    /**
     * Constant for setting quadratic probing
     */
    public static final int QUADRATIC_PROBING = 102;


    /**
     * Working number of characters from data string to use in hash calculation
     */
    private int numHashDigits;

    /**
     * Size of the array table
     */
    private int tableSize;

    /**
     * Flag for setting linear or quadratic probing
     */
    private int probeFlag;

    /**
     * Array for hash table
     */
    private Object[] tableArray;
    
}
