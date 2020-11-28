package com.example.demo.database.repository;

import com.example.demo.database.entity.UserEntity;
import com.example.demo.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class UserRepository {

    @Transactional
    public void save(UserEntity userEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(userEntity);
        tx1.commit();
        session.close();
    }

    public Optional<UserEntity> findById(Long id) {
        UserEntity userEntity = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UserEntity.class, id);

        return Optional.of(userEntity);
  }
}
