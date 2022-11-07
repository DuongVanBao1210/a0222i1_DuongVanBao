package photo_of_the_day.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String photoLink;

    @Column(columnDefinition = "TEXT")
    @OneToMany(targetEntity = Feedback.class)
    private List<Feedback> feedback;

    public Photo() {
    }

    public Photo(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }
}
