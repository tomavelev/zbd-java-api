package com.programtom.zbd_api.model.lightening_address;

import lombok.Data;

@Data
public class ValidateLNResponse {
    private Boolean valid;
    private Metadata metadata;
}
