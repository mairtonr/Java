# Documentação dp projeto.
## 1. Autenticação de Usuários
Antes de tudo, você como usuário, precisa se autenticar no sistema. O sistema possui três tipos de usuários, cada um com permissões específicas:
##### Administrador: Pode fazer tudo (gerenciar estoque, registrar vendas e gerar relatórios).
##### Gerente: Pode gerenciar estoque e registrar vendas.
##### Vendedor: Pode apenas registrar vendas.

Como se autenticar:
O sistema já vem com alguns usuários cadastrados:

Admin: 
Login: admin, Senha: admin123

Gerente:
Login: gerente, Senha: gerente123

Vendedor: 
Login: vendedor, Senha: vendedor123

Ao iniciar o sistema, ele tentará autenticar o usuário com as credenciais acima. Se as credenciais estiverem corretas, você verá a mensagem:

Usuário autenticado: "USUARIO LOGADO POR VOCÊ"
Se as credenciais estiverem incorretas, você verá:

Falha na autenticação. Verifique o login e senha.

## 2. Gerenciamento de Estoque
### 2.1 Adicionar Produtos ao Estoque

Após a autenticação, o sistema adicionará automaticamente dois produtos ao estoque:

##### Notebook: Preço: R$ 3500,00, Quantidade: 10
##### Mouse: Preço: R$ 120,00, Quantidade: 50

Se o usuário autenticado não tiver permissão para gerenciar o estoque, você verá a mensagem:
Acesso negado: Você não tem permissão para gerenciar o estoque.

### 2.2 Verificar Estoque

O sistema gera automaticamente um relatório de estoque após adicionar os produtos. O relatório mostra:

-Nome do produto
-Quantidade em estoque
-Preço
-Estoque mínimo
Exemplo de saída:

---- Relatório de Estoque ----
Produto 1
 Nome: Notebook
 Descrição: Notebook Dell
 Quantidade: 10
 Preço: 3500.0
 Estoque: 5
## 3. Registro de Vendas
### 3.1 Criar um Pedido

O sistema cria automaticamente um pedido para o cliente "João Silva".

Dois produtos são adicionados ao pedido:
2 Notebooks
5 Mouses

Se os produtos estiverem disponíveis no estoque, o pedido será finalizado com sucesso, e você verá a mensagem:

Pedido finalizado com sucesso!
Se algum produto não estiver disponível, você verá:

Erro: Produto não encontrado.
Se o usuário autenticado não tiver permissão para registrar vendas, você verá:

Acesso negado: Você não tem permissão para registrar vendas.

## 4. Geração de Relatórios
### 4.1 Relatório de Vendas

Após finalizar o pedido, o sistema gera automaticamente um relatório de vendas, mostrando:
Detalhes do pedido (ID, cliente, itens e valor total).

Total de vendas.

Exemplo de saída:
---- Relatório de Vendas ----
Pedido ID: 1
Cliente: João Silva
Itens:
Notebook - Quantidade: 2 - Valor Unitário: R$ 3500.0
Mouse - Quantidade: 5 - Valor Unitário: R$ 120.0
Valor Total: R$ 7600.0
Total de Vendas: R$ 7600.0
4.2 Relatório de Estoque

O sistema também gera um relatório de estoque atualizado após as vendas.

Exemplo de saída:
---- Relatório de Estoque ----
Produto 1
 Nome: Notebook
 Descrição: Notebook Dell
 Quantidade: 8
 Preço: 3500.0
 Estoque: 5
## 5. Verificação de Estoque Mínimo

O sistema verifica automaticamente se algum produto está abaixo do estoque mínimo após as movimentações. Se um produto estiver abaixo do estoque mínimo, você verá uma mensagem de alerta:
ALERTA: Estoque mínimo atingido para o produto Notebook

