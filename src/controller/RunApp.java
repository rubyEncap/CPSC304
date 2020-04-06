package controller;

import database.DatabaseHandler;
import database.DatabaseModificationHandler;
import delegates.DataModificationDelegate;
import delegates.LoginWindowDelegate;
import model.*;
import ui.LoginWindow;
import ui.MainWindow;

public class RunApp implements LoginWindowDelegate, DataModificationDelegate {
    private DatabaseHandler dbcHandler;
    private DatabaseModificationHandler dbmHandler;
    private LoginWindow loginWindow;
    public final static String gap = "           ";

    private RunApp() {
        this.dbcHandler = new DatabaseHandler();
        this.dbmHandler = new DatabaseModificationHandler();
    }

    private void start() {
        this.loginWindow = new LoginWindow();
        this.loginWindow.showFrame(this);
    }

    @Override
    public void login(String username, String password) {
        boolean didConnect = this.dbcHandler.login(username, password);

        if (didConnect) {
            loginWindow.dispose();
            new MainWindow(this);
        } else {
            this.loginWindow.handleLoginFailed();

            if (this.loginWindow.hasReachedMaxLoginAttempts()) {
                this.loginWindow.dispose();
                System.out.println("You have exceeded your number of allowed attempts");
                System.exit(-1);
            }
        }
    }

    public static void main(String args[]) {
        RunApp app = new RunApp();
        app.start();
    }

    @Override
    public void insertApp(App app) {
        this.dbmHandler.insertApp(app);
    }

    @Override
    public void insertAccount(Account account) {
        this.dbmHandler.insertAccount(account);
    }

    @Override
    public void insertCustomer(Customer customer) {
        this.dbmHandler.insertCustomer(customer);
    }

    @Override
    public void insertCSO(CSO cso) {
        this.dbmHandler.insertCSO(cso);
    }

    @Override
    public void insertDM(DeliveryMan deliveryMan) {
        this.dbmHandler.insertDM(deliveryMan);
    }

    @Override
    public void insertStore(Store store) {
        this.dbmHandler.insertStore(store);
    }

    @Override
    public void insertSupplier(Supplier supplier) {
        this.dbmHandler.insertSupplier(supplier);
    }

    @Override
    public void insertTS(TechnicalStaff staff) {
        this.dbmHandler.insertTS(staff);
    }

    @Override
    public void deleteData(String table, String primaryKey, int integerValue, String stringValue, boolean isInt) {
        this.dbmHandler.deleteData(table, primaryKey, integerValue, stringValue, isInt);
    }

    @Override
    public void updateDatabase(String table, String attr, String attrValue, String primaryKey, int integerTuple, String stringTuple, boolean isInt) {
        dbmHandler.updateDatabase(table, attr, attrValue, primaryKey, integerTuple, stringTuple, isInt);
    }

    @Override
    public void showApp() {
        MainWindow.jta.append("App: \n");
        App[] apps = this.dbmHandler.getAppInfo();
        for (App app : apps) {
            MainWindow.jta.append(" ");
            MainWindow.jta.append(app.getName() + gap);
            MainWindow.jta.append(app.getManager() + "\n");
        }
        MainWindow.jta.append("\n");
    }

    @Override
    public void showAccount() {
        MainWindow.jta.append("Account: \n");
        Account[] accounts = this.dbmHandler.getAccountInfo();
        for (Account account : accounts) {
            MainWindow.jta.append(" ");
            MainWindow.jta.append(String.valueOf(account.getId()) + gap);
            MainWindow.jta.append(account.getPassword() + gap);
            MainWindow.jta.append(account.getAppName() + "\n");
        }
        MainWindow.jta.append("\n");
    }

    @Override
    public void showCustomer() {
        MainWindow.jta.append("Customer: \n");
        Customer[] customers = this.dbmHandler.getCustomerInfo();
        for (Customer customer : customers) {
            MainWindow.jta.append(" ");
            MainWindow.jta.append(String.valueOf(customer.getId()) + gap);
            MainWindow.jta.append(customer.getName() + gap);
            MainWindow.jta.append(String.valueOf(customer.getPhoneNumber()) + gap);
            MainWindow.jta.append(customer.getGender() + gap);
            MainWindow.jta.append(customer.getAddress() + gap);
            MainWindow.jta.append(customer.getEmail() + gap);
            MainWindow.jta.append(String.valueOf(customer.getFee()) + "\n");
        }
        MainWindow.jta.append("\n");
    }

