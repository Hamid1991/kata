package com.kata.backend.controller;

import com.kata.backend.dto.NumberToTransformDto;
import com.kata.backend.dto.TransformedNumberDto;
import com.kata.backend.service.TransformerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TransformerController {

    private final TransformerService transformerService;

    public TransformerController(TransformerService transformerService) {
        this.transformerService = transformerService;
    }

    @PostMapping("/transform")
    @ResponseBody
    public TransformedNumberDto transformNumber(@RequestBody NumberToTransformDto numberToTransformDto) {
        Integer numberToTransform = numberToTransformDto.numberToTransform();
        String transformedNumber = transformerService.transformNumber(numberToTransform);
        return new TransformedNumberDto(transformedNumber);
    }
}