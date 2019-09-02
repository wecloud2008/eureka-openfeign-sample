package com.chtrak.microscs.microscsitem.controller;

import com.chtrak.microscs.microscsitem.pojo.Item;
import com.chtrak.microscs.microscsitem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/item/{id}")
    public Item queryItemById(@PathVariable(name="id") Long id){
        return itemService.queryItemById(id);
    }
}