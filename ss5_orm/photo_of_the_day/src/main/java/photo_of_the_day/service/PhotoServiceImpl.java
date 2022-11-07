package photo_of_the_day.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photo_of_the_day.entity.Photo;
import photo_of_the_day.repository.PhotoRepo;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService{
    @Autowired
    PhotoRepo photoRepo;

    @Override
    public List<Photo> findAll() {
        return photoRepo.findAll();
    }

    @Override
    public Photo findById(int id) {
        return photoRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Photo photo) {
        List<Photo> photos = photoRepo.findAll();
        if(photos.size()==0) {
            photoRepo.save(photo);
        }else {
            if(photoRepo.findByPhotoLinkContaining(photo.getPhotoLink()) == null) {
                photoRepo.save(photo);
            }
        }

    }

    @Override
    public void deleteById(int id) {
        photoRepo.deleteById(id);
    }

    @Override
    public Photo findByPhotoLinkContaining(String src) {
        return photoRepo.findByPhotoLinkContaining(src);
    }

}
