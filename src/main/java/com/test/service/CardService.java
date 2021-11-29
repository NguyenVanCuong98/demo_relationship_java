package com.test.service;

import com.test.dto.CardDto;
import com.test.entity.Card;
import com.test.in.CardIn;

import java.util.List;

public interface CardService {
    List<CardDto> getAllCard();
    Card createCard(CardDto cardDto);
    void deleteCard(Integer id);
    Card updateCard(CardIn cardIn, Integer id);
    Card findById(Integer id);
}
