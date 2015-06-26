package fr.md.service;

import java.util.List;

import fr.md.iam.datamodel.Identity;

public interface IdentityService {
	public void write(Identity identity);
	public void update(Identity identity);
	public void delete(Identity identity);
	public Identity getIdentity(String uid);
	public Identity getPassword(String password);
	public List<Identity> readAllIdentities();
}
