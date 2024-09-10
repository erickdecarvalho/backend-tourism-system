package com.erick.tourismsystem.services.company;

import com.erick.tourismsystem.repository.TourismRepository;
import com.erick.tourismsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TourismRepository tourismRepository;

}
