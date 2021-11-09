package tuples;

import java.util.stream.IntStream;

import java.util.Arrays;

/**
 * @immutable
 * @invar | getElements() != null
 * @invar | Arrays.stream(getElements()).allMatch(e -> e != null)
 * @invar | getLength() == getElements().length
 * @invar | IntStream.range(0, getLength()).allMatch(i -> getElementAt(i) == getElements()[i]) 
 */
public class Tuple {
	
	/**
	 * @invar | elements != null
	 * @invar | Arrays.stream(elements).allMatch(e -> e != null)
	 * @representationObject
	 */
	private Object[] elements;
	
	public int getLength() { return elements.length; }
	
	/**
	 * @pre | 0 <= index && index < getLength()
	 */
	public Object getElementAt(int index) { return elements[index]; }
	
	/**
	 * @creates | result
	 */
	public Object[] getElements() { return elements.clone(); }
	
	/**
	 * @throws IllegalArgumentException | elements == null
	 * @throws IllegalArgumentException | Arrays.stream(elements).anyMatch(e -> e == null)
	 * @inspects | elements
	 * @post | Arrays.equals(getElements(), elements)
	 */
	public Tuple(Object[] elements) {
		if (elements == null)
			throw new IllegalArgumentException("`elements` is null");
		if (Arrays.stream(elements).anyMatch(e -> e == null))
			throw new IllegalArgumentException("Some elements of `elements` are null");
		this.elements = elements.clone();
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof Tuple tuple && Arrays.equals(elements, tuple.elements);
	}

}
