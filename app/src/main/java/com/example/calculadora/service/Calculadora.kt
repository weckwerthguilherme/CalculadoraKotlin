package com.example.calculadora.service
import com.example.calculadora.model.Operacao

class Calculadora {
    fun somar(op: Operacao): Int {
        return op.numero1 + op.numero2
    }
    fun subtrair(op: Operacao): Int {
        return op.numero1 - op.numero2
    }
    fun multiplicar(op: Operacao): Int {
        return op.numero1 * op.numero2
    }
    fun dividir(op: Operacao): Int {
        require(op.numero2 != 0) {"Não é possivel dividir por zero."}
        return op.numero1 / op.numero2
    }

}