<!DOCTYPE html>
<html lang="en">
  <#include "head.ftl">
  <body>
    <!-- header -->
    <#include "header.ftl">

    <!-- banner -->
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="carousel-item active">
          <img class="d-block img-fluid" src="${root_url}img/banner.jpg" alt="banner">
        </div>
        <div class="carousel-item">
          <img class="d-block img-fluid" src="${root_url}img/banner.jpg" alt="banner">
        </div>
        <div class="carousel-item">
          <img class="d-block img-fluid" src="${root_url}img/banner.jpg" alt="banner">
        </div>
      </div>
      <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>

    <!-- list game -->
    <div class="wrap-content">
      <div class="container" id="list_game">
        <h1 class="text-center title-content">DANH SÁCH GAME</h1>
        <div class="row">
          <div class="line-blue-title">
          </div>
        </div>
        <div class="row justify-content-md-center" style="margin: 50px auto;">
          <div class="col-6 col-md-3 col-lg-2 game-nplay-classic hvr-grow">
            <img class="d-block img-fluid" src="${root_url}img/nplay_classic.png" alt="">
            <h5 class="text-center text-item">NPlay Classic</h5>
          </div>
          <div class="col-6 col-md-3 col-lg-2 game-nplay-pro hvr-grow">
            <img class="d-block img-fluid" src="${root_url}img/nplay_pro.png" alt="">
            <h5 class="text-center text-item">NPlay Pro</h5>
          </div>
          <div class="col-6 col-md-3 col-lg-2 game-nplay-poker hvr-grow">
            <img class="d-block img-fluid" src="${root_url}img/nplay_poker.png" alt="">
            <h5 class="text-center text-item">NPlay Poker</h5>
          </div>
          <div class="col-6 col-md-3 col-lg-2 game-co-chien hvr-grow">
            <img class="d-block img-fluid" src="${root_url}img/cochien.png" alt="">
            <h5 class="text-center text-item">Cờ Chiến</h5>
          </div>
        </div>
      </div>
    </div>

    <!-- footer -->
    <#include "footer.ftl">
    <#include "script.ftl">
    <script src="${root_url}custom/js/homePage.js"></script>
  </body>
</html>
