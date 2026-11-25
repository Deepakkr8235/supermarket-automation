package com.sas.supermarket.dto;
import jakarta.validation.constraints.*; import java.util.List;
public record CheckoutRequest(@NotBlank String paymentMethod,@NotEmpty List<Line> items){public record Line(@NotNull Long productId,@Min(1) int quantity){}}