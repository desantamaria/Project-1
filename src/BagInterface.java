/**
@author Daniel Santamaria
@author Hope Markley
CS2400
2/22/21 
 */
public interface BagInterface<T>
{
    /** An interface that describes the operations of a bag of objects. */
	

	/** Checks if the Bag is not corrupt 
	    
	 	@throws  IllegalStateException throws exception if the integrity is not there*/		 
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

	
	/** Retrieves a specific entry in the bag.
	
		@param index The location of the object in the bag.
		@return The content of a bag at a specific point "index". */
	public T bagContent(int index);
	
	/** Retrieves all entries that are in two bags.
	
		@param bag2 The second bag included in the union.
		@return An array of all of the entries in both bags. */
	public BagInterface<T> union(BagInterface<T> bag2);
	

	/** Retrieves the intersection (the entries that appear in both bags) of the two bags stated. 
	 	Note: If an item occurs more than once in both bags the number of items that is shared by both will be included.

		@param bag2 The second bag included in the intersection.
		@return An array of every entry that is shared by both bags. */
	public BagInterface<T> intersection(BagInterface<T> bag2);
	
	
	/** Retrieves the difference of bag two (within the parameter) from bag one. 
	
		@param bag2 The bag of items being taken away from bag one.
	 	@return An array of every entry in the first bag minus every entry that also appears in bag two. */
	public BagInterface<T> difference(BagInterface<T> bag2);
}



