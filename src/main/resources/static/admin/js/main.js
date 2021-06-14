        $('#bar').click(function() {
            $(this).toggleClass('open');
            $('#page-content-wrapper ,#sidebar-wrapper').toggleClass('toggled');

        });
        
        
        function changes(id)
{
   
      if($('#active'+id).hasClass('btn-success'))
      {
        $('#active'+id).removeClass('btn-success');
        $('#active'+id).addClass('btn-danger');
        $('#active'+id).html('Passive');
      }
       else
      {
        $('#active'+id).removeClass('btn-danger');
        $('#active'+id).addClass('btn-success');
        $('#active'+id).html('Active');
      }
     
       $.ajax({


        type: 'get',
        url: '/admin/activePassive',
        data: { id: id },
        dataType: "json",
        success: function(response) {

    }
    });
   
}

// Js for Auto Add Semester fees-content
    $('.amount').keyup(function() {
     var sum = 0;
    $('.amount').each(function() {
        sum += Number($(this).val());
    });
    $('#total').val(sum);
    
    if(sum>10000000)
    {
      $('#form_submit').attr("disabled","true");
    }
    else
    {
        $('#form_submit').removeAttr("disabled","true");
    }
     
     
});




// Make Equal To all Semester
    $(document).ready(function(){
        $('#btn1').click(function(){
         
         var x=$('#pacakage__total').val();

        var numX=parseInt(x);

        var allSemFee=Math.floor(numX/8); 
        var remainder=(numX%8);   
         $('#sem1').val(allSemFee);
        $('#sem2').val(allSemFee);
        $('#sem3').val(allSemFee);
        $('#sem4').val(allSemFee);
        $('#sem5').val(allSemFee);
        $('#sem6').val(allSemFee);
        $('#sem7').val(allSemFee);
        $('#sem8').val(allSemFee+remainder);
        var sum = 0;
        $('.amount').each(function() {
        sum += Number($(this).val());
     });
    $('#total').val(sum);
    
    
    });
});

    //disble on checking full schoolarship


                $("#full_schoolarship").click(function() { 
                 
                    if ($('#full_schoolarship').is(":checked"))
                     { 
                       
                        $('#pacakage__total').attr('disabled','true'); 
                         $('#scholarship').attr('disabled','true'); 
                         $('#sem1').attr('disabled','true'); 
                         $('#sem2').attr('disabled','true'); 
                        $('#sem3').attr('disabled','true'); 
                        $('#sem4').attr('disabled','true'); 
                        $('#sem5').attr('disabled','true'); 
                        $('#sem6').attr('disabled','true'); 
                        $('#sem7').attr('disabled','true'); 
                        $('#sem8').attr('disabled','true');   
                        $('#btn1').attr('disabled','true');   
                     }
                     else 
                     {
                        
                       $('#pacakage__total').removeAttr('disabled','true');
                       $('#pacakage__total').removeAttr('disabled','true'); 
                         $('#scholarship').removeAttr('disabled','true'); 
                         $('#sem1').removeAttr('disabled','true'); 
                         $('#sem2').removeAttr('disabled','true'); 
                        $('#sem3').removeAttr('disabled','true'); 
                        $('#sem4').removeAttr('disabled','true'); 
                        $('#sem5').removeAttr('disabled','true'); 
                        $('#sem6').removeAttr('disabled','true'); 
                        $('#sem7').removeAttr('disabled','true'); 
                        $('#sem8').removeAttr('disabled','true');   
                        $('#btn1').removeAttr('disabled','true');   
                     }
                });


