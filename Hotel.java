import java.util.*;

public class Hotel {

	private Reservation[] rooms;
	// each element corresponds to a room in the hotel;
	// if rooms[index] is null, the room is empty;
	// otherwise, it contains a reference to the Reservation
	// for that room, such that
	// rooms[index].getRoomNumber() returns index
	
	private ArrayList <String> waitList;
	//  contains names of guests who have not yet been
	//  assigned a room because all rooms are full

	
	public Hotel() {
		rooms = new Reservation[5];
		waitList = new ArrayList<String>();
	}
	
	
	// if there are any empty rooms (rooms with no reservation),
	// then create a reservation for an empty room for the
	// specified guest and return the new Reservation;
	// otherwise, add the guest to the end of waitList
	// and return null
	// (** this is a new concept - "null" may be returned as an option
	//  instead of an object of the required data type.**)
	public Reservation requestRoom(String guestName)
	{ 
		for(int i = 0; i < rooms.length; i++)
			if(rooms[i] == null)
			{
				rooms[i] = new Reservation(guestName, i);
				return rooms[i];
			}
		waitList.add(guestName);
		return null;
		
	}	
	
	
	
	
	// release the room associated with parameter res, effectively
	// canceling the reservation;
	// if any names are stored in waitList, remove the first name
	// and create a Reservation for this person in the room
	// reserved by res; return that new Reservation;
	// if waitList is empty, mark the room specified by res as empty and
	// return null
	// precondition: res is a valid Reservation for some room
	// in this hotel
	public Reservation cancelAndReassign(Reservation res)
	{
		String name = "";
		for(int i = 0; i < rooms.length; i++)
			if(rooms[i] != null && rooms[i].getRoomNumber() == res.getRoomNumber())
			{
				rooms[i] = null;
				if(waitList.size() > 0)
				{
					name = waitList.get(0);
					waitList.remove(0);
					return requestRoom(name);
					
				}
				else
					return null;
			}
		return null;
	}
	
	
	public String toString() {
		String acc = "";
		for(int i = 0; i < rooms.length; i++) {
			if(rooms[i] == null)
				acc+= "unoccupied\tRoom: " + i;
			else
				acc += rooms[i] + "\n";
		}
		return acc;
	}
	
	

}