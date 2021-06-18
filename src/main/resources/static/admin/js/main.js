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
    
    if($('#pacakage__total').val()!=sum)
    {
       $('#form_submit').attr("disabled","true");
    }else
    {
    $('#form_submit').removeAttr("disabled","true");
    }
     
     
});

 $(document).ready(function(){
 
   if ($('#full_schoolarship').is(":checked")){
      $('#form_submit').removeAttr("disabled","true");
                     { 
                       
                      makeDisable()
                     }
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
    
     if( $('#pacakage__total').val()==0){
      $('#form_submit').attr("disabled","true");
        }else
        {
         $('#form_submit').removeAttr("disabled","true");
        }
    
    });
    
   
});

    //disble on checking full schoolarship


                $("#full_schoolarship").click(function() { 
                   
                    if ($('#full_schoolarship').is(":checked"))
                     { 
                      $('#form_submit').removeAttr("disabled","true");
                      makeDisable()
                     }
                     else 
                     {
                      $('#form_submit').attr("disabled","true");
                      makeEnable()
                     }
                });
                
                
            function makeDisable(){
                
                  $('#pacakage__total').val(""); 
                        $('#pacakage__total').attr('disabled','true'); 
                         $('#scholarship').attr('disabled','true'); 
                         $('#scholarship').val(""); 
                         $('#sem1').attr('disabled','true'); 
                         $('#sem1').val(""); 
                         $('#sem2').attr('disabled','true'); 
                         $('#sem2').val(""); 
                        $('#sem3').attr('disabled','true'); 
                        $('#sem3').val(""); 
                        $('#sem4').attr('disabled','true'); 
                        $('#sem4').val(""); 
                        $('#sem5').attr('disabled','true'); 
                        $('#sem5').val(""); 
                        $('#sem6').attr('disabled','true'); 
                        $('#sem6').val(""); 
                        $('#sem7').attr('disabled','true'); 
                        $('#sem7').val(""); 
                        $('#sem8').attr('disabled','true');   
                        $('#sem8').val("");   
                        $('#btn1').attr('disabled','true');   
                        $('#btn1').val("");   
            
            }
            
            function makeEnable(){
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
            
           
      //File upload hide and show 
$(document).ready(function() {
  $("#checkMark1").click(function() {
    $("#form1").toggle("hide");
  });
    $("#checkMark11").click(function() {
    if($('#form1').is(':visible')) {
    $("#form1").toggle("hide");
  }
  });
   $("#checkMark2").click(function() {
    $("#form2").toggle();
  });

});
// check box only selectable in payment of fee

$('input[type="checkbox"]').on('change', function() {
   $('input[type="checkbox"]').not(this).prop('checked', false);
});

// payment form submission
$("form1").submit(function(e){
        e.preventDefault();
    });
    
// first semester payment
function pay_first(){
  var mode="cash";
  var amountFirst=$('#amount_first').val();
  var fileFirst=$('#file_first').val();
  var enteredBy=$('#entered_by').val();
  var fileFirst=$('#file_first').val();
  var feeId=$('#fee_id').val();

  
   if (!$('#checkMark11').is(":checked") && !$('#checkMark1').is(":checked") || !$('#amount_first').val())
   { alert(11);
   }
   else
   {
      if($('#checkMark1').is(":checked")){
        var mode="voucher";
        
        if( !$('#file_first').val()){
          
            alert("no file");
           }
         else{  
        var fd = new FormData();
        var files = $('#file_first')[0].files[0];
        fd.append("file",files);
        fd.append("mode",mode);
        fd.append("amountFirst",amountFirst);
        fd.append("feeId",feeId);
       
           $.ajax({
         type: 'post',
         url: '/admin/payment/save/type-voucher',
         data: fd,
         contentType: false,
         processData: false,
         dataType: "json",
         success: function(response) {
        
         }
        });
        
                   
         }  
      }else{      var semester=1;
                  var fd = new FormData();
                 fd.append("enteredBy",enteredBy);
                 fd.append("mode",mode);
                fd.append("semester",1);
                fd.append("amountFirst",amountFirst);
                  fd.append("feeId",feeId);
               $.ajax({
                      type: 'post',
                      url: '/admin/payment/save/type-cash',
                      data: fd,
                       contentType: false,
                       processData: false,
                      dataType: "json",
                      success: function(response) {
                       $("#amount_first").val("");
                    }
                 });
        
      
     
          
      }
   
   }
  
  
}
