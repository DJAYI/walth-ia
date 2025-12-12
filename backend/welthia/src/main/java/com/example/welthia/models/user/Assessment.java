package com.example.welthia.models.user;

import java.time.Instant;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Assessment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name= "user_id")
    private UserEntity userEntity;

    @Column(name="date_completed")
    private final LocalDate dateCompleted = LocalDate.now(); 

    //datos demograficos 
    private int age;

    @Column(name="weigth_kg")
    private double weightKg;

     @Column(name="height_m")
    private double heightM;

    @Column(name = "user_sex")
    @Enumerated(EnumType.STRING)
    private UserSex userSex;

    //habitos y rutinas
    @Column(name="wake_time")
    private Instant wakeTime;

    @Column(name="sleep_time")
    private Instant sleepTime;

    @Column(name="breakfast_time")
    private Instant breakfastTime;

    @Column(name="lunch_time")
    private Instant lunchTime;

    @Column(name="dinner_time")
    private Instant dinnerTime;

    @Column(name="water_cups_day")
    private int waterCupsDay;

    // sueño
    @Column(name="wake_difficulty")
    private int wakeDifficulty;

    @Column(name="night_awakenings")
    private int nightAwakenings;

    @Column(name="sleep_repair_score")
    private int sleepRepairScore;

    @Column(name="sleep_onset_score")
    private int sleepOnsetScore;

    //actividad fisica
    @Column(name="activity_level")
    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;

    @Column(name="exercise_frequency_per_week")
    private int exerciseFrequencyPerWeek;

    //Estrés / estado de ánimo
    @Column(name="stress_level")
    private int stressLevel;

    @Column(name="end_of_day_feeling")
    @Enumerated(EnumType.STRING)
    private EndOfDayFeeling endOfDayFeeling;

    private int wellbeingScore;

    //cambio de habitos
    @Column(name="readiness_change")
    private int readinessChange;

    @Column(name="confidence_change")
    private int confidenceChange;   

    //Alcohol / tabaco
    @Column(name="drinks_alcohol")
    private boolean drinksAlcohol;

    @Column(name="alcohol_frequency")
    @Enumerated(EnumType.ORDINAL)
    private AlcoholFrequency alcoholFrequency;

    @Column(name="smokes_tobacco")
    private boolean smokesTobacco;

    @Column(name="tobacco_units_per_day")
    private int tobaccoUnitsPerDay;

    //alimentacion minima
    @Column(name="fruit_servings_day")
    private int fruitServingsDay;

    @Column(name="vegetable_servings_day")
    private int vegetableServingsDay;

    @Column(name="processed_food_week")
    private int processedFoodWeek;
}
