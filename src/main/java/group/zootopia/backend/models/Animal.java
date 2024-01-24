package group.zootopia.backend.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String family;
    private String type;
    private char gender;
    private String date;

    public Animal() {
    }
    
    // Constructor adicional para mantener compatibilidad con el constructor existente
    public Animal(long id, String name, String family, String type, char gender, String date) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.type = type;
        this.gender = gender;
        this.date = date;
    }
    // Constructor con fecha como String
    public Animal(String name, String family, String type, char gender, String date) {
        this.name = name;
        this.family = family;
        this.type = type;
        this.gender = gender;
        this.date = date;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}