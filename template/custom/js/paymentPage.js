var _action_url = "/payment";

$(document).ready(function() {
  $('.payment-page').addClass('active-header');
  $('.pay-card').addClass('content-choose-case-payment-active');

  $( ".pay-card" ).on( "click", function() {
    $.post(_action_url, {action: "card"}, function(result){
        $('.wrap-content-event').find('#content_payment').html(result);
    });
  });

  $( ".pay-sms" ).on( "click", function() {
    $.post(_action_url, {action: "sms"}, function(result){
        $('.wrap-content-event').find('#content_payment').html(result);
    });
  });
});
