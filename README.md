# TrabalhoFinalTQS

trabalho final utilizando selenium em java para testar o site www.americanas.com.

Versão do ChromeDriver: 107.0.5304.62 utilizada nos testes.
Versão do Google Chrome: 108.0.5359.71 (Versão oficial) 64 bits

dois casos criados:
1) testar produto que não existe;
2) testar cidades próximas de mim (Porto Alegre), validar quantas cidades próximas (20) e após buscar cidade "Marte", validando quantas cidades próximas (1);

validações através de AssertEquals conferindo os resultados esperados.

para rodar os testes:
Baixar na pasta C:// o chromedriver compatível;
abrir pasta "src/test/java";
Run na classe CadastroTest;
