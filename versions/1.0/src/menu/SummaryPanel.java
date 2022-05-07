package menu;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import start.MainWindow;

public class SummaryPanel extends JPanel {
	private JLabel nombre;
	private JLabel autor;
	private JLabel tipo;
	private JLabel descripcion;
	private JLabel nombre1;
	private JLabel autor1;
	private JLabel tipo1;
	private JLabel descripcion1;
	
    public SummaryPanel() {
		setSize(200, 400);
		
		TitledBorder title = BorderFactory.createTitledBorder("Resumen Proyecto");
		setBorder(title);
		
		setLayout(new BorderLayout());
		
		JPanel panelinfo= new JPanel();
		panelinfo.setLayout(new GridLayout(4,2));
		nombre = new JLabel("Nombre: ");
		panelinfo.add(nombre);
		nombre1 = new JLabel("cree un nuevo proyecto ");
		panelinfo.add(nombre1);
		
		autor = new JLabel("Autor: ");
		panelinfo.add(autor);
		autor1 = new JLabel("...... ");
		panelinfo.add(autor1);
		
		tipo = new JLabel("Tipo: ");
		panelinfo.add(tipo);
		tipo1 = new JLabel("......");
		panelinfo.add(tipo1);
		
		descripcion = new JLabel("Descripcion ");
		panelinfo.add(descripcion);
		descripcion1 = new JLabel("....... ");
		panelinfo.add(descripcion1);
		
		add(panelinfo, BorderLayout.CENTER );
		
    }
	
	public void actualizar( String nombre, String autor, String tipo, String descripcion)
	{
		nombre1.setText(nombre);
		autor1.setText(autor);
		tipo1.setText(tipo);
		descripcion1.setText(descripcion);
	}

    
}
