package com.ynz.springdemo.customdatabinder.front;

import com.ynz.springdemo.customdatabinder.domain.Pet;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ModelAttribute can bind uri path variable or parameter names to domain model attributes, by referring path variable
 * or parameter name to a domain model's attribute. However, this mapping is possible only between String to String or
 * Simple data type like String to int, long etc. So, when the domain model contains a complex data type, like Date,
 * or Enum, then it needs register a converter as it shown in this project. Therefor, the @ModelAttribute is able to
 * map a String to a complex data type.
 */

@RestController
@RequestMapping("pet")
public class PetController {

    @PostMapping("owners/{ownerId}/pets/{name}")
    public Pet createPet(@ModelAttribute Pet pet) {
        return pet;
    }

    @PostMapping("owners/{ownerId}/pets/{name}/dates/{birthDate}")
    public Pet createPetWithBirthDate(@ModelAttribute Pet pet) {
        return pet;
    }

}
