package source;

import static source.Principal.CenterLabel;
import static source.Principal.frame;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import	java.awt.*;
import	java.awt.event.*;

import	javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.SpringLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import net.miginfocom.swing.MigLayout;

import javax.swing.LayoutStyle.ComponentPlacement;

public class Principal extends JFrame {
	static Statement stm;
	
	private JPanel AplicationPanel;
	private JTextField Usertext;
	private JPasswordField passwordText;
	static  JLabel CenterLabel = new JLabel("");
	private JButton btnNewButton_1 = new JButton("Load position of the P3DX");
	static Principal frame;
	static boolean stop_button=true;
	static boolean New_Position=false;
	static boolean Load_Map=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Principal();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 583);
		AplicationPanel = new JPanel();
		AplicationPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AplicationPanel);
		
		JPanel LoginPanel = new JPanel();
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBorder(null);
		
		JPanel UVIcon = new JPanel();
		UVIcon.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JPanel CenterPanel = new JPanel();
		CenterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		CenterPanel.setAutoscrolls(true);
		
		JPanel OptionPanel = new JPanel();
		CenterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		CenterLabel.setBounds(0, 0, 277, 207);
		CenterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CenterPanel.add(CenterLabel);
		CenterLabel.setIcon(new ImageIcon("D:\\Documents\\Docs\\Univalle\\Semestre_10\\Interfaces\\Eclipse\\Interfaz_Proyecto_Final2\\src\\source\\pioneer3dx_real.PNG"));
		UVIcon.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		LoginPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblInsertUserName = new JLabel("Insert User Email");
		lblInsertUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		LoginPanel.add(lblInsertUserName);
		
		Usertext = new JTextField();
		LoginPanel.add(Usertext);
		Usertext.setColumns(10);
		
		JLabel PasswordText = new JLabel("Insert Your Password");
		PasswordText.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordText.setFont(new Font("Tahoma", Font.BOLD, 12));
		LoginPanel.add(PasswordText);
		
		passwordText = new JPasswordField();
		LoginPanel.add(passwordText);
		OptionPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop_button=false;
				GetOdometry.empezar();
				btnNewButton_1.setEnabled(false);
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		OptionPanel.add(btnNewButton_1);
		
		JPanel IconRobot = new JPanel();
		
		JPanel panel = new JPanel();
		
		JLabel UVLabel = new JLabel("");
		UVLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UVLabel.setIcon(new ImageIcon("D:\\Documents\\Docs\\Univalle\\Semestre_10\\Interfaces\\Eclipse\\Interfaz_Proyecto_Final2\\src\\source\\univalle37x50.gif"));
		
		GroupLayout gl_AplicationPanel = new GroupLayout(AplicationPanel);
		gl_AplicationPanel.setHorizontalGroup(
			gl_AplicationPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_AplicationPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_AplicationPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AplicationPanel.createSequentialGroup()
							.addComponent(IconRobot, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(TitlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(UVLabel)
							.addGap(34))
						.addGroup(gl_AplicationPanel.createSequentialGroup()
							.addComponent(CenterPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addGroup(gl_AplicationPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(LoginPanel, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
								.addComponent(OptionPanel, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
							.addGap(8)))
					.addGap(245)
					.addComponent(UVIcon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_AplicationPanel.setVerticalGroup(
			gl_AplicationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AplicationPanel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_AplicationPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AplicationPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(UVIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(IconRobot, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(TitlePanel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(UVLabel))
					.addGap(18)
					.addGroup(gl_AplicationPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AplicationPanel.createSequentialGroup()
							.addComponent(OptionPanel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(LoginPanel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
							.addContainerGap(66, Short.MAX_VALUE))
						.addGroup(gl_AplicationPanel.createSequentialGroup()
							.addComponent(CenterPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		JButton LoginButton = new JButton("Log In");
		LoginButton.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
	                LogActionPerformed(evt);
	            }
		});
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(LoginButton);
		
		JButton btnCloseSession = new JButton("Close Session");
		btnCloseSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop_button=true;
				New_Position=false;
				Load_Map=false;
            	btnNewButton_1.setEnabled(false);
            	CenterLabel.setIcon(new ImageIcon("D:\\Documents\\Docs\\Univalle\\Semestre_10\\Interfaces\\Eclipse\\Interfaz_Proyecto_Final2\\src\\source\\pioneer3dx_real.PNG"));
        		
			}
		});
		panel.add(btnCloseSession);
		TitlePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel TitleLabel = new JLabel("Interface with the P3DX Map");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		TitlePanel.add(TitleLabel);
		IconRobot.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel RobotLabel = new JLabel("");
		RobotLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RobotLabel.setIcon(new ImageIcon("D:\\Documents\\Docs\\Univalle\\Semestre_10\\Interfaces\\Eclipse\\Interfaz_Proyecto_Final2\\src\\source\\pioner2.gif"));
		
		IconRobot.add(RobotLabel);
		gl_AplicationPanel.setAutoCreateGaps(true);
		gl_AplicationPanel.setAutoCreateContainerGaps(true);
		AplicationPanel.setLayout(gl_AplicationPanel);
		
	}
	
	
	
	private void LogActionPerformed(java.awt.event.ActionEvent evt) {
	        String UserEmail = (Usertext.getText());
	        char[] AuxPassword = passwordText.getPassword();
	        String UserPass = String.valueOf(AuxPassword);
	        int ValidUser=0, ValidPass=0, ValidSchedule=0, ValidAcces=0;
	        stm=ConnectDB.Connect();
	        String pedido="";
	        ResultSet rs=null;
	        Date date = new Date();
	        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
	       
	        rs = SelectUsuario.SelectR(stm);
	        try
	        {
	            while(rs.next())
	            {
	                String valEmail = rs.getString("email");
	                if (valEmail.equals(UserEmail))
	                {
	                    ValidUser=1;
	                }
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	                }

	        pedido="clave";
	        String valPass=SelectUsuario.SelectRunico(stm, UserEmail, pedido);
	        if (valPass.equals(UserPass))
	        {
	            ValidPass=1;
	        }

	        pedido="id";
	        String IDUsuario=SelectUsuario.SelectRunico(stm, UserEmail, pedido);
	        int accion=1;
	        String procesoD="1";
	        rs = SelectUsuario.Programacion(stm, accion, procesoD, IDUsuario);
	        try
	        {
	            while(rs.next())
	            {
	                String valHoraInicio = rs.getString("UP.hora_inicio");
	                String valHoraFinal = rs.getString("UP.hora_fin");
	                int comparison = hourFormat.format(date).compareTo(valHoraInicio);
	                int comparison1 = hourFormat.format(date).compareTo(valHoraFinal);
	                if ((comparison>=1)&&(comparison1<0))
	                {
	                    ValidSchedule=1;
	                }
	                else
	                    {
	                    ValidSchedule=0;
	                }
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	                }
	        
	                if((ValidUser==1)&&(ValidPass==1))
	                    {
	                	if(ValidSchedule==1)
	                	{
	                		
	                		btnNewButton_1.setEnabled(true);
	                		stop_button=false;
	                		New_Position=true;
	                		MapThread.empezar();
	                		CenterLabel.setIcon(new ImageIcon("D:\\Documents\\Docs\\Univalle\\Semestre_10\\Interfaces\\Eclipse\\Interfaz_Proyecto_Final2\\src\\source\\reloj.PNG"));
	                		frame.pack();
	                	}
	                	
	                	else
	                	{
	                		JOptionPane.showMessageDialog(null, "Check Your Schedule");
	                	}
	                	
	                	
	                    }
	                else
	                {
	                	JOptionPane.showMessageDialog(null, "wrong Login");
	                }
	                ConnectDB.CloseDB();



	    }//GEN-LAST:event_LogActionPerformed

}
