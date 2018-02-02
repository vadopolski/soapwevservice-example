package com.bank.card;

import javax.xml.ws.WebFault;

@WebFault(name = "CardValidationFault")
public class CardValidationException extends Exception {

    public CardValidationException() {
        super();
    }

    public CardValidationException(String message) {
        super(message);
    }
}