package lii.photozclone;

public class Photos {

    private Integer id;

    private String fileName;

    public Photos() {
    }

    public Photos(Integer id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
