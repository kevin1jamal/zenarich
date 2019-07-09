package zengest.jam.dto;

import java.util.Set;

import zengest.jam.domaine.entities.Role;
import zengest.jam.domaine.entities.Vente;

public class UserDto {
	private int id;
	private String email;
	private String password;
	private String name;
	private String fonction;
	private String telephone;
	private String lastName;
	private int active;
	private Set<Role> roles;
	private Set<Vente> vente;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public UserDto(String email, String password, String name, String lastName,String telephone) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.telephone = telephone;
		this.lastName = lastName;
	}
	public UserDto() {
		super();
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	

}
