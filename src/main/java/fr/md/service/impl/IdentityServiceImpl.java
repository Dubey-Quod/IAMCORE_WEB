package fr.md.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






import fr.md.iam.dao.IdentityDao;
import fr.md.iam.datamodel.Identity;
import fr.md.service.IdentityService;

@Service
public class IdentityServiceImpl implements IdentityService {
	
	@Autowired
	private IdentityDao identityDao;

	@Transactional
	public void write(Identity identity) {
		identityDao.write(identity);
	}

	@Transactional
	public void update(Identity identity) {
		identityDao.update(identity);
	}

	@Transactional
	public void delete(Identity identity) {
		identityDao.delete(identity);
	}

	@Transactional
	public  Identity getIdentity(String uid) {
		return identityDao.getIdentity(uid);
	}
	
	@Transactional
	public Identity getPassword(String password)
	{
		return identityDao.getPassword(password);
	}

	@Transactional
	public List<Identity> readAllIdentities() {
		return identityDao.readAllIdentities();
	}

}
