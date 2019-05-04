function calculadora(operacao) {
    var numero1 = document.calculadoraForm.numero1.value;
    var numero2 = document.calculadoraForm.numero2.value;
    var resultado;

    if (operacao == "somar") {
        resultado = parseInt(numero1) + parseInt(numero2);
    } else if (operacao == "subtrair") {
        resultado = numero1 - numero2;
    } else if (operacao == "multiplicar") {
        resultado = numero1 * numero2;
    } else {
        resultado = numero1 / numero2;
    }

    document.calculadoraForm.resultado.value = resultado;
}