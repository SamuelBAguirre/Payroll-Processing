
/**
 * ObjectList class, an implementation of linear linked list data structure.
 *
 * @author Richard Stegman
 * @version 11/8/2019
 */
public class ObjectList implements ObjectListInterface
{

    private ObjectListNode list;
    private ObjectListNode last;

    // Constructs an empty list
    /**
     * ObjectList() contructs an empty list
     * 
     * @author Richard Stegman
     */
    public ObjectList() {
        list = null;
        last = null;
    }

    // Returns the first node in the list
    /**
     * The getFirstNode() returns the first node of the list. 
     * 
     * @author Richard Stegman
     * @return first node of the list
     */
    public ObjectListNode getFirstNode() {
        return list;
    }

    // Returns the last node in the list
    /**
     * The getLastNode() returns the last node of the list. 
     * 
     * @author Richard Stegman
     * @return last node if the list
     */
    public ObjectListNode getLastNode() {
        return last;
    }

    // Returns the first object in the list
    /**
     * The getFirst() returns the first object of the list
     * 
     * @author Richard Stegman
     * @return first object of the list
     */
    public Object getFirst() {
        if (list == null) {
            System.out.println("Runtime Error: getFirst()");
            System.exit(1);
        }
        return list.getInfo();
    }

    // Returns the last object in the list
    /**
     * The getLast() returns the last object in the last. 
     * 
     * @author Richard Stegman
     * @return last object of the list
     */
    public Object getLast() {
        if (list == null) {
            System.out.println("Runtime Error: getLast()");
            System.exit(1);
        }
        return last.getInfo();
    }

    // Adds an object to the front of a list
    /**
     * The addFirst() adds an object to the front of the list. 
     * 
     * @author Richard Stegman
     * @param o, the object that will be added to the front of the list
     */
    public void addFirst(Object o) {
        ObjectListNode p = new ObjectListNode(o, list);
        if (list == null)
            last = p;
        list = p;
    }

