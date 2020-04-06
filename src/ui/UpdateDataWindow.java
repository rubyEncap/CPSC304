package ui;

import delegates.DataModificationDelegate;
import ui.Tool.JFrameHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class UpdateDataWindow extends AbstractWindow implements ActionListener {
    private DataModificationDelegate dataModificationDelegate;
    private JTextField jtf1, jtf2;
    private final JLabel whereName = JFrameHelper.setUpJLabel("Where Name is:");
    private final JLabel whereId = JFrameHelper.setUpJLabel("Where ID is:");

    public UpdateDataWindow(DataModificationDelegate dataModificationDelegate) {
        this.setTitle("Update data in database");
        this.dataModificationDelegate = dataModificationDelegate;
        this.jtf1 = JFrameHelper.setUpJTextField(0);
        this.jtf2 = JFrameHelper.setUpJTextField(0);
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
        this.setSize(450, 300);
        JFrameHelper.setCenter(this);
        this.setVisible(true);

        super.confirm.addActionListener(this);
        super.cancel.addActionListener(this);
        super.table.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Object item =  e.getItem();
                if (item.equals("")) {
                    this.remove(super.mainPanel);
                    this.repaint();
                } else if (item.equals("App")) {
                    this.setUpPanel(super.appJCB, true);
                } else if (item.equals("Account")) {
                    this.setUpPanel(super.accountJCB, false);
                } else if (item.equals("Customer")) {
                    this.setUpPanel(super.customerJCB, false);
                } else if (item.equals("CustomerServiceOfficer")) {
                    this.setUpPanel(super.csoJCB, false);
                } else if (item.equals("TechnicalStaff")) {
                    this.setUpPanel(super.tsJCB,false);
                } else if (item.equals("DeliveryMan")) {
                    this.setUpPanel(super.dmJCB, false);
                } else if (item.equals("Store")) {
                    this.setUpPanel(super.storeJCB, true);
                } else if (item.equals("Supplier")) {
                    this.setUpPanel(super.supplierJCB, true);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == super.confirm) {
            String table = (String)super.table.getSelectedItem();
            if (table.equals("App")) {
                this.handleUpdate("app", super.appJCB);
                this.dataModificationDelegate.showApp();
                this.dispose();
            } else if (table.equals("Account")) {
                this.handleUpdate("account", super.accountJCB);
                this.dataModificationDelegate.showAccount();
                this.dispose();
            } else if (table.equals("Customer")) {
                this.handleUpdate("customer", super.customerJCB);
                this.dataModificationDelegate.showCustomer();
                this.dispose();
            } else if (table.equals("CustomerServiceOfficer")) {
                this.handleUpdate("cso", super.csoJCB);
                this.dataModificationDelegate.showCSO();
                this.dispose();
            } else if (table.equals("TechnicalStaff")) {
                this.handleUpdate("techStaff", super.tsJCB);
                this.dataModificationDelegate.showTechStaff();
                this.dispose();
            } else if (table.equals("DeliveryMan")) {
                this.handleUpdate("deliveryman", super.dmJCB);
                this.dataModificationDelegate.showDeliveryMan();
                this.dispose();
            } else if (table.equals("Store")) {
                this.handleUpdate("store", super.storeJCB);
                this.dataModificationDelegate.showStore();
                this.dispose();
            } else if (table.equals("Supplier")) {
                this.handleUpdate("supplier", super.supplierJCB);
                this.dataModificationDelegate.showSupplier();
                this.dispose();
            }
            MainWindow.jta.append(MainWindow.end);
        } else if (e.getSource() == super.cancel) {
            this.dispose();
        }
    }

    private void setUpPanel(JComboBox<String> jComboBox, boolean name) {
        this.remove(super.mainPanel);
        super.mainPanel = new JPanel();
        super.mainPanel.setLayout(new GridLayout(5, 2));
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(jComboBox);
        super.mainPanel.add(this.jtf1);
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        if (name) {
            super.mainPanel.add(this.whereName);
        } else {
            super.mainPanel.add(this.whereId);
        }
        super.mainPanel.add(this.jtf2);
        this.add(super.mainPanel);
        this.validate();
        this.repaint();
    }

    private void handleUpdate(String table, JComboBox<String> jComboBox) {
        String attr = (String)jComboBox.getSelectedItem();
        String attrValue = this.jtf1.getText();
        int integerTuple;
        String stringTuple;
        String primaryKey;
        if (table.equals("app") || table.equals("store") || table.equals("supplier")) {
            primaryKey = table + "_name";
            stringTuple = this.jtf2.getText();
            this.dataModificationDelegate.updateDatabase(table, attr, attrValue, primaryKey, 0, stringTuple,  false);
        } else {
            primaryKey = table + "_id";
            integerTuple = Integer.parseInt(this.jtf2.getText());
            this.dataModificationDelegate.updateDatabase(table, attr, attrValue, primaryKey, integerTuple, null,  true);
        }
    }
}
