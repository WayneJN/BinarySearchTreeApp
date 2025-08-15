package com.wayne.bstapp.repository;

import com.wayne.bstapp.model.TreeStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends JpaRepository<TreeStorage, Long> {
}
