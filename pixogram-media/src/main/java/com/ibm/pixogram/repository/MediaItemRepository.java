package com.ibm.pixogram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.pixogram.model.MediaItem;

@Repository
public interface MediaItemRepository extends JpaRepository<MediaItem, Long>{

}
