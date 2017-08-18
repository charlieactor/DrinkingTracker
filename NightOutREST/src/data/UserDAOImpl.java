package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.User;

@Transactional
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> index() {
		String query = "SELECT u FROM User u";
		return em.createQuery(query, User.class)
				 .getResultList();
	}

	@Override
	public User show(int id) {
		String query = "SELECT u FROM User u WHERE u.id = :id";
		return em.createQuery(query, User.class)
				 .setParameter("id", id)
				 .getResultList()
				 .get(0);
	}

	@Override
	public User create(User user) {
		em.persist(user);
		em.flush();
		return user;
	}

	@Override
	public User update(int id, User user) {
		User managed = em.find(User.class, id);
		managed.setDidPuke(user.getDidPuke());
		managed.setName(user.getName());
		managed.setNumberOfDrinks(user.getNumberOfDrinks());
		managed.setNumberOfHookups(user.getNumberOfHookups());
		managed.setNumberOfHours(user.getNumberOfHours());
		managed.setTotalCalories(user.getTotalCalories());
		return managed;
	}

	@Override
	public boolean delete(int id) {
		User u = em.find(User.class, id);
		try {
			em.remove(u);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
