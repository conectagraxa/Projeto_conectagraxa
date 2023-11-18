package com.conecta.conectagraxa.model.annotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<Date, String> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public String convertToDatabaseColumn(Date attribute) {
        if (attribute == null) {
            return null;
        }
        return dateFormat.format(attribute);
    }

    @Override
    public Date convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return dateFormat.parse(dbData);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dbData);
        }
    }
}