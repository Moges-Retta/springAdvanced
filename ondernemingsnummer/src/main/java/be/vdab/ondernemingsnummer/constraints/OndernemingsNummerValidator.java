package be.vdab.ondernemingsnummer.constraints;

import be.vdab.ondernemingsnummer.domain.Firma;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OndernemingsNummerValidator  implements ConstraintValidator<OndernemingsNummer, Long> {
    @Override
    public void initialize(OndernemingsNummer constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(value==null){
            return false;
        }
        var overigeCijfers = value/100;
        var laaste2Cijfers = value-overigeCijfers*100;
        var diff = 97-overigeCijfers%97;
        return laaste2Cijfers==diff;
    }
}
