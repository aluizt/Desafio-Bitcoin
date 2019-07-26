# Desafio-Bitcoin
Desafio Bitcoin
Realizar integração com uma API externa onde a mesma possui limites de requisições por segundo. 
Todas as informações dessa API devem ser armazenadas no banco de dados selecionado no caso "CouchDB ou Couch Base".
Atividas:
1) Carga das criptomoedas. Deve ser feita via job utilizando o Spring Scheduled (https://spring.io/guides/gs/scheduling-tasks/). 
Endpoints necessários para carga:
 - https://api.coinpaprika.com/v1/coins (LISTA TODAS CRIPTOMOEDAS)
 - https://api.coinpaprika.com/v1/coins/{ID_BITCOIN} (DESCRICAO)
 - https://api.coinpaprika.com/v1/{ID_BITCOIN}/ohlcv/latest/ (PRECO)
OBS: Talvez pelo volume tenha que ser avaliado uma estratégia. Nota da API "Single IP address can send less than 10 requests per second"
2) Endpoint consulta Criptomoeda. Deve ser feito um endpoint onde possa filtrar por qualquer informação que contenha nos dados da api, podendo ser também ordenado. 
Por exemplo trazer criptomoedas com maior volume de transação, preço, market cap e outros.
3) Carga Exchanges. Criar um endpoint onde sera feito o processo de cadastro de todas exchanges contidas na api.
Endpoints necessários para carga:
 - https://api.coinpaprika.com/v1/exchanges
 - https://api.coinpaprika.com/v1/exchanges/binance/markets
4) Endpoint que retorna as exchanges que trabalham com a criptomoeda desejada. Ou seja vai ser informado a criptomoeda que desejo operar e a API vai retornar todas exchanges disponíveis.
Link principal: https://api.coinpaprika.com
Requisitos
- Testes unitários.
- Spring
- SonarLint
- Docker
- Java 11
- CouchDB ou Couch Base
