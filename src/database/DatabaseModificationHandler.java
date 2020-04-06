package database;

import controller.RunApp;
import model.*;
import org.apache.ibatis.jdbc.ScriptRunner;
import ui.MainWindow;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseModificationHandler extends DatabaseHandler {

    public void databaseSetup() {
        try {
            this.dropTables();
            ScriptRunner runner = new ScriptRunner(connection);
            runner.setSendFullScript(false);
            runner.setFullLineDelimiter(false);
            runner.setDelimiter(";");
            runner.setLogWriter(null);
            runner.runScript(new InputStreamReader(new FileInputStream("./src/sql/scripts/databaseSetup.sql")));

        } catch (IOException e) {
            MainWindow.jta.append(e.getMessage());
        }
    }

    public void deleteData(String table, String primaryKey, int integerValue, String stringValue, boolean isInt) {
        try {
            String statement = "DELETE FROM " + table + " WHERE " + primaryKey + " = ?";
            PreparedStatement ps = connection.prepareStatement(statement);
            if (isInt) {
                ps.setInt(1, integerValue);
            } else {
                ps.setString(1, stringValue);
            }

            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void insertApp(App app) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO app VALUES (?,?)");
            ps.setString(1, app.getName());
            ps.setString(2, app.getManager());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
    }

    public void insertAccount(Account account) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO account VALUES (?,?,?)");
            ps.setInt(1, account.getId());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getAppName());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void insertCustomer(Customer customer) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getPhoneNumber());
            ps.setString(4, customer.getGender());
            ps.setString(5, customer.getAddress());
            ps.setString(6, customer.getEmail());
            ps.setInt(7, customer.getFee());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }

    }

    public void insertCSO(CSO cso) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cso VALUES (?,?,?,?,?)");
            ps.setInt(1, cso.getId());
            ps.setString(2, cso.getName());
            ps.setString(3, cso.getAppName());
            ps.setInt(4, cso.getCustomerID());
            ps.setInt(5, cso.getSalary());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void insertDM(DeliveryMan deliveryMan) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO deliveryman VALUES (?,?,?,?)");
            ps.setInt(1, deliveryMan.getId());
            ps.setString(2, deliveryMan.getPhoneNumber());
            ps.setString(3, deliveryMan.getAppName());
            ps.setInt(4, deliveryMan.getCustomerID());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void insertStore(Store store) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO store VALUES (?,?,?,?)");
            ps.setString(1, store.getName());
            ps.setString(2, store.getAddress());
            ps.setString(3, store.getGoodType());
            ps.setString(4, store.getAppName());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void insertSupplier(Supplier supplier) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO supplier VALUES (?,?,?,?)");
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getProduct());
            ps.setString(3, supplier.getStoreName());
            ps.setInt(4, supplier.getPrice());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void insertTS(TechnicalStaff staff) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO techStaff VALUES (?,?,?,?)");
            ps.setInt(1, staff.getId());
            ps.setString(2, staff.getName());
            ps.setString(3, staff.getAppName());
            ps.setInt(4, staff.getSalary());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

	public App[] getAppInfo() {
        ArrayList<App> result = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM app");

			while(rs.next()) {
				App app = new App(rs.getString("app_name"),
                                  rs.getString("app_manager"));
				result.add(app);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
		}
		return result.toArray(new App[result.size()]);
    }

    public Account[] getAccountInfo() {
        ArrayList<Account> result = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account");

            while(rs.next()) {
                Account account = new Account(rs.getInt("account_id"),
                                              rs.getString("account_password"),
                                              rs.getString("account_app_name"));
                result.add(account);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Account[result.size()]);
    }

    public Customer[] getCustomerInfo() {
        ArrayList<Customer> result = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

            while(rs.next()) {
                Customer customer = new Customer(rs.getInt("customer_id"),
                                                 rs.getString("customer_name"),
                                                 rs.getString("customer_phone_number"),
                                                 rs.getString("customer_gender"),
                                                 rs.getString("customer_address"),
                                                 rs.getString("customer_email"),
                                                 rs.getInt("membership_fee"));
                result.add(customer);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Customer[result.size()]);
    }

    public CSO[] getCSOInfo() {
        ArrayList<CSO> result = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cso");

            while(rs.next()) {
                CSO cso = new CSO(rs.getInt("cso_id"),
                                  rs.getString("cso_name"),
                                  rs.getString("cso_app_name"),
                                  rs.getInt("cso_customer_id"),
                                  rs.getInt("cso_salary"));
                result.add(cso);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new CSO[result.size()]);
    }

    public DeliveryMan[] getDMInfo() {
        ArrayList<DeliveryMan> result = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM deliveryman");

            while(rs.next()) {
                DeliveryMan deliveryMan = new DeliveryMan(rs.getInt("deliveryman_id"),
                                                          rs.getString("deliveryman_phone_number"),
                                                          rs.getString("deliveryman_app_name"),
                                                          rs.getInt("deliveryman_customer_id"));
                result.add(deliveryMan);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new DeliveryMan[result.size()]);
    }

    public Store[] getStoreInfo() {
        ArrayList<Store> result = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM store");

            while(rs.next()) {
                Store store = new Store(rs.getString("store_name"),
                                        rs.getString("store_address"),
                                        rs.getString("store_good_type"),
                                        rs.getString("store_app_name"));
                result.add(store);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Store[result.size()]);
    }

    public Supplier[] getSupplierInfo() {
        ArrayList<Supplier> result = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM supplier");

            while(rs.next()) {
                Supplier supplier = new Supplier(rs.getString("supplier_name"),
                                                 rs.getString("supplier_product"),
                                                 rs.getString("supplier_store_name"),
                                                 rs.getInt("supplier_price"));
                result.add(supplier);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Supplier[result.size()]);
    }

    public TechnicalStaff[] getStaffInfo() {
        ArrayList<TechnicalStaff> result = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM techStaff");

            while(rs.next()) {
                TechnicalStaff supplier = new TechnicalStaff(rs.getInt("techStaff_id"),
                                                             rs.getString("techStaff_name"),
                                                             rs.getString("techStaff_app_name"),
                                                             rs.getInt("techStaff_salary"));
                result.add(supplier);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new TechnicalStaff[result.size()]);
    }

    public void updateDatabase(String table, String attr, String attrValue, String primaryKey, int integerTuple, String stringTuple, boolean isInt) {
        try {
            String suffix = attr.substring(attr.indexOf("_") + 1);
            String statement = "UPDATE " + table + " SET " + attr + " = ? WHERE " + primaryKey + " = ?";
            PreparedStatement ps = connection.prepareStatement(statement);
            if (isInt) {
                if (suffix.equals("id") || suffix.equals("fee") || suffix.equals("customer_id") || suffix.equals("salary")) {
                    int value = Integer.parseInt(attrValue);
                    ps.setInt(1, value);
                } else {
                    ps.setString(1, attrValue);
                }
                ps.setInt(2, integerTuple);
            } else {
                if (suffix.equals("price")) {
                    int value = Integer.parseInt(attrValue);
                    ps.setInt(1, value);
                } else {
                    ps.setString(1, attrValue);
                }
                ps.setString(2, stringTuple);
            }
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void selection(String table, String selectField, String whereField, String condition, int integerValue, String stringValue, boolean isInt) {
        try {
            String statement = "SELECT " + selectField + " FROM " + table + " WHERE " + whereField + " " + condition + " ?";
            PreparedStatement ps = connection.prepareStatement(statement);
            if (isInt) {
                ps.setInt(1, integerValue);
            } else {
                ps.setString(1, stringValue);
            }
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for(int i = 0; i < rsmd.getColumnCount(); i++) {
                    MainWindow.jta.append(rs.getString(i + 1) + RunApp.gap);
                }
                MainWindow.jta.append("\n");
            }
            MainWindow.jta.append(MainWindow.end);
            rs.close();
            ps.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void projection(String table, String selectField) {
        try {
            String statement = "SELECT " + selectField + " FROM " + table;
            PreparedStatement ps = connection.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for(int i = 0; i < rsmd.getColumnCount(); i++) {
                    MainWindow.jta.append(rs.getString(i + 1) + RunApp.gap);
                }
                MainWindow.jta.append("\n");
            }
            MainWindow.jta.append(MainWindow.end);
            rs.close();
            ps.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void executeAggregation() {
        MainWindow.jta.append("Aggregation Query: Get average price of products offered by all suppliers.\n");
        String statement = "SELECT AVG (supplier_price) FROM supplier";
        MainWindow.jta.append("Statement: " + statement + "\n\n");
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            while(rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for(int i = 0; i < rsmd.getColumnCount(); i++) {
                    MainWindow.jta.append(rs.getString(i + 1) + RunApp.gap);
                }
                MainWindow.jta.append("\n");
            }
            MainWindow.jta.append(MainWindow.end);
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void executeGroupBy() {
        MainWindow.jta.append("GroupBy Query: Get number of customers in different gender.\n");
        String statement = "SELECT customer_gender, COUNT (*) FROM customer GROUP BY customer_gender";
        MainWindow.jta.append("Statement: " + statement + "\n\n");
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            while(rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for(int i = 0; i < rsmd.getColumnCount(); i++) {
                    MainWindow.jta.append(rs.getString(i + 1) + RunApp.gap);
                }
                MainWindow.jta.append("\n");
            }
            MainWindow.jta.append(MainWindow.end);
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void executeDivision() {
        MainWindow.jta.append("Division Query: Find the name of all suppliers who do not supply Korean food to stores\n.\n");
        String statement = "SELECT s.supplier_name " +
                           "FROM supplier s " +
                           "WHERE NOT EXISTS " +
                           "(SELECT s1.store_name " +
                           "FROM store s1 " +
                           "WHERE s1.store_good_type = 'Korean food'" +
                           "AND s1.store_name IN" +
                           "(SELECT s2.store_name " +
                           "FROM store s2 " +
                           "WHERE s2.store_name = s.supplier_store_name))";
        MainWindow.jta.append("Statement: " + statement + "\n\n");
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            while(rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for(int i = 0; i < rsmd.getColumnCount(); i++) {
                    MainWindow.jta.append(rs.getString(i + 1) + RunApp.gap);
                }
                MainWindow.jta.append("\n");
            }
            MainWindow.jta.append(MainWindow.end);
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void joinQueryFirst() {
        MainWindow.jta.append("Join Query: Find all emails of customer who use Ubereats.\n");
        String statement = "SELECT customer_email FROM customer, account WHERE customer.customer_id = account.account_id AND account.account_app_name = 'Ubereats'";
        MainWindow.jta.append("Statement: " + statement + "\n\n");
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            while(rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for(int i = 0; i < rsmd.getColumnCount(); i++) {
                    MainWindow.jta.append(rs.getString(i + 1) + RunApp.gap);
                }
                MainWindow.jta.append("\n");
            }
            MainWindow.jta.append(MainWindow.end);
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void joinQuerySecond() {
        MainWindow.jta.append("Join Query: Find all apps which have membership customers.\n");
        String statement = "SELECT account_app_name FROM account, customer WHERE account.account_id = customer.customer_id AND customer.membership_fee > 0";
        MainWindow.jta.append("Statement: " + statement + "\n\n");
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            while(rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for(int i = 0; i < rsmd.getColumnCount(); i++) {
                    MainWindow.jta.append(rs.getString(i + 1) + RunApp.gap);
                }
                MainWindow.jta.append("\n");
            }
            MainWindow.jta.append(MainWindow.end);
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            MainWindow.jta.append(EXCEPTION_TAG + " " + e.getMessage());
        }

    }

	private void rollbackConnection() {
		try  {
			connection.rollback();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropTables() {
		try {
			Statement stmt = connection.createStatement();
			stmt.execute("DROP TABLE app cascade constraints");
            stmt.execute("DROP TABLE account cascade constraints");
            stmt.execute("DROP TABLE customer cascade constraints");
            stmt.execute("DROP TABLE cso cascade constraints");
            stmt.execute("DROP TABLE deliveryman cascade constraints");
            stmt.execute("DROP TABLE store cascade constraints");
            stmt.execute("DROP TABLE supplier cascade constraints");
            stmt.execute("DROP TABLE techStaff cascade constraints");
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}
}
