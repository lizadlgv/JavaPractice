package ru.dolgova.practice1.dto;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;

@XmlRootElement(name = "flat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flat {
    @XmlAttribute(required = true)
    private Integer floor;

    @XmlAttribute(required = true)
    private Integer number;

    @XmlElement(name = "room")
    private ArrayList<Room> rooms = new ArrayList<>();

    @XmlElement(name = "area")
    private Integer area;

    public Flat() {
    }

    public Flat(int floor, int number, int area, ArrayList<Room> rooms) {
        this.floor = floor;
        this.number = number;
        this.area = area;
        this.rooms = rooms;
    }

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
