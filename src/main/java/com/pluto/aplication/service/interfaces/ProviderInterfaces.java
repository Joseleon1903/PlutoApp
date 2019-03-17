package com.pluto.aplication.service.interfaces;

import com.pluto.aplication.model.entity.Provided;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProviderInterfaces{

    Provided findById(long id);

    Provided save(Provided provided);

    Page<Provided> findAllProviders(Pageable pageable);

    Page<Provided> findProvidersByName(String text, Pageable pageable);


}