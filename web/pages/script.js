var default_content="";

$(document).ready(function(){

	checkURL();

	$('.link').click(function (a){
			checkURL(this.hash);
	});

	//filling in the default content
	default_content = $('#main').html();

	
	

});

var lasturl="";

function checkURL(hash)
{
	if(!hash) hash=window.location.hash;

	if(hash != lasturl)
	{
		lasturl=hash;
		// FIX - if we've used the history buttons to return to the homepage,
		// fill the pageContent with the default_content
		if(hash=="")
		$('#main').html(default_content);

		else{
		   loadPage(hash);
		}
	}
}

function loadPage(url)
{
	url=url.replace('#','');

	$('#loading').css('visibility','visible');

	$.ajax({
		type: "POST",
		url: "singlepage.php",
		data: 'page='+url,
		dataType: "html",
		success: function(msg){

			if(parseInt(msg)!=0)
			{
				$('#main').html(msg);
				$('#loading').css('visibility','hidden');
			}
		}

	});

}