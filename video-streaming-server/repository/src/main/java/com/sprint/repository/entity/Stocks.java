package com.sprint.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stocks")
@AllArgsConstructor
@NoArgsConstructor
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    double price;
    int totalShares;
    int outstandingShares;
}
