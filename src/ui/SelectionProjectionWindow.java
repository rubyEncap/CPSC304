package ui;

import delegates.DataModificationDelegate;
import ui.Tool.JFrameHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class SelectionProjectionWindow extends AbstractWindow implements ActionListener {
    private DataModificationDelegate dataModificationDelegate;
    private JComboBox<String> conditionJCB = JFrameHelper.initializeConditionJComboBox();
    private JTextField jtx = JFrameHelper.setUpJTextField(9);
    private JPanel conditionPanel, backgroundPanel;
    private JCheckBox jCheckBox = new JCheckBox("Use Where?");

    public SelectionProjectionWindow(DataModificationDelegate dataModificationDelegate){
        this.setTitle("Select data from database");
        this.dataModificationDelegate = dataModificationDelegate;
        this.backgroundPanel = new JPanel();
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        jp1.setLayout(new GridLayout(1, 1));
        jp2.setLayout(new GridLayout(4, 0));
        jp3.setLayout(new GridLayout(1, 1));
        jp1.add(super.jLabel1);
        jp1.add(super.table);
        jp2.add(new JLabel());
        jp2.add(jp1);
        jp2.add(new JLabel());
        jp2.add(super.jLabel2);
        this.add(jp2, BorderLayout.NORTH);
        jp3.add(super.confirm);
        jp3.add(super.cancel);
        this.add(jp3, BorderLayout.SOUTH);
        this.setSize(450, 500);
        JFrameHelper.setCenter(this);
        this.setAlwaysOnTop(true);
        this.setVisible(true);

        super.confirm.addActionListener(this);
        super.cancel.addActionListener(this);
        super.table.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Object item =  e.getItem();
                if (item.equals("")) {
                    this.remove(this.backgroundPanel);
                    this.repaint();
                } else if (item.equals("App")) {
                    this.setUpPanel(super.appJCB, super.cloneAppJCB);
                } else if (item.equals("Account")) {
                    this.setUpPanel(super.accountJCB, super.cloneAccountJCB);
                } else if (item.equals("Customer")) {
                    this.setUpPanel(super.customerJCB, super.cloneCustomerJCB);
                } else if (item.equals("CustomerServiceOfficer")) {
                    this.setUpPanel(super.csoJCB, super.cloneCSOJCB);
                } else if (item.equals("TechnicalStaff")) {
                    this.setUpPanel(super.tsJCB, super.cloneTSJCB);
                } else if (item.equals("DeliveryMan")) {
                    this.setUpPanel(super.dmJCB, super.cloneDMJCB);
                } else if (item.equals("Store")) {
                    this.setUpPanel(super.storeJCB, super.cloneStoreJCB);
                } else if (item.equals("Supplier")) {
                    this.setUpPanel(super.supplierJCB, super.cloneSupplierJCB);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == super.confirm) {
            String table = (String)super.table.getSelectedItem();
            if (table.equals("App")) {
                this.handle("app", super.appJCB, super.cloneAppJCB);
                this.dispose();
            } else if (table.equals("Account")) {
                this.handle("account", super.accountJCB, super.cloneAccountJCB);
                this.dispose();
            } else if (table.equals("Customer")) {
                this.handle("customer", super.customerJCB, super.cloneCustomerJCB);
                this.dispose();
            } else if (table.equals("CustomerServiceOfficer")) {
                this.handle("cso", super.csoJCB, super.cloneCSOJCB);
                this.dispose();
            } else if (table.equals("TechnicalStaff")) {
                this.handle("techStaff", super.tsJCB, super.cloneTSJCB);
                this.dispose();
            } else if (table.equals("DeliveryMan")) {
                this.handle("deliveryman", super.dmJCB, super.cloneDMJCB);
                this.dispose();
            } else if (table.equals("Store")) {
                this.handle("store", super.storeJCB, super.cloneStoreJCB);
                this.dispose();
            } else if (table.equals("Supplier")) {
                this.handle("supplier", super.supplierJCB, super.cloneSupplierJCB);
                this.dispose();
            }
        } else if (e.getSource() == super.cancel) {
            this.dispose();
        }
    }

    private void setUpPanel(JComboBox<String> jComboBox1, JComboBox<String> jComboBox2) {
        this.remove(this.backgroundPanel);
        this.conditionPanel = new JPanel();
        this.conditionPanel.setLayout(new GridLayout(1, 3));
        this.backgroundPanel = new JPanel();
        this.backgroundPanel.setLayout(new GridLayout(4, 0));
        super.mainPanel = new JPanel();
        super.mainPanel.setLayout(new GridLayout(3, 2 ));
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(super.chooseLabel);
        super.mainPanel.add(jComboBox1);
        this.conditionPanel.add(jComboBox2);
        this.conditionPanel.add(this.conditionJCB);
        this.conditionPanel.add(this.jtx);
        this.backgroundPanel.add(super.mainPanel);
        this.backgroundPanel.add(this.jCheckBox);
        this.backgroundPanel.add(this.conditionPanel);
        this.add(this.backgroundPanel);
        this.validate();
        this.repaint();
    }

    private void handle(String table, JComboBox<String> jComboBox1, JComboBox<String> jComboBox2) {
        if (this.jCheckBox.isSelected()) {
            this.handleSelection(table, jComboBox1, jComboBox2);
        } else {
            this.handleProjection(table, jComboBox1);
        }
    }

    private void handleSelection(String table, JComboBox<String> jComboBox1, JComboBox<String> jComboBox2) {
        String selectField = (String)jComboBox1.getSelectedItem();
        String whereField = (String)jComboBox2.getSelectedItem();
        String condition = (String)this.conditionJCB.getSelectedItem();
        String text = this.jtx.getText();
        String a = !whereField.equals("*")? whereField.substring(whereField.indexOf("_") + 1) : whereField;
        if (a.equals("id") || a.equals("fee") || a.equals("customer_id") || a.equals("salary") || a.equals("price")) {
            int value = Integer.parseInt(text);
            this.dataModificationDelegate.selection(table, selectField, whereField, condition, value, null, true);
        } else {
            this.dataModificationDelegate.selection(table, selectField, whereField, condition, 0, text, false);
        }
    }

    private void handleProjection(String table, JComboBox<String> jComboBox) {
        String selectField = (String)jComboBox.getSelectedItem();
        this.dataModificationDelegate.projection(table, selectField);
    }
}
