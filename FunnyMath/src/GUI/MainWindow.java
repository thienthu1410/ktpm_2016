package GUI;

import global.Global;

import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JList;

import shape.Shape;
import shape.type.ShapeSample;

import languageSupport.VietnameseTranslator;
import GUI.support.CreateModel;
import creator.windowCreator.NumeralsWindowCreator;
import creator.windowCreator.ShapeWindowCreator;
import javax.swing.JMenuItem;

import numeralsChoices.Numerals;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frmFunnymath;
private ShapeWindowCreator w_creator = new  ShapeWindowCreator();
	
	@SuppressWarnings("rawtypes")
	private JList list = new JList();
	private Hashtable<ShapeSample, Shape> shapeSample = Global.shapeSampleCreator.init().getSampleList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmFunnymath.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFunnymath = new JFrame();
		frmFunnymath.setTitle("FunnyMath");
		frmFunnymath.setBounds(100, 100, 450, 300);
		frmFunnymath.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GroupLayout groupLayout = new GroupLayout(frmFunnymath.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 261, Short.MAX_VALUE)
		);
		frmFunnymath.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmFunnymath.setJMenuBar(menuBar);
		
		JMenu mnNumerals = new JMenu("S\u1ED1 h\u1ECDc");
		menuBar.add(mnNumerals);
		
		JMenuItem mntmTmThaS = new JMenuItem("T\u00ECm th\u1EEBa s\u1ED1 nguy\u00EAn t\u1ED1");
		mntmTmThaS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog window =  new NumeralsWindowCreator().createWindow(Numerals.FIND_PRIMES_OF);
				window.setModalityType(ModalityType.APPLICATION_MODAL);
				window.show();
			}
		});
	
		
		mnNumerals.add(mntmTmThaS);
		
		JMenuItem mntmRtTrchS = new JMenuItem("R\u00FAt tr\u00EDch s\u1ED1");
		mntmRtTrchS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog window =  new NumeralsWindowCreator().createWindow(Numerals.FIND_NUMBERS_FROM_SERIES);
				window.setModalityType(ModalityType.APPLICATION_MODAL);
				window.show();
			}
		});
		
		
		mnNumerals.add(mntmRtTrchS);
		
		JMenu mnGeometry = new JMenu("H\u00ECnh h\u1ECDc");
		menuBar.add(mnGeometry);
		
		
		mnGeometry.add(list);
		
		DefaultListModel model = new DefaultListModel();
		Hashtable<ShapeSample, String> shapeType = new Hashtable<ShapeSample, String>();
		Enumeration<ShapeSample> keys = shapeSample.keys();
		while (keys.hasMoreElements())
		{
			ShapeSample key = keys.nextElement();
			shapeType.put(key, VietnameseTranslator.translateToThisLanguge(key));
		}
		CreateModel.initData(shapeType, model);
		list.setModel(model);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			@SuppressWarnings("deprecation")
			public void valueChanged(ListSelectionEvent arg0) {
				
				
				
				JDialog window = w_creator.createWindow(VietnameseTranslator.ShapeStr2Enum(list.getSelectedValue().toString()));
				window.setModalityType(ModalityType.APPLICATION_MODAL);
				window.show();
			}
			
		
		});
	}

}
