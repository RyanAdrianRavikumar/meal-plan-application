package com.mealplan.delivery.schedule.controller;

import com.mealplan.delivery.schedule.service.DeliveryScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryScheduleController {

    @Autowired
    DeliveryScheduleService deliveryScheduleService;
}
