package HomeWork_5.Service;

import HomeWork_5.Repository.UserRepository;
import HomeWork_5.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@Transactional
public class UserImpl implements UserService{
    @PersistenceContext
    private EntityManager em;

    private UserRepository userRepository;

    @Autowired
    public void setProductRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List <User> getAll() {
        CriteriaQuery <User> query = em.getCriteriaBuilder().createQuery (User.class);
        Root <User> user = query.from(User.class);
        query.select(user);
        return em.createQuery(query).getResultList();
    }
}
