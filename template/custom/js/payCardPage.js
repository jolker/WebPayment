var _action_url = "/payment";

$(document).ready(function() {
  $('.payment-page').addClass('active-header');
  $('.pay-sms').removeClass('content-choose-case-payment-active');
  $('.pay-card').addClass('content-choose-case-payment-active');

  var currency = "";
  $(".format-money").each(function(index) {
    if (parseInt($(this).text()) > 0) {
      currency = (parseInt($(this).text()) + "").replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
      $(this).text(currency);
    }
  });

  $(".btn-mobi").click(function() {
    $(this).children().attr("src", '/img/mobi_hover.png');
    $(this).addClass('active-network');

    $('.mobile-select-telco option[value=mobi]').prop('selected', true);

    $('.btn-vina').children().attr("src", '/img/vina.png');
    $('.btn-vina').removeClass('active-network');

    $('.btn-viettel').children().attr("src", '/img/viettel.png');
    $('.btn-viettel').removeClass('active-network');

    $('.name-network').text('MOBIFONE');
  });

  $(".btn-vina").click(function() {
    $(this).children().attr("src", '/img/vina_hover.png');
    $(this).addClass('active-network');

    $('.mobile-select-telco option[value=vina]').prop('selected', true);

    $('.btn-mobi').children().attr("src", '/img/mobi.png');
    $('.btn-mobi').removeClass('active-network');

    $('.btn-viettel').children().attr("src", '/img/viettel.png');
    $('.btn-viettel').removeClass('active-network');

    $('.name-network').text('VINAPHONE');
  });

  $(".btn-viettel").click(function() {
    $(this).children().attr("src", '/img/viettel_hover.png');
    $(this).addClass('active-network');

    $('.mobile-select-telco option[value=viettel]').prop('selected', true);

    $('.btn-mobi').children().attr("src", '/img/mobi.png');
    $('.btn-mobi').removeClass('active-network');

    $('.btn-vina').children().attr("src", '/img/vina.png');
    $('.btn-vina').removeClass('active-network');

    $('.name-network').text('VIETTEL');
  });

  $('.mobile-select-telco').on('change', function() {
    if ($(this).val() == "mobi") {
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
    }
  });

  $(".btn-send-sms").click(function() {

    var telco = "";
    if ($('.desktop-only').is(":visible")) {
      $(".btn-network").each(function(index) {
        if ($(this).hasClass('active-network')) {
          telco = $(this).data('telco');
        }
      });
    } else {
      telco = $('.mobile-select-telco').val();
    }

    if (telco == "") {
      swal("Error!", "Vui lòng chọn nhà mạng", "error");
      return false;
    }

    if ($('#card_code').val() == "") {
      swal("Error!", "Vui lòng điền mã thẻ", "error");
      return false;
    }

    if ($('#card_serial').val() == "") {
      swal("Error!", "Vui lòng điền số serial", "error");
      return false;
    }

    $.get("http://ipinfo.io", function(data) {
      var datas = {
        "action": "pay_by_card",
        "telco": telco,
        "card_code": $('#card_code').val(),
        "card_serial": $('#card_serial').val(),
        "user_ip": data.ip
      }

      $.ajax({
        url: _action_url,
        data: datas,
        success: function(response) {
          if (response.result) {
            swal("Chúc mừng!", response.msg, "success").then((value) => {
              location.reload();
            });
          } else {
            swal("Thất bại!", response.msg, "warning");
          }
        },
        error: function() {
          swal("Xin lỗi!", "Hệ thống nạp tiền đang bị sự cố", "warning");
        }
      });
    }, "jsonp");

  });

});
