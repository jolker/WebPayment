<!DOCTYPE html>
<html lang="en">
  <#include "head.ftl">
  <#include "script.ftl">
  <body>
    <!-- header -->
    <#include "header.ftl">

    <!-- list event -->
    <#if game??>
      <input type="hidden" class="event-game" value="${game}">
    </#if>
    <input type="hidden" class="event-url" value="${event_url}">

    <div class="wrap-content wrap-content-event">
      <div class="container">
        <h1 class="text-center title-content" style="margin-top: 50px;">SỰ KIỆN</h1>
        <div class="row" style="margin-bottom: 50px;">
          <div class="line-blue-title">
          </div>
        </div>
        <div class="row">
          <div class="col-12 col-md-6" style="margin-bottom: 40px;">
            <div class="row">
              <div class="col-12 col-md-4 text-center">
                <img class="rounded img-fluid" src="${root_url}img/PC_03.png" alt="">
              </div>
              <div class="col col-md-8 content-event-mobile">
                <h5 class="title-event">Hộp Quà May Mắn</h5>
                <p><small> is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</small></p>
                <div class="row">
                  <div class="col col-lg-7">
                    <small><em>09/07/2017 - 11:11AM</em></small>
                  </div>
                  <div class="col">
                    <a class="btn btn-primary btn-login btn-validate-event-1" data-event="nplay_classic">Tham Gia</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-6" style="margin-bottom: 40px;">
            <div class="row">
              <div class="col-12 col-md-4 text-center">
                <img class="rounded img-fluid" src="${root_url}img/PC_05.png" alt="">
              </div>
              <div class="col col-md-8 content-event-mobile">
                <h5 class="title-event">Tuần Lễ Vàng</h5>
                <p><small> is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</small></p>
                <div class="row">
                  <div class="col col-lg-7">
                    <small><em>09/07/2017 - 11:11AM</em></small>
                  </div>
                  <div class="col">
                    <a class="btn btn-primary btn-login btn-validate-event-2" data-event="nplay_classic">Tham Gia</a>
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
    <script src="${root_url}custom/js/eventPage.js"></script>
  </body>
</html>
