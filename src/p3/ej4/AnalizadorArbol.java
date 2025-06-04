/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3.ej4;

import java.util.List;
import p3.ej1.GeneralTree;
import p2.ej2.Queue;

        /**
 *
 * @author UsuarioW10
 */
public class AnalizadorArbol {
    
    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol){
        double prom = 0;
        double promMax = 0;
        double cant = 0;
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        while(!cola.isEmpty()){
            GeneralTree<AreaEmpresa> aux = cola.dequeue();
            if(aux != null){
                prom += aux.getData().getTardanza();
                List<GeneralTree<AreaEmpresa>> children = aux.getChildren();
                cant++;
                for(GeneralTree<AreaEmpresa> child: children){
                    cola.enqueue(child);
                }
            }
            else{
                prom = prom/cant;
                promMax = Math.max(promMax, prom);
                cant = 0;
                prom = 0;
                if(!cola.isEmpty()){
                    cola.enqueue(null);
                }
            }
        }
    
        return promMax;
    }
    
}
