package photo_of_the_day.formatter;

import org.springframework.format.Formatter;
import photo_of_the_day.entity.Photo;
import photo_of_the_day.service.PhotoService;

import java.text.ParseException;
import java.util.Locale;

public class PhotoFormatter implements Formatter<Photo> {
    private PhotoService photoService;

    public PhotoFormatter(PhotoService photoService) {
        this.photoService = photoService;
    }

    @Override
    public Photo parse(String id, Locale locale) throws ParseException {
        Photo photo = photoService.findById(Integer.parseInt(id));
        return photo;
    }

    @Override
    public String print(Photo object, Locale locale) {
        return null;
    }
}
