package App.Menu;

import java.awt.*;  
import java.awt.event.*;  

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import App.Start.StartFrame;

public class ProjectPanel extends JPanel implements ActionListener{
	private JButton actividad;
	private JButton proyecto;
	private StartFrame mainWindow;

	public ProjectPanel(StartFrame mainWindow) {
		
		this.mainWindow=mainWindow;
		TitledBorder title = BorderFactory.createTitledBorder("Panel Proyecto");
		setBorder(title);
		setSize(200, 200);
		// Components
		setLayout(new GridLayout(2,1));
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
		String evento =arg0.getActionCommand();
		if (evento.equals("Add Activity"))
		{
			new Botones2(mainWindow);
		}
		else
		{
			new Botones1(mainWindow);
		}
		
	}
}