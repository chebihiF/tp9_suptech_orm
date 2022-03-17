package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id @Column(length = 30)
    private String ref ;
    private String label ;
    private double price;
    private int quantity;
    @ManyToOne @JoinColumn(name = "id_customer")
    private Customer customer;
}
