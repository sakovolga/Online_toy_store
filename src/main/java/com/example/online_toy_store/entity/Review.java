package com.example.online_toy_store.entity;

import com.example.online_toy_store.entity.enums.Rating;
import com.example.online_toy_store.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "reviews")
@NoArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "rv_id")
    private UUID rvId;

    @Column(name = "review_date")
    private LocalDateTime reviewDate;

    @Column(name = "review_title")
    private String reviewTitle;

    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "u_id")
    private User user;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "p_id")
    private Product product;

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

    @Override
    public String toString() {
        return "Review{" +
                "rvId=" + rvId +
                ", reviewDate=" + reviewDate +
                ", reviewTitle='" + reviewTitle + '\'' +
                '}';
    }
}
