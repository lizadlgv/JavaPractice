package ru.dolgova.practice1.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "flat")
public class Flat {
    @XmlAttribute(required = true)
    private Integer floor;

    @XmlAttribute(required = true)
    private Integer number;

    @XmlElement(name = "room")
    private List<Room> rooms;

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

    public void setRooms(List<Room> room) {
        this.rooms = rooms;
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

    public List<Room> getRooms() {
        return rooms;
    }
}
