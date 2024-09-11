package sda.hibernate.many2many;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Map Trainer class to 'trainers' table as you did for UserEntity
 * For mapping many-to-many relationship:
 *  - declare a variable that holds a list of Classrooms and initialize it with an empty list
 *  - annotate it with @ManyToMany(mappedBy = "trainers")
 */
@Entity
@Table(name = "trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "trainers")
    private List<Classroom> classrooms = new ArrayList<>();

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
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

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
