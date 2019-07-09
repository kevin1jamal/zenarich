package zengest.jam.service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import zengest.jam.domaine.entities.Role;
import zengest.jam.domaine.entities.User;
import zengest.jam.repository.RoleRepository;
import zengest.jam.repository.UserRepository;



@Service("userService")
public class Userservice {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	


	public Userservice(UserRepository userRepository,
			RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	
   public List<User> findUserByStatus(int rol){
	   
	   return userRepository.findByActive(rol);
   }
	
	public User findUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		//activation du compte
		user.setActive(1);
		//initiallisation du role par defaut
		final Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		return userRepository.save(user);
	}
	public User saveUserAux(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		//activation du compte
		user.setActive(2);
		//initiallisation du role par auxiliare
		final Role userRole = roleRepository.findByRole("AUX");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		return userRepository.save(user);
	}

}
