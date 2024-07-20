package com.jingdianjichi.subject.application.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * ClassName: GlobalConfig
 * Package: com.jingdianjichi.subject.application.config
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/11 17:17
 * @Version 1.0
 */
@Configuration
public class GlobalConfig extends WebMvcConfigurationSupport {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 保留父类的配置
        super.configureMessageConverters(converters);
        converters.add(mappingJackson2HttpMessageConverter());
    }

    private static final String DEFAULT_LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DEFAULT_LOCAL_DATE_FORMAT = "yyyy-MM-dd";
    private static final String DEFAULT_LOCAL_TIME_FORMAT = "HH:mm:ss";
    // 对返回给前端的Json对象进行处理
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        // 默认Jackson在试图序列化一个没有可序列化字段的bean（即一个空bean，没有任何公共字段、getter方法或@JsonInclude注解的字段）时，会抛出异常
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 在序列化Java对象为JSON时，只有那些值不为null的字段才会被包含在输出的JSON中
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);


        // 处理Java 8的日期时间类型，确保它们在序列化和反序列化时采用指定的日期时间格式
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule
                .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_LOCAL_DATE_TIME_FORMAT)))
                .addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DEFAULT_LOCAL_DATE_FORMAT)))
                .addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_LOCAL_TIME_FORMAT)))
                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_LOCAL_DATE_TIME_FORMAT)))
                .addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DEFAULT_LOCAL_DATE_FORMAT)))
                .addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_LOCAL_TIME_FORMAT)));
        objectMapper.registerModules(javaTimeModule);


        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);

        return converter;
    }
}
