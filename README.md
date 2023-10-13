## Microsserviços de Exemplo SAGA Coreografado com Kafka

Este repositório contém uma implementação de microsserviços de exemplo que seguem o padrão SAGA Coreografado. Os serviços utilizam Apache Kafka para a coordenação de transações distribuídas. Existem três serviços principais: SALE, INVENTORY e PAYMENT.

<h4>Tecnologias</h4>
<ul>
  <li> Java 17
  <li> Spring Boot 
  <li> Maven
  <li> Lombok
  <li> Docker
  <li> MongoDB
  <li> Apache Kafka
</ul>

### Requisitos

Para rodar esta aplicação, você deve ter instalado em seu computador:

<ul>  
   <li><a href="https://docs.docker.com/get-started/" target="_blank">Docker</a>
</ul>

### Executando o projeto

1. Clone ou baixe o projeto do repositório para o seu `Computador`.

2. Navegue até a raíz do diretório do projeto, abra o `terminal e execute o comando:`
<ul>
   <li> sudo docker-compose up -d
   <li> Observação: Durante a criação dos containers será inserida no banco de dados mongodb uma carga inicial com usuários e inventários para teste.
</ul>


3. Após a criação dos containers, importe os projetos para `IDE` de sua escolha e inicialize os três projetos.

4. Agora basta realizar uma chamada rest para o `endpoint:` <a href="http://localhost:8002/v1/api/sales" target="_blank" title="SALES">SALES</a>
passando no `body` esse payload:

```
   {
   "userId": "648f0e568216534e611ecbdf",
   "productId": "648f0e9a8216534e611ecbe4",
   "value": 15.00,
   "quantity": "2"
   }
```

## Fuxo da transação realizada com sucesso

No caminho de sucesso, os serviços operam da seguinte forma:

1. **SALE**: O pedido é criado com status PENDING e é armazenado no banco de dados MongoDB. Em seguida, gera um evento no tópico com o status CREATE_SALE.

2. **INVENTORY**: Consome o tópico com status CREATE_SALE e reserva o estoque necessário. Atualiza o status da venda para SEPARATED no MongoDB e publica um evento no tópico com status UPDATED_INVENTORY.

3. **PAYMENT**: Consome o tópico com status UPDATED_INVENTORY. Valida o pagamento e, após a validação bem-sucedida, atualiza o status da venda para PAID no MongoDB. Em seguida, publica um evento no tópico VALIDATED_PAYMENT.

4. **SALE**: Consome o tópico VALIDATED_PAYMENT e finaliza a venda com sucesso. Atualiza o status da venda para FINALIZED no MongoDB.
<p align="center">
  <img align="center" alt="" src="https://raw.githubusercontent.com/RodrigoAntonioCruz/assets/main/saga.png" />
</p>

## Fuxo da transação com falha - Ação compensatória

Quando ocorre uma falha, por exemplo, durante a validação do pagamento, o sistema segue o caminho de compensação da seguinte forma:

1. **PAYMENT**: Durante a validação do pagamento, se ocorrer um erro, o serviço PAYMENT publica no seu tópico o status da venda como PAYMENT_FAILED.

2. **INVENTORY**: Consome o tópico com status PAYMENT_FAILED e realiza um ROLLBACK na sua base de dados referente ao estoque da venda. Em seguida, publica um evento no seu tópico com o status ROLLBACK_INVENTORY.

3. **SALE**: Consome o tópico com status ROLLBACK_INVENTORY e realiza o cancelamento imediato da venda. Altera o status da venda na sua base para CANCELED.
<p align="center">
  <img align="center" alt="" src="https://raw.githubusercontent.com/RodrigoAntonioCruz/assets/main/acp.png" />
</p>

Este repositório serve como um exemplo de como implementar o padrão SAGA Coreografado para lidar com transações distribuídas e coordenar eventos entre microsserviços.

### Executando os Microsserviços

Para executar os microsserviços, siga as instruções em cada um dos diretórios dos serviços: SALE, INVENTORY e PAYMENT. Certifique-se de configurar o ambiente com o Apache Kafka e MongoDB para que os serviços funcionem corretamente.

### Configuração do Ambiente

Certifique-se de ter o Apache Kafka e o MongoDB configurados em seu ambiente antes de executar os microsserviços. Você pode encontrar mais informações sobre como configurar essas tecnologias em suas respectivas documentações.
