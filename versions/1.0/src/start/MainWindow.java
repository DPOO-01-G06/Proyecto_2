package start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import logic.Activity;
import logic.Participant;
import logic.Project;
import menu.Botones1;
import menu.Botones2;
import menu.ProjectPanel;
import menu.RecordActivitiesPanel;
import menu.SummaryPanel;


public class MainWindow extends JFrame{

	private String icondir = "assets/icon.png";
	private boolean hasAccess = false;
	private Participant user = null;
	private JPanel centrePanel;
	static Project proyecto;
	private RecordActivitiesPanel actividad;
	private ProjectPanel pproyecto;
	private SummaryPanel resumen;
	static HashMap<String,Participant> participants = new HashMap<String,Participant>();

	public MainWindow() throws Exception {
		// Basics of window
		setLayout(new BorderLayout());
		setTitle("Beesy");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Image
		ImageIcon original = new ImageIcon(icondir);
		int width = original.getIconWidth() / 2;
		int height = original.getIconHeight() / 2;
		ImageIcon scaledIcon = new ImageIcon(original.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		JLabel iconLabel = new JLabel(scaledIcon);
		setIconImage(original.getImage());
		// Components
		this.proyecto=null;
		this.participants = new HashMap<String,Participant>();
		serializeDataInProy();
		serializeDataInUser();
		// North
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.setBackground(Color.WHITE);
		northPanel.add(iconLabel, BorderLayout.NORTH);
		northPanel.add(new JLabel("Beesy",SwingConstants.CENTER), BorderLayout.SOUTH);
		add(northPanel, BorderLayout.NORTH);
		// Centre
		centrePanel = new JPanel();
		centrePanel.setBackground(Color.WHITE);
		// I already have an account / Sign up
		String[] options = {"Sign up", "I already have an account"};
		int result = JOptionPane.showOptionDialog(null, "Do you have an account?", "Sign up", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (result == 0) {
			// Sign up
			centrePanel.add(new SignUpPanel(this));
		} else {
			// Sign In
			centrePanel.add(new SignInPanel(this));
		}
		add(centrePanel, BorderLayout.CENTER);
		// Show
		setVisible(true);
	}
	public static void main(String[] args){
		try {
			new MainWindow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void next() {
		remove(centrePanel);
		centrePanel=new JPanel();
		centrePanel.setBackground(Color.WHITE);
		centrePanel.setLayout(new BorderLayout());
		JPanel act= new JPanel();
		act.setLayout(new GridLayout(1,2));
		actividad=new RecordActivitiesPanel();
		act.add(actividad);
		pproyecto=new ProjectPanel(this);
		act.add(pproyecto);
		centrePanel.add(act, BorderLayout.CENTER);
		resumen=new SummaryPanel();
		centrePanel.add(resumen, BorderLayout.SOUTH);
		add(centrePanel, BorderLayout.CENTER);
		repaint();
		SwingUtilities.updateComponentTreeUI(centrePanel);	
		if (proyecto!=null)
		{
			actualizarProyecto();
			if(proyecto.getactivities().size()!=0)
			{
				actualizarActivity();
			}
		}

	}
	public void sign(String pCorreo, String nombre, String contrasena)
	{
		Participant usuario =new Participant(pCorreo, nombre, contrasena);
		addParticipant(usuario);
		try {
			serializeDataOutUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(this, "se ha creado su usuario exitosamente, por favor inicie sesion");
		remove(centrePanel);
		centrePanel = new JPanel();
		centrePanel.setBackground(Color.WHITE);
		centrePanel.add(new SignInPanel(this));
		add(centrePanel, BorderLayout.CENTER);
		SwingUtilities.updateComponentTreeUI(centrePanel);

	}
	public void sign2()
	{
		JOptionPane.showMessageDialog(this, "no se ha encontrado al usuario cree su cuenta");
		remove(centrePanel);
		centrePanel = new JPanel();
		centrePanel.setBackground(Color.WHITE);
		centrePanel.add(new SignUpPanel(this));
		add(centrePanel, BorderLayout.CENTER);
		SwingUtilities.updateComponentTreeUI(centrePanel);	

	}
	public void validar(String correo, String password)
	{
		Participant buscar = getparticipant(correo);
		if (buscar!=null)
		{
			if(buscar.getContrasena().equals(password))
			{
				user=buscar;
				next();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "datos incorrectos");
			}
		}
		else
		{
			sign2();
		}
	}
	public void newProject(String name, String descripcion, String tipo)
	{
		Date date = new Date();
		@SuppressWarnings("deprecation")
		Date datef = new Date(31,01,2030);
		proyecto= new Project(name, date.toGMTString(), datef.toGMTString(), user, 1, tipo, descripcion);
		try {
			serializeDataOut();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actualizarProyecto();
	}
	public void newactivity(String title, String description, String tipo)
	{
		if (proyecto==null)
		{
			JOptionPane.showMessageDialog(this, "no se ha creado ningun proyecto");
		}
		else
		{
			proyecto.addActivity(new Activity(title, user, description, tipo, proyecto.getactivities().size(), proyecto.getID()));
			actualizarActivity();
		}

	}
	public void actualizarProyecto()
	{
		resumen.actualizar(proyecto.getNombre(), user.getNombre(), proyecto.getTipo(), proyecto.getDescripcion());
	}

	public void actualizarActivity()
	{
		actividad.Actualizar(proyecto.getactivities());
	}


	public void addParticipant(Participant participant) {
		participants.put(participant.getCorreo(),participant);
	}
	public Participant getparticipant(String correo)
	{
		return participants.get(correo);
	}



	public static void serializeDataOut()throws IOException{
		String fileName= "./Data/InfoProy.txt";
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.reset();
		oos.writeObject(proyecto);
		oos.close();
	}
	public static void serializeDataOutUser()throws IOException{
		String fileName= "./Data/InfoUser.txt";
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.reset();
		oos.writeObject(participants);
		oos.close();
	}

	public static void serializeDataInProy() {

		try {
			String fileName= "./Data/InfoProy.txt";
			FileInputStream fin = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fin);
			Object iHandler=  ois.readObject();
			ois.close();
			proyecto=(Project) iHandler;

		} catch (EOFException  e) {

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
	public static void serializeDataInUser() {

		try {
			String fileName= "./Data/InfoUser.txt";
			FileInputStream fin= new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fin);
			Object iHandler=  ois.readObject();
			ois.close();
			participants=(HashMap<String, Participant>) iHandler;
		} catch (EOFException  e) {

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
}
