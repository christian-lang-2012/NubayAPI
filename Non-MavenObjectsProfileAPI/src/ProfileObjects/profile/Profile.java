package ProfileObjects.profile;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

	private int userID;
	private String name;
//	private Image userImage; 
	private String email;
	private int userRating;
	private Location location;
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
			this.userID = userID;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserRating() {
		return userRating;
	}
	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}
	
	/**
	 * service level user and password for sending auth the userid and password
	 */
	
}
