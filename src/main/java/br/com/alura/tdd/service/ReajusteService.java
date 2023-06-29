package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
            BigDecimal percentual = desempenho.percentualReajuste();
            BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
            funcionario.metodoParaReajustarSalario(reajuste.setScale(2, RoundingMode.HALF_UP));
        }
}

