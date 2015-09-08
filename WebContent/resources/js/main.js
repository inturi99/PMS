jQuery(document).ready(function() {
	//$("#showsteps,.tloginform").hide();
	//$("#button-start").click(function(){
	//	$("#overview").hide();
	//	$("#showsteps").fadeIn(1000).delay(1000);
	//	$('html,body').animate({'scrollTop' : 300},1000);
	//	return false;
	//});
	$("#button-close").click(function(){
		window.location.reload(true);
		$("#overview").show();
		$("#showsteps").hide();
		return false;
	});
	$(".ic-menu").click(function(){
		$('.ic-menu').toggleClass("opacity");
		$(".tloginform").toggle();
		return false;
	});
});