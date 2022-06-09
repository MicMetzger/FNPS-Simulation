import java.util.*;
import java.util.stream.*;




/**
 *
 *
 */
public abstract class Supplies extends Item {
	// 
	private static final ArrayList<Supplies> inventory = new ArrayList<>();


	/**
	 *
	 *
	 */
	public void add(Supplies supply) {
		inventory.add(supply);
	}


	/**
	 *
	 *
	 */
	public void remove(Supplies supply) {
		inventory.remove(supply);
	}


	/**
	 *
	 * @return the number of Supplies in this list
	 */
	public static int size() {return inventory.size();}


	/**
	 *
	 * @return {@code true} if this list contains no Supplies
	 */
	public static boolean isEmpty() {return inventory.isEmpty();}


	/**
	 * Returns {@code true} if this list contains the specified Supply.
	 * @param o Supply whose presence in this list is to be tested
	 * @return {@code true} if this list contains the specified Supply
	 */
	public static boolean contains(Supplies o) {return inventory.contains(o);}


	/**
	 * Returns the index of the first occurrence of the specified Supply element
	 * in this list, or -1 if this list does not contain the element.
	 * @param o The targetted Supply state.
	 */
	public static int indexOf(Supplies o) {return inventory.indexOf(o);}


	/**
	 * Removes all the Supplies from this list.  The list will
	 * be empty after this call returns.
	 */
	public static void clear() {inventory.clear();}


	/**
	 * 
	 * @return a sequential {@code Stream} over the Supply elements in the collection
	 */
	public static Stream<Supplies> stream() {return inventory.stream();}


}


