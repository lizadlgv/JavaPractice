package ru.dolgova.practice1.parser;

import ru.dolgova.practice1.dto.Flat;

public interface Parser {
    boolean validate();

    Flat read(String fileName);

    void write(String fileName);
}
