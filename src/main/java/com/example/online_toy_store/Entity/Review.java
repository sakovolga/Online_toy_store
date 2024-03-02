package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.Rating;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
@ToString
public class Review {
    private UUID rId;
    private Customer customer;
    private Product product;
    private LocalDate reviewDate;
    private String title;
    private String content;
    private Rating rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(rId, review.rId) && Objects.equals(reviewDate, review.reviewDate) && Objects.equals(title, review.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rId, reviewDate, title);
    }
}
