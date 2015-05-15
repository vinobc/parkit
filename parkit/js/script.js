function printCars(jsondata) {
	var vac= 10;
	var count = 0;
	var text="";
	var p = document.createElement("strong");
	p.innerHTML = '<strong> CarNumber. &nbsp;&nbsp; Durn.(mins) &nbsp; Id </strong>' + "<br/>";
	
	$.each(jsondata, function(key, value) { 
		text += value.carno + "&nbsp;&nbsp;" + value.durn + "&nbsp;&nbsp;" +  value.id +  "<br>";
		count ++;
	});
	vac = vac - count;
	
	
	$("#cars").append(p);
	$("#cars").append(text);
	
	
	$("#cp").append(count);
	$("#vac").append(vac);
}

function printc1(jsondata) {
	//console.log(jsondata.text_block[0].text);
	 $("#c1").append(jsondata.text_block[0].text);
}


function printCarAvl(op) {
	//var text="append ur car number to the end of the url http://rpms.gids.cf.helion-dev.com/webapi/cars/ur-car/";
	//var status = showResponse(data);
	//$("#carAvl").append(text);
	//$("#carAvl").append(text);
	$("#carAvl").append(op);
}

function printCarFtrs(data) {
	//var text="append ur car number to the end of the url http://rpms.gids.cf.helion-dev.com/webapi/cars/ur-car-features/";
	//$("#carFtrs").append(text);
	
	$("#carFtrs").append(data.color);
	$("#carFtrs").append("<br />");
	$("#carFtrs").append(data.make);
}



$(function() {
	
	
	$("#fetchCars").click(function() {
	$.ajax({
			type: "GET",
			url: "webapi/cars",
			datatype: "json",
			success: function(jsondata) {
			 printCars(jsondata);	
			}
		});
	});
	
	$("#fetchc1").click(function() {
		$.ajax({
				type: "GET",
				url: "https://api.idolondemand.com/1/api/sync/ocrdocument/v1?reference=3bf9953e-0fd0-4f3a-959c-5ff731fb14fe&mode=scene_photo&apikey=5a1d7f68-11fa-4988-8a01-6720e3706eb6",
				dataType: "json",
				success: function(jsondata) {
				 printc1(jsondata);	
				}
			});
		});
	
	
	$("#fetchCarAvl").click(function() {
		$.ajax({
			type: "GET",
			url: "webapi/cars/ur-car/" + $('#ca').val(),
			success: function(op) {
			 printCarAvl(op);	
			}
		});
	})
	
	$("#fetchCarFtrs").click(function() {
		$.ajax({
			type: "GET",
			url: "webapi/cars/ur-car-features/" +  $('#cf').val(),
			datatype: "json",
			success: function(data) {
			 printCarFtrs(data);	
			}
		});
	});
});
	
	


