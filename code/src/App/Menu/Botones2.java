package App.Menu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import App.Start.StartFrame;


public class Botones2 extends JFrame implements ActionListener{
	
	private JLabel cambiarCreador;
	private JTextField cambiarCreadortxt;
	private JLabel descripcion;
	private JTextField descripciontxt;
	private JButton cancelar;
	private JButton guardar;
	private StartFrame window;
	
	public Botones2(StartFrame pinterfaz){
		setTitle("Nuevo proyecto");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5,2));
		
		window= pinterfaz;
		
		cambiarCreador= new JLabel("Nombre Actividad: ");
		add(cambiarCreador);
		cambiarCreadortxt = new JTextField();
		cambiarCreadortxt.setEditable(true);
		add(cambiarCreadortxt);
		
		
		descripcion= new JLabel("Descripcion: ");
		add(descripcion);
		descripciontxt = new JTextField();
		descripciontxt.setEditable(true);
		add(descripciontxt);
		
		
		cancelar = new JButton("Cancelar ");
		cancelar.setActionCommand("cancelar");
		cancelar.addActionListener(this);
		add(cancelar);
		
		
		guardar= new JButton("Guardar");
		guardar.setActionCommand("guardar");
		guardar.addActionListener(this);
		add(guardar);
		
		setVisible(true);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if (evento.equals("guardar")) {
			//interfaz.actividad();
		}

		else {
			//interfaz.proyecto();
		}
	}

}
