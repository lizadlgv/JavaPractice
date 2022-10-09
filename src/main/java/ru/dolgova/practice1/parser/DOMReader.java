package ru.dolgova.practice1.parser;

import ru.dolgova.practice1.dto.Flat;

public class DOMReader implements Parser {
    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Flat read(String fileName) {
        return null;
    }

    @Override
    public void write(String fileName) {

    }
}
