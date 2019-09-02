package com.chtrak.microsns.microsnsorder.service;

import com.chtrak.microsns.microsnsorder.entity.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "microscs-item",value = "microscs-item")
public interface ItemService {

    @GetMapping(value = "/item/{id}",produces = "application/json")
    Item queryItemById(@PathVariable("id") Long id);
}
