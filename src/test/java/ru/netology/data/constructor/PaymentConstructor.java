package ru.netology.data.constructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PaymentConstructor {
    private String id;
    private String amount;
    private String created;
    private String status;
    private String transaction_id;
}
