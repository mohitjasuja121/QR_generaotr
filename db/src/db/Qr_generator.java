package db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import net.glxn.qrgen.image.ImageType;
import com.google.zxing.*;
import com.google.zxing.client.j2se.*;
import com.google.zxing.qrcode.encoder.QRCode;
import javax.swing.DropMode;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JProgressBar;


public class Qr_generator {

	private JFrame frame;
	 ByteArrayOutputStream bout = null;
	 JFileChooser j = null;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Qr_generator window = new Qr_generator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Qr_generator() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 1257, 732);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		// frame.setUndecorated(true);
		
		JLabel j1 = new JLabel("Enter Text  :");
		j1.setBackground(Color.BLACK);
		j1.setForeground(Color.BLACK);
		j1.setToolTipText("text to be converted into QR code");
		j1.setFont(new Font("Perpetua", Font.BOLD, 27));
		j1.setBounds(728, 92, 171, 67);
		frame.getContentPane().add(j1);
		
		
		
		
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(728, 157, 500, 320);
		frame.getContentPane().add(scrollPane);
		
		JTextArea t1 = new JTextArea();
		scrollPane.setViewportView(t1);
		t1.setWrapStyleWord(true);
		t1.setBackground(new Color(255, 255, 255));
		t1.setForeground(new Color(51, 102, 51));
		t1.setFont(new Font("Perpetua", Font.BOLD, 23));
		
		
		JButton b1 = new JButton("Generate");
		b1.setBackground(Color.RED);
		b1.setForeground(SystemColor.desktop);
		b1.setFont(new Font("Perpetua", Font.BOLD, 28));
		b1.setBounds(750, 575, 453, 89);
		frame.getContentPane().add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				bout = Db.Qr(t1.getText());
				try{

				 File ob = j.getSelectedFile();
		            FileOutputStream out = new FileOutputStream(ob);
		            bout.writeTo(out);
		            out.flush();
		            out.close();
		            JOptionPane.showMessageDialog(null, "Success");
				
				}catch(Exception R){
					JOptionPane.showMessageDialog(null, "Add .png extension in filename");
				}
			}
		});
		
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(-18, -17, 703, 749);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		panel.add(label);
		label.setBackground(new Color(0, 102, 51));
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setIcon(new ImageIcon(Qr_generator.class.getResource("/images/tech.jpg")));
		label.setForeground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(739, 70, 464, -42);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(684, 0, 567, 62);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel = new JLabel("QR_Generator");
		lblNewLabel.setForeground(new Color(51, 0, 0));
		lblNewLabel.setFont(new Font("Perpetua", Font.BOLD, 28));
		panel_2.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Change location");
		btnNewButton.setFont(new Font("Perpetua", Font.ITALIC, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j = new JFileChooser();
				j.setDialogTitle("save");
				
			int result=	j.showSaveDialog(null);
			j.removeChoosableFileFilter(j.getAcceptAllFileFilter()); // remove all files part
			FileFilter ff = new FileNameExtensionFilter("Image Files", "png" , "jpg" , "jpeg"); //filtering extension
			j.addChoosableFileFilter(ff); 
			j.setFileFilter(ff); //default
			j.setMultiSelectionEnabled(false);
				
				
			}
		});
		btnNewButton.setBounds(728, 500, 200, 30);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		
		
		
	}
}
