package ru.dolgova.practice2;

import ru.dolgova.practice2.command.CommandReader;

public class Main {
    public static void main(String[] args) {
        CommandReader.startReadCommand();
        ApplicationDataSource.getConnection();
    }
}