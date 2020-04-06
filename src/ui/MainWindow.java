package ui;

import delegates.DataModificationDelegate;
import ui.Tool.JFrameHelper;
import ui.Tool.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends AbstractWindow implements ActionListener {
	private DataModificationDelegate dataModificationDelegate;
	private MyButton add = new MyButton("Add data");
	private MyButton delete = new MyButton("Delete data");
	private MyButton update = new MyButton("Update data");
	private MyButton sp = new MyButton("Selection And Projection");
	private MyButton join = new MyButton("Join");
	private MyButton aggregation = new MyButton("Aggregation");
	private MyButton groupBy = new MyButton("Group By");
	private MyButton division = new MyButton("Division");
    private MyButton exit = new MyButton("Exit");
    public static JTextArea jta = new JTextArea();
    public static final String end = "===================================================\n";

	public MainWindow(DataModificationDelegate dataModificationDelegate) {
        this.setTitle("Main Menu");
	    this.dataModificationDelegate = dataModificationDelegate;
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        jp1.setLayout(new FlowLayout());
        jp2.setLayout(new BorderLayout());
        this.modifyJButton();
        jp1.add(this.add);
        jp1.add(this.delete);
        jp1.add(this.update);
        jp1.add(this.sp);
        jp1.add(this.join);
        jp1.add(this.aggregation);
        jp1.add(this.groupBy);
        jp1.add(this.division);
        jp2.add(this.exit, BorderLayout.EAST);
        jta.setFont(new Font("system", Font.PLAIN, 14));
        JScrollPane jsp = new JScrollPane(jta);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(jsp);
        this.add(jp1, BorderLayout.NORTH);
        this.add(jp2, BorderLayout.SOUTH);
	    this.setSize(1000, 700);
        JFrameHelper.setCenter(this);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add.addActionListener(this);
        this.delete.addActionListener(this);
        this.update.addActionListener(this);
        this.sp.addActionListener(this);
        this.join.addActionListener(this);
        this.aggregation.addActionListener(this);
        this.groupBy.addActionListener(this);
        this.division.addActionListener(this);
        this.exit.addActionListener(this);

        dataModificationDelegate.databaseSetup();
        dataModificationDelegate.showApp();
        dataModificationDelegate.showAccount();
        dataModificationDelegate.showCustomer();
        dataModificationDelegate.showCSO();
        dataModificationDelegate.showDeliveryMan();
        dataModificationDelegate.showStore();
        dataModificationDelegate.showSupplier();
        dataModificationDelegate.showTechStaff();
        jta.append(end);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == this.add) {
            new AddDataWindow(this.dataModificationDelegate);
        } else if (e.getSource() == this.delete) {
            new DeleteDataWindow(this.dataModificationDelegate);
        } else if (e.getSource() == this.update) {
            new UpdateDataWindow(this.dataModificationDelegate);
        } else if (e.getSource() == this.sp) {
            new SelectionProjectionWindow(this.dataModificationDelegate);
        } else if (e.getSource() == this.join) {
            new JoinDataWindow(this.dataModificationDelegate);
        } else if (e.getSource() == this.aggregation) {
            this.dataModificationDelegate.executeAggregation();
        } else if (e.getSource() == this.groupBy) {
            this.dataModificationDelegate.executeGroupBy();
        } else if (e.getSource() == this.division) {
            this.dataModificationDelegate.executeDivision();
        } else if (e.getSource() == this.exit) {
            this.dispose();
            dataModificationDelegate.finished();
        }
    }

//    private JMenu updateJMenuBar(JMenu jm, ArrayList<JMenuItem> list) {
//        for (JMenuItem jmi : list) {
//            jmi.addActionListener(this);
//            jm.add(jmi);
//        }
//        return jm;
//    }

    private void modifyJButton() {
        this.add.setPreferredSize(new Dimension(100,50));
        this.delete.setPreferredSize(new Dimension(100, 50));
        this.update.setPreferredSize(new Dimension(105, 50));
        this.sp.setPreferredSize(new Dimension(180, 50));
        this.join.setPreferredSize(new Dimension(100, 50));
        this.aggregation.setPreferredSize(new Dimension(100, 50));
        this.groupBy.setPreferredSize(new Dimension(100, 50));
        this.division.setPreferredSize(new Dimension(100, 50));
        this.exit.setPreferredSize(new Dimension(80, 40));
    }
}
