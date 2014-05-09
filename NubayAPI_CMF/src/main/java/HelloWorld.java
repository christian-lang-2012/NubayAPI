import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.ws.rs.core.Response;

import BestOnesProfile.MavenClientProfile.ProfileClient;
import ProfileObjects.profile.Location;
import ProfileObjects.profile.Profile;
import customExceptions.CustomException;
import edu.neumont.csc380.AuthClientImpl;
import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.cms.client.CMSClient;

public class HelloWorld {

	public static void main(String[] args) {
		CMSClient cms = new CMSClient();
		ProfileClient profile = new ProfileClient();
		AuthClientImpl auth = new AuthClientImpl();

		Response resp = cms.setUserProfilePicture(1L, "me at the beach",
				getPicData(), "image/png");
		// Response resp = cms.getUserMedia(1L);
		System.out.println("client resp: " + resp.getStatus());
		// resp.getEntity();

	}

	public static void CRUDAuth() {
		AuthClientImpl client = new AuthClientImpl();
		try {
			client.createUser("Tim", "isCanada", AuthorityLevel.User);
			client.updateUser("Tim", "BOOM", "isCanada", AuthorityLevel.Admin);
			client.authenticateUser("Tim", "BOOM");
			client.deleteUser("Tim");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void CRUDProfile() throws CustomException {
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
		System.out.println("test1" + client.getProfile(created.getUserID()));
		client.deleteProfile(created.getUserID());
	}

	public static byte[] getPicData() {

		File imgPath = new File("profile.png");
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(imgPath);
			WritableRaster raster = bufferedImage.getRaster();
			DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
			return data.getData();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new byte[10];
	}
}
