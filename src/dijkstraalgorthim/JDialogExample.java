package dijkstraalgorthim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.TitledBorder;
class JDialogExample extends JFrame{

    ArrayList<JTextField> nei_name = new ArrayList(); //array of text foelds foe neighbors names
    ArrayList<JTextField> nei_cost = new ArrayList(); //array of text foelds foe neighbors costs
    JButton SubmitNeighbors = new JButton("Submit Neighbors");
 public JDialogExample(int numberOfNeighbors, Node currentNode){
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
                 
            }      
       
        }
    }
}