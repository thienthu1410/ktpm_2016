package GUI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;

import algorithm.calculate.Div;
import algorithm.search.helper.IsPrimeOf;

import GUI.support.CreateModel;
import GUI.support.DataChecker;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TreeMap;
import javax.swing.JScrollPane;

public class FindPrimesView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	JList primeList = new JList();
	JList numberList = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FindPrimesView dialog = new FindPrimesView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FindPrimesView() {
		setTitle("T\u00ECm th\u1EEBa s\u1ED1 nguy\u00EAn t\u1ED1");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		
		
		JLabel lblS = new JLabel("S\u1ED1");
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				DataChecker dataChecker = new DataChecker();
				if (!dataChecker.isNumber(arg0))
					arg0.consume();
			}
		});
		textField.setColumns(10);
		
		JButton btnTmThaS = new JButton("T\u00ECm th\u1EEBa s\u1ED1 ngy\u00EAn t\u1ED1");
		btnTmThaS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TreeMap<Integer,Integer> numbers = new TreeMap<Integer,Integer>();
				TreeMap<Integer,Integer> primes = new TreeMap<Integer,Integer>();
				Div algorithm_Mod = new Div();
				IsPrimeOf algorithm_IsPrimeOf = new IsPrimeOf();
				
				int key = 0;
				int temp = Integer.parseInt(textField.getText());
				numbers.put(key, temp);
				while (temp!=1)
				{					
					algorithm_IsPrimeOf.changeNumber(temp);
					for (int i = 2; i <= temp; i++)
					{
						if (algorithm_IsPrimeOf.isOK(i))
						{
							algorithm_Mod.calculate(temp, i);
							temp = algorithm_Mod.getResult();
							primes.put(key, i);							
							numbers.put(++key, temp);
							break;
						}
					}						
				}
				
				DefaultListModel numbersListModel = new DefaultListModel();
				numbersListModel.clear();
				
				DefaultListModel primesListModel = new DefaultListModel();
				primesListModel.clear();
				
				CreateModel.initData(numbers, numbersListModel);
				CreateModel.initData(primes, primesListModel);
				
				numberList.setModel(numbersListModel);
				primeList.setModel(primesListModel);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblS)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(22)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane_1, 0, 0, Short.MAX_VALUE)
						.addComponent(btnTmThaS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(75))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblS)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnTmThaS)))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
						.addComponent(scrollPane_1, Alignment.TRAILING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
		);
		scrollPane_1.setViewportView(primeList);
		scrollPane.setViewportView(numberList);
		contentPanel.setLayout(gl_contentPanel);
		
	}
}
