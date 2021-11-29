package com.test.controller;

import com.test.dto.CardDto;
import com.test.entity.Card;
import com.test.in.CardIn;
import com.test.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardController {
    @Autowired
    CardService cardService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<List<CardDto>> getAllBook () {
        List<CardDto> listCard = cardService.getAllCard();
        return new ResponseEntity<>(listCard , HttpStatus.OK);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Card create(@RequestBody CardDto cardDto){
        return cardService.createCard(cardDto);
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public Card update(@RequestBody CardIn cardIn, @PathVariable Integer id) {
        return cardService.updateCard(cardIn,id);

    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id){
        cardService.deleteCard(id);
    }
}
