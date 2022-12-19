package ru.dolgova.practice1.dto;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement(name = "flat")
public class Flat {
    @XmlAttribute(required = true)
    private Integer floor;

    @XmlAttribute(required = true)
    private Integer number;

    @XmlElement(name = "room")
    private final ArrayList<Room> rooms = new ArrayList<>();

    @XmlElement(name = "area")
    private Integer area;

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setRooms(Room room) {
        rooms.add(room);
    }

    public Integer getArea() {
        return area;
    }

    public Integer getFloor() {
        return floor;
    }

    public Integer getNumber() {
        return number;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
