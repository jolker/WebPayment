$(document).ready(function() {

  var pathname = window.location.href;
  if(pathname.indexOf("home#list_game") >= 0) {
    swal("Xin lỗi bạn!", "Bạn vui lòng chọn game trước nhé!", "info");
  }

  $(".payment-page").click(function() {
    scrollToElement('#list_game', 2000);
    swal("Xin lỗi bạn!", "Bạn vui lòng chọn game trước nhé!", "info");
  });

  $(".game-nplay-classic").click(function() {
    if(typeof $('.user-name').val() === "undefined"){
      window.location.href = "/login?game=nplay_classic";
    } else {
      window.location.href = "/payment";
    }
  });

  $(".game-nplay-pro").click(function() {
    swal("Xin lỗi bạn!", "Hiện tại game này chưa mở nhé!", "warning");
  });

  $(".game-nplay-poker").click(function() {
    swal("Xin lỗi bạn!", "Hiện tại game này chưa mở nhé!", "warning");
  });

  $(".game-co-chien").click(function() {
    swal("Xin lỗi bạn!", "Hiện tại game này chưa mở nhé!", "warning");
  });

});

var scrollToElement = function(el, ms) {
  var speed = (ms)
    ? ms
    : 600;
  $('html,body').animate({
    scrollTop: $(el).offset().top
  }, speed);
}
