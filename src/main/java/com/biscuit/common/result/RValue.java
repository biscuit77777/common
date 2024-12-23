package com.biscuit.common.result;

import com.biscuit.common.base.BaseAMO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author biscuit
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RValue<T> extends BaseAMO {

    private T value;

}
