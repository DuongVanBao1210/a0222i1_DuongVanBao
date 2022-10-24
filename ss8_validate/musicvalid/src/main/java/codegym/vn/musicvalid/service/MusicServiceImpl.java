package codegym.vn.musicvalid.service;

import codegym.vn.musicvalid.entity.Music;
import codegym.vn.musicvalid.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class MusicServiceImpl  implements MusicService {

    @Autowired
    private MusicRepository musicRepository ;

    @Override
    public void create(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void update(Music music) {
        musicRepository.save(music);

    }

    @Override
    public void delete(int id) {
            musicRepository.delete( findById(id));
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Music> getAll(Pageable pageable) {
        return musicRepository.findAll(pageable);
    }
}
