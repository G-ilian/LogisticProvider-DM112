<h1 align="center">DM112 | Logistic Provider module</h1>

### :books: Descrição
<p>O repositório conta com 3 serviços, todos desenvolvidos com conhecimentos adquiridos na disciplina de DM112 - Conceituação em cloud computing, programação OO, Web Services e SOA.Os três serviços tem como principal objetivo demonstrar e apresentar um módulo de lógistica, estes interconectados são capazes de fornecer ao entregador uma lista completa dos pedidos que ainda não foram entregues, realizar a entrega destes pedidos, e posteriormente o sistema se encarregará de enviar um email ao cliente informando ao mesmo sobre a entrega e mais detalhes. </p>

#### Projeto
O projeto como destacado anteriormente conta com 3 serviços principais, sendo eles:
- Serviço de entregas -> Conta com funcionalidades relacionadas as entregas e aos pedidos.
- Serviço de mensageria. -> Conta com a funcionalidade do envio de emails.
- Serviço de lógistica. -> Encapsula e expões os principais endpoints dos outros dois serviços, ou seja, trata-se do serviço principal e tem como principais funcionalidades a recuperação de pedidos(ainda não entregues), registro da entrega do pedido e disparo automatizado de email para o cliente informando a cerca da entrega e seus detalhes.

### Fluxograma simplificado

### :hammer_and_wrench: Instalação e execução
#### Preparação do ambiente no computador para executar os serviços
- [Git](https://git-scm.com/)
- [JavaSDK](https://www.oracle.com/java/technologies/downloads/)
- [IntelliJ](https://www.jetbrains.com/pt-br/idea/download/)
- [Postman](https://www.postman.com/downloads/)

Observação: Você pode usar a IDE e o cliente HTTP de sua preferência, o IntelliJ e Postman são apenas sugestões.

Clone o repositório em seu computador para poder acessar o projeto:
```
$ git clone git@github.com:G-ilian/LogisticProvider-DM112.git
```

A partir desse ponto será necessário que você abra os três serviços utilizando-se do IntelliJ(Ou a Ide de sua preferência).
```
    📂emailService/
    📂entregador/
    📂logisticProvider/
```  
Todos os serviços contam com um arquivo de execução que estará sempre seguido da palavara Application. Sendo assim temos respectivamente:
LogisticProviderApplication.java
EntregadorApplication.java
EmailServiceApplication.java

Esses serviços devem ser todos executados, para que possamos iniciar nossos testes. Caso não esteja os encontrando, procure em todos eles no nível de pastas a seguir:
```
    📂seu_servico/
        📂src/
            📂main/
                📂java/
                    📂br.posInatel.servico_em_questao/
                        servicoApplication.java
```

Considerações importantes.
<p> 1. É necessário que seja alterado em logisticProvider, em application.properties os dados de email.sender e email.password para os seus dados. </p>
<p>2. Caso necessário altere as portas dos serviços em application.properties e depois reflita as alterações no application.properties do logisticProvider</p>

#### 🚀 Executando
NOTA IMPORTANTE
Os endpoints tem validação, ou seja, caso tente criar uma entrega para um pedido inexistente será retornado o erro.Para efetuar os testes sugerimos:
1. Encontre a localização de OrderClientRunner no serviço de logisticProvider
```
    📂logisticProvider/
        📂src/
            📂main/
                📂java/
                    📂br.posInatel.logisticProvider/
                        📂client/
                            📂runner/
                                OrderClientCreateRunner.java
```
2. Execute o serviço para popular o banco
3. Afim de acessar o banco entre em : http://sua_url/entregador/h2-console

Com as etapas anteriormente concluída.

<p>Com todos os serviços em funcionamento, acione o Postman e faça requisições para os endpoints que são expostos pelo LogisticProvider, sendo eles: </p>

<p> [POST] - Criar Entrega : /api/createDelivery </p>
<p> [GET] - Recuperar pedidos entregues : /api/getAllDeliveredOrders </p>
<p> [GET] - Recuperar pedidos : /api/getAllOrders </p>

Para o request do tipo Post será necessário informar um Json, com dados do tipo:
```
    {
        "receiverCpf":"cpf_do_receptor",
        "receiverName":"nome_do_receptor",
        "deliveryDate":"2024-03-29T15:22:30",
        "orderNumber":1
    }
```




## :gear: Autores

* **Luciano Correa** - [Luciano](https://github.com/LuciMito)

* **Gabriel Ilian** - [Gabriel](https://github.com/G-ilian) 