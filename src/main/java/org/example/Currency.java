package org.example;

public record Currency(
        String base_code,
        String target_code,
        Double conversion_rate,
        Double conversion_result
) {
    @Override
    public String base_code() {
        return base_code;
    }

    @Override
    public String target_code() {
        return target_code;
    }

    @Override
    public Double conversion_rate() {
        return conversion_rate;
    }

    @Override
    public Double conversion_result() {
        return conversion_result;
    }
}
