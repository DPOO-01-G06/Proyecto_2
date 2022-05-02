package App.Menu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import App.Start.StartFrame;


public class Botones2 extends JPanel implements ActionListener{
	private JButton actividad;
	private JButton proyecto;
	private StartFrame interfaz;
	
	public Botones2(StartFrame pinterfaz){
		setLayout(new GridLayout(4,1));
		interfaz= pinterfaz;
		actividad= new JButton("NUEVO ");
		actividad.setActionCommand("NUEVO");
		actividad.addActionListener(this);
		add(actividad);
		proyecto = new JButton("DESCRIPCION ");
		proyecto.setActionCommand("DESCRIPCION");
		proyecto.addActionListener(this);
		add(proyecto);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if (evento.equals("NUEVO")) {
			//interfaz.actividad();
		}

		else if (evento.equals("PROYECTO")) {
			//interfaz.proyecto();
		}
	}

}
