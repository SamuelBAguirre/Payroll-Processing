
/**
 * ObjectListNodeInterface holds the signatures for ObjectListNode class. 
 *
 * @author Samuel Aguirre 
 * @version 11/8/2019
 */
public interface ObjectListNodeInterface
{
    public void setInfo(Object o);
    public Object getInfo();
    public void setNext(ObjectListNode p);
    public ObjectListNode getNext();
}
