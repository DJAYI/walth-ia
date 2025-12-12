package com.example.welthia.dto;

import java.time.Instant;

import com.example.welthia.models.user.ActivityLevel;
import com.example.welthia.models.user.AlcoholFrequency;
import com.example.welthia.models.user.EndOfDayFeeling;
import com.example.welthia.models.user.UserSex;

public record AssessmentRequest(
    long userId,
    int age,
    double weightKg,
    double heightM,
    UserSex userSex,
    Instant wakeTime,
    Instant sleepTime,
    Instant breakfastTime,
    Instant lunchTime,
    Instant dinnerTime,
    int waterCupsDay,
    int wakeDifficulty,
    int nightAwakenings,
    int sleepRepairScore,
    int sleepOnsetScore,
    ActivityLevel activityLevel,
    int exerciseFrequencyPerWeek,
    int stressLevel,
    EndOfDayFeeling endOfDayFeeling,
    int wellbeingScore,
    int readinessChange,
    int confidenceChange,
    boolean drinksAlcohol,
    AlcoholFrequency alcoholFrequency,
    boolean smokesTobacco,
    int tobaccoUnitsPerDay,
    int fruitServingsDay,
    int vegetableServingsDay,
    int processedFoodWeek
) {}
