 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorthim;
import java.util.HashMap;
import java.util.HashSet;
/**
 *
 * @author yaffa & khadijah
 */
public class Node {
    private String name;
    private HashMap<Node, Integer> neighborMap=new HashMap();
    public Node(){}
    
    public Node (String name){
        setName(name);
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setNeighbor(Node neighbor, int cost){
        this.neighborMap.put(neighbor, cost);
    }
    
    public String getName(){
        return this.name;
    }
    
    public HashMap getNeighborMap(){
        //how to print a hash map??!
        return this.neighborMap;
    }
    
}
