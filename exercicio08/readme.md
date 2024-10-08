# Exercício 08: Tabela FIPE

## Objetivo

Utilizando o framework Spring Web, implemente um controlador e um método que receba um objeto JSON no corpo da requisição contendo uma marca, modelo e ano de um carro e retorne o valor de tabela FIPE para esse carro.

## Instruções

* Crie um novo projeto Spring Boot usando o Spring Initializr.
* Defina uma classe de controlador com a anotação `@RestController`.
* Crie um método que receba um objeto JSON no corpo da requisição contendo uma marca, modelo e ano de um carro e retorne o valor de tabela FIPE para esse carro.
* Use o RestClient para fazer a requisição à API da Tabela FIPE.


## Entradas (inputs)

````txt
{
  "marca": "Fiat",
  "modelo": "UNO SPORT. Dual. 1.4 B.Edit. Flex 8V 5p",
  "ano": 2016
}
````

## Saídas (outputs)

````txt
{
	"valor": "R$ 42.363,00",
	"mes": "outubro de 2024"
}
````