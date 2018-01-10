$(document).ready(function() {
  $('.payment-page').addClass('active-header');
  $('.pay-card').removeClass('content-choose-case-payment-active');
  $('.pay-sms').addClass('content-choose-case-payment-active');

  var currency = "";
  $(".format-money").each(function(index) {
    if (parseInt($(this).text()) > 0) {
      currency = (parseInt($(this).text()) + "").replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
      $(this).text(currency);
    }
  });

  $('.viettel').hide();
  $('.vinaphone').hide();

  $( ".btn-mobi" ).click(function() {
    $(this).children().attr("src", '/img/mobi_hover.png');
    $(this).addClass('active-network');

    $('.mobile-select-telco option[value=mobi]').prop('selected', true);

    $('.btn-vina').children().attr("src", '/img/vina.png');
    $('.btn-vina').removeClass('active-network');

    $('.btn-viettel').children().attr("src", '/img/viettel.png');
    $('.btn-viettel').removeClass('active-network');

    $('.name-network').text('MOBIFONE');

    $('.mobiphone').show();
    $('.viettel').hide();
    $('.vinaphone').hide();

    sendSMS();
  });

  $( ".btn-vina" ).click(function() {
    $(this).children().attr("src", '/img/vina_hover.png');
    $(this).addClass('active-network');

    $('.mobile-select-telco option[value=vina]').prop('selected', true);

    $('.btn-mobi').children().attr("src", '/img/mobi.png');
    $('.btn-mobi').removeClass('active-network');

    $('.btn-viettel').children().attr("src", '/img/viettel.png');
    $('.btn-viettel').removeClass('active-network');

    $('.name-network').text('VINAPHONE');

    $('.mobiphone').hide();
    $('.viettel').hide();
    $('.vinaphone').show();

    sendSMS();
  });

  $( ".btn-viettel" ).click(function() {
    $(this).children().attr("src", '/img/viettel_hover.png');
    $(this).addClass('active-network');

    $('.mobile-select-telco option[value=viettel]').prop('selected', true);

    $('.btn-mobi').children().attr("src", '/img/mobi.png');
    $('.btn-mobi').removeClass('active-network');

    $('.btn-vina').children().attr("src", '/img/vina.png');
    $('.btn-vina').removeClass('active-network');

    $('.name-network').text('VIETTEL');

    $('.mobiphone').hide();
    $('.viettel').show();
    $('.vinaphone').hide();

    sendSMS();
  });

  $('.value-sms').on('change', function() {
    sendSMS();
  });

  $('.mobile-select-telco').on('change', function() {
    if($(this).val() == "mobi") {
      $('.btn-mobi').children().attr("src", '/img/mobi_hover.png');
      $('.btn-mobi').addClass('active-network');

      $('.btn-vina').children().attr("src", '/img/vina.png');
      $('.btn-vina').removeClass('active-network');

      $('.btn-viettel').children().attr("src", '/img/viettel.png');
      $('.btn-viettel').removeClass('active-network');

      $('.name-network').text('MOBIFONE');

      $('.mobiphone').show();
      $('.viettel').hide();
      $('.vinaphone').hide();

      sendSMS();
    } else if ($(this).val() == "vina") {
      $('.btn-vina').children().attr("src", '/img/vina_hover.png');
      $('.btn-vina').addClass('active-network');

      $('.btn-mobi').children().attr("src", '/img/mobi.png');
      $('.btn-mobi').removeClass('active-network');

      $('.btn-viettel').children().attr("src", '/img/viettel.png');
      $('.btn-viettel').removeClass('active-network');

      $('.name-network').text('VINAPHONE');

      $('.mobiphone').hide();
      $('.viettel').hide();
      $('.vinaphone').show();

      sendSMS();
    } else {
      $('.btn-viettel').children().attr("src", '/img/viettel_hover.png');
      $('.btn-viettel').addClass('active-network');

      $('.btn-mobi').children().attr("src", '/img/mobi.png');
      $('.btn-mobi').removeClass('active-network');

      $('.btn-vina').children().attr("src", '/img/vina.png');
      $('.btn-vina').removeClass('active-network');

      $('.name-network').text('VIETTEL');

      $('.mobiphone').hide();
      $('.viettel').show();
      $('.vinaphone').hide();

      sendSMS();
    }
  });

  var clipboard = new Clipboard('.btn-copy-clipboard');

  clipboard.on('success', function(e) {
    swal("Copied!", "Dán vào Tin nhắn và Gửi 9029", "success");
  });

  clipboard.on('error', function(e) {
      console.error('Action:', e.action);
      console.error('Trigger:', e.trigger);
  });
});

function sendSMS(){
  var telco = "";
  if($('.desktop-only').is(":visible")) {
    $(".btn-network").each(function(index) {
      if ($(this).hasClass('active-network')) {
        telco = $(this).data('telco');
      }
    });
  } else {
    telco = $('.mobile-select-telco').val();
  }

  if (telco == "") {
    swal("Vui lòng chọn nhà mạng", "", "warning");
    return false;
  }

  if ($('.value-sms').val() == "") {
    swal("Vui lòng chọn mệnh giá", "", "warning");
    return false;
  }

  var msg = "MW ";
  if (telco == "viettel") {
    msg = msg + $('.value-sms').val() + " NP NAP " + $('.user-name').val();
    $('#copy_sms').val(msg);
    swal("Soạn " + msg + " Gửi 9029", "", "success");
  } else {
    msg = msg + "NP NAP" + parseInt($('.value-sms').val())/1000 + " " + $('.user-name').val();
    $('#copy_sms').val(msg);
    swal("Soạn " + msg + " Gửi 9029", "", "success");
  }
}
