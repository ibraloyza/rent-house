package com.renthouse.controller;

import com.renthouse.dto.PaymentRequestDTO;
import com.renthouse.dto.PaymentResponseDTO;
import com.renthouse.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/payments")
public class PaymentController {
    private  final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/createPayment")
    public ResponseEntity<PaymentResponseDTO> createPayment(@RequestBody PaymentRequestDTO requestDTO) {
        return ResponseEntity.ok((paymentService.createPayment(requestDTO)));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PaymentResponseDTO>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PaymentResponseDTO> getPayment(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
