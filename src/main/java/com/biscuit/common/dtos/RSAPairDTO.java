package com.biscuit.common.dtos;

import com.biscuit.common.base.BaseAMO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author biscuit
 */
@Getter
@Setter
public class RSAPairDTO {

    private String publicKey;
    private String privateKey;

}
