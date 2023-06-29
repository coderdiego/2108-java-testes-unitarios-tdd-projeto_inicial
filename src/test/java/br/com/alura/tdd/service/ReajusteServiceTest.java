package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ReajusteServiceTest {
    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    public void reajusteADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());

    }

    @Test
    public void reajusteOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteExcelente() {
//        ReajusteService service = new ReajusteService(); // Foi retirado e passado como atributo da classe para refatoração
//        Funcionario funcionario = new Funcionario("Diana", LocalDate.now(), new BigDecimal("1000.00")); // em todos os metodos acima
        service.concederReajuste(funcionario, Desempenho.EXCELENTE);
        Assertions.assertEquals(new BigDecimal("2000.00"), funcionario.getSalario());
    }
}
