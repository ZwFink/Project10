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
     * @param inProbeFlag sets linear or quadratic probing
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

       tableArray = new Object[ inTableSize ];
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


    /**
     * Adds GenericData item to hash table
     * @param newItem GenericData item
     * @return Boolean success of operation
     */
    public boolean addItem( GenericData newItem )
    {
        int itemIndex = findItemIndex( newItem );

        if( itemIndex == ITEM_NOT_FOUND )
        {
            return false;
        }

        tableArray[ itemIndex ] = newItem;

        return true;
    }

    /**
     * Searches for item index in hash table
     * <p> Uses linear or quadratic probing as configured
     * @param searchItem GenericData value to be found
     * @return Integer index location of search item
     */
    @SuppressWarnings( "unchecked" )
    private int findItemIndex( GenericData searchItem )
    {
       int startIndex = generateHash( searchItem );
       int index;

       if( tableArray[ startIndex ] == null )
       {
           return startIndex;
       }

       // if this hash is already in the array
        if( probeFlag == LINEAR_PROBING )
        {
           for( index = startIndex + 1; index < ( startIndex + tableSize ); index++ )
           {
               if( index >= tableSize )
               {
                   index %= tableSize;
               }

               if( tableArray[ index ] == null )
               {
                  return index;
               }
           }

        }

        else
        {
            for( index = startIndex + 1; index < )
            {
                if( index >= tableSize )
                {
                    index %= tableSize;
                }

                if( tableArray[ index ] == null )
                {
                    return index;
                }
            }
        }
        return ITEM_NOT_FOUND;
    }

    /**
     * Method converts GenericData item to has value for use in hash table
     * <p> Note: Gets data from object via toString, then adds integer values of each
     *     character to sum and converts to array index
     * <p> Note: Uses number of characters from string specified by numHashDigits values
     *
     * @param item GenericData value to be converted to hash value
     * @return integer hash value
     */
    public int generateHash( GenericData item ) {
        int digitValue = 0;
        int index = 0;

        String stringValue = item.toString();

        for (index = 0; index < numHashDigits; index++)
        {
            digitValue += stringValue.charAt( index );
        }
        return digitValue % tableSize;
    }

    /**
     * Local recursive method to calculate exponentiation with integers
     * @param base base of exponentiation
     * @param exponent exponent of exponentiation
     * @return result of exponentiation calculation
     */
    private int toPower( int base, int exponent )
    {
       if( exponent == 0 )
       {
           return 1;
       }
       return toPower( base, exponent - 1 );
    }
}
