package com.Api.apiSpring.models;

import com.Api.apiSpring.models.dto.TypeUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MedicalAppointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String Specialty;
    @OneToOne
    @JoinColumn(name = "patient_id", updatable = false, nullable = false, unique = true)
    public User patient;

    @Column(nullable = false, unique = true)
    public Long PatientId;

    @Column(name = "Type_user")
    @Enumerated(value = EnumType.STRING)
    private TypeUser typeUser;
}
