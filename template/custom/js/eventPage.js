$(document).ready(function() {
  $('.event-page').addClass('active-header');

  $(".btn-validate-event-1").click(function() {
    if(typeof $('.user-name').val() === "undefined"){
      swal("Bạn không thể tham gia!", "Bạn vui lòng đăng nhập và chọn game trước nhé!", "info");
      return false;
    } else {
      if($(this).data('event') == $('.event-game').val()){
        var url = $('.event-url').val() + "luckybox?user_id=" + $('.user-id').val() + "&sign=" + $('.user-sign').val() + "&user_name=" + $('.user-name').val();
        window.open(url, '_blank');
      } else {
        swal("Xin lỗi bạn!", "Sự kiện này không thuộc về game bạn chọn, vui lòng thử sự kiện khác bạn nhé!", "warning");
      }
    }
  });

  $(".btn-validate-event-2").click(function() {
    if(typeof $('.user-name').val() === "undefined"){
      swal("Bạn không thể tham gia!", "Bạn vui lòng đăng nhập và chọn game trước nhé!", "info");
      return false;
    } else {
      if($(this).data('event') == $('.event-game').val()){
        var url = $('.event-url').val() + "goldenweek?user_id=" + $('.user-id').val() + "&sign=" + $('.user-sign').val() + "&user_name=" + $('.user-name').val();
        window.open(url, '_blank');
      } else {
        swal("Xin lỗi bạn!", "Sự kiện này không thuộc về game bạn chọn, vui lòng thử sự kiện khác bạn nhé!", "warning");
      }
    }
  });
});
