package photo_of_the_day.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photo_of_the_day.entity.Feedback;
import photo_of_the_day.repository.FeedbackRepo;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    FeedbackRepo feedbackRepo;
    @Override
    public List<Feedback> findAll() {
        return feedbackRepo.findAll();
    }

    @Override
    public Feedback findById(int id) {
        return feedbackRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Feedback feedback) {
        feedbackRepo.save(feedback);
    }

    @Override
    public void deleteById(int id) {
        feedbackRepo.deleteById(id);
    }

    @Override
    public List<Feedback> findAllByPhoto_Id(int id) {
        return feedbackRepo.findAllByPhoto_Id(id);
    }
}
