package com.pluto.aplication.constant;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class UtilityAplication{

    public static Pageable createPageableDefault(){
        return PageRequest.of(1, 10);
    }

    public static Pageable createPageableCustom(int page, int rows){
        return PageRequest.of(1, 10);
    }

}