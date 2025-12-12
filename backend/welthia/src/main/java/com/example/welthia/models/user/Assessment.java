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
}
