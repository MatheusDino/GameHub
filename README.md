
# Projeto GameHub

O projeto faz parte da disciplina de Análise e Projeto de Sistemas Orientados a Objetos, cujo foco no nosso caso foi em implementar um sistema de catálogo de jogos e conquistas, sendo montado em micro serviços relacionados através de um serviço de Discovery.

Os serviços são aplicações REST em Java com Spring e Gradle.
O serviço de Discovery usa Eureka, permitindo que outros serviços o encontrem e se registrem por um serviço de gateway.

Também dispõe de Load Balance para distribuição de serviços caso houvesse múltiplos serviços de um mesmo tipo.

## Arquitetura

Relação entre serviços: 
![Relação entre serviços](https://github.com/MatheusDino/GameHub/blob/DiscoveryFix/utilidades/ServicesArchitecture.png?raw=true "Service Architecture")
O sistema utiliza Service Discovery e Serviço de Gateway. O usuário interage com o sistema pelo serviço de Gateway que vai ter o trabalho de traçar as rotas das requisições feitas pelo usuário dentro do sistema e o de Discovery gerencia a descoberta entre os serviços de jogos e conquista (além dos próprios serviços de Gateway e Discovery).

Orquestração dos Serviços com Docker-Compose: 
![Orquestração dos Serviços com Docker-Compose](https://github.com/MatheusDino/GameHub/blob/DiscoveryFix/utilidades/ServicesOrchestration.png?raw=true "Service Orchestration")
Os serviços (Spring) são buildados junto às suas dependências usando Gradle, em seguida são empacotados e depois são conteinerizados paraserem orquestrados no Docker (Docker Compose).

## Autores

- [@Gibson - joao.gibson@ufrpe.br](https://www.github.com/StevensSteve)
- [@Lucas - lucas.satiro@ufrpe.br](https://www.github.com/durant35533)
- [@Matheus - matheus.dino@ufrpe.br](https://www.github.com/MatheusDino)
- [@Tulio - tulio.carmo@ufrpe.br](https://www.github.com/TulioEduardo12)

## Referências

 - [Video - Microsserviços com Docker-Compose](https://www.youtube.com/watch?v=5227tbCBv3o&authuser=0)
 - [Basic Spring Boot Application on Docker](https://www.codingshuttle.com/blogs/how-to-setup-docker-compose-for-a-basic-spring-boot-application/)
 - [Orquestração de Microsserviços - Lucas Albertins](https://github.com/lucasalbertins/microservices-spring-boot)


## Como rodar

Primeiro, baixe e instale o docker lá em www.docker.com
Alternativamente você pode rodar:

```bash
  brew install docker
```

ou

```bash
  choco install docker
```

(Depois da instlação pode ser que lhe seja solicitado um reboot)

Você pode conferir a instalação assim:

```bash
  docker-compose --version
```

Depois vai ser necessário baixar e instalar o gradle www.gradle.org/install

Como antes, você também pode rodar:

```bash
  brew install gradle
```

ou

```bash
  choco install gradle
```

Pra conferir:

```bash
  gradle --version
```

Apenas e somente apenas se tudo estiver funcionando, continue

Na pasta que desejar:

```bash
  git clone https://github.com/MatheusDino/GameHub.git
```
```bash
  cd GameHub
```

Como temos vários serviços vamos precisar buildar cada um individualmente, então use esse script:

```bash
  ./buildServices.sh
```

Caso seja Windows, use:

```bash
  .\buildServices.ps1
```

Quando todos os serviços terminarem de buildar, então rode (certifique-se que o docker engine está ativo):

```bash
  docker-compose build
```

Logo depois, suba:

```bash
  docker-compose up -d
```

Após os serviços subirem, eles podem demorar de 30 a 40 segundos para ficarem disponíveis. Para checar o registro dos serviços em tempo real no Eureka vá em localhost:8761

Para usar os serviços, você pode abrir o indexV2.html que está na na pasta raiz do projeto em qualquer navegador. Você também pode testar todos os métodos diretamente numa ferramenta como Postman (www.postman.com/downloads) caso prefira.


## HISTÓRICO DE REVISÕES DO RELATORIO

| Data  | Versão  | Descrição | 
| :------------- | :-------------: | :------------- |
| 15/07/2025  | 1.0  | Criação do documento de rascunho e introdução.|
| 17/07/2025 | 1.1  | Complemento dos rascunhos no documento. |
| 17/07/2025 | 2.0  | Estruturação do ReadMe dentro do github. |
| 18/07/2025 | 2.1  | Complementos ao readme. |
| 20/07/2025 | 2.2  | Mudanças das imagens e nomenclaturas baseadas no feedback do professor. |
| 22/07/2025 | 2.3  | Adição de legenda, indetificação do grupo e outras informações adicionais. |








