package com.keymobile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Man {
    private String cardNumber;
    private String name;
    private List<Card> cards;
}
