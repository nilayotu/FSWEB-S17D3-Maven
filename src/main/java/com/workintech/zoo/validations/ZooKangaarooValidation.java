package com.workintech.zoo.validations;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooKangaarooValidation {

    public static void isIdValid(Integer id){
        if (id == null || id < 0){
            throw new ZooException(" id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }
    }
    public static void checkKangarooExistence(Map<Integer, Kangaroo> kangaroos, Integer id, boolean existence) {

        if (existence) {
            if (!kangaroos.containsKey(id)) {
                throw new ZooException("record does not exist: " + id, HttpStatus.NOT_FOUND);
            }
        } else {
            if (kangaroos.containsKey(id)) {
                throw new ZooException("record already exists: " + id, HttpStatus.BAD_REQUEST);

            }
        }
    }

    public static void checkKangarooWeight(Double weight){
        if (weight == null || weight <= 0){
            throw new ZooException("Weight shouldnt be null or less than zero: " + weight, HttpStatus.BAD_REQUEST);
        }
    }
}
