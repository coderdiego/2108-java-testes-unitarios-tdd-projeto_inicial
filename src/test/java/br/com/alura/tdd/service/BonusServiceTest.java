package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    public void testeBonusPraSalarioAlto() {

        BonusService service = new BonusService();
//        Assertions.assertThrows(IllegalArgumentException.class,
//                () -> service.calcularBonus(new Funcionario("Diego", LocalDate.now(), new BigDecimal("25000"))));

        try{
            service.calcularBonus(new Funcionario("Diego", LocalDate.now(), new BigDecimal("25000")));
            fail("Não executou a exception");
        } catch(Exception e) {
            Assertions.assertEquals("Salário > que 1000", e.getMessage());
        }
    }

    @Test
    public void testeBonusParaSalarioBaixo() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus
                (new Funcionario("Diego", LocalDate.now(), new BigDecimal("1500")));
        Assertions.assertEquals(new BigDecimal("150.00"), bonus);
    }

}