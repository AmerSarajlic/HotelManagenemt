package hotelmanagement.dao;

import java.util.List;

import hotelmanagement.data.Rooms;

public interface RoomsDAO {

	public boolean addRoom(Rooms room);
	
	public boolean removeRoom(String roomNumber);
	
	public Rooms getRoom(String roomNumber);
	
	public boolean updateStatus(String roomNumber, boolean status);
	
	public List<Rooms> listAllRooms();
	
	public List<Rooms> listAllRoomsWithStatus(boolean status);
	
}
