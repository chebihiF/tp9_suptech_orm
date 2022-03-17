package entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity @Table(name = "client")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "nom", length = 30, unique = false)
    private String name ;
    private String email ;
    @OneToMany(mappedBy ="customer")
    private List<Product> products;
}
