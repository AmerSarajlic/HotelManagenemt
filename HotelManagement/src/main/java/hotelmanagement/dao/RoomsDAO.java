package hotelmanagement.dao;

import hotelmanagement.data.Rooms;

public interface RoomsDAO {

	public void addRoom(Rooms room);
	
	public void removeRoom(Rooms room);
	
	public boolean updateStatus();
	
}
