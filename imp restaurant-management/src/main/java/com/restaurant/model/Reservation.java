package com.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private Date reservationDate;
    private String status;
}
