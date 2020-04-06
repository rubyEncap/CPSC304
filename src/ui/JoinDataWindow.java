package ui;

import delegates.DataModificationDelegate;
import ui.Tool.JFrameHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinDataWindow extends AbstractWindow implements ActionListener {
    private DataModificationDelegate dataModificationDelegate;
    private JLabel jLabelTable1, jLabelTable2, jLabelChoose1, jLabelChoose2, jLabelQuery;
    private JComboBox<String> queries = new JComboBox<>();

    public JoinDataWindow(DataModificationDelegate dataModificationDelegate) {
        this.setTitle("Join");
        this.dataModificationDelegate = dataModificationDelegate;
        this.jLabelTable1 = JFrameHelper.setUpJLabel("Account");
        this.jLabelTable2 = JFrameHelper.setUpJLabel("Customer");
        this.jLabelChoose1 = JFrameHelper.setUpJLabel("First table chosen:");
        this.jLabelChoose2 = JFrameHelper.setUpJLabel("Second table chosen:");
        this.jLabelQuery = JFrameHelper.setUpJLabel("Choose Query:");
        this.queries.addItem("Query 1");
        this.queries.addItem("Query 2");
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        jp1.setLayout(new GridLayout(5, 2));
        jp2.setLayout(new GridLayout(1, 1));
        jp1.add(new JLabel());
        jp1.add(new JLabel());
        jp1.add(jLabelChoose1);
        jp1.add(jLabelTable1);
        jp1.add(jLabelChoose2);
        jp1.add(jLabelTable2);
        jp1.add(jLabelQuery);
        jp1.add(queries);
        jp2.add(super.confirm);
        jp2.add(super.cancel);
        this.add(jp1);
        this.setSize(450, 400);
        this.add(jp2, BorderLayout.SOUTH);
        JFrameHelper.setCenter(this);
        this.setVisible(true);

        super.confirm.addActionListener(this);
        super.cancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == super.confirm) {
            String query = (String)this.queries.getSelectedItem();
            if (query.equals("Query 1")) {
                this.dataModificationDelegate.joinQueryFirst();
            } else if (query.equals("Query 2")) {
                this.dataModificationDelegate.joinQuerySecond();
            }
            this.dispose();
        } else if (e.getSource() == super.cancel) {
            this.dispose();
        }
    }
}
