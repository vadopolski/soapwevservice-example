package com.bank.card;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import static javax.jws.WebParam.Mode.IN;
import static javax.jws.soap.SOAPBinding.Style.RPC;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

@WebService (portName = "CreditCardValidationService", serviceName = "ValidatorService")
@SOAPBinding(style = RPC, use = LITERAL)
@Stateless
public class CardValidator {

    @WebMethod(operationName = "ValidateCreditCard")
    @WebResult(name = "IsValid")
    public boolean validate(@WebParam(name = "Credit-Card", mode = IN) CreditCard creditCard) throws CardValidationException {
        Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

        if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
            return true;
        }
        else {
            throw new CardValidationException("Неверный номер кредитной карты");
        }
    }

    @WebMethod(operationName = "ValidateCreditCardNumber")
    public boolean validate(String creditCardNumber) {
        Character lastDigit = creditCardNumber.charAt(creditCardNumber.length() - 1);

        if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @WebMethod(exclude = true)
    public boolean validate(Long creditCardNumber) {
        Character lastDigit = creditCardNumber.toString().charAt(creditCardNumber.toString().length() - 1);

        if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
            return true;
        }
        else {
            return false;
        }
    }
}