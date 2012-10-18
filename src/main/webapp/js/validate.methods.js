$(function(){
// INICIO - adicionar m�todos no validate
	//adicionar m�todo de verifica��o de data
	jQuery.validator.addMethod("dateBR", function(value, element) {
		var v = value.split('/');
		return	/^\d{1,2}[\/]\d{1,2}[\/]\d{4}$/.test(value)
				&& v[0] > 0 && v[0] <= 31
				&& v[1] > 0 && v[1] <= 12 && !((v[1]==4 || v[1]==5 || v[1]==9 || v[1]==11) && v[0]==31) && !(v[0] > 29 && v[1]==2);
	}, "Data Inv�lida");
    
	//adicionar m�todo de verifica��o de campo: � requirido se outro � preenchido
	jQuery.validator.addMethod("requiredIf", function(value, element, param) {
       if(value == "" && $(param).val()!="")
            return false;
       return true;               
	});
	//adicionar m�todo de verifica��o de senha
	jQuery.validator.addMethod("senha", function(value, element) {
		var soma = 0;
	    for(i=0; i<=value.length-2; i++){
	        if(parseInt(value.charAt(i))+1 == parseInt(value.charAt(i+1))) soma++;
	    }
		
		var expReg = /^0+$|^1+$|^2+$|^3+$|^4+$|^5+$|^6+$|^7+$|^8+$|^9+$/;
		
	  	if(value.match(expReg) || soma == value.length-1) return false;
		return true;
		
	}, "N�o utilize repeti��es de algarismos ou sequ�ncias, como 0000000 e 123456");
	
	//adicionar m�todo de verifica��o de CPF
	jQuery.validator.addMethod("verificaCPF", function(value, element) {
		cpf = value;
		
		while(cpf.length < 11) cpf = "0"+ cpf;
		
		var expReg = /^0+$|^1+$|^2+$|^3+$|^4+$|^5+$|^6+$|^7+$|^8+$|^9+$/;
		
		var a = [];
		var b = new Number;
		var c = 11;
		for (i=0; i<11; i++){
			a[i] = cpf.charAt(i);
			if (i < 9) b += (a[i] * --c);
		}
		if ((x = b % 11) < 2) { a[9] = 0; } else { a[9] = 11-x; }
		b = 0;
		c = 11;
		for (y=0; y<10; y++) b += (a[y] * c--);
		if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }
		if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10]) || cpf.match(expReg)) return false;
		return true;
		
	}, "CPF inv�lido");
// FIM - adicionar m�todos no validate
	
})

