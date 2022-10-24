package codegym.vn.musicvalid.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Music {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @NotBlank(message = "{notempty}")
        @Size(max = 800)
        private String name;


        @NotBlank(message = "{notempty}")
        @Size(max = 300)
        private String author;

    private String filePath;

    private String filePic;


    public Music() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String description) {
        this.author = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePic() {
        return filePic;
    }

    public void setFilePic(String filePic) {
        this.filePic = filePic;
    }

    public Music(int id, @NotBlank(message = "{notempty}") @Size(max = 100, min = 5, message = "Do dai ten tu 5-100") String name, @NotBlank(message = "{notempty}") String description,  String filePath,String filePic) {
        this.id = id;
        this.name = name;
        this.author = description;
        this.filePath = filePath;
        this.filePic = filePic;
    }
}
