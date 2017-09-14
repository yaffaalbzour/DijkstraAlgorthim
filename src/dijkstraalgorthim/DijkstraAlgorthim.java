/*
 */
package dijkstraalgorthim;
//import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/**
 *
 * @author yaffa & khadijah
 */
public class DijkstraAlgorthim extends JFrame{
//*public static Thread threadObject = new Thread();
boolean clicked  ;
public static ArrayList<Node> NodesList;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//throws InterruptedException{
        String nodes = JOptionPane.showInputDialog("Enter the name of the network nodes ");
       nodes= nodes.toUpperCase().trim();
         NodesList=new ArrayList();
        HashSet<Character> NodeSet=new HashSet();   
        //!!!!need to be changed to split the string according to spaces
        for(int i=0; i<nodes.length();i++){
           if(Character.isLetter(nodes.charAt(i))){
              NodeSet.add(nodes.charAt(i));
            }
        }
        //Copy the set contents to an ArrayList
        Iterator<Character> iteratorSet=NodeSet.iterator();
        
         while(iteratorSet.hasNext()){
              Node n=new Node(iteratorSet.next());
              NodesList.add(n);            
        }
         Iterator<Node> iteratorList=NodesList.iterator();
         // threadObject.start();
         while(iteratorList.hasNext()){
             //threadObject.start();
             Node currentNode=iteratorList.next();
             char nodeName =currentNode.getName();
             String NO_nei = JOptionPane.showInputDialog("Enter the number of "+nodeName+"'s neighbors");
             int numberOfNeighbors = Integer.parseUnsignedInt(NO_nei);
             //**System.out.print(NodesList.size());
             if(numberOfNeighbors>=NodesList.size()){
                 System.err.print("ERROR: NETWORK TOPLOGY NOT CORRECT\n");
                 break;
             }
             DijkstraAlgorthim frame =new DijkstraAlgorthim(numberOfNeighbors,currentNode);
             frame.setTitle(nodeName+"'s Neighbors Information");
             frame.pack();
             frame.setLocationRelativeTo(null);
             //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//stop run when frame is closed
             frame.setVisible(true);
             //** threadObject.wait();
             //satatment to stop until frame info. submitted
         }
         /***Iterator<Node> iteratorList2=NodesList.iterator();
         while(iteratorList2.hasNext()){
             Node current=iteratorList2.next();
             System.out.println("......"+current.getNeighbor()+""+current.getName());
         }***/
         //!!!!Loop shoudn't reach this point until the button is clicked
         System.out.print("*******");
         //!!!!Input To enter src & dst nods    
    } 
    
    ArrayList<JTextField> nei_name = new ArrayList(); //array of text foelds foe neighbors names
    ArrayList<JTextField> nei_cost = new ArrayList(); //array of text foelds foe neighbors costs
    JButton SubmitNeighbors = new JButton("Submit Neighbors");
    
    public DijkstraAlgorthim(int numberOfNeighbors, Node currentNode){
        //Panel p1 to hold labels and text feilds
        JPanel p1 =new JPanel(new GridLayout(numberOfNeighbors,3));
        //Loop to add two fields for each neighbor
        for(int i=0;i<numberOfNeighbors;i++){
            nei_name.add(new JTextField(1));
            nei_cost.add(new JTextField(4));
            p1.add(new JLabel("Name"));
            p1.add(nei_name.get(i));
            p1.add(new JLabel("Cost"));
            p1.add(nei_cost.get(i));         
        }
        
        p1.setBorder(new TitledBorder("Enter nieghbors names and costs"));
        
        //panel p2 to hold the button
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(SubmitNeighbors);
        
        //add panels to the frame
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        //Register listners
        SubmitNeighbors.addActionListener(new ButtonListener(currentNode));
    }
    /** Handel the submit button **/
    private class ButtonListener implements ActionListener {
        Node currentNode=new Node();
        
        private ButtonListener(Node currentNode) {
            this.currentNode=currentNode;           
        }
           
        @Override
        public void actionPerformed(ActionEvent e){
            //Get values from text fields
            for(int i = 0; i<nei_name.size();i++){
                String newStringNode= nei_name.get(i).getText();
                char newNod=newStringNode.charAt(0);
                int newNodeCost=Integer.parseInt(nei_cost.get(i).getText());
                 //send nodes to Node Object HashMap >> setNeighbor
                 currentNode.setNeighbor(newNod, newNodeCost); 
                 System.out.print(currentNode.getName()+""+currentNode.getNeighbor());
                 clicked=true;
                
                 if (clicked){
                    dispose();
                    CalculatShortestPath();
                  
                 }
                //notify();
            }  
        }    
    }
    public void CalculatShortestPath(){
        Iterator<Node> iteratorList2=NodesList.iterator();
         while(iteratorList2.hasNext()){
             Node current=iteratorList2.next();
             System.out.println("!!!!!!!"+current.getNeighbor()+""+current.getName());
         }
    }
}