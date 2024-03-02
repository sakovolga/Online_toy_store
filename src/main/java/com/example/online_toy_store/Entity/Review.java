package com.example.online_toy_store.Entity;

import com.example.online_toy_store.Entity.Enums.Rating;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class Rewiev {
    private UUID rId;
    private Customer customer;
    private Product product;
    private Timestamp reviewDate;
    private String title;
    private String content;
    private Rating rating;

}
