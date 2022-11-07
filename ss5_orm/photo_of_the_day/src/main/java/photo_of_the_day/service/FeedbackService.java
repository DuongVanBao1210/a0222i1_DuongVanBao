package photo_of_the_day.service;

import photo_of_the_day.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> findAll();
    Feedback findById(int id);
    void save(Feedback feedback);
    void deleteById(int id);
    List<Feedback> findAllByPhoto_Id(int id);
}
