/**
 * 
 */
package com.zenika.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.zenika.model.Contact;

/**
 * @author acogoluegnes
 *
 */
public class ContactRepositoryImpl implements ContactRepositoryCustom {
	
	@PersistenceContext private EntityManager em;

	/* (non-Javadoc)
	 * @see com.zenika.repository.ContactRepositoryCustom#findByExample(com.zenika.model.Contact)
	 */
	@Override
	public List<Contact> findByExample(Contact contact) {
		TypedQuery<Contact> query = em.createQuery("from Contact c where c.firstname = ? and c.lastname = ?", Contact.class);
		query.setParameter(1, contact.getFirstname());
		query.setParameter(2, contact.getLastname());
		return query.getResultList();
	}

}
