/*package com.wnslp.ssm.common.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Strings;
import com.wnslp.ssm.common.utils.DateTimeUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.util.Date;

public final class JacksonDateConverter {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm:ss");
    private static final DateTimeFormatter ISO8601_DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
    private static final DateTimeFormatter ZONED_DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    public static class DateSerializer extends JsonSerializer<Date> {

        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
            if (value == null) {
                gen.writeNull();
            } else {
                gen.writeString(DateTimeUtils.format(value, DateTimeUtils.DEFAULT_DATE_TIME_FORMATTER));
            }
        }
    }

    public static class DateDeserializer extends JsonDeserializer<Date> {

        @Override
        public Date deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonToken jsonToken = parser.getCurrentToken();

            if (jsonToken == JsonToken.VALUE_STRING) {
                String dateAsString = parser.getText();
                if (Strings.isNullOrEmpty(dateAsString)) {
                    return null;
                }

                dateAsString = dateAsString.trim();

                // yyyy-MM-dd'T'HH:mm:ssZ
                if (dateAsString.length() == 24 && dateAsString.contains("T") && dateAsString.contains("+")) {
                    return DateTime.parse(dateAsString, ZONED_DATE_TIME_FORMATTER).toDate();
                }

                // yyyy-MM-dd'T'HH:mm:ss
                if (dateAsString.length() == 19 && dateAsString.contains("T")) {
                    return DateTimeUtils.toDate(dateAsString, ISO8601_DATE_TIME_FORMATTER);
                }

                // yyyy-MM-dd HH:mm:ss
                if (dateAsString.length() == 19) {
                    return DateTimeUtils.toDate(dateAsString, DateTimeUtils.DEFAULT_DATE_TIME_FORMATTER);
                }

                // yyyy-MM-dd HH:mm
                if (dateAsString.length() == 16) {
                    return DateTimeUtils.toDate(dateAsString, DATE_TIME_FORMATTER);
                }

                // yyyy-MM-dd
                if (dateAsString.length() == 10) {
                    return DateTimeUtils.toDate(dateAsString, DateTimeUtils.DEFAULT_DATE_FORMATTER);
                }

                // HH:mm:ss
                if (dateAsString.length() == 8) {
                    if (dateAsString.indexOf(":") > 0) {
                        return DateTimeUtils.toDate(dateAsString, DEFAULT_TIME_FORMATTER);
                    } else {
                        return DateTimeUtils.toDate(dateAsString, DateTimeUtils.COMPACT_DATE_FORMATTER);
                    }
                }
            } else if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
                return new DateTime(parser.getLongValue()).toDate();
            }

            throw new IllegalArgumentException(String.format("Unsupported datetime format: [%s]", parser.getText()));
        }
    }
}
*/