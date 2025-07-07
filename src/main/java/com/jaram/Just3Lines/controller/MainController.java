package com.jaram.Just3Lines.controller;

import com.jaram.Just3Lines.dto.SummaryDto;
import com.jaram.Just3Lines.dto.SummaryResponseDto;
import com.jaram.Just3Lines.service.MainService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @PostMapping("/summary")
    public ResponseEntity<SummaryResponseDto> summarize(@RequestBody SummaryDto summaryDto){


        List<String> text = mainService.summarizeText(summaryDto.getContent(), summaryDto.getLanguage());
        SummaryResponseDto responseDto = new SummaryResponseDto(text);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
