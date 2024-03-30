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


Para acessar o repositório clonado usando o terminal, digite: 
```
$ cd Projeto_C214-Lab
```
Para acessar os arquivos de código pelo terminal, digite:
```
$ cd API
```

## :gear: Autores

* **Luciano Correa** - [Luciano](https://github.com/LuciMito)

* **Gabriel Ilian** - [Gabriel](https://github.com/G-ilian) 