package codegym.vn.musicvalid.service;

import codegym.vn.musicvalid.entity.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

public interface MusicService {

    void create(Music music);
    void update(Music music);
    void delete( int id);
    Music findById(int id);
    Page<Music> getAll(Pageable pageable);




}
