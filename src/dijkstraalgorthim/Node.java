/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorthim;

import java.util.HashMap;

/**
 *
 * @author yaffa & khadijah
 */
public class Node {
    private char name;
    private HashMap<Character, Integer> neighbor=new HashMap();
    public Node(){
        
    }
    public Node (char name){
        setName(name);
    }
    public void setName(char name){
        this.name=name;
    }
    public void setNeighbor(char neighborName, int cost){
        this.neighbor.put(neighborName, cost);
    }
    public char getName(){
        return this.name;
    }
    public HashMap getNeighbor(){
        return this.neighbor;
    }
}
