<%@ include file="/includes.jsp"%>
<html>
<head>
<title>Adiciona caloteiro</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<form action="sistema" method="post" id="formAdicionaCaloteiro">
		<input type="hidden" name="logica" value="AdicionaCaloteiro" />
		<triadTag:campoTexto campoName="nome" label="Nome:" id="labelNome" /> <br>
		<triadTag:campoTexto campoName="email" label="Email:" id="labelEmail" /><br>
		<triadTag:campoTexto campoName="devendo" label="Devendo:"
			id="labelDevendo" /><br>
		<triadTag:campoTexto campoName="dataDivida" label="Data da Dívida:"
			id="labelData" /><br>

		<input type="submit" value="Salvar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/jquery.maskMoney.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/mascara-validacoes.js"></script>
</html>