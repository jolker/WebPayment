<!DOCTYPE html>
<html lang="en">
<#include "head.ftl">
  <link rel="stylesheet" href="${root_url}custom/css/loginPage.css">

  <body>
    <!-- header -->
    <div class="container">
      <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="/home">
          <img src="${root_url}img/logo.png" alt="logo" class="img-fluid">
        </a>
      </nav>
      <div class="row justify-content-md-center">
        <div class="col-sm-6 col-md-2 text-center" style="padding: 10px;">
        </div>
        <div class="col-sm-6 col-md-2 text-center ">
        </div>
      </div>
    </div>
    <!-- login -->

    <div class="wrap-content wrap-content-event">
      <div class="container ">
        <div style="padding-bottom:100px">
        </div>
        <!-- Bootstrap Grid -->
        <div class="row justify-content-md-center">
          <div class="col-xs-12 text-center" style="margin: 0 auto;">
            <h4 style="color:#778899; margin-bottom:25px">CHỌN HÌNH THỨC ĐỂ ĐĂNG NHẬP</h4>
          </div>
        </div>
        <!-- login account guest or game center-->
        <div class="row justify-content-md-center">
          <div class="col-xs-12 col-md-6 col-lg-4"><a href="/gencode" class="btn btn-success btn-guest shadow" style="width: 100%;margin-bottom:25px" >Tài khoản khách và Game Center</a></div>
        </div>
        <div class="row justify-content-md-center">
          <!-- login facebook-->
          <div class="col-md-3 col-xs-12 col-lg-2"><button type="button" class="btn btn-primary btn-facebook shadow" style="width: 100%;margin-bottom:25px" name="btnAction" value="facebook"><i class="fa fa-facebook-square" style="font-size:20px"></i> Facebook</button></div>
          <!-- login google-->
          <div class="col-md-3 col-xs-12 col-lg-2"><button type="button" class="btn btn-danger btn-google shadow" style="width: 100%;margin-bottom:25px" name="btnAction" value="google"><i class="fa fa-google" style="font-size:20px"></i> Google</button></div>
        </div>
        <div style="padding-bottom:100px">
        </div>
      </div>
    </div>
    <!-- footer -->
    <#include "footer.ftl">
    <#include "script.ftl">
    <!-- <script src="${root_url}custom/js/homePage.js"></script> -->
  </body>

</html>
