package ru.dolgova.practice1.dto;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "room")
public class Room {
    @XmlAttribute(required = true)
    private Integer height;

    @XmlAttribute(required = true)
    private Integer width;

    public Room(Integer height, Integer width) {
        this.height = height;
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }
}
