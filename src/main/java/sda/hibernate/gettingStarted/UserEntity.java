package sda.hibernate.gettingStarted;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Declare instance variables for corresponding column in table 'users'.
 * Start mapping this class to table 'users':
 *  - in HibernateUtils.getSessionFactory put 'addAnnotatedClass(UserEntity.class)' on Configuration instance
 *  - add annotations @Entity and @Table to class
 *  - add annotation @Id and @GeneratedValue with used strategy on id field
 *  - for each field add @Column annotation
 */
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "created_at")
    private LocalDateTime createdAt;



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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createdAt=" + createdAt +
                '}';
    }
}
