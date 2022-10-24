package codegym.vn.musicvalid.repository;

import codegym.vn.musicvalid.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {
}
