package menu;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import start.MainWindow;


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
	private MainWindow window;
	
	public Botones1(MainWindow pinterfaz){
		setTitle("Nuevo proyecto");
		setSize(300, 300);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(4,2));
		
		window= pinterfaz;
		
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
			window.newProject(cambiarCreadortxt.getText(), descripciontxt.getText(), nuevoTipotxt.getText());
			setVisible(false);
		}
		else  {
			setVisible(false);
		}
		
	}

}