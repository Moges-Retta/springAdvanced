package be.vdab.ondernemingsnummer.firma;

import be.vdab.ondernemingsnummer.domain.Firma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class FirmaTest {
    private Validator validator;
    private Firma firma;

    @BeforeEach
    void beforeEach() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        firma = new Firma();
        firma.setOndernemingsNummer(426388541);
    }

    @Test
    void correctFirma() {
        assertThat(validator.validate(firma)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(longs = {426388542,42635255,426388})
    void verkeerdeOndernemmerNummer(Long number) {
        firma.setOndernemingsNummer(number);
        assertThat(validator.validate(firma)).isNotEmpty();
    }
}
