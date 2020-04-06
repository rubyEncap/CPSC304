package ui.Tool;

import javax.swing.*;
import java.awt.*;

public class JFrameHelper {
    private final static int fontSize = 12;

    public static JComboBox<String> initializeTableJComboBox() {
        JComboBox<String> table = new JComboBox<>();
        table.setFont(new Font("system", Font.PLAIN, fontSize));
        table.addItem("");
        table.addItem("App");
        table.addItem("Account");
        table.addItem("Customer");
        table.addItem("CustomerServiceOfficer");
        table.addItem("TechnicalStaff");
        table.addItem("DeliveryMan");
        table.addItem("Store");
        table.addItem("Supplier");
        return table;
    }

    public static JComboBox<String> initializeAppJComboBox() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.setFont(new Font("system", Font.PLAIN, fontSize));
        jComboBox.addItem("*");
        jComboBox.addItem("app_name");
        jComboBox.addItem("app_manager");
        return jComboBox;
    }

    public static JComboBox<String> initializeAccountJComboBox() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.setFont(new Font("system", Font.PLAIN, fontSize));
        jComboBox.addItem("*");
        jComboBox.addItem("account_id");
        jComboBox.addItem("account_password");
        jComboBox.addItem("account_app_name");
        return jComboBox;
    }

    public static JComboBox<String> initializeCustomerJComboBox() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.setFont(new Font("system", Font.PLAIN, fontSize));
        jComboBox.addItem("*");
        jComboBox.addItem("customer_id");
        jComboBox.addItem("customer_name");
        jComboBox.addItem("customer_phone_number");
        jComboBox.addItem("customer_gender");
        jComboBox.addItem("customer_address");
        jComboBox.addItem("customer_email");
        jComboBox.addItem("membership_fee");
        return jComboBox;
    }

    public static JComboBox<String> initializeCSOJComboBox() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.setFont(new Font("system", Font.PLAIN, fontSize));
        jComboBox.addItem("*");
        jComboBox.addItem("cso_id");
        jComboBox.addItem("cso_name");
        jComboBox.addItem("cso_app_name");
        jComboBox.addItem("cso_customer_id");
        jComboBox.addItem("cso_salary");
        return jComboBox;
    }

    public static JComboBox<String> initializeDMJComboBox() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.setFont(new Font("system", Font.PLAIN, fontSize));
        jComboBox.addItem("*");
        jComboBox.addItem("deliveryman_id");
        jComboBox.addItem("deliveryman_phone_number");
        jComboBox.addItem("deliveryman_app_name");
        jComboBox.addItem("deliveryman_customer_id");
        return jComboBox;
    }

    public static JComboBox<String> initializeStoreJComboBox() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.setFont(new Font("system", Font.PLAIN, fontSize));
        jComboBox.addItem("*");
        jComboBox.addItem("store_name");
        jComboBox.addItem("store_address");
        jComboBox.addItem("store_good_type");
        jComboBox.addItem("store_app_name");
        return jComboBox;
    }

    public static JComboBox<String> initializeSupplierJComboBox() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.setFont(new Font("system", Font.PLAIN, fontSize));
        jComboBox.addItem("*");
        jComboBox.addItem("supplier_name");
        jComboBox.addItem("supplier_product");
        jComboBox.addItem("supplier_store_name");
        jComboBox.addItem("supplier_price");
        return jComboBox;
    }

    public static JComboBox<String> initializeTSJComboBox() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.setFont(new Font("system", Font.PLAIN, fontSize));
        jComboBox.addItem("*");
        jComboBox.addItem("techStaff_id");
        jComboBox.addItem("techStaff_name");
        jComboBox.addItem("techStaff_app_name");
        jComboBox.addItem("techStaff_salary");
        return jComboBox;
    }

    public static JComboBox<String> initializeGenderJComboBox() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.setFont(new Font("system", Font.PLAIN, fontSize));
        jComboBox.addItem("");
        jComboBox.addItem("Male");
        jComboBox.addItem("Female");
        jComboBox.addItem("Other");
        return jComboBox;
    }

    public static JComboBox<String> initializeConditionJComboBox() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.setFont(new Font("system", Font.PLAIN, fontSize));
        jComboBox.addItem("<");
        jComboBox.addItem("<=");
        jComboBox.addItem("=");
        jComboBox.addItem(">=");
        jComboBox.addItem(">");
        jComboBox.addItem("<>");
        return jComboBox;
    }

    public static JLabel setUpJLabel(String title) {
        JLabel jLabel = new JLabel(title, JLabel.CENTER);
        jLabel.setFont(new Font("system", Font.PLAIN, fontSize));
        return jLabel;
    }

    public static JButton setUpJButton(String title) {
        JButton jButton = new JButton(title);
        jButton.setFont(new Font("system", Font.PLAIN, fontSize));
        return jButton;
    }

    public static JTextField setUpJTextField(int limit) {
        JTextField jTextField = new JTextField();
        if (limit != 0) {
            jTextField.setDocument(new JTextFieldLimit(limit));
        }
        return jTextField;
    }

    public static void setCenter(Component component) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle rectangle = ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        component.setLocation(((int)((rectangle.getWidth() - component.getWidth()) / 2)), ((int)((rectangle.getHeight() - component.getHeight()) / 2)));
    }
}
