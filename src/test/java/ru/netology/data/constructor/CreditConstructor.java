package ru.netology.data.constructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditConstructor {
    private String id;
    private String bank_id;
    private String created;
    private String status;
}
