package BestOnesProfile.MavenClientProfile;

import java.util.Arrays;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;

import customExceptions.CustomException;

import CRUD.ICRUDService;
import ProfileObjects.profile.Location;
import ProfileObjects.profile.Profile;

public class ProfileClient {
	ICRUDService service = JAXRSClientFactory.create("http://localhost:8080/MavenServerProfile/rest", ICRUDService.class, Arrays.asList(new JSONProvider<Object>()));
	
	public Profile getProfile(int id) throws CustomException{
		return service.getProfile(id).readEntity(Profile.class);
	}
	
	public Profile updateProfile(int id, Profile profile) throws CustomException{
		return service.updateProfile(id, profile).readEntity(Profile.class);
	}

	public Profile createProfile(Profile profile) throws CustomException{
		return service.createProfile(profile).readEntity(Profile.class);
	}

	public void deleteProfile(int id) throws CustomException{
		service.deleteProfile(id);
	}

	public static void main(String[] args) throws CustomException {
		ProfileClient client = new ProfileClient();
		Profile profile = new Profile();
		profile.setName("ZAD-Man");
		profile.setEmail("goobers@gmail.com");
		Location loc = new Location();
		loc.setCity("Sandy");
		loc.setOwnerID(99);
		loc.setState("CA");
		loc.setStreet("1234 Main St.");
		loc.setZip("90069");
		profile.setLocation(loc);
		profile.setUserRating(5);
		Profile created = client.createProfile(profile);
		System.out.println(client.getProfile(created.getUserID()).getName());
		System.out.println("test1"+client.getProfile(created.getUserID()));
		client.deleteProfile(created.getUserID());
		

	}
}
