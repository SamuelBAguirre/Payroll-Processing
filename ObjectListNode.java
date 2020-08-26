
/**
 * The ObjectListNode class, represents a node in a list
 *
 * @author Richard Stegman 
 * @version 11/6/2019
 */
public class ObjectListNode implements ObjectListNodeInterface
{
    private Object info;
    private ObjectListNode next;

    // Default ctor    
    /**
     * Constructor for objects of class ObjectListNode
     * 
     * @author Richard Stegman
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    // One-arg ctor
    /**
     * One-Arg Constructor for objects of class ObjectListNode
     * 
     * @author Richard Stegman
     * @param o, object in info field
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    

    // Two-arg ctor
    /**
     * Two-Arg Constructor for objects of class ObjectListNode
     * 
     * @author Richard Stegman
     * @param o, object in info field; p, node that p points to
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    // Sets info field
    /**
     * The setInfo() sets the info field of the node
     * 
     * @author Richard Stegman
     * @param o, object that will be set in the info field
     */
    public void setInfo(Object o) {
        info = o;
    }    

    // Returns object in info field
    /**
     * The getInfo() returns the object in the info field. 
     * 
     * @author Richard Stegman
     * @return object in the info field
     */
    public Object getInfo() {
        return info;
    }

    // Sets next field
    /**
     * The setNext() sets the info field of the next node in the list. 
     * 
     * @author Richard Stegman
     * @param p, node that points to 
     */
    public void setNext(ObjectListNode p) {
        next = p;
    }

    // Returns object in info field
    /**
     * The getNext() returns object in info of the next node of the list. 
     * 
     * @author Richard Stegman
     * @return object of the next node
     */
    public ObjectListNode getNext() {
        return next;
    }
}
