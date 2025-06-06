/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.ej2;

/**
 *
 * @author UsuarioW10
 */
import java.util.*;
public class Queue<T> {
    
    List<T> data;
    
    public Queue() {
        this.data = new LinkedList<T>();
    }
    
    public void enqueue(T dato) {
    // agrega al final
        data.add(dato);
    }
 
    public T dequeue() {
        return data.remove(0);
    }
    
    public T head() {
        return data.get(0);
    }
 
    public int size() {
        return data.size();
    }
 
    public boolean isEmpty() {
        return data.size()==0;
    }
 
    @Override
    public String toString() {
        String str = "[";
        for(T d: data)
            str = str + d +", ";
        str = str.substring(0, str.length()-2)+"]";
    return str;
    }
}