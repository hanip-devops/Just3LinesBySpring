package com.jaram.Just3Lines.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SummaryResponseDto {

    private final List<String> summary;
}
