package hotelmanagement.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hotelmanagement.data.Customers;
import hotelmanagement.data.Services;
import hotelmanagement.utils.HibernateUtils;

public class CustomersDAOImplementation implements CustomersDAO {

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
	public boolean addCustomer(Customers customer) {

		try {

			openCurrentSessionWithTransaction().save(customer);
			closeCurrentSessionWithTransaction();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customers> displayAllCustomers() {

		List<Customers> customersList = new ArrayList<>();
		
		try {

			openCurrentSessionWithTransaction();
			
			String hql = "FROM Customers";
			
			@SuppressWarnings("unchecked")
			Query<Customers> query = currentSession.createQuery(hql);
			
			customersList = query.getResultList();

			return customersList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customers findCustomerByName(String firstName, String lastName) {
	
		Customers customer = null;

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Customers WHERE firstName= :firstName AND lastName= :lastName";

			@SuppressWarnings("unchecked")
			Query<Customers> query = currentSession.createQuery(hql);

			query.setParameter("firstName", firstName);
			query.setParameter("lastName", lastName);

			customer = query.getSingleResult();

			closeCurrentSessionWithTransaction();
			
			return customer;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customers findCustomerByIdCard(String idCard) {

		Customers customer = null;

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Customers WHERE idCard= :idCard";

			@SuppressWarnings("unchecked")
			Query<Customers> query = currentSession.createQuery(hql);

			query.setParameter("idCard", idCard);

			customer = query.getSingleResult();

			closeCurrentSessionWithTransaction();
			
			return customer;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean deleteCustomer(String idCard) {

		Customers customer = null;

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Customers WHERE idCard= :idCard";

			@SuppressWarnings("unchecked")
			Query<Customers> query = currentSession.createQuery(hql);

			query.setParameter("idCard", idCard);

			customer = query.getSingleResult();
			
			currentSession.delete(customer);

			closeCurrentSessionWithTransaction();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Customers findCustomerByRoomId(int roomId) {
		
		Customers customer = null;

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Customers WHERE rooms_id= :roomId";

			@SuppressWarnings("unchecked")
			Query<Customers> query = currentSession.createQuery(hql);

			query.setParameter("roomId", roomId);

			customer = query.getSingleResult();

			closeCurrentSessionWithTransaction();
			
			return customer;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean updateCustomer(String idCard, List<Services> serviceList) {
		
		Customers customer = null;

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Customers WHERE idCard= :idCard";

			@SuppressWarnings("unchecked")
			Query<Customers> query = currentSession.createQuery(hql);

			query.setParameter("idCard", idCard);

			customer = query.getSingleResult();

			customer.setServiceList(serviceList);
			currentSession.update(customer);

			closeCurrentSessionWithTransaction();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean setDateOut(String idCard) {
		
		Customers customer = null;

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Customers WHERE idCard= :idCard";

			@SuppressWarnings("unchecked")
			Query<Customers> query = currentSession.createQuery(hql);

			query.setParameter("idCard", idCard);

			customer = query.getSingleResult();
			
			Date dateOut = new Date();
			customer.setDateOut(dateOut);;
			currentSession.update(customer);

			closeCurrentSessionWithTransaction();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean updateCustomerServices(Customers customer) {
		try {

			openCurrentSessionWithTransaction().update(customer);
			closeCurrentSessionWithTransaction();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
