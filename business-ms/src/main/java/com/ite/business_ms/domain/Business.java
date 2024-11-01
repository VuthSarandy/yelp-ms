package com.ite.business_ms.domain;

import com.ite.business_ms.config.jpa.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "business")
@Embeddable
public class Business extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String yelpBusinessId;
    private String alias;
    private String name;
    private String imageUrl;
    private Boolean isClosed;
    private String url;
    private Integer reviewCount;
    private Double rating;
    private String price;
    private String phone;
    private String displayPhone;
    private String distance;
    private Boolean isClaimed;
    private String dateOpened;
    private String dateClosed;
    private Integer photoCount;
    private String yelpMenuUrl;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL)
//    private List<Review> reviews;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "business_category",
            joinColumns = @JoinColumn(name = "business_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    private Coordinate coordinates;

    private Location location;

    @ElementCollection
    private List<String> transactions;

    @ElementCollection
    private List<String> displayAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Photo> photos;

    @OneToOne(cascade = CascadeType.ALL)
    private Messaging messaging;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SpecialHour> specialHours;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BusinessHour> hours;

    private PopularityScore popularityScore;

}


