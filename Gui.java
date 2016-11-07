import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import java.awt.GridLayout;
import java.awt.Point;

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class Gui extends JFrame implements ActionListener {

	int boardRow = 4;
	int boardCol = 8;
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();

	JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(leftPanel),
			new JScrollPane(rightPanel));

	DefaultTableModel model = new DefaultTableModel() {

		@Override
		public boolean isCellEditable(int row, int column) {
			// Only the third column
			return false;
		}
	};

	JTable table;
	private final JLabel lblBattlesheepDashboard = new JLabel("Battlesheep dashboard:");
	private final JLabel lblTotalSheepPerPlayer = new JLabel("Total sheep per player:");
	private final JLabel totalSheep = new JLabel("n");
	private final JLabel lblPlayerDashboard = new JLabel("Player dashboard");
	private final JLabel lblSheepAtHandLabel = new JLabel("Sheep at hand:");
	private final JLabel lblSheepAtHand = new JLabel("n");
	private final JLabel lblFromXCoordinate = new JLabel("From x coordinate:");
	private final JLabel lblFromYCoordinate = new JLabel("From y coordinate:");
	private final JLabel lblxCoordinate = new JLabel("x");
	private final JLabel lblyCoordinate = new JLabel("y");
	private final JButton btnSubmit = new JButton("Done");

	int numberOfSheepsPerPlayer = 0;
	Boolean isHolding = false;

	public Gui() {
		rightPanel.setLayout(new MigLayout("", "[185.00][33.00]", "[][][][][][][][][][][][][][][]"));
		lblBattlesheepDashboard.setFont(new Font("Tahoma", Font.BOLD, 13));

		rightPanel.add(lblBattlesheepDashboard, "cell 0 0");

		rightPanel.add(lblTotalSheepPerPlayer, "cell 0 1");

		rightPanel.add(totalSheep, "cell 1 1,aligny baseline");
		lblPlayerDashboard.setFont(new Font("Tahoma", Font.BOLD, 12));

		rightPanel.add(lblPlayerDashboard, "cell 0 3");

		rightPanel.add(lblSheepAtHandLabel, "cell 0 4");

		rightPanel.add(lblSheepAtHand, "cell 1 4,aligny baseline");

		rightPanel.add(lblFromXCoordinate, "cell 0 5");

		rightPanel.add(lblxCoordinate, "cell 1 5,alignx left");

		rightPanel.add(lblFromYCoordinate, "cell 0 6");

		rightPanel.add(lblyCoordinate, "cell 1 6");
		btnSubmit.setVerticalAlignment(SwingConstants.BOTTOM);

		rightPanel.add(btnSubmit, "cell 0 14,growx");

		this.setSize(1000, 700);

		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		this.setTitle("Battlesheep (Alejandria, Cardano, Matias)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

		getContentPane().add(splitPane);

		splitPane.setSize(1000, 650);
		splitPane.setVisible(true);
		splitPane.setDividerLocation(750);

		initializeTable();
		initializeTableLooks();

		// ask number sheep per player store it in numberOfSheepsPerPlayer
		numberOfSheepsPerPlayer = Integer
				.parseInt(JOptionPane.showInputDialog(this, "Total number of sheeps per player", "Welcome", 2));
		totalSheep.setText(Integer.toString(numberOfSheepsPerPlayer));

		// ask where player wants to put all his sheep (where to put stack)

		model.setValueAt(Integer.toString(numberOfSheepsPerPlayer),
				Integer.parseInt(JOptionPane.showInputDialog(this, "X coordinate:",
						"Where do you want to put all your sheep?", 2)),
				Integer.parseInt(JOptionPane.showInputDialog(this, "Y coordinate:",
						"Where do you want to put all your sheep?", 2)));

		leftPanel.add(table);

		///
		///
		///
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					System.out.println("double clicked");

					int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					System.out.println(row);
					System.out.println(column);
				}
			}
		});

	}

	public void initializeTableLooks() {
		table.setRowHeight(45);
		TableColumn column = null;

		for (int i = 0; i < 8; i++) {
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(45);
		}
		for (int i = 0; i < 8; i++) {
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

	}

	public void initializeTable() {
		// <----><----><----><---->---------table parts

		for (int i = 0; i < boardCol; i++) {
			model.addColumn("*");
		}

		for (int j = 0; j < boardRow * 2; j++) {
			if (j % 2 == 0)
				model.addRow(new Object[] { "0", "<---->", "0", "<---->", "0", "<---->", "0", "|||||" });
			else
				model.addRow(new Object[] { "|||||", "0", "<---->", "0", "<---->", "0", "<---->", "0" });
		}

		// center all data in table

		table = new JTable(model);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
