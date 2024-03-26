# Resumo

## Introdução
Então aqui eu fiz uma implementação de uma api usando java spring boot e o graphQL 

## Seção 1
Começando com o arquivo .graphqls alí eu pus todo a interface da querry tendo todos os requisitos

### Subseção 1.1
já na pasta config temos o arquivo .java que faz isso : 
Este código configura a funcionalidade de assinatura (subscription) em um projeto Spring Boot, permitindo que os clientes recebam atualizações em tempo real sobre os usuários. A classe SubscriptionConfig é anotada com @Configuration, indicando que contém métodos que definem beans gerenciados pelo Spring. Dois métodos estão marcados com @Bean: userSink() e userFlux().

O método userSink() cria e configura um bean do tipo Sinks.Many<User>, responsável por enviar elementos para os clientes inscritos para receber atualizações sobre os usuários. Este bean é configurado para ser um fluxo multicast, permitindo várias assinaturas, e possui um buffer de backpressure para lidar com situações em que os consumidores não conseguem lidar com a taxa de produção.

Já o método userFlux() cria um bean do tipo Flux<User>, que representa um fluxo de elementos do tipo User. Ele recebe como parâmetro o bean userSink e retorna o fluxo gerado a partir dele. Essa configuração permite que os clientes se inscrevam para receber atualizações em tempo real sobre os usuários do sistema, com o Spring cuidando da lógica de gerenciamento de assinaturas e entrega de eventos.

### Subseção 1.2
na pasta controle temos o arquivo .java que controla o que queremos na query, lá desenvolve-se todos os métodos que queremos como mudar adicionar,mapear e etc..

## Seção 2
pasta Modelo temos a inicialização das interfaces endereço user e user input onde construimos as suas propriedades e parâmetros 

### Subseção 2.1
Pasta service temos o coração da query onde implemento os métodos seja get registrar buscar e todos os métodos necessários, consultar código para entender melhor 

### Subseção 2.2
O mais importante agora é a parte do application.properties onde deu uma boa dor de cabeça na parte de acertar os paths da query 

## Conclusão

Como usar: Coloque query mutation ou Subscription e ponha ou modifique as propriedades que foram definidas em outros arquivos e tá feito, além dos métodos que eu criei como get all users serch find e demais.


Query: Os métodos de consulta são usados para recuperar dados do servidor. Eles são análogos às operações de leitura em um banco de dados. Exemplos de métodos de consulta podem incluir getUserById, getAllUsers, getPosts, etc.

Mutation: Os métodos de mutação são usados para modificar ou criar dados no servidor. Eles correspondem a operações de escrita em um banco de dados. Exemplos de métodos de mutação podem incluir addNewUser, updatePost, deleteComment, etc.

Subscription: Os métodos de assinatura são usados para criar um canal de comunicação assíncrona entre o servidor e o cliente, permitindo que o servidor envie atualizações para o cliente quando ocorrerem determinados eventos. Exemplos de métodos de assinatura podem incluir newUserNotification, realTimeUpdates, etc.
