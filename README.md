# Gestão de escalas 
Esse é um projeto pessoal que surgiu a partir da observação de um problema dentro da empreso que eu trabalho atualmente. Junto com o problema, eu idealizei uma solução, e estou estudando e trabalhando em uma aplicação para aplicar meus conhecimentos e estudos em Java com Spring Boot e resolver um problema real.

## Sobre o projeto
O objetivo desse projeto, é criar uma aplicação para auxiliar empresas no gerenciamento de funcionários que trabalham na escala 12X36.

#### Descrição do problema
Eu atualmente trabalho como vigilante noturno em um condomínio por uma empresa tercerizada. No plantão diurno(7:00 - 19:00) ficam 2 funcionários, sendo um vigilante e um porteiro, e no plantão noturno(19:00 - 7:00) ficam 3 funcionários, sendo 1 vigilante, 1 porteiro e outro vigilante que fica na função de fazer as rondas noturnas. 

É obrigatório ter 2 funcionarios de dia e 3 de noite nesse condomínio, e quem já trabalhou na escala 12X36 sabe que os funcionários só podem ir embora do trabalho depois de uma rendição pelo outro funcionário que vai assumir aquele posto, se o funcionário for embora sem ser rendido, é dado como abandono de posto e o funcionário acaba sendo prejudicado. E as vezes o funcionário que faltou não teve tempo de avisar previamente uma falta, por ser tratar de uma emergência.

E nem sempre esses imprevistos podem ser avisados com tempo para a empresa achar outro funcionário para assumir esse posto, e aquele funcionário que já trabalhou 12 horas seguidas no seu plantão tem que esperar horas a mais até a empresa achar outro funcionário para assumir o posto, e muitas das vezes a empresa acaba não achando e pede para o funcionário que já trabalhou 12 virar mais 12 horas trabalhando. 

A falta de um funcionário nessa escala pode causar uma terrivel dor de cabeça para a empresa, que tem que contatar outros funcionários até achar um que possa arrumir aquele respectivo posto, diante disso esse funcionário está sendo designado para assumir aquele posto tem que se virar nos 30 para conseguir chegar até o local para render o mais breve possível o outro trabalhador que já virou 12 horas e está apressado para ir embora. E muitas vezes ainda demora horas para chegar até o local, dando um exemplo da minha empresa, eles tem vários condominios localizados nos mais diversos locais aqui na cidade de São Paulo, e dependendo do horário e do local e do trájeto que o funcionário vai percorrer, pode demorar de 3 a 4 horas para ele chegar até o local.


## Minha solução
Diante das observações desses cenários, eu estou trabalhando em uma aplicação para o gerenciamento dos funcionários de uma empresa. Onde os superiores e gerentes de escalas podem monitorar em tempo real e imediato os locais de trabalho e seus funcionarios ali presentes. O sistema também irá armazenar informações dos locais de trabalho, e de todos os funcionários que trabalham na empresa, informações como local onde cada funcionário mora, qual o horário do plantão aquele funcionário trabalha, quais os dias da folga que aquele funcionário tem.

Quando um funcionário faltar, ou avisar previamente sua ausência, o sistema criará alertas para os gerentes, e recomendará para eles os melhores funcionários para assumir aquele posto, baseado na folga de cada funcionário. O sistema também recomendará os funcionários que moram mais perto daquele local, para que o tempo daquele posto ser assumido por ele seja mais curto. 

Também terá um aplicativo para os funcionários, para que eles marquem em um calendário os dias em que eles iram faltar previamente, e esses o responsável pelas escalas seja avisado e possa achar e designar outros funcionários para assumir o posto. Nesse aplicativo, esse mesmo calendário irá mostrar para os funcionários os dias em que eles trabalham e folgam, assim se o funcionário precisar de banco de horas ou queiram fazer horas extras para aumentar a sua renda, há a possibilidade de se candidatar para trabalhar nos dias de folga e nos locais que necessitam de outra pessoa para assumir aquele plantão, e assim os superiores não precisariam se preocupar em contatar vários funcionários até achar outro, os proprios funcionários podem se contatar entre si para isso. 

Assim os responsáveis pelas escalas e funcionários teriam um maior gerenciamento e noção de vários locais de trabalho ao mesmo tempo, e de forma imediata, e isso seria de grande ajuda e grande impacto para a empresa e também para os funcionários.



### Outras idéias e implementaçãos
Essas são algumas idéias que eu penso em implementar conforme eu for estudando para tornar cada vez mais a aplicação robusta, completa e atualizada:

• **API do MAPS e IA**

Mapa de distância para que o sistema  ter noção da localização da moradia dos funcionários, e locais de trabalho, e a IA para analisar quem está de folga para e mora mais perto para assumir aquele posto.

• **Histórico de coberturas**

• **Sistema de pontuações/recomendações(folgas/bonus)**
• **Filtro de disponibilidade personalizada**

• **Chat para os superiores e funcionários**

Para os funcionários poderem conversar entre si, para uma possivel troca de dias, assumir aquele posto no dia previamente avisado, ou até outro funcionários podem designar outra pessoa para assumir seu plantão negociando diretamente com o funcionário que se candidatou para trabalhar no dia dele.

• **Controle de escalas fixas e trocas planejadas**









Esse é meu primeiro REAME, conforme eu for me estudando eu vou corrigindo erros e atualizando ele para vocês!

• **Painel administrativo**





