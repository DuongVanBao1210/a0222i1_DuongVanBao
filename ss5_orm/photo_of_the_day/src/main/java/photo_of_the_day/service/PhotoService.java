package photo_of_the_day.service;

import photo_of_the_day.entity.Photo;

import java.util.List;

public interface PhotoService {
    List<Photo> findAll();
    Photo findById(int id);
    void save(Photo photo);
    void deleteById(int id);

    Photo findByPhotoLinkContaining(String src);
}
