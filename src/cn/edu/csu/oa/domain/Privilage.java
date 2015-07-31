package cn.edu.csu.oa.domain;

import java.util.HashSet;
import java.util.Set;

public class Privilage {

	private Long id;
	private String url;
	private String name;
	
	private Set<Role> roles = new HashSet<Role>();
	
	private Privilage parent;
	
	private Set<Privilage> children = new HashSet<Privilage>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Privilage getParent() {
		return parent;
	}

	public void setParent(Privilage parent) {
		this.parent = parent;
	}

	public Set<Privilage> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilage> children) {
		this.children = children;
	}
	
	
}
