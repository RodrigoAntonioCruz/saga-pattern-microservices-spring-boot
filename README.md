## Microsserviços de Exemplo SAGA Coreografado com Kafka

Este repositório contém uma implementação de microsserviços de exemplo que seguem o padrão SAGA Coreografado. Os serviços utilizam Apache Kafka para a coordenação de transações distribuídas. Existem três serviços principais: SALE, INVENTORY e PAYMENT.

## Transação realizada com sucesso

No caminho de sucesso, os serviços operam da seguinte forma:

1. **SALE**: O pedido é criado com status PENDING e é armazenado no banco de dados MongoDB. Em seguida, gera um evento no tópico com o status CREATE_SALE.

2. **INVENTORY**: Consome o tópico com status CREATE_SALE e reserva o estoque necessário. Atualiza o status da venda para SEPARATED no MongoDB e publica um evento no tópico com status UPDATED_INVENTORY.

3. **PAYMENT**: Consome o tópico com status UPDATED_INVENTORY. Valida o pagamento e, após a validação bem-sucedida, atualiza o status da venda para PAID no MongoDB. Em seguida, publica um evento no tópico VALIDATED_PAYMENT.

4. **SALE**: Consome o tópico VALIDATED_PAYMENT e finaliza a venda com sucesso. Atualiza o status da venda para FINALIZED no MongoDB.
<p align="center">
  <img align="center" alt="" src="https://raw.githubusercontent.com/RodrigoAntonioCruz/assets/main/saga.png" />
</p>

## Fuxo da transação com falha - Ação Compensatória

Quando ocorre uma falha, por exemplo, durante a validação do pagamento, o sistema segue o caminho de compensação da seguinte forma:

1. **PAYMENT**: Durante a validação do pagamento, se ocorrer um erro, o serviço PAYMENT publica no seu tópico o status da venda como PAYMENT_FAILED.

2. **INVENTORY**: Consome o tópico com status PAYMENT_FAILED e realiza um ROLLBACK na sua base de dados referente ao estoque da venda. Em seguida, publica um evento no seu tópico com o status ROLLBACK_INVENTORY.

3. **SALE**: Consome o tópico com status ROLLBACK_INVENTORY e realiza o cancelamento imediato da venda. Altera o status da venda na sua base para CANCELED.

Este repositório serve como um exemplo de como implementar o padrão SAGA Coreografado para lidar com transações distribuídas e como usar o Apache Kafka para coordenar eventos entre microsserviços.
<p align="center">
  <img align="center" alt="" src="https://raw.githubusercontent.com/RodrigoAntonioCruz/assets/main/acp.png" />
</p>


### Executando os Microsserviços

Para executar os microsserviços, siga as instruções em cada um dos diretórios dos serviços: SALE, INVENTORY e PAYMENT. Certifique-se de configurar o ambiente com o Apache Kafka e MongoDB para que os serviços funcionem corretamente.

### Configuração do Ambiente

Certifique-se de ter o Apache Kafka e o MongoDB configurados em seu ambiente antes de executar os microsserviços. Você pode encontrar mais informações sobre como configurar essas tecnologias em suas respectivas documentações.
