package test.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import test.entity.BaseEntity;
import test.entity.Gender;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by genghz on 18/3/27.
 */

@Data
public class InAuthor extends BaseEntity {

    private String firstName;

    private String lastName;

    private Gender gender;
}
