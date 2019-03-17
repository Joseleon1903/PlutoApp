package com.pluto.aplication.service.implementation;

import com.pluto.aplication.model.entity.Provided;
import com.pluto.aplication.repository.ProviderRepository;
import com.pluto.aplication.service.interfaces.ProviderInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderInterfaces {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Provided save(Provided provided) {
        return providerRepository.save(provided);
    }

    @Override
	public Page<Provided> findAllProviders(Pageable pageable) {
		return providerRepository.findAll(pageable);
	}

    @Override
    public Page<Provided> findProvidersByName(String text, Pageable pageable) {
        return providerRepository.findByNameContainingIgnoreCase(text, pageable);
    }

    @Override
    public Provided findById(long id) {
        return providerRepository.findById(id);
    }

}