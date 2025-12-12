package com.example.welthia.service;

import com.example.welthia.dto.AssessmentRequest;
import com.example.welthia.dto.PreAssessment;

public interface AiService {
    PreAssessment generarPreAssessment(AssessmentRequest request);
}
