package ru.itis.semestrovaya.videosmotr.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.semestrovaya.videosmotr.models.User;
import ru.itis.semestrovaya.videosmotr.models.Video;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryJpaImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<User> update(User model) {
        User user = entityManager
                .merge(model);
        return Optional.ofNullable(user);
    }

    @Override
    @Transactional
    public Optional<User> save(User model) {
        entityManager
                .persist(model);
        return Optional.ofNullable(model);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        try {
            return Optional.ofNullable(entityManager
                    .find(User.class, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByName(String name) {
        try {
            User user = entityManager
                    .createQuery("select user from User user where user.email = :name", User.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        } catch (NoResultException noResultException) {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<User> delete(Long id) {
        User user = findById(id).get();
        entityManager
                .remove(user);
        return Optional.ofNullable(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return entityManager
                .createQuery("select u from User u", User.class)
                .getResultList();
    }
}
