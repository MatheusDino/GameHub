
# Projeto GameHub

O projeto faz parte da disciplina de Análise e Projeto de Sistemas Orientados a Objetos, cujo foco no nosso caso foi em implementar um sistema de catálogo de jogos e conquistas, sendo montado em micro serviços relacionados através de um serviço de Discovery.

Os serviços são aplicações REST em Java com Spring e Gradle.
O serviço de Discovery usa Eureka, permitindo que outros serviços o encontrem e se registrem por um serviço de gateway.

Também dispõe de Load Balance para distribuição de serviços caso houvesse múltiplos serviços de um mesmo tipo.




## Referência

 - [Video - Microsserviços com Docker-Compose](https://www.youtube.com/watch?v=5227tbCBv3o&authuser=0)
 - [Basic Spring Boot Application on Docker](https://www.codingshuttle.com/blogs/how-to-setup-docker-compose-for-a-basic-spring-boot-application/)
 - [Orquestração de Microsserviços - Lucas Albertins](https://github.com/lucasalbertins/microservices-spring-boot)


## Deploy

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

Depois vai ser necessário baixar e instalar o gradle gradle.org/install

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

Quando todos os serviços terminarem de buildar, então rode:

```bash
  docker-compose build
```

Logo depois, suba:

```bash
  docker-compose up -d
```

Após os serviços subirem, eles podem demorar de 30 a 40 segundos para ficarem disponíveis. Para checar o registro dos serviços em tempo real no Eureka vá em localhost:8761

Para usar os serviços, você pode abrir o indexV2.html que está na na pasta raiz do projeto em qualquer navegador. Você também pode testar todos os métodos diretamente numa ferramenta como Postman (www.postman.com/downloads) caso prefira.


