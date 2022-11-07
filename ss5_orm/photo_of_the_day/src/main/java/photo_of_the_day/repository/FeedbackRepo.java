package photo_of_the_day.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import photo_of_the_day.entity.Feedback;

import java.util.List;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback,Integer> {
    List<Feedback> findAllByPhoto_Id(int id);
}
