package hotelmanagement.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hotelmanagement.data.Rooms;
import hotelmanagement.utils.HibernateUtils;

public class RoomsDAOImplementation implements RoomsDAO{

	private Session currentSession;
	private Transaction currentTransaction;

	public RoomsDAOImplementation() {
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
	public void addRoom(Rooms room) {
		getCurrentSession().save(room);
	}

	@Override
	public void removeRoom(Rooms room) {
		getCurrentSession().delete(room);
	}

	@Override
	public boolean updateStatus() {
		// TODO Auto-generated method stub
		return false;
	}

}
