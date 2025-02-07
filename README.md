# Encurtador de Links

## Descrição
Este é um sistema de encurtador de links que permite aos usuários:

- **Usuários não logados:** Gerar links encurtados sem personalização.
- **Usuários logados:** Criar links personalizados, visualizar estatísticas de acessos e gerenciar seus links (editar e excluir).

## Tecnologias Utilizadas
- **Java** (Back-end)
- **SQL** (Banco de Dados)
- **CSS** (Estilização)
- **Command** (Execução de comandos)
- **DAO** (Data Access Object para interação com o banco de dados)

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

## Estrutura do Projeto
```
/link-shortener
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

## Configuração
1. **Banco de Dados:**
   - Criar as tabelas necessárias utilizando os scripts SQL disponíveis na pasta `/database`.

2. **Execução:**
   - Compilar o projeto Java.
   - Configurar o servidor web.
   - Acessar a aplicação via navegador.

## Contribuição
Caso queira contribuir, sinta-se à vontade para abrir um pull request ou relatar problemas na aba de issues.

## Licença
  - Guilherme Zappalenti Fragiacomo
  - Luiz Francisco Rodrigues Junior

