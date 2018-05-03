package rest;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.UserDTO;


@Path("user")
public class UserService {
	static Map<Integer, UserDTO> users = new HashMap<>();
	static {
		
		users.put(1, new UserDTO(8, "Mads Jørgensen", new ArrayList<String>(Arrays.asList("test")), "1234", "080197-0761"));
	}
	ObjectMapper mapper = new ObjectMapper();
	
//	@Path("user")
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public boolean AddIngredient(String userId, String userName, String ini, String roles, String password, String cpr) {
//		users.put(1, new UserDTO(Integer.parseInt(userId), userName, new ArrayList<String>(Arrays.asList(roles)), password, cpr));
//		return true;
//	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsers() {
			try {
				UserDTO mads = new UserDTO(8, "Mads Jørgensen", new ArrayList<String>(Arrays.asList("test")), "1234", "080197-0761");
				return mapper.writeValueAsString(mads);
			} catch (JsonProcessingException e) {
				return "hej";
			}

	}
	




}
