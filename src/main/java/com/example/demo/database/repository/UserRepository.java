package com.example.demo.database.repository;

import com.example.demo.database.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity save(UserEntity userEntity);

    Optional<UserEntity> findById(Long id);

    List<UserEntity> findAll();
}

//public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
//    Page<UserEntity> findAll(Pageable pageable);
//}
