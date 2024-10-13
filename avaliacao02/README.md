# Serviço de Meteorologia

## Instruções para Execução
Este aplicativo assume que você tem um token de API válido configurado de acordo com este manual.

#### Acesse a área de registro de usuário das API's: 
- [WeaterAPI](https://www.weatherapi.com/signup.aspx)
- [Climatempo API](https://advisor.climatempo.com.br/)

#### Registre seu usuário.
Acesse seu email para validar os cadastros.
Acesse a página de gerenciamento de API cada api para gerar o token 

Renomeie o arquivo src/main/resources/application.properties.sample para application.properties e substitua as variaveis indicadas abaixo pelo token gerado em cada API


```
climatempo.api.token=SUA-CHAVE-AQUI

weatherapi.api.key=SUA-CHAVE-AQUI
```

### Pré-requisitos
- Java 11+
- Docker

### Compilação e Execução
```bash
mvnw clean install
docker-compose up --build
```

### Rotas
- [GET] /api/previsao/climatempo/{cidadeNome}/{estadoNome}: Retorna a previsão do tempo com a api climatempo.
- [GET] /api/previsao/weatherapi/{cidadeNome}: Retorna a previsão do tempo com a api weatherapi.
- [POST] /api/previsao: Processa os dados para previsão do tempo usando as duas API's.
- [GET] /sobre: Dados sobre o autor e a API

[POST] /api/previsao

Recebe os dados no body em formato json
``` JSON
{
	"cidade": "Criciuma",
	"estado": "SC"
}
```


