package com.mealplan.delivery.schedule.service;

import com.mealplan.delivery.schedule.repository.DeliveryScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryScheduleService {

    @Autowired
    DeliveryScheduleRepository deliveryScheduleRepository;
}
