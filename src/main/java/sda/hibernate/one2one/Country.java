package sda.hibernate.one2one;

import jakarta.persistence.*;

/**
 * Map Country class to 'countries' table as you did for UserEntity
 * For mapping one-to-one relationship:
 *  - declare a variable of type Capital
 *  - annotate it with @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
 *  - annotate it with @JoinColumn(name = "capital_id")
 *
 */
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "capital_id")
    private Capital capital;

    public Country(String name, Capital capital) {
        this.name = name;
        this.capital = capital;
    }

    public Country() {
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

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                '}';
    }
}
