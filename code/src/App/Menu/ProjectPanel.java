package App.Menu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.*;  
import java.awt.event.*;  

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import App.Logic.Activity;
import OldLogic.Participant;

public class ProjectPanel extends JPanel implements ActionListener{
	private JButton actividad;
	private JButton proyecto;
	private StartFrame mainWindow;

 
 
	public ProjectPanel() {
		setSize(200, 200);
		// Components
		setLayout(new GridLayout(4,1));
		actividad = new JButton("Add Activity");
		actividad.setActionCommand("Add Activity");
		actividad.addActionListener(this);
		add(actividad);
		proyecto= new JButton("New Proyect ");
		proyecto.setActionCommand("New Proyect");
		proyecto.addActionListener(this);
		add(proyecto);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}