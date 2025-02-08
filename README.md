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
2. Execute os scripts SQL disponíveis na pasta `/database` para criar as tabelas necessárias.

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

1. **Página Inicial**
   ![Tela Inicial](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/home_page.png?raw=true)
   - A tela inicial possui uma entrada de texto para a criação do link encurtado sem vínculo com usuário,
   além de uma barra de navegação entre a tela inicial, tela de login e de cadastro.

   ---
   
2. **Tela de Login**
   ![Tela de Login](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/login_page.png?raw=true)
   - A tela de login possui duas entradas de texto para nome e senha respectivamente
   ![Falha no Login](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/login_not_found.png?raw=true)
   - Caso o usuário insira informações de um usuário que não existe no banco de dados, ou no caso de um erro inesperado do sistema,
   o mesmo irá devolver uma mensagem de erro ao usuário o informando sobre o ocorrido.
   ![Login Sucedido](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/logged_home.png?raw=true)
   - Caso o contrário, o usuário insira as informações corretamente, ele será redirecionado para a tela principal de seu usuário,
   onde voltar para a tela principal, sair de seu usuário atual ou gerenciar seus links ativos.

   ---
   
3. **Tela de Cadastro**
   ![Tela de Cadastro](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/sign.png?raw=true)
   - A tela de cadastro possui 2 entradas de texto, nome e senha respectivamente, que o usuário utilizará na aplicação.
   ![Falha ao Cadastrar](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/sign_error.png?raw=true)
   - Caso o usuário insira o nome de um usuário existe, ou no caso de um erro inesperado ocorrer, o sistema irá devolver
   uma mensagem na tela principal informando o usuário do ocorrido.
   ![Cadastro Sucedido](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/sign_success.png?raw=true)
   - Caso o contrário, o cadastro do usuário seja feito sem nenhum problema, uma mensagem de sucesso o será entregue pela
   tela principal da aplicação.

   ---
   
4. **Encurtamento de Links**
   ![Encurtamento de links sem usuário](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/short.png?raw=true)
   - O usuário pode preferir criar links curtos sem vínculo com uma conta própria para o sistema, nesse caso a aplicação irá gerar
   um link curto automaticamente, o link terá um tamanho mínimo de 5 caractéres, mas poderá se estender até 12 caractéres.
   ![Encurtamento de links sem usuário sucedido](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/short_created.png?raw=true)
   - Caso o link curto do usuário seja criado sem nenhum problema, o mesmo será apresentado na tela principal da aplicação pronto para
   ser utilizado.
   

   ![Encurtamento de links com usuário](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/fill_logged_short.png?raw=true)
   - O usuário com uma conta ativa na aplicação poderá gerar links curtos personalizados, podendo escolher códigos de 5 à 12 caractéres,
   além de poder verificar a quantidade de acessos e o localização de cada um que trafegou pelo seu link.
   ![Encurtamento de links com usuário sucedido](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/custom_short_generated.png?raw=true)
   - Caso o link curto personalizado do usuário seja criado sem nenhum problema, o mesmo será apresentado na tela principal da aplicação pronto
   para ser utilizado e observado.

   ---
   
5. **Gerenciamento de Links**
   ![Gerenciamento de Links](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/table_link.png?raw=true)
   - Um usuário logado poderá acessar a aba "Tabela de Links" que apresentará todos os links que o usuário criou e
   quantos acessos, de maneira geral, cada um obteve até o momento, sendo disponibilizado 3 funcionalidades para cada um:
   "Analisar seus acessos", "Alterar o link" e "Deletar o link"

   ![Verificar Acessos](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/check_access.png?raw=true)
   Ao clicar em "Verificar Acessos" o usuário será apresentado com uma tabela contendo a quantidade que cada ip trafegou por
   aquele link em específico.
   ![Alterar Link Encurtado](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/update_link.png?raw=true)
   Ao clicar em "Alterar Link" o usuário poderá alterar o link original e até mesmo o identificador do link curto,
   caso o usuário escolha deixar o identificar em branco, o identificador permanecerá o mesmo de antes.
   ![Deletar Link Encurtado](https://github.com/Luiz-frj/EncurtadorDeLinks/blob/main/assets/screenshots/deleted.png?raw=true)
   Ao clicar em "Deletar Link" o usuário será redirecionado para a página principal onde receberá uma mensagem
   informando se ocorreu um erro ou se a operação foi bem sucedida.

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

