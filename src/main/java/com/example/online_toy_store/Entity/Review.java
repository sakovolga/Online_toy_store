package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.Rating;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Timestamp;
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
    @Column(name = "rv_id")
    private UUID rId;

    private Customer customer;

    private Product product;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    @Column(name = "review_title")
    private String reviewTitle;

    @Column(name = "content")
    private String content;

    @Column(name = "content")
    private Rating rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(rId, review.rId) && Objects.equals(reviewDate, review.reviewDate) && Objects.equals(reviewTitle, review.reviewTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rId, reviewDate, reviewTitle);
    }
}
