package com.example.online_toy_store.entity;

import com.example.online_toy_store.entity.enums.Rating;
import com.example.online_toy_store.generator.UuidTimeSequenceGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "reviews")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Review {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "rv_id")
    private UUID rvId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "u_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "p_id")
    private Product product;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    @Column(name = "review_title")
    private String reviewTitle;

    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(rvId, review.rvId) && Objects.equals(reviewDate, review.reviewDate) && Objects.equals(reviewTitle, review.reviewTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rvId, reviewDate, reviewTitle);
    }
}
