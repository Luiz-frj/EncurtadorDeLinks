![short](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/encurtaLink.png?raw=true)# Encurtador de Links

## Descrição
Este é um sistema de encurtador de links que permite aos usuários:

- **Usuários não logados:** Gerar links encurtados sem personalização.
- **Usuários logados:** Criar links personalizados, visualizar estatísticas de acessos e gerenciar seus links (editar e excluir).

---

## Tecnologias Utilizadas
- **Java** (Back-end)
- **SQL** (Banco de Dados)
- **CSS** (Estilização)
- **Command** (Execução de comandos)
- **DAO** (Data Access Object para interação com o banco de dados)

---

## Funcionalidades
1. **Encurtamento de Links:**
   - Usuários não logados podem gerar links curtos automaticamente.
   - Usuários logados podem personalizar o link encurtado.

2. **Autenticação e Cadastro:**
   - O sistema permite cadastro e login para acesso a funcionalidades extras.
   
3. **Gerenciamento de Links:**
   - Usuários autenticados podem visualizar uma tabela com seus links criados e estatísticas de acessos.
   - Possibilidade de editar ou excluir um link criado.

4. **Filtro de Acesso:**
   - O sistema verifica se o usuário está logado para liberar funcionalidades extras.

---

## Estrutura do Projeto
```
/EncurtadorDeLinks
│── /src
│   ├── /model      # Modelos de dados
│   |    ├── /dao        # Camada de acesso a dados (DAO)
│   |    ├── /entity        # Localização das Entidades (Objetos)
│   ├── /controller # Controladores do sistema
│   |    ├── /command        # Localização dos Commands
├── /view       # Interface do usuário
│── /database       # Scripts SQL para o banco de dados
│── /assets         # Arquivos CSS e mídias
│── README.md       # Documentação do projeto
```

---

## Configuração do Ambiente
### Banco de Dados
O Tomcat está configurado para conectar a um banco de dados MySQL com as seguintes credenciais:
- **Usuário:** root
- **Senha:** (sem senha)
- **Porta:** 3306

Para configurar o banco de dados:
1. Instale o MySQL em sua máquina.
2. Execute os scripts SQL disponíveis na pasta `/scripts_sql` para criar as tabelas necessárias.

### Executando o Projeto
O servidor Tomcat está configurado para rodar na porta **8888**. Para iniciar o projeto:
1. Compile o código Java.
2. Configure o Tomcat na porta 8888.
3. Inicie o servidor Tomcat.
4. Acesse a aplicação via navegador no link: `http://localhost:8888/encurtador_link_2/index.jsp`

---

