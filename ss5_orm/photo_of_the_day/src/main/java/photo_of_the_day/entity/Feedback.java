package photo_of_the_day.entity;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rate;
    private String author;
    private String comment;
//    private int like;

    @ManyToOne
    @JoinColumn(name = "id_photo")
    private Photo photo;

    public Feedback() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public Feedback(int rate, String author, String comment, int like, Photo photo) {
//        this.rate = rate;
//        this.author = author;
//        this.comment = comment;
//        this.like = like;
//        this.photo = photo;
//    }


    public Feedback(int rate, String author, String comment, Photo photo) {
        this.rate = rate;
        this.author = author;
        this.comment = comment;
        this.photo = photo;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

//    public int getLike() {
//        return like;
//    }
//
//    public void setLike(int like) {
//        this.like = like;
//    }

}
