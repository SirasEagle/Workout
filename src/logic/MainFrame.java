package logic;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Design.Colors;
import Design.ModernScrollPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 1055;
	private static final int HEIGHT = 625;
	private static final int menuHEIGHT = 150;
	private static final int menuWIDTH = 212;
	private static final int statCol1X = 68;
	private static final int statCol2X = 410;
	private static final int statCol3X = 683;
	private static final int statRow1 = 53;
	private static final int imgWIDTH = 200;
	private static final int imgHEIGHT = 225;
	private static final int imgX = 5;
	private static int iRow = 0;
	private JPanel panelMenu;
	private JPanel panelMenu2;
	private JPanel panelMenu3;
	private JPanel contentPane;
	private JPanel panelContent;
	private JPanel panelOverfiew;
	private JPanel panelStatistics;
	private JTable tableMain;
	private Object[][] oContent = Main.oContent;
	private JTextArea areaStats;
	protected JTextArea areaLeast;
	private JLabel labelImage;
	private File[] exercisePics;
	private JButton buttonExc1;
	private JButton buttonExc2;
	private JButton buttonExec3;
	private JButton buttonExec4;
	private JButton buttonExec5;
	private JButton buttonExec6;
	private JButton buttonExec7;
	private JButton buttonExec8;
	private JButton buttonExec9;
	private JButton buttonExec10;
	private JButton buttonExec11;
	private JButton buttonExec12;
	private JButton buttonExec13;
	private JButton buttonExec14;
	private JButton buttonExec15;
	private JButton buttonExec16;
	private JButton buttonExec17;
	private JButton buttonExec18;
	private JButton buttonCat2;
	private JButton exit;
	private JLabel lblDetails;
	private JLabel labelPerformance;
	private JLabel labelMedOfExer;
	private JLabel labelPerfData;
	private JLabel labelMedOfExerData;
	private JLabel labelStartData;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_1_5;
	private JLabel lblNewLabel_1_6;
	private JLabel lblNewLabel_1_7;
	private JLabel lblNewLabel_1_8;
	private JLabel lblNewLabel_1_9;
	private JLabel lblNewLabel_1_10;
	private JLabel lblNewLabel_1_11;
	private JLabel lblNewLabel_1_12;
	private JLabel lblNewLabel_1_13;
	private JLabel lblNewLabel_1_14;
	private JLabel lblNewLabel_1_15;
	private JScrollBar scrollChosen;
	private JButton buttonToMost;

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public MainFrame() throws IOException {

		exercisePics = new File[Main.tableColSize];
		for (int i = 0; i < 18; i++) {
			exercisePics[i] = new File(Main.getWorkouts().get(0).getExercises()[i].getPicPath());
		}

		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBounds(0, 0, WIDTH, HEIGHT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		exit = new JButton("X");
		exit.setBounds((this.getWidth() - 30), 0, 30, 30);
		exit.setForeground(Color.WHITE);
		exit.setBorder(null);
		exit.setFocusable(false); // TODO important for other buttons as well
		exit.setBorderPainted(false);
		exit.setBackground(new Color(20, 20, 20));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		contentPane.add(exit);

		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.DARK_GRAY);
		panelMain.setBounds(0, 0, WIDTH, HEIGHT);
		contentPane.add(panelMain);
		panelMain.setLayout(null);

		panelMenu = new JPanel();
		panelMenu.setBackground(Color.DARK_GRAY);
		panelMenu.setBounds(0, 0, menuWIDTH, HEIGHT);
		panelMain.add(panelMenu);
		panelMenu.setLayout(null);

		JPanel panelMenu1 = new JPanel();
		panelMenu1.setBackground(Colors.warmLight());
		panelMenu1.setBounds(0, 0, menuWIDTH, menuHEIGHT);
		panelMenu.add(panelMenu1);
		panelMenu1.setLayout(null);

		JButton buttonCat1 = new JButton("Calander");
		buttonCat1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panelContent.show();
				panelStatistics.hide();
				panelOverfiew.hide();
				panelMenu1.setBackground(Colors.warmLight());
				panelMenu2.setBackground(Colors.warm());
				panelMenu3.setBackground(Colors.warm());
				buttonCat1.setBackground(Colors.warm());
				buttonCat2.setBackground(Colors.redBackLight());
			}
		});
		buttonCat1.setForeground(Color.LIGHT_GRAY);
		buttonCat1.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonCat1.setFocusPainted(false);
		buttonCat1.setBackground(Colors.warm());
		buttonCat1.setBounds(20, 20, 172, 110);
		panelMenu1.add(buttonCat1);

		panelMenu3 = new JPanel();
		panelMenu3.setBackground(Colors.warm());
		panelMenu3.setLayout(null);
		panelMenu3.setBounds(0, 149, menuWIDTH, menuHEIGHT);
		panelMenu.add(panelMenu3);

		buttonCat2 = new JButton("Exercises");
		buttonCat2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				panelContent.hide();
				panelStatistics.hide();
				panelOverfiew.show();
				labelImage.setVisible(false);
				panelMenu1.setBackground(Colors.redBack());
				panelMenu2.setBackground(Colors.redBack());
				panelMenu3.setBackground(Colors.redBackLight());
				buttonCat2.setBackground(Colors.redBack());
				buttonCat1.setBackground(Colors.warmLight());
			}
		});
		buttonCat2.setForeground(Color.LIGHT_GRAY);
		buttonCat2.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonCat2.setFocusPainted(false);
		buttonCat2.setBackground(Colors.redBackLight());
		buttonCat2.setBounds(20, 20, 172, 110);
		panelMenu3.add(buttonCat2);

		panelMenu2 = new JPanel();
		panelMenu2.setBackground(Colors.warm());
		panelMenu2.setBounds(0, 298, menuWIDTH, (HEIGHT - menuHEIGHT * 2 + 5));
		panelMenu.add(panelMenu2);
		panelMenu2.setLayout(null);

		// Image
		labelImage = new JLabel(" ");
		// labelImage.setBounds(20, 20, 172, 158);
		// File pathToFile = new File("C:\\Adrian\\3_Selfmade\\5_Programme\\_1
		// Java\\alul\\src\\database\\MusikPng.png");
		// Image image = ImageIO.read(pathToFile);
		// Image dimg = image.getScaledInstance(labelImage.getWidth(),
		// labelImage.getHeight(), Image.SCALE_SMOOTH);
		// ImageIcon icon = new ImageIcon(dimg);
		// labelImage.setIcon(icon);
		panelMenu2.add(labelImage);

		panelContent = new JPanel();
		panelContent.setBackground(Colors.warmLight());
		panelContent.setBounds(210, 0, (WIDTH - menuWIDTH + 5), HEIGHT);
		panelMain.add(panelContent);
		panelContent.setLayout(null);

		String[] sColumns = { "1", "2", "3", "4", "5", "6", "7" };

		tableMain = new JTable(oContent, sColumns);
		tableMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		tableMain.setRowHeight(22);
		tableMain.setIntercellSpacing(new Dimension(2, 2));
		tableMain.setGridColor(Color.DARK_GRAY);
		tableMain.setFont(new Font("Courier New", Font.PLAIN, 10));
		tableMain.setForeground(Color.WHITE);
		tableMain.setEnabled(false);
		tableMain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableMain.setBackground(Color.BLACK);
		tableMain.setBounds(95, 84, 683, 418);
		tableMain.setFillsViewportHeight(true);

		tableMain.getColumnModel().getColumn(1).setCellRenderer(new CustomColumnCellRenderer());
		tableMain.getColumnModel().getColumn(2).setCellRenderer(new CustomColumnCellRenderer());
		tableMain.getColumnModel().getColumn(3).setCellRenderer(new CustomColumnCellRenderer());
		tableMain.getColumnModel().getColumn(4).setCellRenderer(new CustomColumnCellRenderer());
		tableMain.getColumnModel().getColumn(5).setCellRenderer(new CustomColumnCellRenderer());
		tableMain.getColumnModel().getColumn(6).setCellRenderer(new CustomColumnCellRenderer());

		buttonExc1 = new JButton(" " + ExerciseManager.getName(0));
		buttonExc1.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExc1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[0]);
			}
		});

		buttonExc2 = new JButton(" " + ExerciseManager.getName(1));
		buttonExc2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[1]);
			}
		});

		buttonExec3 = new JButton(" " + ExerciseManager.getName(2));
		buttonExec3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[2]);
			}
		});

		buttonExec4 = new JButton(" " + ExerciseManager.getName(3));
		buttonExec4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[3]);
			}
		});

		buttonExec5 = new JButton(" " + ExerciseManager.getName(4));
		buttonExec5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[4]);
			}
		});

		buttonExec6 = new JButton(" " + ExerciseManager.getName(5));
		buttonExec6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[5]);
			}
		});

		buttonExec7 = new JButton(" " + ExerciseManager.getName(6));
		buttonExec7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[6]);
			}
		});

		buttonExec8 = new JButton(" " + ExerciseManager.getName(7));
		buttonExec8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[7]);
			}
		});

		buttonExec9 = new JButton(" " + ExerciseManager.getName(8));
		buttonExec9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[8]);
			}
		});

		buttonExec10 = new JButton(" " + ExerciseManager.getName(9));
		buttonExec10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[9]);
			}
		});

		buttonExec11 = new JButton(" " + ExerciseManager.getName(10));
		buttonExec11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[10]);
			}
		});

		buttonExec12 = new JButton(" " + ExerciseManager.getName(11));
		buttonExec12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[11]);
			}
		});

		buttonExec13 = new JButton(" " + ExerciseManager.getName(12));
		buttonExec13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[12]);
			}
		});

		buttonExec14 = new JButton(" " + ExerciseManager.getName(13));
		buttonExec14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[13]);
			}
		});

		buttonExec15 = new JButton(" " + ExerciseManager.getName(14));
		buttonExec15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[14]);
			}
		});

		buttonExec16 = new JButton(" " + ExerciseManager.getName(15));
		buttonExec16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[15]);
			}
		});

		buttonExec17 = new JButton(" " + ExerciseManager.getName(16));
		buttonExec17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[16]);
			}
		});

		buttonExec18 = new JButton(" " + ExerciseManager.getName(17));
		buttonExec18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExePic(exercisePics[17]);
			}
		});

		for (int j = 0; j < Main.tableWidthSize; j++) {
			int x = 194 + (j * 98);
			for (iRow = 0; iRow < Main.tableColSize; iRow++) {
				int y = 106 + (iRow * 22);
				JButton buttonDetail = new JButton(" ");
				buttonDetail.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int currentCol = ((buttonDetail.getX() - 194) / 98) + 1;
						int currentRow = ((buttonDetail.getY() - 106) / 22) + 1;
						int index = Main.getWorkouts().size() - (7 - currentCol) - Main.pastJumps;
						Exercise xx = null;
						if (currentRow >= 1) {
							xx = Main.getWorkouts().get(index).getExercises()[currentRow - 1];
						}
						lblDetails.setText(xx.getName() + ": " + xx.set1 + "-" + xx.set2 + "-" + xx.set3);

						// Image
						labelImage.setVisible(false);

						labelImage = new JLabel("New label");
						labelImage.setBounds(imgX, 30, imgWIDTH, imgHEIGHT);
						Image image = null;
						try {
							image = ImageIO.read(exercisePics[currentRow - 1]);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						Image dimg = image.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(),
								Image.SCALE_SMOOTH);
						ImageIcon icon = new ImageIcon(dimg);
						labelImage.setIcon(icon);
						panelMenu2.add(labelImage);

						// refreshes page
						contentPane.validate();
						contentPane.repaint();
					}
				});
				buttonDetail.setOpaque(false);
				buttonDetail.setHorizontalAlignment(SwingConstants.LEFT);
				buttonDetail.setForeground(Color.WHITE);
				buttonDetail.setFont(new Font("Courier New", Font.PLAIN, 10));
				buttonDetail.setFocusable(false);
				buttonDetail.setContentAreaFilled(false);
				buttonDetail.setBorderPainted(false);
				buttonDetail.setBorder(null);
				buttonDetail.setBounds(x, y, 95, 21);
				panelContent.add(buttonDetail);
			}
		}

		buttonExec18.setOpaque(false);
		buttonExec18.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec18.setForeground(Color.WHITE);
		buttonExec18.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec18.setFocusable(false);
		buttonExec18.setContentAreaFilled(false);
		buttonExec18.setBorderPainted(false);
		buttonExec18.setBorder(null);
		buttonExec18.setBounds(95, 480, 95, 21);
		panelContent.add(buttonExec18);
		buttonExec17.setOpaque(false);
		buttonExec17.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec17.setForeground(Color.WHITE);
		buttonExec17.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec17.setFocusable(false);
		buttonExec17.setContentAreaFilled(false);
		buttonExec17.setBorderPainted(false);
		buttonExec17.setBorder(null);
		buttonExec17.setBounds(95, 458, 95, 21);
		panelContent.add(buttonExec17);
		buttonExec16.setOpaque(false);
		buttonExec16.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec16.setForeground(Color.WHITE);
		buttonExec16.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec16.setFocusable(false);
		buttonExec16.setContentAreaFilled(false);
		buttonExec16.setBorderPainted(false);
		buttonExec16.setBorder(null);
		buttonExec16.setBounds(95, 436, 95, 21);
		panelContent.add(buttonExec16);
		buttonExec15.setOpaque(false);
		buttonExec15.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec15.setForeground(Color.WHITE);
		buttonExec15.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec15.setFocusable(false);
		buttonExec15.setContentAreaFilled(false);
		buttonExec15.setBorderPainted(false);
		buttonExec15.setBorder(null);
		buttonExec15.setBounds(95, 414, 95, 21);
		panelContent.add(buttonExec15);
		buttonExec14.setOpaque(false);
		buttonExec14.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec14.setForeground(Color.WHITE);
		buttonExec14.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec14.setFocusable(false);
		buttonExec14.setContentAreaFilled(false);
		buttonExec14.setBorderPainted(false);
		buttonExec14.setBorder(null);
		buttonExec14.setBounds(95, 393, 95, 21);
		panelContent.add(buttonExec14);
		buttonExec13.setOpaque(false);
		buttonExec13.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec13.setForeground(Color.WHITE);
		buttonExec13.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec13.setFocusable(false);
		buttonExec13.setContentAreaFilled(false);
		buttonExec13.setBorderPainted(false);
		buttonExec13.setBorder(null);
		buttonExec13.setBounds(95, 371, 95, 21);
		panelContent.add(buttonExec13);
		buttonExec12.setOpaque(false);
		buttonExec12.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec12.setForeground(Color.WHITE);
		buttonExec12.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec12.setFocusable(false);
		buttonExec12.setContentAreaFilled(false);
		buttonExec12.setBorderPainted(false);
		buttonExec12.setBorder(null);
		buttonExec12.setBounds(95, 349, 95, 21);
		panelContent.add(buttonExec12);
		buttonExec11.setOpaque(false);
		buttonExec11.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec11.setForeground(Color.WHITE);
		buttonExec11.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec11.setFocusable(false);
		buttonExec11.setContentAreaFilled(false);
		buttonExec11.setBorderPainted(false);
		buttonExec11.setBorder(null);
		buttonExec11.setBounds(95, 327, 95, 21);
		panelContent.add(buttonExec11);
		buttonExec10.setOpaque(false);
		buttonExec10.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec10.setForeground(Color.WHITE);
		buttonExec10.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec10.setFocusable(false);
		buttonExec10.setContentAreaFilled(false);
		buttonExec10.setBorderPainted(false);
		buttonExec10.setBorder(null);
		buttonExec10.setBounds(95, 305, 95, 21);
		panelContent.add(buttonExec10);
		buttonExec9.setOpaque(false);
		buttonExec9.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec9.setForeground(Color.WHITE);
		buttonExec9.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec9.setFocusable(false);
		buttonExec9.setContentAreaFilled(false);
		buttonExec9.setBorderPainted(false);
		buttonExec9.setBorder(null);
		buttonExec9.setBounds(95, 283, 95, 21);
		panelContent.add(buttonExec9);
		buttonExec8.setOpaque(false);
		buttonExec8.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec8.setForeground(Color.WHITE);
		buttonExec8.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec8.setFocusable(false);
		buttonExec8.setContentAreaFilled(false);
		buttonExec8.setBorderPainted(false);
		buttonExec8.setBorder(null);
		buttonExec8.setBounds(95, 261, 95, 21);
		panelContent.add(buttonExec8);
		buttonExec7.setOpaque(false);
		buttonExec7.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec7.setForeground(Color.WHITE);
		buttonExec7.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec7.setFocusable(false);
		buttonExec7.setContentAreaFilled(false);
		buttonExec7.setBorderPainted(false);
		buttonExec7.setBorder(null);
		buttonExec7.setBounds(95, 239, 95, 21);
		panelContent.add(buttonExec7);
		buttonExec6.setOpaque(false);
		buttonExec6.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec6.setForeground(Color.WHITE);
		buttonExec6.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec6.setFocusable(false);
		buttonExec6.setContentAreaFilled(false);
		buttonExec6.setBorderPainted(false);
		buttonExec6.setBorder(null);
		buttonExec6.setBounds(95, 217, 95, 21);
		panelContent.add(buttonExec6);
		buttonExec5.setOpaque(false);
		buttonExec5.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec5.setForeground(Color.WHITE);
		buttonExec5.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec5.setFocusable(false);
		buttonExec5.setContentAreaFilled(false);
		buttonExec5.setBorderPainted(false);
		buttonExec5.setBorder(null);
		buttonExec5.setBounds(95, 195, 95, 21);
		panelContent.add(buttonExec5);
		buttonExec4.setOpaque(false);
		buttonExec4.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec4.setForeground(Color.WHITE);
		buttonExec4.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec4.setFocusable(false);
		buttonExec4.setContentAreaFilled(false);
		buttonExec4.setBorderPainted(false);
		buttonExec4.setBorder(null);
		buttonExec4.setBounds(95, 173, 95, 21);
		panelContent.add(buttonExec4);
		buttonExec3.setOpaque(false);
		buttonExec3.setHorizontalAlignment(SwingConstants.LEFT);
		buttonExec3.setForeground(Color.WHITE);
		buttonExec3.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExec3.setFocusable(false);
		buttonExec3.setContentAreaFilled(false);
		buttonExec3.setBorderPainted(false);
		buttonExec3.setBorder(null);
		buttonExec3.setBounds(95, 151, 95, 21);
		panelContent.add(buttonExec3);
		buttonExc2.setFont(new Font("Courier New", Font.PLAIN, 10));
		buttonExc2.setOpaque(false);
		buttonExc2.setForeground(Color.WHITE);
		buttonExc2.setFocusable(false);
		buttonExc2.setContentAreaFilled(false);
		buttonExc2.setBorderPainted(false);
		buttonExc2.setBorder(null);
		buttonExc2.setBounds(95, 128, 95, 21);
		buttonExc2.setHorizontalAlignment(SwingConstants.LEFT);
		panelContent.add(buttonExc2);
		buttonExc1.setForeground(Color.WHITE);
		buttonExc1.setBounds(95, 106, 95, 21);
		buttonExc1.setOpaque(false); // Must add
		buttonExc1.setContentAreaFilled(false); // No fill
		buttonExc1.setFocusable(false); // I'd like to set focusable false to the button.
		buttonExc1.setBorderPainted(true); // I'd like to enable it.
		buttonExc1.setBorder(null); // Border (No border for now)
		buttonExc1.setHorizontalAlignment(SwingConstants.LEFT);
		panelContent.add(buttonExc1);

		JPanel panelExec = new JPanel();
		panelExec.setBackground(Color.BLACK);
		panelExec.setBounds(95, 106, 97, 396);
		panelContent.add(panelExec);

		panelContent.add(tableMain);

		JButton buttonStatistics = new JButton("Statistics");
		buttonStatistics.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				areaStats.setText("");
				areaLeast.setText("");
				labelPerfData.setText(Statistics.getPerformance(1) + "%");
				labelMedOfExerData.setText(Statistics.getPerformance(0) + "%");
				labelStartData.setText(Statistics.getMeasureStart(1));
				Statistics.getExAverages(1, areaLeast, 0);
				// // System.out.println("[GUI] " + Main.getUserFlag());
				for (int i = 0; i < Main.getWorkouts().size(); i++) {
					areaStats.append(Statistics.getValueFromDay(Main.getWorkouts().get(i)) + "% ");
					areaStats.append(Statistics.getValueAsDots(Main.getWorkouts().get(i)) + "\n");
					if ((i + 1) < Main.getWorkouts().size()) {
						if (Main.getWorkouts().get(i + 1).getDate().isAfter(Main.getWorkouts().get(i).getDate().plusDays(7))) {
							areaStats.append("________________________________________\n");
						}
					}
				}
				areaLeast.setCaretPosition(0);
				panelContent.hide();
				panelOverfiew.hide();
				panelStatistics.show();
				labelImage.setVisible(false);
				panelMenu1.setBackground(Colors.cyanBackLight());
				panelMenu2.setBackground(Colors.cyanBack());
				panelMenu3.setBackground(Colors.cyanBack());
				buttonCat1.setBackground(Colors.cyanBack());
			}
		});
		buttonStatistics.setBorder(null);
		buttonStatistics.setBackground(new Color(0, 100, 0));
		buttonStatistics.setForeground(Color.WHITE);
		buttonStatistics.setBounds(683, 53, 95, 21);
		panelContent.add(buttonStatistics);

		JButton buttonBefore = new JButton("←");
		buttonBefore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Main.getOlder()) {
					oContent = Main.oContent;

					// refreshes page
					contentPane.validate();
					contentPane.repaint();
				}
			}
		});
		buttonBefore.setOpaque(false);
		buttonBefore.setHorizontalAlignment(SwingConstants.LEFT);
		buttonBefore.setForeground(Color.WHITE);
		buttonBefore.setFont(new Font("Courier New", Font.PLAIN, 20));
		buttonBefore.setFocusable(false);
		buttonBefore.setContentAreaFilled(false);
		buttonBefore.setBorderPainted(false);
		buttonBefore.setBorder(null);
		buttonBefore.setBounds(68, 82, 20, 20);
		panelContent.add(buttonBefore);

		JButton buttonAfter = new JButton("→");
		buttonAfter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Main.getNewer()) {
					oContent = Main.oContent;

					// refreshes page
					contentPane.validate();
					contentPane.repaint();
				}
			}
		});
		buttonAfter.setOpaque(false);
		buttonAfter.setHorizontalAlignment(SwingConstants.LEFT);
		buttonAfter.setForeground(Color.WHITE);
		buttonAfter.setFont(new Font("Courier New", Font.PLAIN, 20));
		buttonAfter.setFocusable(false);
		buttonAfter.setContentAreaFilled(false);
		buttonAfter.setBorderPainted(false);
		buttonAfter.setBorder(null);
		buttonAfter.setBounds(788, 82, 20, 20);
		panelContent.add(buttonAfter);

		ButtonGroup bgUserSelector;
		JPanel panelUserSelection = new JPanel();
		panelUserSelection.setBackground(Colors.warm());
		panelUserSelection.setBounds(92, 513, 142, 31);
		panelContent.add(panelUserSelection);

		JRadioButton radioUser0 = new JRadioButton("User 1");
		radioUser0.setForeground(Color.WHITE);
		radioUser0.setBackground(Colors.warmLight());
		radioUser0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (radioUser0.isSelected() && Main.getUserFlag() == 0) {
					Main.refreshContent();
					// refreshes page
					contentPane.validate();
					contentPane.repaint();
				}
			}
		});
		radioUser0.setSelected(true);
		radioUser0.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (radioUser0.isSelected() && Main.getUserFlag() != 0) {
					Main.setUserFlag(0);
					Main.refreshContent();
					exercisePics = new File[Main.tableColSize];
					for (int i = 0; i < 18; i++) {
						exercisePics[i] = new File(ExerciseManager.getPicPath(Main.exercises.get(i).getName()));
					}
					try {
						buttonExc1.setText(" " + ExerciseManager.getName(0));
						buttonExc2.setText(" " + ExerciseManager.getName(1));
						buttonExec3.setText(" " + ExerciseManager.getName(2));
						buttonExec4.setText(" " + ExerciseManager.getName(3));
						buttonExec5.setText(" " + ExerciseManager.getName(4));
						buttonExec6.setText(" " + ExerciseManager.getName(5));
						buttonExec7.setText(" " + ExerciseManager.getName(6));
						buttonExec8.setText(" " + ExerciseManager.getName(7));
						buttonExec9.setText(" " + ExerciseManager.getName(8));
						buttonExec10.setText(" " + ExerciseManager.getName(9));
						buttonExec11.setText(" " + ExerciseManager.getName(10));
						buttonExec12.setText(" " + ExerciseManager.getName(11));
						buttonExec13.setText(" " + ExerciseManager.getName(12));
						buttonExec14.setText(" " + ExerciseManager.getName(13));
						buttonExec15.setText(" " + ExerciseManager.getName(14));
						buttonExec16.setText(" " + ExerciseManager.getName(15));
						buttonExec17.setText(" " + ExerciseManager.getName(16));
						buttonExec18.setText(" " + ExerciseManager.getName(17));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

					// refreshes page
					contentPane.validate();
					contentPane.repaint();
				}
			}
		});
		panelUserSelection.add(radioUser0);

		JRadioButton radioUser1 = new JRadioButton("User 2");
		radioUser1.setForeground(Color.WHITE);
		radioUser1.setBackground(Colors.warmLight());
		radioUser1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (radioUser1.isSelected() && Main.getUserFlag() == 1) {
					Main.refreshContent();
					// refreshes page
					contentPane.validate();
					contentPane.repaint();
				}
			}
		});
		radioUser1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (radioUser1.isSelected() && Main.getUserFlag() != 1) {
					Main.setUserFlag(1);
					Main.refreshContent();
					exercisePics = new File[Main.tableColSize];
					for (int i = 0; i < 18; i++) {
						exercisePics[i] = new File(ExerciseManager.getPicPath(Main.exercises.get(i).getName()));
					}
					try {
						buttonExc1.setText(" " + ExerciseManager.getName(0));
						buttonExc2.setText(" " + ExerciseManager.getName(1));
						buttonExec3.setText(" " + ExerciseManager.getName(2));
						buttonExec4.setText(" " + ExerciseManager.getName(3));
						buttonExec5.setText(" " + ExerciseManager.getName(4));
						buttonExec6.setText(" " + ExerciseManager.getName(5));
						buttonExec7.setText(" " + ExerciseManager.getName(6));
						buttonExec8.setText(" " + ExerciseManager.getName(7));
						buttonExec9.setText(" " + ExerciseManager.getName(8));
						buttonExec10.setText(" " + ExerciseManager.getName(9));
						buttonExec11.setText(" " + ExerciseManager.getName(10));
						buttonExec12.setText(" " + ExerciseManager.getName(11));
						buttonExec13.setText(" " + ExerciseManager.getName(12));
						buttonExec14.setText(" " + ExerciseManager.getName(13));
						buttonExec15.setText(" " + ExerciseManager.getName(14));
						buttonExec16.setText(" " + ExerciseManager.getName(15));
						buttonExec17.setText(" " + ExerciseManager.getName(16));
						buttonExec18.setText(" " + ExerciseManager.getName(17));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

					// refreshes page
					contentPane.validate();
					contentPane.repaint();
				}
			}
		});
		panelUserSelection.add(radioUser1);

		bgUserSelector = new ButtonGroup();
		bgUserSelector.add(radioUser0);
		bgUserSelector.add(radioUser1);

		lblDetails = new JLabel("");
		lblDetails.setForeground(new Color(192, 192, 192));
		lblDetails.setBounds(358, 513, 400, 14);
		panelContent.add(lblDetails);

		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setBounds(68, 108, 17, 14);
		panelContent.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("2");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(68, 130, 17, 14);
		panelContent.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("3");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(68, 153, 17, 14);
		panelContent.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("4");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setBounds(68, 175, 17, 14);
		panelContent.add(lblNewLabel_1_1);

		lblNewLabel_1_2 = new JLabel("5");
		lblNewLabel_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_2.setBounds(68, 197, 17, 14);
		panelContent.add(lblNewLabel_1_2);

		lblNewLabel_1_3 = new JLabel("6");
		lblNewLabel_1_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_3.setBounds(68, 219, 17, 14);
		panelContent.add(lblNewLabel_1_3);

		lblNewLabel_1_4 = new JLabel("7");
		lblNewLabel_1_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_4.setBounds(68, 241, 17, 14);
		panelContent.add(lblNewLabel_1_4);

		lblNewLabel_1_5 = new JLabel("8");
		lblNewLabel_1_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_5.setBounds(68, 263, 17, 14);
		panelContent.add(lblNewLabel_1_5);

		lblNewLabel_1_6 = new JLabel("9");
		lblNewLabel_1_6.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_6.setBounds(68, 285, 17, 14);
		panelContent.add(lblNewLabel_1_6);

		lblNewLabel_1_7 = new JLabel("10");
		lblNewLabel_1_7.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_7.setBounds(68, 307, 17, 14);
		panelContent.add(lblNewLabel_1_7);

		lblNewLabel_1_8 = new JLabel("11");
		lblNewLabel_1_8.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_8.setBounds(68, 329, 17, 14);
		panelContent.add(lblNewLabel_1_8);

		lblNewLabel_1_9 = new JLabel("12");
		lblNewLabel_1_9.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_9.setBounds(68, 351, 17, 14);
		panelContent.add(lblNewLabel_1_9);

		lblNewLabel_1_10 = new JLabel("13");
		lblNewLabel_1_10.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_10.setBounds(68, 373, 17, 14);
		panelContent.add(lblNewLabel_1_10);

		lblNewLabel_1_11 = new JLabel("14");
		lblNewLabel_1_11.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_11.setBounds(68, 395, 17, 14);
		panelContent.add(lblNewLabel_1_11);

		lblNewLabel_1_12 = new JLabel("15");
		lblNewLabel_1_12.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_12.setBounds(68, 416, 17, 14);
		panelContent.add(lblNewLabel_1_12);

		lblNewLabel_1_13 = new JLabel("16");
		lblNewLabel_1_13.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_13.setBounds(68, 438, 17, 14);
		panelContent.add(lblNewLabel_1_13);

		lblNewLabel_1_14 = new JLabel("17");
		lblNewLabel_1_14.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_14.setBounds(68, 460, 17, 14);
		panelContent.add(lblNewLabel_1_14);

		lblNewLabel_1_15 = new JLabel("18");
		lblNewLabel_1_15.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_15.setBounds(68, 482, 17, 14);
		panelContent.add(lblNewLabel_1_15);

		// Tab:
		// Statistics========================================================================
		panelStatistics = new JPanel();
		panelStatistics.setVisible(false);
		panelStatistics.setBackground(Colors.cyanBackLight());
		panelStatistics.setBounds(210, 0, (WIDTH - menuWIDTH + 5), HEIGHT);
		panelStatistics.setLayout(null);

		// Facts:_______________________________________________________________
		JPanel panelFacts = new JPanel();
		panelFacts.setBounds(statCol2X, statRow1, 230, 200);
		panelFacts.setVisible(true);
		panelFacts.setBackground(Colors.limeBack());
		panelFacts.setLayout(null);
		labelPerformance = new JLabel("Performance:");
		labelPerformance.setForeground(Colors.limeWeak());
		labelPerformance.setBounds(10, 10, 95, 14);
		panelFacts.add(labelPerformance);
		JLabel labelDots1 = new JLabel("----------------------------------");
		labelDots1.setForeground(Colors.limeBackLight());
		labelDots1.setBounds(10, 10, 140, 14);
		panelFacts.add(labelDots1);
		JLabel labelMesStart = new JLabel("Measure start:");
		labelMesStart.setForeground(Colors.limeWeak());
		labelMesStart.setBounds(10, 40, 95, 14);
		panelFacts.add(labelMesStart);
		JLabel labelDots2 = new JLabel("----------------------------------");
		labelMedOfExer = new JLabel("MedOfExerc.:");
		labelMedOfExer.setForeground(Colors.limeWeak());
		labelMedOfExer.setBounds(10, 70, 95, 14);
		panelFacts.add(labelMedOfExer);
		labelDots2.setForeground(Colors.limeBackLight());
		labelDots2.setBounds(10, 40, 140, 14);
		panelFacts.add(labelDots2);
		JLabel labelDots3 = new JLabel("----------------------------------");
		labelDots3.setForeground(Colors.limeBackLight());
		labelDots3.setBounds(10, 70, 140, 14);
		panelFacts.add(labelDots3);
		labelPerfData = new JLabel("-");
		labelPerfData.setForeground(Colors.lime());
		labelPerfData.setBounds(150, 10, 30, 14);
		panelFacts.add(labelPerfData);
		labelMedOfExerData = new JLabel("-");
		labelMedOfExerData.setForeground(Colors.lime());
		labelMedOfExerData.setBounds(150, 70, 30, 14);
		panelFacts.add(labelMedOfExerData);
		labelStartData = new JLabel("-");
		labelStartData.setForeground(Colors.lime());
		labelStartData.setBounds(150, 40, 150, 14);
		panelFacts.add(labelStartData);
		panelStatistics.add(panelFacts);
		JLabel labelLeastFav = new JLabel("Exercises");
		labelLeastFav.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelLeastFav.setForeground(Color.LIGHT_GRAY);
		labelLeastFav.setBounds(statCol2X, 337, 95, 14);
		panelStatistics.add(labelLeastFav);
		JButton buttonToLeast = new JButton("Least");
		buttonToLeast.setBounds(715, 360, 50, 50);
		buttonToLeast.setForeground(Color.WHITE);
		buttonToLeast.setBorder(null);
		buttonToLeast.setBackground(new Color(20, 20, 20));
		buttonToLeast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaLeast.setText("");
				Statistics.getExAverages(1, areaLeast, 2);
				areaLeast.setCaretPosition(0);
			}
		});
		panelStatistics.add(buttonToLeast);
		buttonToMost = new JButton("Most");
		buttonToMost.setForeground(Color.WHITE);
		buttonToMost.setBorder(null);
		buttonToMost.setBackground(new Color(20, 20, 20));
		buttonToMost.setBounds(715, 418, 50, 50);
		buttonToMost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaLeast.setText("");
				Statistics.getExAverages(1, areaLeast, 1);
				areaLeast.setCaretPosition(0);
			}
		});
		panelStatistics.add(buttonToMost);
		JButton buttonToNormal = new JButton("Reset");
		buttonToNormal.setBounds(715, 476, 50, 50);
		buttonToNormal.setForeground(new Color(140, 140, 140));
		buttonToNormal.setBorder(null);
		buttonToNormal.setBackground(new Color(20, 20, 20));
		buttonToNormal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaLeast.setText("");
				Statistics.getExAverages(1, areaLeast, 0);
				areaLeast.setCaretPosition(0);
			}
		});
		panelStatistics.add(buttonToNormal);
		areaLeast = new JTextArea();
		areaLeast.setBackground(Colors.limeBack());
		areaLeast.setForeground(Colors.lime());
		areaLeast.setBounds(statCol2X, 360, 300, 167);
		areaLeast.setBorder(
				BorderFactory.createCompoundBorder(areaLeast.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		ModernScrollPane mspExer = new ModernScrollPane(areaLeast);
		mspExer.setBounds(statCol2X, 360, 300, 167);
		mspExer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelStatistics.add(mspExer);
		areaStats = new JTextArea();
		areaStats.setBackground(Colors.cyanBack());
		areaStats.setForeground(Colors.cyan());
		areaStats.setBounds(statCol1X, statRow1, 320, 474);
		areaStats.setBorder(
				BorderFactory.createCompoundBorder(areaStats.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		ModernScrollPane spOverfiew = new ModernScrollPane(areaStats);
		spOverfiew.setBounds(statCol1X, statRow1, 320, 474);
		spOverfiew.setBackground(new Color(0, 0, 0));
		spOverfiew.setForeground(new Color(0, 0, 0));
		spOverfiew.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelStatistics.add(spOverfiew);
		JButton buttonBack1 = new JButton("Zurück");
		buttonBack1.setForeground(Color.WHITE);
		buttonBack1.setBorder(null);
		buttonBack1.setBackground(new Color(83, 155, 10));
		buttonBack1.setBounds(statCol3X, statRow1, 95, 21);
		buttonBack1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				panelContent.show();
				panelOverfiew.hide();
				panelStatistics.hide();
				panelMenu1.setBackground(Colors.warmLight());
				panelMenu2.setBackground(Colors.warm());
				panelMenu3.setBackground(Colors.warm());
				buttonCat1.setBackground(Colors.warm());
			}
		});
		panelStatistics.add(buttonBack1);

		// attaching
		panelMain.add(panelStatistics);

		// Tab: Exercises________________________________________
		panelOverfiew = new JPanel();
		panelOverfiew.setVisible(false);
		panelOverfiew.setBounds(210, 0, (WIDTH - menuWIDTH + 5), HEIGHT);
		panelOverfiew.setBackground(Colors.redBackLight());
		panelOverfiew.setLayout(null);

		JPanel panelChosen = new JPanel();
		panelChosen.setBackground(Colors.redBack());
		panelChosen.setBounds(95, 84, 683, 200);
		panelChosen.setLayout(null);
		JPanel panelSelect = new JPanel();
		panelSelect.setBackground(Colors.redBack());
		panelSelect.setLayout(null);
		panelSelect.setBounds(95, 300, 683, 200);

		scrollChosen = new JScrollBar();
		scrollChosen.setForeground(Color.GRAY);
		scrollChosen.setBackground(Color.DARK_GRAY);
		scrollChosen.setBounds(666, 0, 17, 196);
		panelChosen.add(scrollChosen);
		ModernScrollPane yyyyyyyyyy = new ModernScrollPane(scrollChosen);
		yyyyyyyyyy.setBounds(666, 0, 17, 196);
		yyyyyyyyyy.setBackground(new Color(0, 0, 0));
		yyyyyyyyyy.setForeground(new Color(0, 0, 0));
		yyyyyyyyyy.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelChosen.add(yyyyyyyyyy);

		// attaching
		panelOverfiew.add(panelChosen);
		panelOverfiew.add(panelSelect);
		panelMain.add(panelOverfiew);
	}

	protected void setExePic(File file) {
		// Image
		labelImage.setVisible(false);

		labelImage = new JLabel("New label");
		labelImage.setBounds(imgX, 30, imgWIDTH, imgHEIGHT);
		Image image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image dimg = image.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(dimg);
		labelImage.setIcon(icon);
		panelMenu2.add(labelImage);

		// refreshes page
		contentPane.validate();
		contentPane.repaint();
	}

	class CustomColumnCellRenderer extends DefaultTableCellRenderer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int col) {
			// parse cell to JLabel for appropriate coloring
			JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

			String parsedValue = value.toString();
			float fBrightnes = 0.1f;
			float fColor = Colors.exOrange();
			float fSaturation = 0.7f;
			if (parsedValue.equals(" ") == false) {
				int index = Main.getWorkouts().size() - (7 - col) - Main.pastJumps;
				if (row >= 1) {
					fBrightnes = ExerciseManager.getExeBrightnes(Main.getWorkouts().get(index).getExercises()[row - 1]);
				}
			}
			if (row >= 1) {
				fColor = Main.getWorkouts().get(0).getExercises()[row - 1].getColor();
			}
			if ((row <= 18) && (row > 0)) {
				label.setBackground(Color.getHSBColor(fColor, fSaturation, fBrightnes));
			} else {
				label.setBackground(Color.BLACK);
			}

			return label;
		}
	}
}
