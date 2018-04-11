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


    /**
     * Default constructor
     * <p> Initializes to default table size, number of hash digits,
     * with probe flag set to linear probing
     */
    public GenericHashClass()
    {
        tableArray = new Object[ DEFAULT_TABLE_SIZE ];
        numHashDigits = DEFAULT_NUM_HASH_DIGITS;
        probeFlag = LINEAR_PROBING;
    }

    /**
     * Initialization constructor
     * @param inProbeFlag sets linear or quadratic prbing
     */
    public GenericHashClass( int inProbeFlag )
    {
        tableArray = new Object[ DEFAULT_TABLE_SIZE ];
        numHashDigits = DEFAULT_NUM_HASH_DIGITS;
        probeFlag = inProbeFlag;
    }

    /**
     * Initialization constructor
     * @param inTableSize Sets table size
     * @param inHashDigits Sets number of characters from data string for use in
     *                     hash calculation
     * @param inProbeFlag sets linear or quadratic probing
     */
    public GenericHashClass( int inTableSize, int inHashDigits,
                             int inProbeFlag )
    {
       tableSize = inTableSize;
       numHashDigits = inHashDigits;
       probeFlag = inProbeFlag;
    }

    /**
     * Copy constructor
     * @param copied GenericHashClass object to be copied
     */
    public GenericHashClass( GenericHashClass< GenericData > copied )
    {
        int index = 0;

        probeFlag = copied.probeFlag;
        tableSize = copied.tableSize;
        numHashDigits = copied.numHashDigits;

        tableArray = new Object[ tableSize ];

        for( index = 0; index < tableSize; index++ )
        {
           tableArray[ index ] = copied.tableArray[ index ];
        }
    }
    
}
