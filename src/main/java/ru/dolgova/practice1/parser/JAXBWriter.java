package ru.dolgova.practice1.parser;

import ru.dolgova.practice1.dto.Flat;
import ru.dolgova.practice1.dto.Room;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class JAXBWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inFile, outFile;
        try {
            System.out.print("Введите имя входного XML-файла: ");
            inFile = scanner.nextLine();
            System.out.print("Введите имя выходного XML-файла: ");
            outFile = scanner.nextLine();
            InputStream is = new FileInputStream("src/main/resources/" + inFile + ".xml");
            OutputStream os = new FileOutputStream("src/main/resources/" + outFile + ".xml");

            JAXBContext jc = JAXBContext.newInstance(Flat.class);
            Unmarshaller um = jc.createUnmarshaller();
            Marshaller m = jc.createMarshaller();
            Flat flat = (Flat) um.unmarshal(is);

            checkFlat(flat);
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(flat, os);
            os.close();
            is.close();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkFlat(Flat flat) {
        List<Room> rooms = flat.getRooms();
        int area = 0;
        for (Room room : rooms) {
            area = area + room.getHeight() * room.getWidth();
        }
        if (flat.getArea() == 0) {
            flat.setArea(area);
            System.out.println("Площадь квартиры посчитана: " + area);
        } else {
            if (area != flat.getArea()) {
                System.out.println("Действительная площади квартиры(" + area + ") не совпадает с площадью в xml-докумнте(" + flat.getArea() + ").");
                flat.setArea(area);
            } else {
                System.out.println("Площадь квартиры: " + area);
            }
        }
    }
}
