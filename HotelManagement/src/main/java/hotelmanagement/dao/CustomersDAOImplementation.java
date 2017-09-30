package hotelmanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hotelmanagement.data.Customers;
import hotelmanagement.utils.HibernateUtils;

public class CustomersDAOImplementation implements CustomersDAO{

	private Session currentSession;
	private Transaction currentTransaction;

	public CustomersDAOImplementation() {
	}

	public Session openCurrentSession() {
		return currentSession = HibernateUtils.getSessionFactory().openSession();
	}

	public Session openCurrentSessionWithTransaction() {
		currentSession = HibernateUtils.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionWithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}
	
	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	@Override
	public void addCustomer(Customers customer) {
		getCurrentSession().save(customer);
	}

	@Override
	public void removeCustomer(String idCard) {
		
		
	}

	@Override
	public double bill(String idCard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customers> displayAllCustomers() {

		String hql = "FROM Customers";
		Query query = currentSession.createQuery(hql);
		List<Customers> customers = query.getResultList();
		return customers;
	}
}
















