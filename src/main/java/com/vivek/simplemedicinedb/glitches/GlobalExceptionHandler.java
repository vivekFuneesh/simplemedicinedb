package com.vivek.simplemedicinedb.glitches;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public PrescriptionsError bindingValidationFailed(BindException be) {
		System.out.println("Inside 1");
		List<String> errors = be.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
		
		PrescriptionsError me=new PrescriptionsError(400,errors.toString());
		return me;
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public PrescriptionsError validationFailed(MethodArgumentNotValidException manve) {
		System.out.println("Inside 2");
		List<String> errors = manve.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
		PrescriptionsError me=new PrescriptionsError(400,errors.toString());
		return me;
	}
	
	@ExceptionHandler(MedicineDataNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public PrescriptionsError MedicineDataNotFoundErrors(MedicineDataNotFoundException mdnfe) {
		System.out.println("Inside 3");
		return new PrescriptionsError(404, "MedicineData with "+(mdnfe.getName()!=null?" name= "+mdnfe.getName()+",":"")
											+(mdnfe.getMfg_By()!=null?" mfg. company= "+mdnfe.getMfg_By()+",":"")
											+(mdnfe.getMktd_By()!=null?" marketing company= "+mdnfe.getMktd_By():"")
											+" Not Found");
	}

	
	@ExceptionHandler(MedicineDataIncompleteException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public PrescriptionsError MedicineDataIncompleteErrors(MedicineDataIncompleteException mdie) {
		System.out.println("Inside 4");
		return new PrescriptionsError(404, "MedicineData for "+mdie.getName()+" is not complete, mfg_By, mktd_By, name required");
	}

	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public PrescriptionsError otherExceptions(Exception ex) {
		System.out.println("Inside 5");
		return new PrescriptionsError(400,	ex.getMessage());
	}
	
}