    @Override
    public void showCSO() {
        MainWindow.jta.append("Customer Service Officer: \n");
        CSO[] csos = this.dbmHandler.getCSOInfo();
        for (CSO cso : csos) {
            MainWindow.jta.append(" ");
            MainWindow.jta.append(String.valueOf(cso.getId()) + gap);
            MainWindow.jta.append(cso.getName() + gap);
            MainWindow.jta.append(cso.getAppName() + gap);
            MainWindow.jta.append(String.valueOf(cso.getCustomerID()) + gap);
            MainWindow.jta.append(String.valueOf(cso.getSalary()) + "\n");
        }
        MainWindow.jta.append("\n");
    }

    @Override
    public void showDeliveryMan() {
        MainWindow.jta.append("Delivery Man: \n");
        DeliveryMan[] deliveryMen = this.dbmHandler.getDMInfo();
        for (DeliveryMan deliveryMan : deliveryMen) {
            MainWindow.jta.append(" ");
            MainWindow.jta.append(String.valueOf(deliveryMan.getId()) + gap);
            MainWindow.jta.append(String.valueOf(deliveryMan.getPhoneNumber()) + gap);
            MainWindow.jta.append(deliveryMan.getAppName() + gap);
            MainWindow.jta.append(String.valueOf(deliveryMan.getCustomerID()) + "\n");
        }
        MainWindow.jta.append("\n");
    }

    @Override
    public void showStore() {
        MainWindow.jta.append("Store: \n");
        Store[] stores = this.dbmHandler.getStoreInfo();
        for (Store store : stores) {
            MainWindow.jta.append(" ");
            MainWindow.jta.append(store.getName() + gap);
            MainWindow.jta.append(store.getAddress() + gap);
            MainWindow.jta.append(store.getGoodType() + gap);
            MainWindow.jta.append(store.getAppName() + "\n");
        }
        MainWindow.jta.append("\n");
    }

    @Override
    public void showSupplier() {
        MainWindow.jta.append("Supplier: \n");
        Supplier[] suppliers = this.dbmHandler.getSupplierInfo();
        for (Supplier supplier : suppliers) {
            MainWindow.jta.append(" ");
            MainWindow.jta.append(supplier.getName() + gap);
            MainWindow.jta.append(supplier.getProduct() + gap);
            MainWindow.jta.append(supplier.getStoreName() + gap);
            MainWindow.jta.append(String.valueOf(supplier.getPrice()) + "\n");
        }
        MainWindow.jta.append("\n");
    }

    @Override
    public void showTechStaff() {
        MainWindow.jta.append("Technical Staff: \n");
        TechnicalStaff[] technicalStaffs = this.dbmHandler.getStaffInfo();
        for (TechnicalStaff technicalStaff : technicalStaffs) {
            MainWindow.jta.append(" ");
            MainWindow.jta.append(String.valueOf(technicalStaff.getId()) + gap);
            MainWindow.jta.append(technicalStaff.getName() + gap);
            MainWindow.jta.append(technicalStaff.getAppName() + gap);
            MainWindow.jta.append(String.valueOf(technicalStaff.getSalary()) + "\n");
        }
        MainWindow.jta.append("\n");
    }

    @Override
    public void selection(String table, String selectField, String whereField, String condition, int integerValue, String stringValue, boolean isInt) {
        this.dbmHandler.selection(table, selectField, whereField, condition, integerValue, stringValue, isInt);
    }

    @Override
    public void projection(String table, String selectField) {
        this.dbmHandler.projection(table, selectField);
    }

    @Override
    public void executeAggregation() {
        this.dbmHandler.executeAggregation();
    }

    @Override
    public void executeGroupBy() {
        this.dbmHandler.executeGroupBy();
    }

    @Override
    public void executeDivision() {
        this.dbmHandler.executeDivision();
    }

    @Override
    public void joinQueryFirst() {
        this.dbmHandler.joinQueryFirst();
    }

    @Override
    public void joinQuerySecond() {
        this.dbmHandler.joinQuerySecond();
    }

    @Override
    public void databaseSetup() {
        this.dbmHandler.databaseSetup();
    }

    @Override
    public void finished() {
        this.dbcHandler.close();
        System.exit(0);
    }
}
