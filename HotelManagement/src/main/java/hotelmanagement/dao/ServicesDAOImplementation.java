package hotelmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hotelmanagement.data.Services;
import hotelmanagement.utils.HibernateUtils;

public class ServicesDAOImplementation implements ServicesDAO {

	private Session currentSession;
	private Transaction currentTransaction;

	public ServicesDAOImplementation() {
	}

	public Session openCurrentSession() {
		currentSession = HibernateUtils.getSessionFactory().openSession();
		return currentSession;
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
	public boolean addService(Services service) {
		try {

			openCurrentSessionWithTransaction().save(service);
			closeCurrentSessionWithTransaction();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean removeService(String serviceName) {

		Services service = null;

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Services WHERE serviceName= :serviceName";

			@SuppressWarnings("unchecked")
			Query<Services> query = currentSession.createQuery(hql);

			query.setParameter("serviceName", serviceName);

			service = query.getSingleResult();

			currentSession.delete(service);

			closeCurrentSessionWithTransaction();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public List<Services> displayAllServices() {

		List<Services> servicesList = new ArrayList<>();

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Services";

			@SuppressWarnings("unchecked")
			Query<Services> query = currentSession.createQuery(hql);

			servicesList = query.getResultList();

			closeCurrentSessionWithTransaction();

			return servicesList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
