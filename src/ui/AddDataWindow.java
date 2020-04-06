package ui;

import delegates.DataModificationDelegate;
import model.*;
import ui.Tool.JFrameHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class AddDataWindow extends AbstractWindow implements ActionListener {
    private DataModificationDelegate dataModificationDelegate;

    public AddDataWindow(DataModificationDelegate dataModificationDelegate) {
        this.setTitle("Insert data into database");
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
        this.setSize(450, 500);
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
                    this.displayAppAttrs();
                } else if (item.equals("Account")) {
                    this.displayAccountAttrs();
                } else if (item.equals("Customer")) {
                    this.displayCustomerAttrs();
                } else if (item.equals("CustomerServiceOfficer")) {
                    this.displayCSOAttrs();
                } else if (item.equals("TechnicalStaff")) {
                    this.displayTSAttrs();
                } else if (item.equals("DeliveryMan")) {
                    this.displayDMAttrs();
                } else if (item.equals("Store")) {
                    this.displayStoreAttrs();
                } else if (item.equals("Supplier")) {
                    this.displaySupplierAttrs();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == super.confirm) {
            String table = (String)super.table.getSelectedItem();
            if (table.equals("App")) {
                 this.handleApp();
                 this.dispose();
            } else if (table.equals("Account")) {
                this.handleAccount();
                this.dispose();
            } else if (table.equals("Customer")) {
                this.handleCustomer();
                this.dispose();
            } else if (table.equals("CustomerServiceOfficer")) {
                this.handleCSO();
                this.dispose();
            } else if (table.equals("TechnicalStaff")) {
                this.handleTS();
                this.dispose();
            } else if (table.equals("DeliveryMan")) {
                this.handleDM();
                this.dispose();
            } else if (table.equals("Store")) {
                this.handleStore();
                this.dispose();
            } else if (table.equals("Supplier")) {
                this.handleSupplier();
                this.dispose();
            }
        } else if (e.getSource() == super.cancel) {
            this.dispose();
        }
    }

    private void displayAppAttrs() {
        this.remove(super.mainPanel);
        super.mainPanel = new JPanel();
        super.mainPanel.setLayout(new GridLayout(7, 2));
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(super.nameLabel);
        super.mainPanel.add(super.nameField);
        super.mainPanel.add(super.managerLabel);
        super.mainPanel.add(super.managerField);
        this.add(super.mainPanel);
        this.validate();
        this.repaint();
    }

    private void displayAccountAttrs() {
        this.remove(super.mainPanel);
        super.mainPanel = new JPanel();
        super.mainPanel.setLayout(new GridLayout(7, 2));
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(super.idLabel);
        super.mainPanel.add(super.idField);
        super.mainPanel.add(super.passWordLabel);
        super.mainPanel.add(super.passWordField);
        super.mainPanel.add(super.appNameLabel);
        super.mainPanel.add(super.appNameField);
        this.add(super.mainPanel);
        this.validate();
        this.repaint();
    }

    private void displayCustomerAttrs() {
        this.remove(super.mainPanel);
        super.mainPanel = new JPanel();
        super.mainPanel.setLayout(new GridLayout(7, 2));
        super.mainPanel.add(super.idLabel);
        super.mainPanel.add(super.idField);
        super.mainPanel.add(super.nameLabel);
        super.mainPanel.add(super.nameField);
        super.mainPanel.add(super.phoneNumLabel);
        super.mainPanel.add(super.phoneNumField);
        super.mainPanel.add(super.genderLabel);
        super.mainPanel.add(super.genderJCB);
        super.mainPanel.add(super.addressLabel);
        super.mainPanel.add(super.addressField);
        super.mainPanel.add(super.emailLabel);
        super.mainPanel.add(super.emailField);
        super.mainPanel.add(super.feeLabel);
        super.mainPanel.add(super.feeField);
        this.add(super.mainPanel);
        this.validate();
        this.repaint();
    }

    private void displayCSOAttrs() {
        this.remove(super.mainPanel);
        super.mainPanel = new JPanel();
        super.mainPanel.setLayout(new GridLayout(7, 2));
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(super.idLabel);
        super.mainPanel.add(super.idField);
        super.mainPanel.add(super.nameLabel);
        super.mainPanel.add(super.nameField);
        super.mainPanel.add(super.appNameLabel);
        super.mainPanel.add(super.appNameField);
        super.mainPanel.add(super.cIdLabel);
        super.mainPanel.add(super.cIdField);
        super.mainPanel.add(super.salaryLabel);
        super.mainPanel.add(super.salaryField);
        this.add(super.mainPanel);
        this.validate();
        this.repaint();
    }

    private void displayTSAttrs() {
        this.remove(super.mainPanel);
        super.mainPanel = new JPanel();
        super.mainPanel.setLayout(new GridLayout(7, 2));
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(super.idLabel);
        super.mainPanel.add(super.idField);
        super.mainPanel.add(super.nameLabel);
        super.mainPanel.add(super.nameField);
        super.mainPanel.add(super.appNameLabel);
        super.mainPanel.add(super.appNameField);
        super.mainPanel.add(super.salaryLabel);
        super.mainPanel.add(super.salaryField);
        this.add(super.mainPanel);
        this.validate();
        this.repaint();
    }

    private void displayDMAttrs() {
        this.remove(super.mainPanel);
        super.mainPanel = new JPanel();
        super.mainPanel.setLayout(new GridLayout(7, 2));
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(super.idLabel);
        super.mainPanel.add(super.idField);
        super.mainPanel.add(super.phoneNumLabel);
        super.mainPanel.add(super.phoneNumField);
        super.mainPanel.add(super.appNameLabel);
        super.mainPanel.add(super.appNameField);
        super.mainPanel.add(super.cIdLabel);
        super.mainPanel.add(super.cIdField);
        this.add(super.mainPanel);
        this.validate();
        this.repaint();
    }

    private void displayStoreAttrs() {
        this.remove(super.mainPanel);
        super.mainPanel = new JPanel();
        super.mainPanel.setLayout(new GridLayout(7, 2));
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(super.nameLabel);
        super.mainPanel.add(super.nameField);
        super.mainPanel.add(super.addressLabel);
        super.mainPanel.add(super.addressField);
        super.mainPanel.add(super.goodTypeLabel);
        super.mainPanel.add(super.goodTypeField);
        super.mainPanel.add(super.appNameLabel);
        super.mainPanel.add(super.appNameField);
        this.add(super.mainPanel);
        this.validate();
        this.repaint();
    }

    private void displaySupplierAttrs() {
        this.remove(super.mainPanel);
        super.mainPanel = new JPanel();
        super.mainPanel.setLayout(new GridLayout(7, 2));
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(new JLabel());
        super.mainPanel.add(super.nameLabel);
        super.mainPanel.add(super.nameField);
        super.mainPanel.add(super.productLabel);
        super.mainPanel.add(super.productField);
        super.mainPanel.add(super.storeNameLabel);
        super.mainPanel.add(super.storeNameField);
        super.mainPanel.add(super.priceLabel);
        super.mainPanel.add(super.priceField);
        this.add(super.mainPanel);
        this.validate();
        this.repaint();
    }

    private void handleApp() {
        String name = super.nameField.getText();
        String manager = super.managerField.getText();
        this.dataModificationDelegate.insertApp(new App(name, manager));
        this.dataModificationDelegate.showApp();
        MainWindow.jta.append(MainWindow.end);
    }

    private void handleAccount() {
        int id = Integer.parseInt(super.idField.getText());
        String password = super.passWordField.getText();
        String appName = super.appNameField.getText();
        this.dataModificationDelegate.insertAccount(new Account(id, password, appName));
        this.dataModificationDelegate.showAccount();
        MainWindow.jta.append(MainWindow.end);
    }

    private void handleCustomer() {
        int id = Integer.parseInt(super.idField.getText());
        String name = super.nameField.getText();
        String phoneNumber = super.phoneNumField.getText();
        String gender = (String)super.genderJCB.getSelectedItem();
        String address = super.addressField.getText();
        String email = super.emailField.getText();
        String f = super.feeField.getText();
        int fee = f.equals("") ? 0 : Integer.parseInt(f);
        Customer c = new Customer(id, name, phoneNumber, gender, address, email, fee);
        this.dataModificationDelegate.insertCustomer(c);
        this.dataModificationDelegate.showCustomer();
        MainWindow.jta.append(MainWindow.end);
    }

    private void handleCSO() {
        int id = Integer.parseInt(super.idField.getText());
        String name = super.nameField.getText();
        String appName = super.appNameField.getText();
        int cId = Integer.parseInt(super.cIdField.getText());
        int salary = Integer.parseInt(super.salaryField.getText());
        CSO cso = new CSO(id, name, appName, cId, salary);
        this.dataModificationDelegate.insertCSO(cso);
        this.dataModificationDelegate.showCSO();
        MainWindow.jta.append(MainWindow.end);
    }

    private void handleTS() {
        int id = Integer.parseInt(super.idField.getText());
        String name = super.nameField.getText();
        String appName = super.appNameField.getText();
        int salary = Integer.parseInt(super.salaryField.getText());
        TechnicalStaff staff = new TechnicalStaff(id, name, appName, salary);
        this.dataModificationDelegate.insertTS(staff);
        this.dataModificationDelegate.showTechStaff();
        MainWindow.jta.append(MainWindow.end);
    }

    private void handleDM() {
        int id = Integer.parseInt(super.idField.getText());
        String phoneNumber = super.phoneNumField.getText();
        String appName = super.appNameField.getText();
        int cId = Integer.parseInt(super.cIdField.getText());
        DeliveryMan d = new DeliveryMan(id, phoneNumber, appName, cId);
        this.dataModificationDelegate.insertDM(d);
        this.dataModificationDelegate.showDeliveryMan();
        MainWindow.jta.append(MainWindow.end);
    }

    private void handleStore() {
        String name = super.nameField.getText();
        String address = super.addressField.getText();
        String goodType = super.goodTypeField.getText();
        String appName = super.appNameField.getText();
        Store s = new Store(name, address, goodType, appName);
        this.dataModificationDelegate.insertStore(s);
        this.dataModificationDelegate.showStore();
        MainWindow.jta.append(MainWindow.end);
    }

    private void handleSupplier() {
        String name = super.nameField.getText();
        String product = super.productField.getText();
        String storeName = super.storeNameField.getText();
        int price = Integer.parseInt(super.priceField.getText());
        Supplier s = new Supplier(name, product, storeName, price);
        this.dataModificationDelegate.insertSupplier(s);
        this.dataModificationDelegate.showSupplier();
        MainWindow.jta.append(MainWindow.end);
    }
}
