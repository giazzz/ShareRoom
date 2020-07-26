package nguyentv.room.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RoomValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Room.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Room r = (Room) o;

        if(r.getName() == null){
            errors.rejectValue("name", null, "Name is required!");
        }else if(r.getName().length() < 3){
            errors.rejectValue("name", null, "Min length is 3!");
        }

        if(r.getArea() == null){
            errors.rejectValue("area", null, "Area is required!");
        }

        if(r.getDescription() == null){
            errors.rejectValue("description", null, "Description is required!");
        }

        if(r.getPicture() == null){
            errors.rejectValue("picture", null, "ImageURL is required!");
        }

        if(r.getPriceDay() == null){
            errors.rejectValue("priceDay", null, "Price per day is required!");
        }

        if(r.getPriceMonth() == null){
            errors.rejectValue("priceMonth", null, "Price per month is required!");
        }
    }
}
