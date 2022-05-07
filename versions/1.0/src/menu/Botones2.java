package menu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import start.MainWindow;


public class Botones2 extends JFrame implements ActionListener{
	
	private JLabel cambiarCreador;
	private JTextField cambiarCreadortxt;
	private JLabel descripcion;
	private JTextField descripciontxt;
	private JLabel nuevoTipo;
	private JTextField nuevoTipotxt;
	private JButton cancelar;
	private JButton guardar;
	private MainWindow window;
	
	public Botones2(MainWindow pinterfaz){
		setTitle("Nueva actividad");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5,2));
		
		window= pinterfaz;
		
		cambiarCreador= new JLabel("Nombre Actividad: ");
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
			window.newactivity(cambiarCreadortxt.getText(), descripciontxt.getText(), nuevoTipotxt.getText());
			setVisible(false);
		}

		else {
			setVisible(false);
		}
	}

}
