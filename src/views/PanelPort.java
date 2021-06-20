package views;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.controller;
/**
 * The {@code PanelPort} class from {@code view} package is class which allow to display a JCombobox to choose the port
 * and display the localisation.
 * @author Alexandre LENFANTIN
 *
 */

public class PanelPort extends JPanel /*implements*/{
	JComboBox ports = new JComboBox();
	GridBagConstraints constraints = new GridBagConstraints ();

	public PanelPort () {
		
		constraints.fill = GridBagConstraints.BOTH ;
		constraints.insets = new Insets (10,10,10,10);
		
		/*for (int i =0; i< portsName.length();i++) {
			ports.addItem(portsName[i]);
		}*/
		
		//Add constraints on the JComboBox
		constraints.gridx = 0; constraints.gridy = 0;
		constraints.gridheight = 2;
		this.add(ports,constraints);
		
	
	}
	
	/*public void recordListenner(controller controller) {
		for (int monthIndex = 0 ; monthIndex< MONTHS_NAME.length ; monthIndex++)
		{
			for(DateButton bt : monthPanel[monthIndex].arJButton)
			{
				bt.addActionListener(controller);
			}
		}
	}*/
}
