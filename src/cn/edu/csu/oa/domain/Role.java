package cn.edu.csu.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 岗位
 * 
 * @author Ching
 * 
 */
public class Role {
	private Long id;
	private String name;
	private String description;
	
	private Set<User> users = new HashSet<User>();
	
	private Set<Privilage> privilages = new HashSet<Privilage>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Privilage> getPrivilages() {
		return privilages;
	}

	public void setPrivilages(Set<Privilage> privilages) {
		this.privilages = privilages;
	}

	
}
