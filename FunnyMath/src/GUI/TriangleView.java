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

import shape.shapes.Triangle;
import shape.triangle.TriangleType;
import shape.type.ShapeSample;
import shapeMachine.Pencil;
import shapeSupport.IsTriangle;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import languageSupport.VietnameseTranslator;
import GUI.support.*;

@SuppressWarnings("serial")
public class TriangleView extends JDialog {

	private  JPanel contentPanel = new JPanel();
	private JTextField txtFieldA = new JTextField();
	private JLabel lblB = new JLabel("Cạnh thứ hai");
	private JLabel lblA = new JLabel("Cạnh thứ nhất");
	private JTextField txtFieldB = new JTextField();
	private JTextArea textArea = new JTextArea();
	
	private Pencil pencil = new Pencil();
	private Triangle triangle = (Triangle) pencil.draw(ShapeSample.TRIANGLE);
	private DataChecker checkKey = new DataChecker();
	private  JLabel lblC = new JLabel("Cạnh thứ ba");
	private  JTextField txtFieldC = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TriangleView dialog = new TriangleView();
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
			float b_edge_value = Float.parseFloat(txtFieldB.getText());
			float a_edge_value = Float.parseFloat(txtFieldA.getText());
			float c_edge_value = Float.parseFloat(txtFieldC.getText());
			
			boolean isTriangle = new IsTriangle().check(a_edge_value, b_edge_value, c_edge_value);
			
			if (!isTriangle)
				textArea.setText(VietnameseTranslator.translateToThisLangugage(TriangleType.NULL));
			else
			{
				triangle.setA(a_edge_value);
				triangle.setB(b_edge_value);
				triangle.setC(c_edge_value);
				textArea.setText(triangle.typeToStr() + "\nDiện tích: " + Float.toString(triangle.findArea()) + 
									"\nChu vi: " + Float.toString(triangle.findPerimeter()));
			}
			
			
		}
		
		catch(Exception e)
		{
			//textArea.setText("Dữ liệu không hợp lệ");
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public TriangleView() {
		txtFieldC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				changeRectangle();
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				String s = txtFieldC.getText() + arg0.getKeyChar();				
				if (!checkKey.canAddMore(s, arg0))
				{
					arg0.consume();
					
				}																			
				}
				
			
			
		});
		txtFieldC.setColumns(10);
		
		setTitle("Hình tam giác");
		txtFieldB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				changeRectangle();
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				String s = txtFieldB.getText() + arg0.getKeyChar();				
				if (!checkKey.canAddMore(s, arg0))
				{
					arg0.consume();
					
				}																			
				}
				
			
			
		});

		txtFieldB.setColumns(10);
		txtFieldA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				changeRectangle();
				
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String s = txtFieldA.getText() + arg0.getKeyChar();
				
					if (!checkKey.canAddMore(s, arg0))
					{
						arg0.consume();
						
					}																
				
			}
			
		});
		txtFieldA.setColumns(10);
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblB, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblC, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(lblA, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(46)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtFieldB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFieldA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFieldC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(131, Short.MAX_VALUE))
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblA)
						.addComponent(txtFieldA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFieldB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblB))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblC)
						.addComponent(txtFieldC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
		);
		textArea.setEditable(false);
		
		
		scrollPane.setViewportView(textArea);
		contentPanel.setLayout(gl_contentPanel);
	}
}
