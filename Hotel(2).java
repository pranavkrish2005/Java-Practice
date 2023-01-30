public class Hotel
{
// list[] stores reservations for each room. The index is the room number.
// All elements are null at the beginning
private Reservation[] list;
public Hotel(int numbRooms)
{
	list = new Reservation[numbRooms];
	for(int i = 0; i < list.length; i++)
		list[i] = new Reservation();
}
// Displays room numbers and reservation information.
public void display()
{
	for(int i = 0; i < list.length; i++)
		System.out.println("Room " + i + " " +  list[i].toString());
}

// returns true if room is occupied
public boolean isOccupied(int room)
{
	if(list[room].getRate() == 0)
		return true;
	return false;
}
// Assigns a new Reservation to the first available room.
// Print out reservation with room number or indicate that hotel is full
public void reserveRoom(String name, double rate)
{
	for(int i = 0; i < list.length; i++)
	{
		if(!isOccupied(i) && i == list.length - 1)
			System.out.println("Hotel is full");
		else if(!isOccupied(i)) {}
		else
		{
			list[i] = new Reservation(name, rate);
			break;
		}
	}
}
// Assigns a new Reservation to an inputed room.
// if room is occupied, find the first available room in the array
// Print out reservation with room number or indicate that hotel is full
public void reserveRoom(String name, double rate, int room)
{
	if(!isOccupied(room))
		reserveRoom(name, rate);
	else
		list[room] = new Reservation(name, rate);
}
// Find and return number of rooms with a reservation
public int reservedRoomCount()
{
	int count = 0;
	for(int i = 0; i < list.length; i++)
		if(isOccupied(i))
			count++;
	return count;
}
// find and return the average room rate of the occupied rooms.
public double averageRoomRate()
{
	double sum = 0;
	for(Reservation i : list)
		sum += i.getRate();
	return sum/reservedRoomCount();
}
}