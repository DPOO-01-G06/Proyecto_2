package App.Menu;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import App.Start.StartFrame;


public class Botones1 extends JFrame implements ActionListener{
	private JLabel nuevoCreador;
	private JTextField nuevoCreadortxt;
	private JLabel cambiarCreador;
	private JTextField cambiarCreadortxt;
	private JLabel nuevoTipo;
	private JTextField nuevoTipotxt;
	private JLabel descripcion;
	private JTextField descripciontxt;
	private JButton cancelar;
	private JButton guardar;
	private StartFrame window;
	
	public Botones1(StartFrame pinterfaz){
		setTitle("Nuevo proyecto");
		setSize(300, 300);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(5,2));
		
		window= pinterfaz;
		
		nuevoCreador= new JLabel("Creador: ");
		add(nuevoCreador);
		nuevoCreadortxt = new JTextField();
		nuevoCreadortxt.setEditable(true);
		add(nuevoCreadortxt);
		
		cambiarCreador= new JLabel("Nombre proyecto: ");
		add(cambiarCreador);
		cambiarCreadortxt = new JTextField();
		cambiarCreadortxt.setEditable(true);
		add(cambiarCreadortxt);
		
		
		nuevoTipo= new JLabel("Tipo: ");
		add(nuevoTipo);
		nuevoTipotxt = new JTextField();
		nuevoTipotxt.setEditable(true);
		add(nuevoTipotxt);
		
		
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
			
		}
		else  {
			
		}
		
	}

}