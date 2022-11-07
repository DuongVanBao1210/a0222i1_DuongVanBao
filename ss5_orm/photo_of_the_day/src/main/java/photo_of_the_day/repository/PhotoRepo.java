package photo_of_the_day.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import photo_of_the_day.entity.Photo;

@Repository
public interface PhotoRepo extends JpaRepository<Photo,Integer> {
    Photo findByPhotoLinkContaining(String src);

}
