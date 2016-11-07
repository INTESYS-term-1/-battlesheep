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

public class Gui extends JFrame implements ActionListener {

	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();

	JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(leftPanel),
			new JScrollPane(rightPanel));

	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);

	public Gui() {
		// this.setSize(700, 700);
		//
		// this.setLocationRelativeTo(null);
		// getContentPane().setLayout(null);
		//
		// this.setTitle("Battlesheep (Alejandria, Cardano, Matias)");
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setResizable(false);
		// this.setVisible(true);

		this.setSize(1000, 700);

		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		this.setTitle("Battlesheep (Alejandria, Cardano, Matias)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

		this.add(splitPane);

		splitPane.setSize(1000, 650);
		splitPane.setVisible(true);
		splitPane.setDividerLocation(450);

		// -------------------------------------------------table parts

		table.setRowHeight(30);

		for (int i = 0; i <= 15; i++) {
			model.addColumn("*");
		}

		TableColumn column = null;
		for (int i = 0; i < 15; i++) {
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(50);
		}

		for (int j = 0; j < 20; j++) {
			if (j % 2 == 0)
				model.addRow(new Object[] { "0", "<---->", "0", "<---->", "0", "<---->", "0", "<---->", "0", "<---->",
						"0", "<---->", "0", "<---->", "0" });
			else
				model.addRow(new Object[] { "----------", "0", "----------", "0", "----------", "0", "----------", "0",
						"----------", "0", "----------", "0", "----------", "0", "----------", });

		}

		// center all data in table

		for (int i = 0; i < 15; i++) {
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		// Color color = UIManager.getColor("Table.gridColor");
		// MatteBorder border = new MatteBorder(1, 1, 0, 0, color);

		// table.setBorder(border);

		leftPanel.add(table);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}