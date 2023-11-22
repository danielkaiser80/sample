
package com.efass;

import java.io.FileNotFoundException;
import java.util.Optional;

import javax.validation.Valid;

import com.efass.auth.jwt.user.DAOUser;
import com.efass.auth.jwt.user.UserDao;
import com.efass.user.SignUpRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.efass.auth.jwt.user.PassData;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.procedures.ProcedureService;
import com.efass.report.ReportService;
import com.efass.specials.DateConverter;
import com.efass.user.UserDAO;
import com.efass.user.UserRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
@Log4j2
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	 UserDao userDao;

	Response res = new Response();

	@Autowired
	private ReportService reportSvc;

	@Autowired
	ProcedureService prodSvc;

	@Autowired
	DateConverter dateSvc;

	//FETCH ALL USERS
	@RequestMapping("/users")
	public ResponseEntity<?> fetchAllUsers() {
		Iterable<UserDAO> data = userRepository.findAll();
		res.setAllUsers(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping("/files")
	public ResponseEntity<?> fetchAllGeneratedFiles() throws FileNotFoundException {
	return reportSvc.fetchallActivity();
	}

	/*//DELETE FILE
	@DeleteMapping("/deletefile/{id}")
	public ResponseEntity<?> deletefiles(@PathVariable int id) {

		return reportSvc.DeleteGeneratedFile(id);

	}
	*/

	//CREATE A USER
//	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@Valid @RequestBody SignUpRequest signUpRequest) throws ResourceNotFoundException {

		DAOUser user = new DAOUser();
//		UserDAO user = new UserDAO();
		String password = signUpRequest.getPassword();
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String encryptedPassword = encoder.encode(password);
//		user.setPassword(encryptedPassword);

		try {



//			UserDAO userdata = userRepository.findByUsername(signUpRequest.getUsername());
			DAOUser userDaoData = userDao.findByUsername(signUpRequest.getUsername());
//
//			if(userdata != null) {

			if(userDaoData != null) {

				res.setResponseMessage("User Already Exists");
				res.setResponseCode(-1001);
				return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
			}
//			}
//			user.setPassword(encryptedPassword);
			user.setUsername(signUpRequest.getUsername());
			user.setRole("ADMIN_ROLE");
			log.info(user.toString());
//			UserDAO _user = userRepository.save(user);
			DAOUser _user = userDao.save(user);
			log.info("Username {}",_user.getUsername());

			res.setDaoUser(_user);
			res.setResponseMessage("User Created");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.CREATED);

		} catch (Exception e) {
			res.setResponseMessage("Failed");
			res.setResponseCode(-1001);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	//User Update Password
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public ResponseEntity<?>  updatePassword(@Valid @RequestBody PassData user)throws ResourceNotFoundException{

				if (!user.getPassword().equals(user.getConfirm_password())) {
					System.out.println(user.getPassword());
			res.setResponseMessage("Confirmation Password doesn't match");
			res.setResponseCode(-1001);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		UserDAO userdata = userRepository.findUserdetails(user.getUsername());


//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		if (encoder.matches(user.getOld_password(), userdata.getPassword())) {
//
//
//			Optional<UserDAO> DataDb = userRepository.findUserdetails2(user.getUsername());
//
//			if (DataDb.isPresent()) {
//
//
//				BCryptPasswordEncoder encodedPass = new BCryptPasswordEncoder();
//				String encryptedPassword = encodedPass.encode(user.getPassword());
//
//
//
//				UserDAO DataUpdate = DataDb.get();
//				DataUpdate.setPassword(encryptedPassword);
//				userRepository.save(DataUpdate);
//				Response res = new Response();
//				res.setResponseMessage("Password Changed");
//
//				return new ResponseEntity<>(res, HttpStatus.OK);
//
//			} else {
//				throw new ResourceNotFoundException("Could not change Password " );
//			}
//
//
//
//
//
//		}else {
//
//			res.setResponseMessage("Old Password doesn't match");
//			res.setResponseCode(-1001);
//			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
//
//		}
		return null;
	}

	//FETCH USER BY ID
	@RequestMapping(value = "/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(value = "id") Integer userId) throws ResourceNotFoundException {
		UserDAO user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		user.setPassword(null);
		res.setUser(user);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
