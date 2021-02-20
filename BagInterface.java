
public interface BagInterface<T>
{
    /** An interface that describes the operations of a bag of objects. */
	
	/** Checks if the ArrayBag is not corrupt     
	 	@return  throws exception if the integrity is not there*/
		 
	public void checkIntegrity();	
	/** Gets the current number of entries in this bag.
		@return  The integer number of entries currently in the bag. */

	public int getCurrentSize();
	/** Sees whether this bag is empty.
	    @return  True if the bag is empty, or false if not */

	public boolean isEmpty();
	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or false if not. */

	public boolean isFull();
	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or false if not. */

	public boolean add(T newEntry);
	/** Removes one unspecified entry from this bag, if possible.
        @return  Either the removed entry, if the removal was successful, or null. */

	public T remove();
	/** Removes one occurrence of a given entry from this bag, if possible.
        @param anEntry  The entry to be removed.
        @return  True if the removal was successful, or false if not. */

    public boolean remove(T anEntry);
	/** Removes all entries from this bag. */

	public void clear();
	/** Counts the number of times a given entry appears in this bag.
		@param anEntry  The entry to be counted.
		@return  The number of times anEntry appears in the bag. */

	public int getFrequencyOf(T anEntry);
	/** Tests whether this bag contains a given entry.
		@param anEntry  The entry to find.
		@return  True if the bag contains anEntry, or false if not. */

	public boolean contains(T anEntry);
	/** Retrieves all entries that are in this bag.
		@return  A newly allocated array of all the entries in the bag. Note: If the bag is empty, the returned array is empty. */
	
	public T[] toArray();

	public T union(T anEntry);
	/**  Retrieves all entries that are in two bags.
	 * @param anEntry The second bag included in the union.
	 * @return An array of all of the entries in both bags.
	*/

	public T interception(T anEntry);
	/** Retrieves the intersection (the entries that appear in both bags) of the two bags stated. Note: If an item occurs more than once in both bags the number of items that is shared by both will be included.
	 * @param anEntry The second bag included in the intersection.
	 * @return An array of every entry that is shared by both bags. */

	public T difference(T anEntry);
	/** Retrieves the difference of bag two (within the parameter) from bag one. 
	 * @param anEntry The bag of items being taken away from bag one.
	 * @return An array of every entry in the first bag minus every entry that also appears in bag two. */
}



