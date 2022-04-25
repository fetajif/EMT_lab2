package mk.ukim.finki.lab2_emt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String continent;

    public Country() {
    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
