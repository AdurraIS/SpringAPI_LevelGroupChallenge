# SalesUnity

A equipe SalesUnity esta desenvolvendo uma aplicação web que simplifica o processo de cotação de compras, utilizando APIs para automatização e melhorando a acessibilidade. A plataforma permite solicitar cotações com poucos cliques, reduzindo tarefas manuais e erros. Além disso, enfoca-se na segurança dos dados, implementando medidas para garantir confidencialidade e integridade. A solução é globalmente acessível, virtualizada e hospedada na nuvem. Oferecemos um web service para integração, utilizando uma abordagem de SaaS (Software as a Service) para proporcionar uma solução completa que economiza tempo, recursos e aprimora a eficiência operacional das empresas no cenário de transformação digital.

### Objetivos a serem Alcançados:

- Transformar a experiência de compra, tornando-a intuitiva, eficiente e segura através da criação de uma plataforma autônoma que conecta clientes e fornecedores.
- Simplificar o processo de solicitação de cotações e compras, oferecendo uma abordagem mais eficaz e ágil para empresas de diversos setores.
- Gerar impactos financeiros positivos para as empresas, através da automação e simplificação dos processos, resultando em economias operacionais consideráveis, redução da necessidade de mão de obra e agilização do ciclo de compras.

### Tecnologias utilizadas:

![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Azure](https://img.shields.io/badge/azure-%230072C6.svg?style=for-the-badge&logo=microsoftazure&logoColor=white)
### Documentação(Em breve):
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
### Versionamento:
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
### Ferramentas de desenvolvimento:
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

## Diagrama atualizado:
![Diagrama](https://github.com/AdurraIS/SpringAPI_LevelGroupChallenge/assets/119917719/8ed2c8a1-c750-4ba0-ad9f-332e4ee471cb)

## Principais funcionalidades:
- Cadastro de Empresas
- Cadastro de Usuarios
- Criação de Pedido
- Gerenciamento de Produtos
- Gerenciamento de Compras
- Gerenciamento de Pedidos
- Segurança utilizando JWT Tokens
- Criptografia de Senhas
## Endpoints(Em breve no Swagger):

- Cadastro de Usuario e Login
  - /auth/login (POST) (LIVRE)
  - /auth/register (POST) (LIVRE)
- Criação
  - /api/v1/produtos (POST) (ADMIN) (TOKEN)
  - /api/v1/empresas (POST) (LIVRE)
  - /api/v1/pedidos (POST) (USER) (TOKEN)
  - /api/v1/compras (POST) (USER) (TOKEN)
- Atualizar
  - /api/v1/empresas (PUT) (USER) (TOKEN)
  - /api/v1/usuarios (PUT) (USER) (TOKEN)
  - /api/v1/produtos (PUT) (USER) (TOKEN)
  - /api/v1/pedidos (PUT) (USER) (TOKEN)
  - /api/v1/compras (PUT) (USER) (TOKEN)
- Apagar
  - /api/v1/produtos (DELETE) (USER) (TOKEN)
  - /api/v1/usuario (DELETE) (USER) (TOKEN)
  - /api/v1/empresa (DELETE) (USER) (TOKEN)
  - /api/v1/pedidos (DELETE) (USER) (TOKEN)
  - /api/v1/compras (DELETE) (USER) (TOKEN)
- Get Id
  - /api/v1/produtos/id (GET) (USER) (TOKEN)
  - /api/v1/usuario/id (GET) (USER) (TOKEN)
  - /api/v1/empresa/id (GET) (USER) (TOKEN)
  - /api/v1/pedidos/id (GET) (USER) (TOKEN)
  - /api/v1/compras/id (GET) (USER) (TOKEN)
- Get Paginable
  - /api/v1/empresas?page=0&size=10 (GET) (USER) (TOKEN)
  - /api/v1/pedidos?page=0&size=10 (GET) (USER) (TOKEN)
  - /api/v1/produtos?page=0&size=10 (GET) (USER) (TOKEN)
- Get All
  - /api/v1/categorias (GET) (USER) (TOKEN)
  - /api/v1/tipoprodutos (GET) (USER) (TOKEN)

## Pontos a melhorar:
  - Segurança e acesso a endpoints:
    - Exemplo: Atualmente um usuario de uma empresa "x" pode mudar o nome da empresa "y".
  - Adicionar métodos de pesquisa:
    - Exemplo: Pesquisar produto por nome.
  - Adicionar validações:
    - Exemplo: Validação de cnpj e validação de email.
## Dificuldades e aprendizados:
  Além de eu ter refatorado em 8 dias a aplicação inteira, eu ainda quis me desafiar a aprender Spring Security para fazer a autenticação. No começo eu achei muito massante e conforme eu fui fazendo e entendendo, percebi que fazer o simples não é díficil, porém, é um tema muito complexo e profundo e ainda tenho muito a aprender.
