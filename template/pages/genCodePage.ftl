<!DOCTYPE html>
<html lang="en">
<#include "head.ftl">
  <link rel="stylesheet" href="${root_url}custom/css/loginPage.css">
  <body>
    <!-- header -->
    <div class="container">
      <div class="col-12">
        <a href="#">
          <img src="${root_url}img/logo.png" alt="logo" height="100px;" style="padding: 15px 0;">
        </a>
      </div>
    </div>
    <!-- login -->

    <div class="wrap-content wrap-content-event" style="margin-top: 0px;">
      <div class="container ">
        <div style="padding-bottom:50px">
        </div>
        <!-- Bootstrap Grid -->
        <#if message??>
          <div class="row justify-content-md-center">
            <div class="col-xs-12 col-md-6 alert alert-danger text-center" role="alert">
              <strong>Đăng nhập thất bại!</strong> ${message}.
            </div>
          </div>
        </#if>
        <div class="row justify-content-md-center">
          <div class="col">
            <h4 style="color:#778899; text-align:center;margin-bottom:35px">CHỌN HÌNH THỨC ĐỂ ĐĂNG NHẬP</h4>
          </div>
          <input type="hidden" class="fb-id" value="${facebook_id}">
        </div>
        <div class="row justify-content-md-center">
          <!-- login facebook-->
          <div class="col-md-3 col-xs-12 col-lg-2">
            <button type="button" class="btn btn-primary btn-facebook shadow" style="width: 100%;margin-bottom:25px">
              <i class="fa fa-facebook-square" style="font-size:20px"></i> Facebook
            </button>
          </div>
          <!-- login google-->
          <div class="col-md-3 col-xs-12 col-lg-2">
            <button type="button" class="btn btn-danger btn-google shadow" style="width: 100%;margin-bottom:25px">
              <i class="fa fa-google" style="font-size:20px"></i> Google
            </button>
            <div class="g-signin2" data-onsuccess="onSignIn" style="display:none;"></div>
          </div>
        </div>
        <div class="row justify-content-md-center">
          <div class="col-12 col-md-8 col-lg-5 text-center">
            <p><strong>Hoặc nhập Gencode vào khung bên dưới để đăng nhập bằng Tài Khoản Khách hoặc Game Center</strong></p>
          </div>
        </div>
        <form action="/gencode" method="POST" >
        <!-- login account guest or game center-->
        <div class="row justify-content-md-center">
          <div class="col-xs-12 col-md-6 col-lg-4"><input type="text" style="width: 100%;height:50px;border-radius: 25px;margin-bottom:10px;text-align:center" name="gencode" placeholder="Gencode" required/></div>
        </div>
         <div class="row justify-content-md-center text-center">
            <p style="margin: 10px auto;"><small><strong>(Xem hướng dẫn lấy Gencode bên dưới)</strong></small></p>
        </div>
         <div class="row justify-content-md-center">
          <div class="col-xs-12 col-md-2 col-lg-2"><button type="submit" class="btn btn-primary btn-guest shadow" style="text-align:center;width:100%" value="checkQrCode" name="action">Gửi</button></div>
        </div>
          </form >
          <!-- Modal -->
          <div class="" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
              <div class="modal-content">
                <div class="modal-header text-center" style="margin: 0 auto;">
                  <h5 class="modal-title" id="exampleModalLongTitle"><b>Hướng dẫn lấy Gencode</b></h5>
                </div>
                <div class="modal-body">
                  <div class="container-fluid">
                    <div class="row">
                      <div class="col"><p>1. Mở app vào màn hình chính của nplay</p></div>
                    </div>
                    <div class="row">
                      <div class="col-12"><p>2. Mở cài đặt</p></div>
                      <div class="col" style="margin-bottom:20px;"><img src="${root_url}img/main.png" alt="logo" class="img-fluid"></div>
                    </div>
                    <div class="row">
                      <div class="col-12"><p>3. Chọn tab mã code</p></div>
                      <div class="col" style="margin-bottom:20px;"><img src="${root_url}img/tabgencode.png" alt="logo" class="img-fluid"></div>
                    </div>
                    <div class="row">
                      <div class="col-12"><p>4. Nhấn nút làm mới để nhận gencode</p></div>
                      <div class="col" style="margin-bottom:20px;"><img src="${root_url}img/renewcode.png" alt="logo" class="img-fluid"></div>
                    </div>
                    <div class="row">
                      <div class="col-12"><p>5. Nhấn nút copy để sao chép mã code</p></div>
                      <div class="col" style="margin-bottom:20px;"><img src="${root_url}img/copycode.png" alt="logo" class="img-fluid"></div>
                    </div>
                    <div class="row">
                      <div class="col-12"><p>6. Dán vào field gencode khi chọn hình thức đăng nhập bằng tài khoản khách và game center</p></div>
                      <div class="col" style="margin-bottom:20px;"><img src="${root_url}img/endcode.png" alt="logo" class="img-fluid"></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
      </div>
    </div>

    <!-- footer -->
    <#include "footer.ftl">
    <#include "script.ftl">
    <script src="${root_url}custom/js/genCodePage.js"></script>
  </body>

</html>
