package com.Api.apiSpring.services;

import com.Api.apiSpring.Errors.RepeatFoundException;
import com.Api.apiSpring.models.MedicalAppointment;
import com.Api.apiSpring.repositories.MedicalAppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MedicalAppointmentImpl implements MedicalAppointmentService{
    private final MedicalAppointmentRepository medicalRepo;


    @Override
    public MedicalAppointment createMedical(MedicalAppointment medicalAppointment) {
        var foundMedicalRepeat = medicalRepo.findById(medicalAppointment.PatientId);
        if (foundMedicalRepeat.isPresent()) {
            throw new RepeatFoundException(foundMedicalRepeat.get().PatientId);
        } else
            return medicalRepo.save(medicalAppointment);
    }

    @Override
    public Optional<MedicalAppointment> getOneMedical(Long medicalId) {
        try {
            return medicalRepo.findById(medicalId);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
    }
}
