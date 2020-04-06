package ui;

import ui.Tool.JFrameHelper;

import javax.swing.*;

public abstract class AbstractWindow extends JFrame {
    protected JPanel mainPanel = new JPanel();

    protected final JComboBox<String> table = JFrameHelper.initializeTableJComboBox();
    protected final JComboBox<String> appJCB = JFrameHelper.initializeAppJComboBox();
    protected final JComboBox<String> accountJCB = JFrameHelper.initializeAccountJComboBox();
    protected final JComboBox<String> customerJCB = JFrameHelper.initializeCustomerJComboBox();
    protected final JComboBox<String> csoJCB = JFrameHelper.initializeCSOJComboBox();
    protected final JComboBox<String> dmJCB = JFrameHelper.initializeDMJComboBox();
    protected final JComboBox<String> storeJCB = JFrameHelper.initializeStoreJComboBox();
    protected final JComboBox<String> supplierJCB = JFrameHelper.initializeSupplierJComboBox();
    protected final JComboBox<String> tsJCB = JFrameHelper.initializeTSJComboBox();
    protected final JComboBox<String> genderJCB = JFrameHelper.initializeGenderJComboBox();
    protected final JComboBox<String> cloneAppJCB = JFrameHelper.initializeAppJComboBox();
    protected final JComboBox<String> cloneAccountJCB = JFrameHelper.initializeAccountJComboBox();
    protected final JComboBox<String> cloneCustomerJCB = JFrameHelper.initializeCustomerJComboBox();
    protected final JComboBox<String> cloneCSOJCB = JFrameHelper.initializeCSOJComboBox();
    protected final JComboBox<String> cloneDMJCB = JFrameHelper.initializeDMJComboBox();
    protected final JComboBox<String> cloneStoreJCB = JFrameHelper.initializeStoreJComboBox();
    protected final JComboBox<String> cloneSupplierJCB = JFrameHelper.initializeSupplierJComboBox();
    protected final JComboBox<String> cloneTSJCB = JFrameHelper.initializeTSJComboBox();
    protected final JComboBox<String> cloneGenderJCB = JFrameHelper.initializeGenderJComboBox();

    protected final JLabel nameLabel = JFrameHelper.setUpJLabel("Name:");
    protected final JLabel appNameLabel = JFrameHelper.setUpJLabel("App Name:");
    protected final JLabel managerLabel = JFrameHelper.setUpJLabel("Manager:");
    protected final JLabel idLabel = JFrameHelper.setUpJLabel("ID:");
    protected final JLabel cIdLabel = JFrameHelper.setUpJLabel("Customer ID:");
    protected final JLabel passWordLabel = JFrameHelper.setUpJLabel("Password:");
    protected final JLabel phoneNumLabel = JFrameHelper.setUpJLabel("Phone Number:");
    protected final JLabel genderLabel = JFrameHelper.setUpJLabel("Gender:");
    protected final JLabel addressLabel = JFrameHelper.setUpJLabel("Address:");
    protected final JLabel emailLabel = JFrameHelper.setUpJLabel("Email:");
    protected final JLabel goodTypeLabel = JFrameHelper.setUpJLabel("Good Type:");
    protected final JLabel productLabel = JFrameHelper.setUpJLabel("Product:");
    protected final JLabel storeNameLabel = JFrameHelper.setUpJLabel("Store Name:");
    protected final JLabel feeLabel = JFrameHelper.setUpJLabel("Fee:");
    protected final JLabel salaryLabel = JFrameHelper.setUpJLabel("Salary:");
    protected final JLabel priceLabel = JFrameHelper.setUpJLabel("Price:");
    protected final JLabel jLabel1 = JFrameHelper.setUpJLabel("Choose Table:");
    protected final JLabel jLabel2 = JFrameHelper.setUpJLabel("Please input below information");
    protected final JLabel chooseLabel = JFrameHelper.setUpJLabel("Choose Field:");

    protected final JTextField nameField = JFrameHelper.setUpJTextField(20);
    protected final JTextField appNameField = JFrameHelper.setUpJTextField(20);
    protected final JTextField managerField = JFrameHelper.setUpJTextField(20);
    protected final JTextField idField = JFrameHelper.setUpJTextField(9);
    protected final JTextField cIdField = JFrameHelper.setUpJTextField(20);
    protected final JTextField passWordField = JFrameHelper.setUpJTextField(20);
    protected final JTextField phoneNumField = JFrameHelper.setUpJTextField(11);
    protected final JTextField addressField = JFrameHelper.setUpJTextField(20);
    protected final JTextField emailField = JFrameHelper.setUpJTextField(20);
    protected final JTextField goodTypeField = JFrameHelper.setUpJTextField(20);
    protected final JTextField productField = JFrameHelper.setUpJTextField(20);
    protected final JTextField storeNameField = JFrameHelper.setUpJTextField(20);
    protected final JTextField feeField = JFrameHelper.setUpJTextField(9);
    protected final JTextField salaryField = JFrameHelper.setUpJTextField(9);
    protected final JTextField priceField = JFrameHelper.setUpJTextField(9);

    protected final JButton confirm = JFrameHelper.setUpJButton("Confirm");
    protected final JButton cancel = JFrameHelper.setUpJButton("Cancel");
}
