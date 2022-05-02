package App.Menu;

public class SummaryPanel extends JFrame {
    private JButton nuevoCreador;
	private JButton cambiarCreador;
	private JButton nuevoTipo;
	private JButton descripcion;
	private StartFrame window;

    public SummaryPanel() {
		setTitle("Record Activities");
		setSize(150, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Components
		setLayout(new GridLayout(4,1));
		window= pinterfaz;
		nuevoCreador= new JButton("NUEVO ");
		nuevoCreador.setActionCommand("NUEVO");
		nuevoCreador.addActionListener(this);
		add(nuevoCreador);
		nuevoTipo= new JButton("TIPO ");
		nuevoTipo.setActionCommand("TIPO");
		nuevoTipo.addActionListener(this);
		add(nuevoTipo);
		descripcion= new JButton("DESCRIPCION ");
		descripcion.setActionCommand("DESCRIPCION");
		descripcion.addActionListener(this);
		add(descripcion);
		// Show
		setVisible(true);
    }

    
}
