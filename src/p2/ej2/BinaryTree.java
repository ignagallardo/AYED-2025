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
public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int contarHojas() {  //hojas son los nodos que no tienen hijos
            BinaryTree<T> aux = new BinaryTree<T>();
            aux = this;
            int i = 0;
            
            if(aux.isLeaf()){
                i++;
            }
            else {
                if(this.hasLeftChild()){
                    this.getLeftChild().contarHojas();
                    i += aux.getLeftChild().contarHojas();
                }
                if(this.hasRightChild()){
                    this.getRightChild().contarHojas();
                    i += aux.getRightChild().contarHojas();
                }
            }
            return i;
	}
		
		
    	 
        public BinaryTree<T> espejo(){
            BinaryTree<T> aux = new BinaryTree<T>(this.getData());
            if(this.hasLeftChild())
                aux.addRightChild(this.getLeftChild().espejo());
            if(this.hasRightChild())
                aux.addLeftChild(this.getRightChild().espejo());
            
            return aux;
        }

            // 0<=n<=m
	public void entreNiveles(int n, int m){
            BinaryTree<T> aux = null;
            Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
            cola.enqueue(this);
            cola.enqueue(null);
            int i = 0;
            while(!cola.isEmpty() && i <= m){
                aux = cola.dequeue();
                if(aux != null){
                    if(i <= n){
                        System.out.println(aux.getData());
                    }
                    if(aux.hasLeftChild()){
                        cola.enqueue(aux.getLeftChild());
                    }
                    if(aux.hasRightChild()){
                        cola.enqueue(aux.getRightChild());
                    }
                } else if(!cola.isEmpty()){
                    i++;
                    cola.enqueue(null);
                }
            }
        }
        
        public void preorden(BinaryTree<T> ab) {
            System.out.println(ab.getData());
            if (ab.hasLeftChild()) {
                this.preorden(ab.getLeftChild());
            }
            if (ab.hasRightChild()) {
                this.preorden(ab.getRightChild());
            }
        }


        
   public static void main(String[] args){
       
        BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
        ab.addLeftChild(hijoIzquierdo);
        ab.addRightChild(hijoDerecho);

        
        System.out.println(ab.contarHojas());
        
        ab.preorden(ab);
        ab.preorden(ab.espejo());
        
        ab.entreNiveles(0, 3);
   }
        
        
}

