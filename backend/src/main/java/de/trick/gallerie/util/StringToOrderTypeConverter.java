package de.trick.gallerie.util;

import de.trick.gallerie.type.OrderType;
import org.springframework.core.convert.converter.Converter;

public class StringToOrderTypeConverter implements Converter<String, OrderType> {
    @Override
    public OrderType convert(String source) {
        return OrderType.valueOf(source.toUpperCase());
    }
}
