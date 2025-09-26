Projeto Integrador - Etapa 2
Sistema de Biblioteca - Projeto de Usabilidade e Interfaces

Conteúdo:
- Wireframes (imagens PNG)
- Paleta de cores (paleta.png)
- Documento de UI/UX (UI_UX_Notes.txt)
- Sugestão: arquivo .fig (export do Figma) não incluso; use Figma com as imagens como referência.

Resumo do projeto de usabilidade e UI
------------------------------------
Objetivo: desenhar telas desktop simples e acessíveis para o Sistema de Biblioteca, facilitando
o cadastro de livros, usuários e controle de empréstimos.

Wireframes
----------
Inclui 3 wireframes em PNG (Desktop):
1) Tela principal / Dashboard - lista de livros e ações (cadastrar, buscar, emprestar)
2) Tela de cadastro de livro - formulário simples
3) Tela de cadastro de usuário / gerenciamento de empréstimos

Esquema de cores (paleta)
-------------------------
- Primária: Azul (#1E88E5) - usado para elementos principais, botões e cabeçalho.
- Secundária: Cinza escuro (#37474F) - textos e ícones.
- Suporte: Verde (#43A047) - confirmações/sucesso.
- Alerta: Laranja (#FB8C00) - avisos e atenção.
- Fundo: Branco (#FFFFFF) e Cinza claro (#F5F5F5) para áreas de conteúdo.

Tipografia
---------
- Família sugerida: Roboto ou system UI.
- Tamanhos: Título 20-24pt; Subtítulo 14-16pt; Texto 12-14pt; Botões 14pt.
- Espaçamento: padding interno mínimo 12px; margens 16px entre grupos.

Acessibilidade
--------------
- Contraste de cores: assegurar relação de contraste >= 4.5:1 para textos normais.
- Navegabilidade por teclado: todos os elementos interativos acessíveis via Tab; destaque visível (outline).
- Labels explícitas em formulários e placeholders descritivos.
- Mensagens de erro e sucesso com ícones e texto; não confiar apenas em cor.
- Tamanho de fonte ajustável e modo alto contraste como opção futura.
- Uso de aria-labels/descrições em futura versão web; para desktop Swing/JavaFX, usar tooltips e acessibilidade da plataforma.

Wireframes e interações
-----------------------
- Foco na simplicidade: ações principais (Cadastrar Livro, Cadastrar Usuário, Registrar Empréstimo) visíveis no topo/side.
- Tabela/lista de livros com filtro por título/autor e indicador de disponibilidade.
- Modal ou tela dedicada para cadastro com validação imediata dos campos obrigatórios.
- Histórico de empréstimos por usuário em tela separada.

Observações
-----------
- Recomenda-se criar um arquivo de design no Figma e exportar assets (ícones, imagens) para uso no desenvolvimento.
- Forneci wireframes estáticos em PNG como protótipo de baixa fidelidade.
