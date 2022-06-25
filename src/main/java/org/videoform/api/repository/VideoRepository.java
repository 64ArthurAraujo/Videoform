package org.videoform.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.videoform.database.entity.Video;

import java.util.List;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {
    List<Video> findByOwnerId(Long id);
}
