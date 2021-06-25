package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import commons.Constants;

public class CenterPanel extends JPanel implements ChangeListener,commons.Constants{
	JTabbedPane  thumb;
	public CenterPanel () {
		this.setBackground (new Color (207, 235, 173));
		GridBagConstraints constraints = new GridBagConstraints ();
		this.setLayout (new GridBagLayout ());
		constraints.insets = new Insets (10, 10, 10 ,10);
		
		
		// container with thumb
		
		thumb = new JTabbedPane () ;
		for (int i=0 ; i<Constants.THUMB.length ; i++) {
		JLabel etiquette = new JLabel (Constants.THUMB [i] );
		etiquette.setBackground (new Color (232, 242, 159));
		thumb.add (Constants.THUMB [i] , etiquette);
		} // for
		
		thumb.addChangeListener (this);
		constraints.gridx = 0;
		constraints.gridheight = 1; 
		/*contraintes.fill=GridBagConstraints.BOTH;*/
		this.add (thumb, constraints) ;

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
}
