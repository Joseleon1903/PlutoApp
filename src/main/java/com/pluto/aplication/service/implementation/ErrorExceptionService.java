package com.pluto.aplication.service.implementation;

import java.util.List;
import com.pluto.aplication.model.entity.ErrorException;
import com.pluto.aplication.repository.ErrorExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorExceptionService implements com.pluto.aplication.service.interfaces.ErrorExceptionService {

    @Autowired
    private ErrorExceptionRepository errorExceptionRepository;

	@Override
	public ErrorException findByCode(long code) {
		return errorExceptionRepository.findByCode(code);
	}

	@Override
	public List<ErrorException> findAll() {
		return errorExceptionRepository.findAllActive();
	}

	@Override
	public List<ErrorException> findAllActive() {
		return errorExceptionRepository.findAllActive();
	}

	@Override
	public ErrorException save(ErrorException errorException) {
		return errorExceptionRepository.save(errorException);
	}

}