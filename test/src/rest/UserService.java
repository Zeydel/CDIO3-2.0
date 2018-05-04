package rest;
import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.aopalliance.reflect.Field;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.UserDTO;


@Path("/UserService")
public class UserService {
	static Map<Integer, UserDTO> users = new HashMap<>();
	static {
		users.put(1, new UserDTO(8, "Mads Jï¿½rgensen", new ArrayList<String>(Arrays.asList("test")), "1234", "080197-0761"));
		users.put(2, new UserDTO(9, "Isaacs Far", new ArrayList<String>(Arrays.asList("test")), "1331", "00000"));
		users.put(3, new UserDTO(10, "FredeHus", new ArrayList<String>(Arrays.asList("pjï¿½kker")), "6969", "420"));
	}
	ObjectMapper mapper = new ObjectMapper();

	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createUser(String json) {
		
		String[] values = json.split("&");
		

		String anId = values[0].replace("id=",""); 
		String aUsername = values[1].replace("username=",""); 
		String aPassword = values[3].replace("password_repeat=","");
		String aCPR = values[4].replace("CPR=","");
		String roles = values[5].replace("roles=","");

		
		users.put(users.size() + 1, new UserDTO(Integer.parseInt(anId), aUsername, 
				new ArrayList<String>(Arrays.asList(roles)), aPassword, aCPR));
	
		System.out.println(users);
				
		return anId;
	}



	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Map getUsers() {
		System.out.println(users);
		return users;
	}
}
