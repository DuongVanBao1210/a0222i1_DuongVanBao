package codegym.vn.musicvalid.valid;


import codegym.vn.musicvalid.entity.Music;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MusicValid implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Music.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Music music = (Music) target;
        if (music.getAuthor().equals("AA"))
            errors.rejectValue("author", "AA");

        if(!music.getName().matches("[a-z A-Z]*")) {
            errors.rejectValue("name","musicNameError","Invalid input");
        }

        if(!music.getAuthor().matches("[a-z A-Z]*")) {
            errors.rejectValue("author","musicNameError","Invalid input");
        }


    }
}
