package hotelmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hotelmanagement.data.Rooms;
import hotelmanagement.utils.HibernateUtils;

public class RoomsDAOImplementation implements RoomsDAO {

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
	public boolean addRoom(Rooms room) {

		try {

			openCurrentSessionWithTransaction().save(room);
			closeCurrentSessionWithTransaction();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeRoom(String roomNumber) {

		Rooms room = null;

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Rooms WHERE roomNumber= :roomNumber";

			@SuppressWarnings("unchecked")
			Query<Rooms> query = currentSession.createQuery(hql);

			query.setParameter("roomNumber", roomNumber);

			room = query.getSingleResult();

			currentSession.delete(room);

			closeCurrentSessionWithTransaction();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean updateStatus(String roomNumber, boolean status) {
		
		Rooms room = null;

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Rooms WHERE roomNumber= :roomNumber";

			@SuppressWarnings("unchecked")
			Query<Rooms> query = currentSession.createQuery(hql);

			query.setParameter("roomNumber", roomNumber);

			room = query.getSingleResult();

			room.setAvilable(status);
			currentSession.update(room);

			closeCurrentSessionWithTransaction();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public List<Rooms> listAllRooms() {

		List<Rooms> roomsList = new ArrayList<>();

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Rooms";

			@SuppressWarnings("unchecked")
			Query<Rooms> query = currentSession.createQuery(hql);

			roomsList = query.getResultList();

			closeCurrentSessionWithTransaction();

			return roomsList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Rooms> listAllRoomsWithStatus(boolean status) {

		List<Rooms> roomsList = new ArrayList<>();

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Rooms WHERE avilable= :status";

			@SuppressWarnings("unchecked")
			Query<Rooms> query = currentSession.createQuery(hql);
			query.setParameter("status", status);

			roomsList = query.getResultList();

			closeCurrentSessionWithTransaction();

			return roomsList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Rooms getRoom(String roomNumber) {
		
		Rooms room = null;

		try {
			openCurrentSessionWithTransaction();

			String hql = "FROM Rooms WHERE roomNumber= :roomNumber";

			@SuppressWarnings("unchecked")
			Query<Rooms> query = currentSession.createQuery(hql);

			query.setParameter("roomNumber", roomNumber);

			room = query.getSingleResult();

			closeCurrentSessionWithTransaction();
			
			return room;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
