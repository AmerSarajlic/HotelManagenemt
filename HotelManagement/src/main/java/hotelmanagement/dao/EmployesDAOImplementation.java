package hotelmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hotelmanagement.data.Employes;
import hotelmanagement.utils.HibernateUtils;

public class EmployesDAOImplementation implements EmployesDAO {

	private Session currentSession;
	private Transaction currentTransaction;

	public EmployesDAOImplementation() {
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
	public boolean addEmployee(Employes employee) {
		try {

			openCurrentSessionWithTransaction().save(employee);
			closeCurrentSessionWithTransaction();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeEmployee(String firstName, String lastName) {
		Employes employee = null;

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Employes WHERE firstName= :firstName AND lastName= :lastName";

			@SuppressWarnings("unchecked")
			Query<Employes> query = currentSession.createQuery(hql);

			query.setParameter("firstName", firstName);
			query.setParameter("lastName", lastName);

			employee = query.getSingleResult();

			currentSession.delete(employee);

			closeCurrentSessionWithTransaction();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employes> displayAllEmployess() {
		List<Employes> employesList = new ArrayList<>();

		try {

			openCurrentSessionWithTransaction();

			String hql = "FROM Employes";

			@SuppressWarnings("unchecked")
			Query<Employes> query = currentSession.createQuery(hql);

			employesList = query.getResultList();

			return employesList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
