package com.biscuit.common.util;

import com.biscuit.common.base.BaseAMO;
import com.biscuit.common.factory.GsonFactory;
import com.biscuit.common.result.R;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author biscuit
 */
public abstract class ResponseUtil {

    public static void responseWrite(HttpServletResponse response, R<BaseAMO> result) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(GsonFactory.get().toJson(result));
    }

}
