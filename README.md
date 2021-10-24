# programacao2
### Projeto de Programação 2
#### 2º período do curso de Ciência da Computação

Projeto desenvolvido em dupla para a cadeira de Programação 2.

Seguem as orientações do professor para o desenvolvimento do projeto:

.

Uma academia de Recife pretende desenvolver um sistema para fazer a  gestão da base de clientes.

Para isso, deve-se criar uma classe Sistema com os seguintes atributos e  métodos: 

#### Atributos da classe Sistema: 

- Vetor de clientes (tipo Cliente) com tamanho 15; 

#### Métodos da classe Sistema: 

 - Método para adicionar cliente; 

- Imprimir na tela a lista de clientes (matrícula, nome e atividade); 

- Imprimir na tela todos os dados de um cliente específico (recebe o número de matrícula para  realizar a busca); 

- Imprimir na tela a quantidade de clientes que estão em dia com o pagamento, bem como a  quantidade de clientes que estão devendo; 

- Imprimir na tela a lista de clientes devedores, ordenados da maior para a menor dívida; 

- Modificar os dados de um cliente específico (recebe o número de matrícula para realizar a  busca). 

Também deve-se criar uma classe conta com os seguintes atributos, todos privados (Obs: os métodos getters e setters devem ser públicos): 

#### Atributos da classe Cliente: 

- Número da matrícula (int); 

- Nome do cliente (String); 

- Devedor (Boolean); 

- Quantidade devida (double); Obs: Se devedor = False, quantidade devida = 0.

- Atividade (String). 

#### Métodos da classe Cliente: 
- Getters e setters. 

Obs: A tela principal do programa deve listar as opções correspondentes aos métodos da classe Sistema. Após escolher e executar uma dessas funcionalidades, o programa deve retornar a sua tela principal. 

