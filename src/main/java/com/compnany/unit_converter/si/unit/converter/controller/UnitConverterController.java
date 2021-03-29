package com.compnany.unit_converter.si.unit.converter.controller;

import com.compnany.unit_converter.si.unit.converter.service.UnitConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UnitConverterController {

    @Autowired
    private UnitConverterService service;

    @GetMapping("/units/si")
    public ResponseEntity<?> convertUnits(@RequestParam(name = "units")String units) {
    	Map<String, Object> result = new HashMap<>();
    	try {
    		result = service.convert(units);
    	} catch(Exception e) {
    		result.put("error: ", "fail parsing unit");
    		return ResponseEntity.badRequest().body(result);
    	}
    	return ResponseEntity.ok(result);
    }
}
    	