## Acesso Remoto
Você pode acessar a aplicação sem precisar configurá-la em seu computador pelo link:
[http://guizf.ddns.net:8888/encurtador_link_2/index.jsp](http://guizf.ddns.net:8888/encurtador_link_2/index.jsp)

### Aviso Importante:
- Este link pode não estar funcionando em determinados momentos, pois o servidor pode estar desligado.
- O domínio gratuito utilizado pode apresentar instabilidades e nem sempre funcionar corretamente.
- O link foi configurado dessa forma para evitar a exposição do meu IP público por questões de segurança.

---

## Capturas de Tela
Abaixo estão algumas capturas de tela das principais funcionalidades do sistema:

### 1. **Página Inicial**  
![Tela Inicial](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/home_page.png?raw=true)  
A página inicial oferece uma entrada de texto para criar links encurtados sem a necessidade de um usuário logado. Além disso, possui uma barra de navegação para acessar as telas de login e cadastro.

---

### 2. **Tela de Login**  
![Tela de Login](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/login_page.png?raw=true)  
Nesta tela, o usuário pode inserir seu nome e senha para acessar o sistema.  

- **Falha no Login**  
  ![Falha no Login](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/login_not_found.png?raw=true)  
  Caso as informações inseridas estejam incorretas ou o usuário não exista no banco de dados, uma mensagem de erro será exibida.  

- **Login Bem-Sucedido**  
  ![Login Sucedido](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/logged_home.png?raw=true)  
  Se o login for bem-sucedido, o usuário será redirecionado para sua página principal, onde poderá voltar à tela inicial, gerenciar seus links ou encerrar a sessão.  

---

### 3. **Tela de Cadastro**  
![Tela de Cadastro](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/sign.png?raw=true)  
Permite que novos usuários criem uma conta com nome e senha.  

- **Falha ao Cadastrar**  
  ![Falha ao Cadastrar](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/sign_error.png?raw=true)  
  Caso o nome de usuário já exista ou ocorra um erro inesperado, uma mensagem será exibida informando o problema.  

- **Cadastro Bem-Sucedido**  
  ![Cadastro Sucedido](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/sign_success.png?raw=true)  
  Após um cadastro bem-sucedido, uma mensagem de confirmação será exibida.  

---

### 4. **Encurtamento de Links**  
#### Sem Usuário  
![Encurtamento de links sem usuário](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/short.png?raw=true)  
Usuários não registrados podem criar links curtos automaticamente. Os links têm entre 5 e 12 caracteres.  

- **Link Criado com Sucesso**  
  ![Encurtamento de links sem usuário sucedido](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/short_created.png?raw=true)  
  Caso o link seja gerado corretamente, ele será exibido na tela para uso.  

#### Com Usuário  
![Encurtamento de links com usuário](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/fill_logged_short.png?raw=true)  
Usuários logados podem criar links personalizados com códigos de 5 a 12 caracteres e monitorar acessos ao link, incluindo localização e quantidade de cliques.  

- **Link Personalizado Criado com Sucesso**  
  ![Encurtamento de links com usuário sucedido](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/custom_short_generated.png?raw=true)  
  Links personalizados criados sem problemas serão exibidos para uso e acompanhamento.  

---

### 5. **Gerenciamento de Links**  
![Gerenciamento de Links](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/table_link.png?raw=true)  
Usuários logados têm acesso à aba "Tabela de Links", que lista todos os links criados, o número total de acessos e permite realizar três ações: **verificar acessos**, **alterar** ou **deletar** links.

- **Verificar Acessos**  
  ![Verificar Acessos](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/check_access.png?raw=true)  
  Mostra uma tabela com os IPs que acessaram o link e a quantidade de acessos por IP.  

- **Alterar Link**  
  ![Alterar Link Encurtado](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/update_link.png?raw=true)  
  Permite modificar o link original ou o identificador do link curto. Caso o identificador seja deixado em branco, ele permanecerá inalterado.  

- **Deletar Link**  
  ![Deletar Link Encurtado](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/deleted.png?raw=true)  
  Após deletar um link, o sistema redireciona o usuário para a tela principal com uma mensagem indicando sucesso ou erro na operação.  

---

## Diagramas do Sistema
### Diagrama de Classe
![Diagrama de Classe](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/diagrams/ClassDiagram.png?raw=true)

### 1. **Model (Camada de Modelo)**
- Representa as entidades principais do sistema.
- Classes:
  - **User**: Modelo para representar um usuário. Possui atributos como nome, senha e outros dados relacionados.
  - **Classname**: Parece ser uma entidade genérica, talvez usada para categorizar ou organizar outras informações.
  - **Access**: Modelo para registrar acessos, possivelmente relacionados aos links encurtados, com atributos como IP ou timestamp.

---

### 2. **DAO (Data Access Object)**
- Responsável pela interação com o banco de dados.
- **DatabaseConnection**:
  - Classe que gerencia a conexão com o banco de dados. Pode ser uma implementação singleton para reuso eficiente da conexão.
  
- **AcessDaoImpl**, **LinkDaoImpl**, **UserDaoImpl**:
  - Implementações das interfaces DAO correspondentes.
  - Métodos:
    - `insert()`: Insere novos registros no banco.
    - `update()`: Atualiza registros existentes (apenas no `LinkDaoImpl`).
    - `delete()`: Exclui registros.
    - Métodos de busca (`get_by_user_name`, `get_by_short`, `getByName`): Obtêm registros filtrados por atributos específicos.
  
- **Factories (AcessDaoFactory, LinkDaoFactory, UserDaoFactory)**:
  - Fábricas que encapsulam a lógica de criação dos objetos DAO.
  - Método `factory()`: Retorna a instância da interface DAO correspondente.

---

### 3. **Controller (Camada de Controle)**
- Contém lógica de controle e processamento de comandos.
- **Command Interface**:
  - Interface comum para todos os comandos, com o método `execute()`.
  
- **Commands (Diversos)**:
  - Implementações específicas da interface `Command`.
  - Exemplo:
    - **FormLoginUserCommand**: Processa o formulário de login do usuário.
    - **LinkTableCommand**: Gerencia a exibição da tabela de links.
    - **LogoffCommand**: Lida com o encerramento da sessão.
  
- **FrontServlet_**:
  - Principal servlet responsável por receber e direcionar as requisições.
  - Métodos:
    - `doGet()`, `doPost()`: Lidam com requisições HTTP GET e POST.
    - `processRequest()`: Processa e delega as requisições aos comandos apropriados.

- **Servlets Secundários**:
  - **LoggedServlet**: Gerencia funcionalidades que exigem autenticação.
  - **ShortLinkServlet**: Lida com a funcionalidade de encurtar links.
    - Método `urlExist()`: Verifica se o URL já existe no banco.

- **AuthenticationFilter**:
  - Implementa um filtro para autenticação, garantindo que apenas usuários autorizados acessem certas áreas do sistema.

---

### Fluxo Geral do Sistema:
1. **Requisição do Usuário**:
   - Usuário faz uma solicitação (por exemplo, encurtar um link ou visualizar links).
   
2. **Processamento no FrontServlet_**:
   - O servlet principal recebe a requisição e delega a um comando apropriado com base no tipo de ação.

3. **Execução do Comando**:
   - O comando realiza a lógica específica, podendo interagir com os DAOs para acessar ou manipular dados no banco.

4. **Retorno ao Usuário**:
   - O resultado da operação é enviado de volta ao usuário, geralmente através de uma página JSP.

---

### Diagrama de Entidade-Relacionamento
![Diagrama de ER](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/diagrams/diagrama_entidade_relacionamento_encurtador_de_link.drawio.png?raw=true)

### Entidades:
1. **User**:
   - Representa os usuários do sistema.
   - Atributos:
     - `name`: Nome do usuário.
     - `password`: Senha do usuário.
   - Um usuário pode criar links, mas não é obrigatório (cardinalidade `0,1`).

2. **Link**:
   - Representa os links encurtados no sistema.
   - Atributos:
     - `link`: URL original.
     - `user_name`: Nome do usuário que criou o link (relacionado ao User).
     - `short_link`: URL encurtada.
   - Um link pode ser gerado por um usuário ou ser criado automaticamente.

3. **Access**:
   - Representa os acessos feitos a um link encurtado.
   - Atributos:
     - `link`: URL encurtada que foi acessada.
     - `ip`: Endereço IP de quem acessou o link.

---

### Relacionamentos:
1. **Cria**:
   - Relaciona o usuário (`User`) com os links (`Link`).
   - Cardinalidade: 
     - Um usuário pode criar nenhum ou vários links (`0,n`).
     - Um link pertence a, no máximo, um usuário (`0,1`).

2. **Gera**:
   - Relaciona os links (`Link`) com os acessos (`Access`).
   - Cardinalidade:
     - Um link pode gerar nenhum ou vários acessos (`0,n`).
     - Cada acesso está relacionado a um único link (`1,1`).

---

## Contribuição
Caso queira contribuir, sinta-se à vontade para abrir um pull request ou relatar problemas na aba de issues.

---

## Licença
- Guilherme Zappalenti Fragiacomo
- Luiz Francisco Rodrigues Junior

