package com.cg.model.entity;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "categories_products",
            joinColumns = @JoinColumn(name = "categories_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Categories> categories;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "name")
    private String name;

    @Column(name = "description_p")
    private String description;

    private String genuineWarranty;
    private String waterproof;
    private String wireColor;
    private String clockFace;
    private String gender;
    private String ropeType;
    private String glassType;
    private String typeOfMachine;

    @Column(name = "price")
    private String price;

    @Column(name = "image")
    private String image;
//    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinTable(name = "manufacturers_products",
//            joinColumns = @JoinColumn(name = "manufacturer_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private List<Manufacturer> manufacturers;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "madeIn_id")
    private MadeIn madeIn;

    @OneToMany(targetEntity = CartItem.class)
    private List<CartItem> cartItems;


}
