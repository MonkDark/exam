package com.monk.exam.common;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author monk
 * @description 全局配置LocalDateTime，实现格式化
 * @date 2022-05-03 18:22
 */

@Configuration
public class LocalDateTimeSerializerConfig {
    @Value("${spring.jackson.date-format}")
    private String pattern;

    /**
     * 统一配置时间
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        JavaTimeModule module = new JavaTimeModule();
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(pattern)));
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern)));
        return builder -> {
            builder.simpleDateFormat(pattern);
            builder.deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(pattern)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern)));
            builder.modules(module);
        };
    }
}
