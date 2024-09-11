package sda.hibernate.one2one;

import jakarta.persistence.*;

/**
 * Map Capital class to 'capitals' table as you did for UserEntity
 * For mapping one-to-one relationship:
 * - declare a variable of type Country
 * - annotate it with @OneToOne(mappedBy = "capital", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
 * - 'mappedBy' attribute tells Hibernate that Country is the owning side of the relationship (only Country changes will be propagated to db)
 * <p>
 * Great job! You successfully map a one-to-one relationship between two Java classes. Now lets put Hibernate on work!
 */
@Entity
@Table(name = "capitals")
public class Capital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToOne(mappedBy = "capital", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Country country;

    public Capital() {
    }

    public Capital(String name) {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Capital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
