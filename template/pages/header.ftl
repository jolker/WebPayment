<div class="container">
  <div class="row">
    <div class="col-md-8 col-6">
      <a href="#">
                <img src="${root_url}img/logo.png" alt="logo" height="100px;" style="padding: 15px 0;">
            </a>
    </div>
    <#if user??>
      <div class="col-md-4 col-6" style="text-align:center;margin:auto">
        <img src="<#if avatar??>${avatar}<#else>${root_url}img/user-avata.png</#if>" class="rounded-circle" alt="" width="50" height="50"> ${user}
        <a class="btn btn-primary my-2 my-sm-0 btn-login btn-logout" style="font-size:12px;">Đăng Xuất</a>
      </div>
      <input type="hidden" class="user-id" value="${user_id}">
      <input type="hidden" class="user-name" value="${user}">
      <input type="hidden" class="user-sign" value="${sign}">

      <script>
        $(".btn-logout").click(function() {
          logOutFB();
          document.location.href = "https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=${root_url}logout";
        });
        // logout facebook
        function logOutFB() {
          FB.getLoginStatus(function(response) {
            if (response && response.status === 'connected') {
              FB.logout();
            }
          });
        }

        window.fbAsyncInit = function() {
          FB.init({
            appId: ${facebook_id},
            cookie: true, // enable cookies to allow the server to access
            // the session
            xfbml: true, // parse social plugins on this page
            version: 'v2.8' // use graph api version 2.8
          });
        };

        (function(d, s, id) {
          var js,
            fjs = d.getElementsByTagName(s)[0];
          if (d.getElementById(id))
            return;
          js = d.createElement(s);
          js.id = id;
          js.src = "https://connect.facebook.net/en_US/sdk.js";
          fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));
      </script>
      <#else>
        <div class="col-md-2 col-6" style="text-align:center;margin:auto">
          <a href="/gencode" class="btn btn-primary my-2 my-sm-0 btn-login btn-act-login">Đăng nhập</a>
        </div>
    </#if>
  </div>

  <div class="row justify-content-md-center">
    <div class="col-sm-6 col-md-2 text-center header header-payment-tab">
      <a class="text-header payment-page" href="/payment">NẠP THẺ</a>
    </div>
    <div class="col-sm-6 col-md-2 text-center header header-payment-tab">
      <a class="text-header event-page" href="#">SỰ KIỆN</a>
    </div>
    <script>
      $(".event-page").click(function(){
        swal("Coming soon.", "", "warning");
      });
    </script>
  </div>
</div>
