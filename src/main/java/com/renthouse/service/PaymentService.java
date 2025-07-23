package com.renthouse.service;

import com.renthouse.dto.PaymentRequestDTO;
import com.renthouse.dto.PaymentResponseDTO;
import com.renthouse.model.Payment;
import com.renthouse.model.Rental;
import com.renthouse.repository.PaymentRepo;
import com.renthouse.repository.RentalRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private  final PaymentRepo paymentRepo;
    private final RentalRepo rentalRepo;

    public PaymentService(PaymentRepo paymentRepo, RentalRepo rentalRepo) {
        this.paymentRepo = paymentRepo;
        this.rentalRepo = rentalRepo;
    }

    public PaymentResponseDTO createPayment(PaymentRequestDTO requestDTO){
        Rental rental = rentalRepo.findById(requestDTO.getRentalId())
                .orElseThrow(() -> new RuntimeException("Rental not found"));

        Payment payment = Payment.builder()
                .rental(rental)
                .amount(requestDTO.getAmount())
                .paymentDate(requestDTO.getPaymentDate())
                .status(requestDTO.getStatus())
                .paymentMethod(requestDTO.getPaymentMethod())
                .referenceId(requestDTO.getReferenceId())
                .build();

        Payment saved = paymentRepo.save(payment);
        return  toResponseDTO(saved);

    }

    public List<PaymentResponseDTO> getAllPayments() {
        return paymentRepo.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PaymentResponseDTO getPaymentById(Long id) {
        Payment payment = paymentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return toResponseDTO(payment);
    }

    public void deletePayment(Long id) {
        paymentRepo.deleteById(id);
    }

    private PaymentResponseDTO toResponseDTO(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setAmount(payment.getAmount());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setStatus(payment.getStatus());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setReferenceId(payment.getReferenceId());
        dto.setRentalId(payment.getRental().getId());
        dto.setTenantId(payment.getRental().getTenant().getId());
        dto.setPropertyId(payment.getRental().getProperty().getId());

        return dto;
    }

}
