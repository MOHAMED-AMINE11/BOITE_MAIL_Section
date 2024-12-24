package com.example.backend_pfm.service;

import com.example.backend_pfm.beans.BoiteMail;
import com.example.backend_pfm.repository.BoiteMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoiteMailService {

    @Autowired
    private BoiteMailRepository boiteMailRepository;

    // Créer une nouvelle demande
    public BoiteMail createRequest(BoiteMail boiteMail) {
        return boiteMailRepository.save(boiteMail);
    }

    // Récupérer les demandes d'un donneur
    public List<BoiteMail> getRequestsByDonor(int donorId) {
        return boiteMailRepository.findByDonor_Id(donorId);
    }

    // Récupérer les demandes d'un bénéficiaire
    public List<BoiteMail> getRequestsByBeneficiary(int beneficiaryId) {
        return boiteMailRepository.findByBeneficiary_Id(beneficiaryId);
    }

    // Récupérer les demandes d'un don
    public List<BoiteMail> getRequestsByDonation(int donationId) {
        return boiteMailRepository.findByDonation_IdDonation(donationId);
    }

    // Récupérer une demande par son ID
    public Optional<BoiteMail> getRequestById(int idMail) {
        return boiteMailRepository.findById(idMail);
    }

    // Supprimer une demande par ID
    public void deleteRequest(int idMail) {
        boiteMailRepository.deleteById(idMail);
    }

    public List<BoiteMail> getActiveRequestsByBeneficiary(int beneficiaryId) {
        return boiteMailRepository.findByBeneficiary_IdAndIsActive(beneficiaryId, true);
    }
}

