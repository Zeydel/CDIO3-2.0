package rest;
import java.awt.List;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.UserDTO;


@Path("user")
public class UserService {
	static Map<Integer, UserDTO> users = new HashMap<>();
	static {
		users.put(8, new UserDTO(8, "Mads Jørgensen", new ArrayList<String>(Arrays.asList("test")), "1234", "080197-0761"));
		users.put(9, new UserDTO(9, "Isaacs Far", new ArrayList<String>(Arrays.asList("test")), "1331", "00000"));
		users.put(10, new UserDTO(10, "FredeHus", new ArrayList<String>(Arrays.asList("pjækker")), "6969", "420"));
	}
	ObjectMapper mapper = new ObjectMapper();

	//	@POST
	//	@Consumes(MediaType.APPLICATION_JSON)
	//	public boolean createUser(String userId, String userName, String ini, String roles, String password, String cpr) {
	//		users.put(1, new UserDTO(Integer.parseInt(userId), userName, new ArrayList<String>(Arrays.asList(roles)), password, cpr));
	//		return true;
	//	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map getUsers() {
		return users;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(String id) {
		users.remove(Integer.parseInt(id));
	}

}
