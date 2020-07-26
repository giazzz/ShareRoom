package nguyentv.room.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoomDTO {
    private Integer id;


    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    private Double area;

    @NotNull
    private String picture;

    @NotNull
    private String description;

    @NotNull
    private Double priceDay;

    @NotNull
    private Double priceMonth;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(Double priceDay) {
        this.priceDay = priceDay;
    }

    public Double getPriceMonth() {
        return priceMonth;
    }

    public void setPriceMonth(Double priceMonth) {
        this.priceMonth = priceMonth;
    }
}
