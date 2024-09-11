package sda.hibernate.many2many;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Map Classroom class to 'classrooms' table as you did for UserEntity
 * For mapping many-to-many relationship:
 *  - declare a variable that holds a list of Trainers and initialize it with an empty list
 *  - annotate it with @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) - why do you think we omitted the CascadeType.REMOVE ?
 *  - annotate it with
 *      @JoinTable(name = "classroom_trainer",
 *         joinColumns = @JoinColumn(name = "classroom_id"),
 *         inverseJoinColumns = @JoinColumn(name = "trainer_id")
 *     )
 * - as this is whe owner of the relationship, we have to make 2 methods that keep relationship in sync (as we did for one-to-many)
 * - create a method 'addTrainer' that receive as parameter a Trainer and add it to trainers list declared above, and also add 'this' in trainer's classrooms
 * - create a method 'removeTrainer' that receive as parameter a Trainer and remove it from trainers list declared above, and also remove 'this' from trainer's classrooms
 *
 * Great job! You successfully map a many-to-many database relationship between two Java classes. Now lets put Hibernate on work!
 */
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "students_number")
    private int studentsNumber;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "classroom_trainer",
            joinColumns = @JoinColumn(name = "classroom_id"),
            inverseJoinColumns = @JoinColumn(name = "trainer_id"))
    private List<Trainer> trainers = new ArrayList<>();

    public Classroom() {
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

    public int getStudentsNumber() {
        return studentsNumber;
    }

    public void setStudentsNumber(int studentsNumber) {
        this.studentsNumber = studentsNumber;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public void addTrainer(Trainer trainer){
        this.getTrainers().add(trainer);
        trainer.getClassrooms().add(this);
    }
    public void removeTrainer(Trainer trainer){
        this.getTrainers().remove(trainer);
        trainer.getClassrooms().remove(this);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentsNumber=" + studentsNumber +
                ", trainers=" + trainers +
                '}';
    }
}
