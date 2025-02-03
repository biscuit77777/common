package com.biscuit.common.dtos;

import com.biscuit.common.base.BaseAMO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author biscuit
 * @create 2025年02月03日 10:47
 */
@Getter
@Setter
public class RSAPairDTO {

    private String publicKey;
    private String privateKey;

}
