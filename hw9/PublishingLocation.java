
import java.util.*;

public class PublishingLocation {
	
	//city, state, and postCode	
	private String city;

	private String state;
	
	private String postCode;

//#7. PublishingLocation should have a getPostCode method
//#8. PublishingLocation should have a private String field named state
//#9. PublishingLocation should have a getState method
//#10. PublishingLocation should have a private String field named city
//#11. PublishingLocation should have a private String field named postCode
//#12. PublishingLocation should have a getCity method

	public String getPostCode(){
		return postCode;
	}

	public String getState(){
		return state;
	}

	public String getCity(){
		return city;
	}


	public PublishingLocation(String city, String state, String postCode){
		this.city = city;
		this.state = state;
		this.postCode = postCode;
	}

}