    // Adds a node to the front of the list
    /**
     * The addFirst(ObjectListNode p) adds a node to the front of a list. 
     * 
     * @author Richard Stegman
     * @param p, node that will be added to the front of list. 
     */
    public void addFirst(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addFirst()");
            System.exit(1);
        }
        p.setNext(list);
        if (list == null)
            last = p;
        list = p;
    }

    // Adds an object to the end of the list
    /**
     * The addLast(Object o) adds an object to the end of a list. 
     * 
     * @author Richard Stegman
     * @param o, the object that will be added to the end of the list
     */
    public void addLast(Object o) {
        ObjectListNode p = new ObjectListNode(o);
        if (list == null) 
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    // Adds a node to the end of the list
    /**
     * The addLast(ObjectListNode p) adds a node to the end of a list. 
     * 
     * @author Richard Stegman
     * @param p, node that will be added to the end of the list
     */
    public void addLast(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addLast()");
            System.exit(1);
        }
        p.setNext(null);
        if (list == null)
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    // Removes the first object from the list
    /**
     * The removeFirst() removes the first object from the list
     * 
     * @author Richard Stegman
     * @return first object from the list
     */
    public Object removeFirst() {
        if (list == null) {
            System.out.println("Runtime Error: removeFirst()");
            System.exit(1);
        }
        ObjectListNode p = list;
        list = p.getNext();
        if (list == null)
            last = null;
        return p.getInfo();
    }

    // Removes the last object from the list
    /**
     * The removeLast() removes the last object from the list
     * 
     * @author Richard Stegman
     * @return last object from the list
     */
    public Object removeLast() {
        if (list == null) {
            System.out.println("Runtime Error: removeLast()");
            System.exit(1);
        }
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        if (q == null) {
            list = null;
            last = null;
        }    
        else {
            q.setNext(null);
            last = q;
        }    
        return p.getInfo();
    }

    // Inserts an object after the node referenced by p
    /**
     * The insertAfter(ObjectListNode p, Object o) inserts an object after the node 
     * referenced by p
     * 
     * @author Richard Stegman
     * @param p, the node referenced by p; o, object to be inserted
     */
    public void insertAfter (ObjectListNode p, Object o) {
        if (list == null || p == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        ObjectListNode q = new ObjectListNode(o, p.getNext());
        p.setNext(q);
        if (q.getNext() == null)
            last = q;
    }

    // Inserts a node after the node referenced by p
    /**
     * The insertAfter(ObjectListNode p, ObjectListNode q) inserts a node after the node 
     * referenced by p
     * 
     * @author Richard Stegman
     * @param p, the node referenced by p; q, the node referenced by q
     */
    public void insertAfter(ObjectListNode p, ObjectListNode q) {
        if (list == null || p == null || q == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        q.setNext(p.getNext());
        p.setNext(q);
        if (last.getNext() != null)
            last = q;
    }

    // Deletes the node after the node referenced by p
    /**
     * The deleteAfter(ObjectListNode p) deletes the node after the node 
     * referenced by p
     * 
     * @author Richard Stegman
     * @return object in the info field of the node referenced by q
     * @param p, node referenced by p
     */
    public Object deleteAfter(ObjectListNode p) {
        if (list == null || p == null || p.getNext() == null) {
            System.out.println("Runtime Error: deleteAfter()");
            System.exit(1);
        }
        ObjectListNode q = p.getNext();
        p.setNext(q.getNext());
        if (p.getNext() == null)
            last = p;
        return q.getInfo();
    }

    // Inserts an item into its correct location within an ordered list
    /**
     * The insert(Object o) inserts an item into its correct location in an ordered list
     * 
     * @author Richard Stegman
     * @param o, object that will be inserted in the ordered list
     */
    public void insert(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(o);
        else
            insertAfter(q, o);
    }

    // Inserts a node into its correct location within an ordered list
    /**
     * The insert(ObjectListNode r) inserts a node into its correct location in an ordered list
     * 
     * @author Richard Stegman
     * @param r, node that will be inserted in the ordered list
     */
    public void insert(ObjectListNode r) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null &&
        ((Comparable)r.getInfo()).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(r);
        else
            insertAfter(q, r);
    }

    // Removes the first occurrence of an item in a list 
    /**
     * The remove(Object o) removes the first occurrence of an object in a list
     * 
     * @author Richard Stegman
     * @param o, object that to be removed 
     * @return null if list is empty
     */
    public Object remove(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) !=
        0) {
            q = p;
            p = p.getNext();
        }
        if (p == null)
            return null;
        else return q == null ? removeFirst() : deleteAfter(q);
    }

    // Returns true if the item is found in the list
    /**
     * The contains(Object o) returns true if the item is found in the list, false otherwise
     * 
     * @author Richard Stegman
     * @param o, object that is being searched 
     * @return true if the item is found in the list
     */
    public boolean contains(Object o) {
        ObjectListNode p = list;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) !=
        0)
            p = p.getNext();
        return p != null;
    }

    // Returns a reference to the node with the requested value
    // Returns null otherwise
    /**
     * The select(Object o) returns a reference to the node with the requested value
     * 
     * @author Richard Stegman
     * @param o, object that will be used in compareTo() 
     * @return reference to the node with the requested value
     */
    public ObjectListNode select(Object o) {
        ObjectListNode p = list;
        while (p != null)
            if (((Comparable)o).compareTo(p.getInfo()) == 0)
                return p;
            else
                p = p.getNext();
        return null;
    }

    // Determines whether or not a list is empty
    /**
     * The isEmpty() determines whether or not a list is empty. 
     * 
     * @author Richard Stegman 
     * @return true if the list is empty and false otherwise.
     */
    public boolean isEmpty() {
        return list == null;
    }

    // Removes all elements from a list
    /**
     * The clear() removes all elements from a list.
     * 
     * @author Richard Stegman
     */
    public void clear() {
        list = null;
        last = null;
    }

    // Returns the number of elements in the list
    /**
     * The size() returns the number of nodes in the list
     * 
     * @author Richard Stegman 
     * @return number of nodes
     */
    public int size() {
        int count = 0;
        ObjectListNode p = list;
        while (p != null) {
            ++count;
            p = p.getNext();
        }
        return count;
    }

    // Makes a copy of a list
    /**
     * The copyList() creats a copy of a list. 
     * 
     * @author Richard Stegman
     * @return the copied list
     */
    public ObjectList copyList() {
        ObjectListNode p = null; 
        ObjectListNode q = null; // to satisfy compiler;
        ObjectListNode r = list;

        if (isEmpty())
            return null;
        ObjectList newList = new ObjectList();
        while (r != null) {
            p = new ObjectListNode(r.getInfo());
            if (newList.isEmpty())
                newList.addFirst(p);
            else
                q.setNext(p); 
            q = p;
            r = r.getNext();
        }
        newList.last = p;
        return newList;
    }

    // Reverses a list
    /**
     * The reverse() reverses a list
     * 
     * @author Richard Stegman
     */
    public void reverse() {
        ObjectListNode p = list;
        ObjectListNode q = null;
        ObjectListNode r;

        while (p != null) {
            r = q;
            q = p;
            p = p.getNext();
            q.setNext(r);
        }
        last = list;
        list = q;
    }   
}
