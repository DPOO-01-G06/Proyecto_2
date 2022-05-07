package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logic.Activity;

public class RecordActivitiesPanel  extends JPanel implements ActionListener{

	private JButton act1;
	private JButton act2;
	private JButton act3;
	private JButton act4;
	private Activity activ1;
	private Activity activ2;
	private Activity activ3;
	private Activity activ4;


	public RecordActivitiesPanel()
	{
		TitledBorder title = BorderFactory.createTitledBorder("Panel Ultimas Actividades");
		setBorder(title);
		setSize(200, 200);
		setLayout(new GridLayout(2,2));

		act1 =new JButton("actividad 1");
		act1.setActionCommand("1");
		act1.addActionListener(this);
		act1.setBackground(Color.red);
		act1.setForeground(Color.red);
		act1.setEnabled(false);
		add(act1);

		act2 =new JButton("actividad 2");
		act2.setActionCommand("2");
		act2.addActionListener(this);
		act2.setBackground(Color.green);
		act2.setForeground(Color.green);
		act2.setEnabled(false);
		add(act2);

		act3 =new JButton("actividad 3");
		act3.setActionCommand("3");
		act3.addActionListener(this);
		act3.setBackground(Color.green);
		act3.setForeground(Color.green);
		act3.setEnabled(false);
		add(act3);

		act4 =new JButton("actividad 4");
		act4.setActionCommand("4");
		act4.addActionListener(this);
		act4.setBackground(Color.red);
		act4.setForeground(Color.red);
		act4.setEnabled(false);
		add(act4);

	}

	public void Actualizar(ArrayList<Activity> lista)
	{
		int cual=1;
		for(int i =lista.size()-1; i>-1;i--)
		{
			Activity elemento = lista.get(i);
			if (cual==1)
			{
				act1.setText(elemento.getTitle());
				act1.setEnabled(true);
				activ1=elemento;
			}
			else if (cual==2)
			{
				act2.setText(elemento.getTitle());
				act2.setEnabled(true);
				activ2=elemento;
			}
			else if (cual==3)
			{
				act3.setText(elemento.getTitle());
				act3.setEnabled(true);
				activ3=elemento;
			}
			else if (cual==4)
			{
				act4.setText(elemento.getTitle());
				act4.setEnabled(true);
				activ4=elemento;
				break;
			}

			cual++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String evento = arg0.getActionCommand();
		if (evento.equals("1"))
		{
			detalles(activ1);
		}
		else if (evento.equals("2"))
		{
			detalles(activ2);
		}
		else if (evento.equals("3"))
		{
			detalles(activ3);
		}
		else if (evento.equals("4"))
		{
			detalles(activ4);
		}

	}
	public void detalles(Activity cual)
	{
		String mensaje = "nombre: "+cual.getTitle()+"\nDescripcion: "+cual.getDescription()+"\nTipo: "+ cual.getType();
		JOptionPane.showMessageDialog(this, mensaje);
	}

}
