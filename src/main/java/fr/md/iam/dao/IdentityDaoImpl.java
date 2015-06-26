/**
 * 
 */
package fr.md.iam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.md.iam.datamodel.*;


/**
 * @author Manish
 *
 */

@Repository
public class IdentityDaoImpl implements IdentityDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void write(Identity identity) {
		session.getCurrentSession().save(identity);	
	}

	@Override
	public void update(Identity identity) {
		session.getCurrentSession().update(identity);
	}

	@Override
	public void delete(Identity identity) {
		session.getCurrentSession().createQuery("DELETE FROM Identity WHERE uid = '"+identity.getUid() +"'").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Identity> readAllIdentities() {
		return session.getCurrentSession().createQuery("from Identity").list();
	}

	@Override
	public Identity getPassword(String password) {
		return (Identity) session.getCurrentSession().get(Identity.class,password);
	}
	
	@Override
	public Identity getIdentity(String uid) {
		return (Identity) session.getCurrentSession().get(Identity.class, uid);
	}

}
