package App.Menu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import App.Start.StartFrame;


public class Botones1 extends JPanel implements ActionListener{
	private JButton nuevoCreador;
	private JButton cambiarCreador;
	private JButton nuevoTipo;
	private JButton descripcion;
	private StartFrame window;
	
	public Botones1(StartFrame pinterfaz){
		setLayout(new GridLayout(4,1));
		window= pinterfaz;
		nuevoCreador= new JButton("NUEVO ");
		nuevoCreador.setActionCommand("NUEVO");
		nuevoCreador.addActionListener(this);
		add(nuevoCreador);
		cambiarCreador= new JButton("CAMBIARCREADOR");
		cambiarCreador.setActionCommand("CAMBIARCREADOR");
		cambiarCreador.addActionListener(this);
		add(cambiarCreador);
		nuevoTipo= new JButton("TIPO ");
		nuevoTipo.setActionCommand("TIPO");
		nuevoTipo.addActionListener(this);
		add(nuevoTipo);
		descripcion= new JButton("DESCRIPCION ");
		descripcion.setActionCommand("DESCRIPCION");
		descripcion.addActionListener(this);
		add(descripcion);
		
	}
	
	

	

	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if (evento.equals("NUEVO")) {
			//interfaz.nuevoCreador();
		}
		else if (evento.equals("CAMBIARJUGADOR")) {
			//interfaz.cambiarJugador();
		}
		else if (evento.equals("TIPO")) {
			//interfaz.tipo();
		}
		else if (evento.equals("DESCRIPCION")) {
			//interfaz.descripcion();
		}
	}
}