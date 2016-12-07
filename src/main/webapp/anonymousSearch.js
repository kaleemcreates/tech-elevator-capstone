


$(document).ready( function() {
	var distance = [{name:'1 mile', value:'1'}, {name:'5 Miles', value:'5'}, {name:'10 Miles', value:'10'}, {name:'25 Miles', value:'25'}];

	var type = [{name:'Entertainment', value:'Entertainment'}, {name:'Sports', value:'Sports'}, {name:'Museum', value:'Museum'}, {name:'Park', value:'Park'},
	            {name:'Theater', value:'Theater'}, {name:'Government', value:'Government'}, {name:'Restaurant', value:'Restaurant'},];
	}
  $("input[name='chk']").on('change',function() {

      if($(this).is(':checked') && $(this).val() == '1')
      {
        $('#describe').empty()
        $.each(listA, function(index, value) {
         $('#describe').append('<option value="'+value.value+'">'+value.name+'</option>');
        });                  
      }
      else if($(this).is(':checked') && $(this).val() == '2')
      {
        $('#describe').empty()
        $.each(listB, function(index, value) {
         $('#describe').append('<option value="'+value.value+'">'+value.name+'</option>');
        }); 
      }
      else
      {

      }

  });
});