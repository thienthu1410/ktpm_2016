package GUI;

import global.Global;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import creator.algorithmMachine.AlgorithmCreator;

import algorithm.search.AbstractAlgorithm;
import algorithm.search.Algorithm;

import GUI.support.CreateModel;
import GUI.support.DataChecker;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import languageSupport.VietnameseTranslator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class FindNumbersView extends JDialog 
{

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	
	JComboBox comboBox = new JComboBox();
	private AlgorithmCreator algoCreator = new AlgorithmCreator();
	private ArrayList<AbstractAlgorithm> algoArrayList = new ArrayList<AbstractAlgorithm>();
	private ArrayList<Float> numbers = new ArrayList<Float>();
	
	private JTextArea textArea_1 = new JTextArea();	
	private JTextArea textArea_2 = new JTextArea();	
	private JTextArea textArea = new JTextArea();
	
	JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
	JRadioButton radioButton = new JRadioButton("2");
	
	private int type = 1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FindNumbersView dialog = new FindNumbersView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FindNumbersView() {
		setTitle("D\u00E3y s\u1ED1");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 613, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JButton btnNhpS = new JButton("Nh\u1EADp 1 s\u1ED1");
		btnNhpS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s = textField.getText();
				if (s.length() > 0)
				{
					float number = Float.parseFloat(s);
					numbers.add(number);
					textArea.setText(textArea.getText() + s + "\n");
				}
			}
		});
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				DataChecker dataChecker = new DataChecker();
				String s = textField.getText() + arg0.getKeyChar();
				if (arg0.getKeyChar() == '-' && !dataChecker.canAddNegativeSignal(s, arg0) )
						arg0.consume();
				else if (arg0.getKeyChar()!='-' && !dataChecker.canAddMore(s, arg0))
					arg0.consume();
			}
		});
		textField.setColumns(10);
	
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnThcThi = new JButton("Th\u1EF1c thi");
		btnThcThi.addMouseListener(new MouseAdapter() {
			
			
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textArea_2.setText("");
				ArrayList<Float> temp = (ArrayList<Float>) numbers.clone();
				if (type==1)
				{
					for (AbstractAlgorithm algorithm : algoArrayList)
					{
						algorithm.findNumber(temp);
						ArrayList<String> strNumbers = algorithm.convertResultToStr();
						for (String str : strNumbers )
						{
							textArea_2.setText(textArea_2.getText() + str + " ");
						}
						
						textArea_2.setText(textArea_2.getText() + "\n");
					}
				}
				
				else if (type==2)
				{
					ArrayList<String> strNumbers = new ArrayList<String>();
					AbstractAlgorithm algo = null;
					for (AbstractAlgorithm algorithm : algoArrayList)
					{
						algo = algorithm;
						temp = algorithm.findNumber(temp);						
					}
					
					if (algo != null)
					{
						strNumbers = algo.convertResultToStr();
						for (String str : strNumbers )
						{
							textArea_2.setText(textArea_2.getText() + str + " ");
						}	
					}
				}
			}							
		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblKtQu = new JLabel("K\u1EBFt qu\u1EA3");
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JButton btnChnChcNng = new JButton("Ch\u1ECDn ch\u1EE9c n\u0103ng");
		btnChnChcNng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s = (String) comboBox.getSelectedItem();
				algoCreator.createAlgorithm(algoArrayList, VietnameseTranslator.AlgorithmStr2Enum(s));
				textArea_1.setText(textArea_1.getText()+s+"\n");
				
			}
		});
	
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rdbtnNewRadioButton.isSelected())
				{
					radioButton.setSelected(false);
				
					
				}
				else
				{
					rdbtnNewRadioButton.setSelected(true);
					
					
				}
				
				type = 1;
				
			}
		});
		
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				numbers.clear();
				textArea.setText("");
			}
		});
		
		JButton btnResetAll = new JButton("Reset All");
		btnResetAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				numbers.clear();
				algoArrayList.clear();
				textArea.setText("");
				textArea_1.setText("");
				textArea_2.setText("");
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField)
								.addComponent(btnNhpS, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane))
							.addGap(18)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnChnChcNng, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(15)
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
							.addComponent(btnThcThi)
							.addGap(18)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(22)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNewRadioButton)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnResetAll))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(113)
							.addComponent(lblKtQu)))
					.addGap(155))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNhpS)
								.addComponent(btnChnChcNng)
								.addComponent(rdbtnNewRadioButton))
							.addGap(11)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton))
							.addGap(38))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(btnResetAll)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(separator_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(separator, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnThcThi)
							.addComponent(btnReset))
						.addComponent(lblKtQu))
					.addGap(48))
		);
		radioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (radioButton.isSelected())
				{
					rdbtnNewRadioButton.setSelected(false);
					
					
				}
				else
				{
					radioButton.setSelected(true);
					
				}
				type = 2;
			}
		});
		
		
		
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		
	
		textArea_2.setEditable(false);
		scrollPane_2.setViewportView(textArea_2);
		
		
		
		
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		contentPanel.setLayout(gl_contentPanel);
		
		TreeMap algoCatalo = Global.algorithmCreator.getList();
		TreeMap<Algorithm, String> algoListName = new TreeMap<Algorithm, String>();
		
		DefaultComboBoxModel model = new DefaultComboBoxModel<>();

		Set valueSet = algoCatalo.entrySet();
		Iterator i_value = valueSet.iterator();
	   
	     while(i_value.hasNext()) 
	     {
		   	  Map.Entry<Algorithm, AbstractAlgorithm> me = (Map.Entry)i_value.next();
		   	  
		   	  Algorithm tmp = me.getKey();
		   	
		   	  algoListName.put(tmp, VietnameseTranslator.translateToThisLangugage(tmp));
		   	 }
	     
	     CreateModel.initData(algoListName, model);
	     comboBox.setModel( model);
	}
}
