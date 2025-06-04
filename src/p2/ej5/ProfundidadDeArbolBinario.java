package p2.ej5;
import p2.ej2.BinaryTree;
import p2.ej2.Queue;
public class ProfundidadDeArbolBinario {

	BinaryTree<Integer> arbol;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> ab) {
		
		arbol = ab;
		
	}
	
	public int sumaElementosProfundidad(int p) {
		int nodos = 0;
		int nivel = 0;
		BinaryTree<Integer> ab;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(this.arbol);
		cola.enqueue(null);
		while(!cola.isEmpty() && nivel < p) {
			
			ab = cola.dequeue();
			if(ab != null) {
				if(ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
					nodos++;
				}
				if(ab.hasRightChild()) {
					cola.enqueue(ab.getRightChild());
					nodos++;
				}
			} else if(!cola.isEmpty()) {
				if(nodos == Math.pow(2, ++nivel)) {
					cola.enqueue(null);
					if(nivel == p)
						return nodos;
					else
						nodos = 0;
				}
			}
			
		}
		return 0;
	}
	
}
