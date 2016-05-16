package com.denis.shuvalov.algo.adt.positionList;

/**
 * Position<String> cursor = guests.first( );
 * while (cursor != null) {
 * System.out.println(cursor.getElement( ));
 * cursor = guests.after(cursor);
 * }
 */
public interface PositionalList<E> {

    int size();

    boolean isEmpty();

    /**
     * Returns the first Position in the list (or null, if empty).
     */
    Position<E> first();

    /**
     * Returns the last Position in the list (or null, if empty).
     */
    Position<E> last();

    /**
     * Returns the Position immediately before Position p (or null, if p is first).
     */
    Position<E> before(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position immediately after Position p (or null, if p is last).
     */
    Position<E> after(Position<E> p) throws IllegalArgumentException;

    /**
     * Inserts element e at the front of the list and returns its new Position.
     */
    Position<E> addFirst(E e);

    /**
     * Inserts element e at the back of the list and returns its new Position.
     */
    Position<E> addLast(E e);

    /**
     * Inserts element e immediately before Position p and returns its new Position.
     */
    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Inserts element e immediately after Position p and returns its new Position.
     */
    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Replaces the element stored at Position p and returns the replaced element.
     */
    E set(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Removes the element stored at Position p and returns it (invalidating p).
     */
    E remove(Position<E> p) throws IllegalArgumentException;
}
