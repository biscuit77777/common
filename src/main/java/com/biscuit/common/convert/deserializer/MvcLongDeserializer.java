package com.biscuit.common.convert.deserializer;

import com.biscuit.common.util.JudgmentUtil;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * SpringMVC，接收 Long 类型参数时的处理
 *
 * @author biscuit
 */
public class MvcLongDeserializer extends JsonDeserializer<Long> {

    @Override
    public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String dateString = jsonParser.getText();
        return JudgmentUtil.isBlank(dateString) ? null : Long.parseLong(dateString);
    }

}
