package libraries.dataStructures.linear;

import libraries.dataStructures.models.*;

/** Implementing queue interface throughout an Array 
*@author (nitoss)
*@version 1.0.1
*@param <E> Array generic data type
 */

public class ArrayQueue<E> implements Queue<E>{
    //Class atributes
    protected static final int default_capacity  = 50;
    //Instance atributes
    protected E[] array; 
    protected int end,first,size;
    
    //Constructor
    @SuppressWarnings("unchecked")

    public ArrayQueue(){
        array = (E[]) new Object[default_capacity];
        first = 0;
        end = -1;
        size = 0;
    }

    public void queueUp(E e){
        if(size == array.length){ expandQueue();}  //We make the array bigger so it fits in case it doesnt
        end = increment(end);
        array[end] = e;
        size++;
        
    }
    public int size(){
        return size;
    }

    public E desize(){
        E theFirst = array[first];
        first = increment(first);
        size--;
        return theFirst;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public E first(){
        return array[first];
    }

    public int increment(int index){
        return(index +1) % array.length;

    }

    @SuppressWarnings("unchecked")
    private void expandQueue(){
        E[] newA = (E[]) new Object[array.length * 2];
        for(int i = 0; i<size; i++){
            newA[i] = array[first];
            first = increment(first);
        }
        array = newA;
        first = 0;
        end = size - 1;
    }

    


}
