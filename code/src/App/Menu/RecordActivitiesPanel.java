package App.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class RecordActivitiesPanel  extends JPanel{
	
	public RecordActivitiesPanel()
	{
		TitledBorder title = BorderFactory.createTitledBorder("Panel Actividades");
		setBorder(title);
		setSize(200, 200);
		setLayout(new GridLayout(2,2));
		
		JLabel act1 =new JLabel("actividad 1");
		act1.setBackground(Color.red);
		act1.setForeground(Color.red);
		add(act1);
		
		JLabel act2 =new JLabel("actividad 2");
		act2.setBackground(Color.green);
		act2.setForeground(Color.green);
		add(act2);
		
		JLabel act3 =new JLabel("actividad 3");
		act3.setBackground(Color.green);
		act3.setForeground(Color.green);
		add(act3);
		
		JLabel act4 =new JLabel("actividad 4");
		act4.setBackground(Color.red);
		act4.setForeground(Color.red);
		add(act4);
		
	}

}
