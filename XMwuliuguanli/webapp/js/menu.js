$(function(){
	$("[parentMenu]").each(function(){
		this.index = 0;
	});

	$("[parentMenu]").click(function(){
		var index = this.index++;
		if(index % 2 != 0)
			$(this).children("ul").slideUp("slow");
		else
			$(this).children("ul").slideDown("slow");
	});
})