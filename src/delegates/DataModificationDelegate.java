package delegates;

import model.*;

/**
 * This interface uses the delegation design pattern where instead of having
 * the MainWindow class try to do everything, it will only
 * focus on handling the UI. The actual logic/operation will be delegated to the 
 * controller class (in this case RunApp).
 * 
 * MainWindow calls the methods that we have listed below but
 * RunApp is the actual class that will implement the methods.
 */
public interface DataModificationDelegate {
    void insertApp(App app);
    void insertAccount(Account account);
    void insertCustomer(Customer customer);
    void insertCSO(CSO cso);
    void insertDM(DeliveryMan deliveryMan);
    void insertStore(Store store);
    void insertSupplier(Supplier supplier);
    void insertTS(TechnicalStaff staff);

    void deleteData(String table, String primaryKey, int integerValue, String stringValue, boolean isInt);

	void updateDatabase(String table, String attr, String attrValue, String primaryKey, int integerTuple, String stringTuple, boolean isInt);

	void showApp();
	void showAccount();
	void showCustomer();
	void showCSO();
	void showDeliveryMan();
	void showStore();
	void showSupplier();
	void showTechStaff();

	void selection(String table, String selectField, String whereField, String condition, int integerValue, String stringValue, boolean isInt);
	void projection(String table, String selectField);
	void executeAggregation();
	void executeGroupBy();
	void executeDivision();
	void joinQueryFirst();
	void joinQuerySecond();

	void databaseSetup();
	void finished();
}
