$(function(){
  $("#year").change(function(){
	 var month=$('#month').val();
    window.location='/calendar?mahina='+month+'&saal='+this.value;

  });
});

$(function(){
  $("#month").change(function(){
	 var year=$('#year').val();
    window.location='/calendar?mahina='+this.value+'&saal='+year;

  });
});

