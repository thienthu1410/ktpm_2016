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

import shape.shapes.Square;
import shape.type.ShapeSample;
import shapeMachine.Pencil;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import GUI.support.*;

@SuppressWarnings("serial")
public class SquareView extends JDialog {

	private  JPanel contentPanel = new JPanel();
	private JTextField txtFieldEdge = new JTextField();
	private JLabel lblCanh = new JLabel("Cạnh");
	private JTextArea textArea = new JTextArea();
	
	private Pencil pencil = new Pencil();
	private Square square = (Square) pencil.draw(ShapeSample.SQUARE);
	private DataChecker checkKey = new DataChecker();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SquareView dialog = new SquareView();
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
			float square_edge_value = Float.parseFloat(txtFieldEdge.getText());
			
			square.setA(square_edge_value);
			
			
			
			textArea.setText("Diện tích: " + Float.toString(square.findArea()) + 
								"\nChu vi: " + Float.toString(square.findPerimeter()));
			
			
		}
		
		catch(Exception e)
		{
			//textArea.setText("Dữ liệu không hợp lệ");
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public SquareView() {
		setTitle("Hình vuông");
		txtFieldEdge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				changeRectangle();
				
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String s = txtFieldEdge.getText() + arg0.getKeyChar();
				
					if (!checkKey.canAddMore(s, arg0))
					{
						arg0.consume();
						
					}
					
									
					
					
				
				
			}
			
		});
		txtFieldEdge.setColumns(10);
		
		
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
					.addComponent(lblCanh, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtFieldEdge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(129))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCanh)
						.addComponent(txtFieldEdge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
		);
		textArea.setEditable(false);
		
		
		scrollPane.setViewportView(textArea);
		contentPanel.setLayout(gl_contentPanel);
	}
}
