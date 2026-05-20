package org.example.ptit_cntt1_it211_session05_ex3.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name không được để trống")
    private String name;

    @Min(value = 1, message = "Price phải lớn hơn 0")
    private double price;
}