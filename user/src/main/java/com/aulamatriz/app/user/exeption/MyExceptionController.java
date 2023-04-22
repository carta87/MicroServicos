package com.aulamatriz.app.user.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionController {
	
	//implementar leer variables de propiedades
	
	@ExceptionHandler(MyBisnessExepeption.class)
	public ResponseEntity<Object> managemyException(MyBisnessExepeption ex){
		return new ResponseEntity<>("se lanza una exepcion personalizada" + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity  systemExcepton(Exception ex){
        return  ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Esta es una excepcion del systema " + ex.getMessage());

    }
}
