package com.Api.apiSpring.services;

import com.Api.apiSpring.models.MedicalAppointment;

import java.util.Optional;

public interface MedicalAppointmentService {
    MedicalAppointment createMedical(MedicalAppointment medicalAppointment);

    Optional<MedicalAppointment> getOneMedical(Long medicalId);
}
