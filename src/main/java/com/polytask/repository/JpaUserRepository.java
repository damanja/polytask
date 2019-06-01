package com.polytask.repository;

import com.polytask.business.Authority;
import com.polytask.business.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class JpaUserRepository implements UserRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void register(User user) {
        user = new User(user.getUsername(),user.getHashPassword());
        entityManager.persist(user);
    }
}
