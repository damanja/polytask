package com.polytask.repository;

import com.polytask.business.Authority;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class JpaAuthorityRepository implements AuthorityRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add_authority(Authority authority) {
        authority = new Authority(authority.getUsername());
        entityManager.persist(authority);
    }
}

