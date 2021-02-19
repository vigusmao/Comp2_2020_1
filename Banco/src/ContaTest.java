import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ContaTest {

    private static final float ERRO_ACEITAVEL_NOS_FLOATS = 0.000001f;

    private Pessoa maria;
    private Pessoa joao;

    private Banco banco;

    private Agencia minhaAgencia;

    private Conta contaDaMaria;
    private Conta contaDoJoao;

    @Before
    public void setUp() {
        banco = new Banco();

        // cria algumas pessoas
        maria = new Pessoa("Maria", 12345678);
        joao = new Pessoa("Joao", 23222);

        // cria uma agencia
        minhaAgencia = new Agencia(banco, 1, "Agência Principal");

        Conta.numeroDeContasCriadas = 0;  // reseta o static da classe

        // cria algumas contas
        contaDaMaria = new Conta(maria, minhaAgencia, TipoDeConta.CONTA_CORRENTE);
        contaDoJoao = new Conta(joao, minhaAgencia, TipoDeConta.CONTA_SALARIO);
    }

    @Test
    public void testarNumerosAutomaticosDeContas() {
        assertEquals(1, contaDaMaria.getNumeroDaConta());
        assertEquals(2, contaDoJoao.getNumeroDaConta());
//        Conta novaConta = new Conta(maria, minhaAgencia);
//        long numeroDaConta = novaConta.getNumeroDaConta();
//
//        assertEquals(numeroDaConta + 1,
//                (new Conta(joao, minhaAgencia).getNumeroDaConta()));
//        assertEquals(numeroDaConta + 2,
//                (new Conta(joao, minhaAgencia).getNumeroDaConta());
    }

    @Test
    public void testarDeposito() {
        checarSaldoInicial(contaDaMaria);

        contaDaMaria.depositar(1000);
        assertFloatEquals(1010f, contaDaMaria.getSaldoEmReais());

        contaDaMaria.depositar(500);
        assertFloatEquals(1510f, contaDaMaria.getSaldoEmReais());

        contaDaMaria.depositar(-100);
        assertFloatEquals(1510f, contaDaMaria.getSaldoEmReais());  // nada mudou,porque o depósito não foi feito
   }

   @Test
   public void testarDepositoEmDinheiro() {
       checarSaldoInicial(contaDaMaria);

       Map<Dinheiro, Integer> contagemPorCedulaOuMoeda = new HashMap<>();
       contagemPorCedulaOuMoeda.put(Dinheiro.MOEDA_DE_CINCO_CENTAVOS, 3);
       contagemPorCedulaOuMoeda.put(Dinheiro.CEDULA_DE_DUZENTOS_REAIS, 1);

       contaDaMaria.depositarEmDinheiro(contagemPorCedulaOuMoeda);
       assertFloatEquals(210.15f, contaDaMaria.getSaldoEmReais());
   }

    @Test
    public void testarSaque() throws SaldoInsuficienteException, SaqueDeValorNaoPositivoException {
        checarSaldoInicial(contaDaMaria);
        contaDaMaria.sacar(7);
        assertEquals(3f, contaDaMaria.getSaldoEmReais(), ERRO_ACEITAVEL_NOS_FLOATS);
    }

    @Test
    public void testarSaqueSemFundos() throws SaldoInsuficienteException, SaqueDeValorNaoPositivoException {
        checarSaldoInicial(contaDaMaria);
        contaDaMaria.sacar(17);
        assertFloatEquals(10f, contaDaMaria.getSaldoEmReais());
    }

    @Test
    public void testarTransferecia() {
        // sanity check: as contas já começam com saldo 10 (regra de negócio)
        checarSaldoInicial(contaDaMaria);
        checarSaldoInicial(contaDoJoao);

        contaDaMaria.transferir(7, contaDoJoao);

        assertFloatEquals(3f, contaDaMaria.getSaldoEmReais());
        assertFloatEquals(17f, contaDoJoao.getSaldoEmReais());
    }

    @Test
    public void testarTransfereciaSemFundosNaContaDeOrigem() {
        // sanity check: as contas já começam com saldo 10 (regra de negócio)
        assertFloatEquals(10f, contaDaMaria.getSaldoEmReais());
        assertFloatEquals(10f, contaDoJoao.getSaldoEmReais());

        contaDaMaria.transferir(200, contaDoJoao);

        assertFloatEquals(10f, contaDaMaria.getSaldoEmReais());
        assertFloatEquals(10f, contaDoJoao.getSaldoEmReais());
        // a transferência NÃO DEVE SER REALIZADA, porque não fundos na conta de origem (Maria).
    }

    private void checarSaldoInicial(Conta conta) {
        // sanity check: as contas já começam com saldo 10 (regra de negócio)
        assertFloatEquals(
                Conta.SALDO_INICIAL_DE_NOVAS_CONTAS,
                conta.getSaldoEmReais());
    }

    private static void assertFloatEquals(float expected, float actual) {
        assertEquals(expected, actual, ERRO_ACEITAVEL_NOS_FLOATS);
    }
}