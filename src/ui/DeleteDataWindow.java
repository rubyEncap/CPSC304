package ui;

import delegates.DataModificationDelegate;
import ui.Tool.JFrameHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class DeleteDataWindow extends AbstractWindow implements ActionListener {
    private DataModificationDelegate dataModificationDelegate;

    public DeleteDataWindow(DataModificationDelegate dataModificationDelegate) {
        this.setTitle("Delete data from database");
        this.dataModificationDelegate = dataModificationDelegate;
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
                Object item = e.getItem();
                if (item.equals("")) {
                    this.remove(super.mainPanel);
                    this.repaint();
                } else if (item.equals("App") || item.equals("Store") || item.equals("Supplier")) {
                    this.setUpPanel(true);
                } else {
                    this.setUpPanel(false);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == super.confirm) {
            String table = (String)super.table.getSelectedItem();
            if (table.equals("App") || table.equals("Store") || table.equals("Supplier")) {
                this.handleDeleteWithName();
                this.dispose();
            } else {
                this.handleDeleteWithId();
                this.dispose();
            }
        } else if (e.getSource() == super.cancel) {
            this.dispose();
        }
    }

    private void setUpPanel(boolean name) {
        this.remove(super.mainPanel);
        super.mainPanel = new JPanel();
        super.mainPanel.setLayout(new GridLayout(3, 2));
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        if (name) {
            super.mainPanel.add(super.nameLabel);
            super.mainPanel.add(super.nameField);
        } else {
            super.mainPanel.add(super.idLabel);
            super.mainPanel.add(super.idField);
        }
        this.add(super.mainPanel);
        this.validate();
        this.repaint();
    }

    private void handleDeleteWithName() {
        String table = (String)super.table.getSelectedItem();
        String name = super.nameField.getText();
        if (table.equals("App")) {
            this.dataModificationDelegate.deleteData("app", "app_name", 0, name, false);
            this.dataModificationDelegate.showApp();
        } else if (table.equals("Store")) {
            this.dataModificationDelegate.deleteData("store", "store_name", 0, name, false);
            this.dataModificationDelegate.showStore();
        } else {
            this.dataModificationDelegate.deleteData("supplier", "supplier_name", 0, name, false);
            this.dataModificationDelegate.showSupplier();
        }
        MainWindow.jta.append(MainWindow.end);
    }

    private void handleDeleteWithId() {
        String table = (String)super.table.getSelectedItem();
        int id = Integer.parseInt(super.idField.getText());
        if (table.equals("Account")) {
            this.dataModificationDelegate.deleteData("account", "account_id", id, null, true);
            this.dataModificationDelegate.showAccount();
        } else if (table.equals("Customer")) {
            this.dataModificationDelegate.deleteData("customer", "customer_id", id, null, true);
            this.dataModificationDelegate.showCustomer();
        } else if (table.equals("CustomerServiceOfficer")) {
            this.dataModificationDelegate.deleteData("cso", "cso_id", id, null, true);
            this.dataModificationDelegate.showCSO();
        } else if (table.equals("TechnicalStaff")) {
            this.dataModificationDelegate.deleteData("techStaff", "techStaff_id", id, null, true);
            this.dataModificationDelegate.showTechStaff();
        } else if (table.equals("DeliveryMan")) {
            this.dataModificationDelegate.deleteData("deliveryman", "deliveryman_id", id, null, true);
            this.dataModificationDelegate.showDeliveryMan();
        }
        MainWindow.jta.append(MainWindow.end);
    }
}
