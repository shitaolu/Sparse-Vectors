package A1Q1;
import java.util.*;

/**
 * Represents a sparse numeric vector. Elements are comprised of a (long)
 * location index an a (double) value.  The vector is maintained in increasing
 * order of location index, which facilitates numeric operations like
 * inner products (projections).  Note that location indices can be any integer
 * from 1 to Long.MAX_VALUE.  The representation is based upon a
 * singly-linked list.
 * The following methods are supported:  iterator, getSize, getFirst,
 * add, remove, and dot, which takes the dot product of the with a second vector
 * passed as a parameter.
 * @author jameselder
 */
public class SparseNumericVector implements Iterable {

    protected SparseNumericNode head = null;
    protected SparseNumericNode tail = null;
    protected long size;

  /**
     * Iterator
     */
    @Override
    public Iterator<SparseNumericElement> iterator() { //iterator
        return new SparseNumericIterator(this);
    }
    
    /**
     * @return number of non-zero elements in vector
     */
   public long getSize() {
        return this.size;
    }

     /**
     * @return the first node in the list.
     */
    public SparseNumericNode getFirst() {
        return this.head;
    }
    
    /**
     * Add the element to the vector.  It is inserted to maintain the
     * vector in increasing order of index.  If the element has zero value, or if 
     * an element with the same index already exists, an UnsupportedOperationException is thrown. 
     * @param e element to add 
     */
  public void add(SparseNumericElement e) throws UnsupportedOperationException {
      SparseNumericNode current = this.head;
      while(current != null){
        	  if(e.getIndex() == current.getElement().getIndex()){
        		  throw new UnsupportedOperationException();
        	  }
        	  current = current.getNext();
          }
      
      if(e == null){
    	  throw new IllegalArgumentException();
      }
      
      if(e.getValue() == 0 ){
    	   throw new UnsupportedOperationException();
       }
      
      
      if(this.head == null){
    	  SparseNumericNode temp1 = new SparseNumericNode(e,null);
          this.head = this.tail = temp1;
          this.size++;
      } 
      
      else if(this.size == 1){
    	  if(this.head.getElement().getIndex() < e.getIndex()){
    		  SparseNumericNode temp2 = new SparseNumericNode(e,null);
        	  this.tail = temp2;
        	  this.head.setNext(temp2);
        	  this.size++;
    	  }
    	  else{
    		  SparseNumericNode temp2 = new SparseNumericNode(e,null);
    		  temp2.setNext(this.tail);
    		  this.head = temp2;
    		  this.size++;
    	  }
      }
      else if(this.head.getElement().getIndex() > e.getIndex() ){
    	  SparseNumericNode temp6 = new SparseNumericNode(e,this.head);
    	  this.head = temp6;
    	  this.size++;
      }
      else if(this.head!= null && this.tail.getElement().getIndex() < e.getIndex()){
          SparseNumericNode temp4 = new SparseNumericNode(e,null);
          this.tail.setNext(temp4);
          this.tail = temp4;
          this.size++;
      }
      else if(this.head!= null && this.tail.getElement().getIndex() > e.getIndex()){
    	  current = this.head;
    	  while(current != null){
    		  if(current.getElement().getIndex() < e.getIndex() && current.getNext().getElement().getIndex() >e.getIndex()){
    			  SparseNumericNode temp3 = new SparseNumericNode(e,current.getNext());
    			  current.setNext(temp3);
    			  this.size++;
    			  break;
    		  }
    		  current = current.getNext();
    	  }
      }
    }

    /**
     * If an element with the specified index exists, it is removed and the
     * method returns true.  If not, it returns false.
     *
     * @param index of element to remove
     * @return true if removed, false if does not exist
     */
    public boolean remove(Long index) {
    	
    	if(this.size == 0){
    		return false;
    	}
    	
    	if(this.size == 1){
    		if(this.head.getElement().getIndex() == index){
    			this.head = this.tail = null;
    			this.size--;
    			return true;
    		}
    	}
    	
    	SparseNumericNode current = head.getNext();
    	SparseNumericNode beforecurrent = head;
      
    	if(this.head.getElement().getIndex() == index){
    	   this.head = this.head.getNext();
    	   this.size--;
    	   return true;
       }
       
       while(current!= null){
    	   if(current.getElement().getIndex() == index){
    		   beforecurrent.setNext(current.getNext());
    		   this.size--;
    		   return true;
    	   } 
    	   beforecurrent = current;
    	   current = current.getNext();
       }
    	//implement this method
        //this return statement is here to satisfy the compiler - replace it with your code.
        return false; 
    }

    /**
     * Returns the inner product of the vector with a second vector passed as a
     * parameter.  The vectors are assumed to reside in the same space.
     * Runs in O(m+n) time, where m and n are the number of non-zero elements in
     * each vector.
     * @param Y Second vector with which to take inner product
     * @return result of inner product
     */

    public double dot (SparseNumericVector Y) {
    	SparseNumericNode current = this.head;
    	SparseNumericNode i = Y.head;
    	double value = 0.0;
    	 do{
    		if(current.getElement().getIndex() == (i.getElement().getIndex())) {
    			value = value + current.getElement().getValue() * i.getElement().getValue();
    			if(i.getNext() != null){
    				i = i.getNext();
    			}
    			if(current.getNext() != null){
    				current = current.getNext( );
    			}
    		}
    		else if(current.getElement().getIndex() > (i.getElement().getIndex())){
    			if(i.getNext() != null){
    				i = i.getNext();
    			}
    		}
    		else if(current.getElement().getIndex() < (i.getElement().getIndex())){
    			if(current.getNext() != null){
    				current = current.getNext( );
    			}
    		} }
    		while(current.getNext()!= null || i.getNext()!= null);
    	 
    	 if(current.getElement().getIndex() == (i.getElement().getIndex())) {
			value = value + current.getElement().getValue() * i.getElement().getValue();
		}
    	//implement this method
        //this return statement is here to satisfy the compiler - replace it with your code.
        return value;
   }

       /**
     * returns string representation of sparse vector
     */

    @Override
    public String toString() {
        String sparseVectorString = "";
        Iterator<SparseNumericElement> it = iterator();
        SparseNumericElement x;
        while (it.hasNext()) {
            x = it.next();
            sparseVectorString += "(index " + x.getIndex() + ", value " + x.getValue() + ")\n";
        }
        return sparseVectorString;
    }
}