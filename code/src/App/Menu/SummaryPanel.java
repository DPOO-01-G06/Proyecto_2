package App.Menu;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import App.Start.StartFrame;

public class SummaryPanel extends JPanel implements ActionListener{
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
		nombre1 = new JLabel("Proyecto desarrollo urbano ");
		panelinfo.add(nombre1);
		
		autor = new JLabel("Autor: ");
		panelinfo.add(autor);
		autor1 = new JLabel("Pepito Perez ");
		panelinfo.add(autor1);
		
		tipo = new JLabel("Tipo: ");
		panelinfo.add(tipo);
		tipo1 = new JLabel("Construccion ");
		panelinfo.add(tipo1);
		
		descripcion = new JLabel("Descripcion ");
		panelinfo.add(descripcion);
		descripcion1 = new JLabel("Proyecto desarrollo urbano para bogota ");
		panelinfo.add(descripcion1);
		
		add(panelinfo, BorderLayout.CENTER );
		
		
		
		
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

    
}
