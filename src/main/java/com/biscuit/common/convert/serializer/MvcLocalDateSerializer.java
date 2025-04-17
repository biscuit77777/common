package com.biscuit.common.convert.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * SpringMVC，响应返回 LocalDate 数据类型时的处理
 *
 * @author biscuit
 */
public class MvcLocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(localDate == null ? "" : localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

}
