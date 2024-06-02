package Entities;

public class Cours {
    private int coursId ;
    private String titre ;
    private String description ;
    private String format ;
    private int enseignantId;


    public int getCoursId() {
        return coursId;
    }

    public void setCoursId(int coursId) {
        this.coursId = coursId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getEnseignantId() {
        return enseignantId;
    }

    public void setEnseignantId(int enseignantId) {
        this.enseignantId = enseignantId;
    }

    public Cours(int coursId, String titre, String description, String format, int enseignantId) {
        this.coursId = coursId;
        this.titre = titre;
        this.description = description;
        this.format = format;
        this.enseignantId = enseignantId;
    }

    public Cours(String titre, String description, String format, int enseignantId) {
        this.titre = titre;
        this.description = description;
        this.format = format;
        this.enseignantId = enseignantId;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "coursId=" + coursId +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                ", enseignantId=" + enseignantId +
                '}';
    }
}
