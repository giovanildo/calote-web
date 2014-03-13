$(document).ready(function() {
	 $("#labelDevendo").maskMoney();
	 jQuery.validator.setDefaults({
		  debug: true,
		  success: "valid"
		});
	 $("#formAdicionaCaloteiro").validate({
		  rules: {
			 nome: {
				 required: true,
				 maxlength: 45
		    },
		    email: {
		    	required: true,
		    	email:true
		    }
		  },
		  messages:{
			  nome: {
				  required: "Esse campo é obrigatório!",
				  maxlength: "O campo nome não pode ter mais que 45 caracteres"
			  },
			  email:{
				  required: "Esse campo é obrigatório!",
				  email: "Este não é um email válido!"
			  }
		  }
	 });
});