   
    $(function() {

    /*
        Background slideshow
    */
    $.backstretch([
      "1.jpg"
    , "2.jpg"
    , "3.jpg"
   ], {duration: 3000, fade: 750});

    
     //   Tooltips
    
    $('.links a.home').tooltip();
    $('.links a.Login').tooltip();
    $('.links a.Services').tooltip();
    
     // Colors
     
     
        
        
    /*
        Form validation
    */
    $('.register').submit(function(){
      //  $(this).find("label[for='firstname']").html('First Name');
      //  $(this).find("label[for='lastname']").html('Last Name');
      //  $(this).find("label[for='username']").html('Username');
          $(this).find("label[for='email']").html('Email');
          $(this).find("label[for='password']").html('Password');
        ////
      //  var firstname = $(this).find('input#firstname').val();
      //  var lastname = $(this).find('input#lastname').val();
      //  var username = $(this).find('input#username').val();
        var email = $(this).find('input#email').val();
        var password = $(this).find('input#password').val();
       // $.msgbox(email);
      /*  if(firstname == '') {
            $(this).find("label[for='firstname']").append("<span style='display:none' class='red'> - Please enter your first name.</span>");
            $(this).find("label[for='firstname'] span").fadeIn('medium');
            return false;
        }
        if(lastname == '') {
            $(this).find("label[for='lastname']").append("<span style='display:none' class='red'> - Please enter your last name.</span>");
            $(this).find("label[for='lastname'] span").fadeIn('medium');
            return false;
        }
        if(username == '') {
            $(this).find("label[for='username']").append("<span style='display:none' class='red'> - Please enter a valid username.</span>");
            $(this).find("label[for='username'] span").fadeIn('medium');
            return false;
        }*/
        if(email == '') {
            $(this).find("label[for='email']").append("<span style='display:none' class='red'> - Please enter a valid email.</span>");
            $(this).find("label[for='email'] span").fadeIn('medium');
            return false;
        }
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - Please enter a valid password.</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }
        /*
        $.ajax({
				type: "POST",
				url: "https://api.idolondemand.com/1/api/sync/adduser/v1?store=myparkinglot&email=ss1%40gmail.com&password=ssn&apikey=fa64dd8c-6193-47fd-a4ba-052939805fa4",
				dataType: "json",
				success: alert("succ")
                                        /*function(jsondata) {
				printc1(jsosdata);	*/
                                
				//} */
			});
        
       
        
		});

        
        
        
   /*
    $(function() {
    	$("#register1").click(function() {
		$.ajax({
				type: "GET",
				url: "https://api.idolondemand.com/1/api/sync/adduser/v1?store=myparkinglot&email="+email+"&password="+password+"&apikey=fa64dd8c-6193-47fd-a4ba-052939805fa4",
				dataType: "json",
				success: function(jsondata) {
				printc1(jsondata);	
				}
			});
		});


}); 

function printc1(jsondata) {
	//console.log(jsondata.text_block[0].text);
	// $("#c1").append(jsondata.text_block[0].text);
        alert("success");
         //out.println(jsondata);
        var text="registered";
	$("#reg").append(text);
      //  $("#reg").append(jsondata.text_block[0].text);
}

});*/

