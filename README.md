# Gastos

# MBA Fullstack FIAP - Turma 1SCJR

+ RM346614 - Ebertt Costa dos Santos
+ RM346139 - Juliana Mota Carneiro
+ RM347401 - Pamela Lais Oliveira Macedo
+ RM346573 - Rafael Luiz Ross de Moura
+ RM346746 - Vitor Souza Alves 

### Tema
<p align="justify">
O tema da aplicação é gerenciamento de despesas e conversão de moedas. Através dessa aplicação, é possível registrar e acompanhar as despesas, tornando mais fácil o controle financeiro pessoal ou empresarial. Além disso, a aplicação também permite a conversão entre diferentes moedas, facilitando transações financeiras internacionais e permitindo que o usuário saiba exatamente quanto está gastando em sua moeda local.
</p>

### Tecnologias escolhidas
Linguagem: Java 1.8
Framework: Spring Boot versão 2.7.9
Banco de Dados: PostgreSQL

### Endereço do código-fonte 

https://github.com/plomacedo/fiap-gastos

### Página da documentação da API
![img.png](img.png)

### Instruções

<p align="justify">
Para o funcionamento a aplicação é necessária a criação de um arquivo chamado env.properties com as seguintes variáveis:
</p>

```
# Hostname ou IP do servidor de banco de dados
DB_SERVER = 
# Porta utilizada
DB_PORT = 
# Nome do banco de dados 
DB_NAME = 
# Nome do usuário
DB_USER = 
# Senha
DB_PASSWORD = 

# Google clientId
GOOGLE_CLIENT_ID =
# Google clientSecret 
GOOGLE_CLIENT_SECRET =
# Url da API 
EXCHANGE_API_URL = https://api.apilayer.com/exchangerates_data/convert?to=%s&from=%s&amount=%s
# Chave da API
EXCHANGE_API_KEY = 
```