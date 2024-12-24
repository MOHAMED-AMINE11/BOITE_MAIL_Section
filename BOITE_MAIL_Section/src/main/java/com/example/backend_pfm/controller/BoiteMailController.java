package com.example.backend_pfm.controller;

import com.example.backend_pfm.beans.BoiteMail;
import com.example.backend_pfm.service.BoiteMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boite_mail")
public class BoiteMailController {

    @Autowired
    private BoiteMailService boiteMailService;

    // Créer une nouvelle demande
    @PostMapping("/create")
    public ResponseEntity<BoiteMail> createRequest(@RequestBody BoiteMail boiteMail) {
        BoiteMail createdRequest = boiteMailService.createRequest(boiteMail);
        return ResponseEntity.ok(createdRequest);
    }

    // Récupérer les demandes d'un donneur
    @GetMapping("/donor/{idDonor}")
    public List<BoiteMail> getRequestsByDonor(@PathVariable int idDonor) {
        return boiteMailService.getRequestsByDonor(idDonor);
    }

    // Récupérer les demandes d'un bénéficiaire
    @GetMapping("/beneficiary/{idBeneficiary}")
    public List<BoiteMail> getRequestsByBeneficiary(@PathVariable int idBeneficiary) {
        return boiteMailService.getRequestsByBeneficiary(idBeneficiary);
    }

    // Récupérer les demandes liées à un don
    @GetMapping("/donation/{idDonation}")
    public List<BoiteMail> getRequestsByDonation(@PathVariable int idDonation) {
        return boiteMailService.getRequestsByDonation(idDonation);
    }

    // Récupérer une demande par son ID
    @GetMapping("/{idMail}")
    public ResponseEntity<BoiteMail> getRequestById(@PathVariable int idMail) {
        Optional<BoiteMail> boiteMail = boiteMailService.getRequestById(idMail);
        return boiteMail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Supprimer une demande
    @DeleteMapping("/delete/{idMail}")
    public ResponseEntity<String> deleteRequest(@PathVariable int idMail) {
        boiteMailService.deleteRequest(idMail);
        return ResponseEntity.ok("Demande supprimée avec succès");
    }
    @GetMapping("/beneficiary/active/{idBeneficiary}")
    public List<BoiteMail> getActiveRequestsByBeneficiary(@PathVariable int idBeneficiary) {
        return boiteMailService.getActiveRequestsByBeneficiary(idBeneficiary);
    }

}

