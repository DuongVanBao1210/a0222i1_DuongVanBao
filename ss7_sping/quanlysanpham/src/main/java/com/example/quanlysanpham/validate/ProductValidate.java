package com.example.quanlysanpham.validate;

import com.example.quanlysanpham.entity.Product;
import com.example.quanlysanpham.formatter.DateFomatter;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        //        System.out.println(product.getExpiryDate());

        Date inDay = product.getExpiryDate();


//        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        SimpleDateFormat ntn = new SimpleDateFormat("yyyy-MM-dd");


        try {
            Date date =  ntn.parse("2000-01-01");
            System.out.println(date);
            System.out.println(product.getExpiryDate());

            if( inDay.before( date) == true ){
                errors.rejectValue("expiryDate", "dateMinAAA");
            }



//            String inDayString = ntn.format(product.getExpiryDate());
//            Date inDate = ntn.parse( inDayString);
//            System.out.println(inDate);



        } catch (ParseException e) {
            e.printStackTrace();
        }




//        else if (!student.getPhoneNumber().startsWith("0")) {
//            errors.rejectValue("phoneNumber", "phonenumberstart", "Số điện thoại không đúng định dạng");
//        }
    }
}
