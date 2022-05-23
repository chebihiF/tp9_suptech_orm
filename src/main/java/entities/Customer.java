package entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity @Table(name = "client")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "nom", length = 30, unique = false)
    private String name ;
    private String password;
    @Column(unique = true)
    private String email ;
    @OneToMany(mappedBy ="customer")
    @ToString.Exclude
    private List<Product> products;
}
