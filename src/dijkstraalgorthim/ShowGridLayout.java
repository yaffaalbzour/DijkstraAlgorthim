/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraalgorthim;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
/**
 *
 * @author yaffa
 */
public class ShowGridLayout extends JFrame {
    public ShowGridLayout(int numberOfNeighbors, char nodeName){//loop on #nei to print layout
        setLayout(new GridLayout(numberOfNeighbors,2,5,5));
        add(new JLabel("Neighbors of Node"+nodeName));
        for(int i=0;i<numberOfNeighbors;i++){
            add(new JLabel("name"));
            add(new JTextField(1));
            add(new JLabel("Cost"));
            add(new JTextField(4));         
        }
        add(new JButton("done"));
    }

    
}
