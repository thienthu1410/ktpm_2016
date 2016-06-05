package GUI;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import shape.shapes.Rectangle;
import shape.type.ShapeSample;
import shapeMachine.Pencil;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import GUI.support.*;

@SuppressWarnings("serial")
public class RectangleView extends JDialog {

	private  JPanel contentPanel = new JPanel();
	private JTextField txtFieldHeight = new JTextField();
	private JLabel lblChiuRng = new JLabel("Chiều rộng");
	private JLabel lblChiuDi = new JLabel("Chiều dài");
	private JTextField txtFieldWidth = new JTextField();
	private JTextArea textArea = new JTextArea();
	
	private Pencil pencil = new Pencil();
	private Rectangle rectangle = (Rectangle) pencil.draw(ShapeSample.RECTANGLE);
	private DataChecker checkKey = new DataChecker();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RectangleView dialog = new RectangleView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void changeRectangle()
	{
		try
		{	
			float width = Float.parseFloat(txtFieldWidth.getText());
			float height = Float.parseFloat(txtFieldHeight.getText());
			
			rectangle.setHeigt(height);
			rectangle.setWidth(width);
			
			textArea.setText("Diện tích: " + Float.toString(rectangle.findArea()) + 
								"\nChu vi: " + Float.toString(rectangle.findPerimeter()));
			
			
		}
		
		catch(Exception e)
		{
			//textArea.setText("Dữ liệu không hợp lệ");
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public RectangleView() {
		setTitle("Hình chữ nhật");
		txtFieldWidth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				changeRectangle();
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				String s = txtFieldWidth.getText() + arg0.getKeyChar();				
				if (!checkKey.canAddMore(s, arg0))
				{
					arg0.consume();
					
				}																			
				}
				
			
			
		});

		txtFieldWidth.setColumns(10);
		txtFieldHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				changeRectangle();
				
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String s = txtFieldHeight.getText() + arg0.getKeyChar();
				
					if (!checkKey.canAddMore(s, arg0))
					{
						arg0.consume();
						
					}
					
									
					
					
				
				
			}
			
		});
		txtFieldHeight.setColumns(10);
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(125, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblChiuRng, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChiuDi, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtFieldHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFieldWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(129))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChiuDi)
						.addComponent(txtFieldHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChiuRng)
						.addComponent(txtFieldWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
		);
		textArea.setEditable(false);
		
		
		scrollPane.setViewportView(textArea);
		contentPanel.setLayout(gl_contentPanel);
	}
}
