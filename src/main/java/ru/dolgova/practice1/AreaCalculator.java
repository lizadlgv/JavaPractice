package ru.dolgova.practice1;

import ru.dolgova.practice1.dto.Flat;

public class AreaCalculator {
    private final Flat flat;

    public AreaCalculator(Flat flat) {
        this.flat = flat;
    }

    public Integer calculateArea() {
        return flat.getRooms()
                .stream()
                .mapToInt(it -> it.getWidth() * it.getHeight())
                .sum();
    }

    public boolean isAreaEqual(int area) {
        return area == flat.getArea();
    }
}
