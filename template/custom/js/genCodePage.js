var appIdFb = $('.fb-id').val();

$(document).ready(function() {
  $(".btn-facebook").click(function() {
    FB.login(function(response) {
      if (response.authResponse) {
        FB.api('/me', function(response) {
          console.log('Good to see you, ' + response.name + '.');
          $.post("gencode", {
            action: "fblogin",
            id: response.id
          }).done(function(data) {
            if (data.result == true) {
              window.location.href = "/payment";
            } else {
              swal(data.message, "", "warning");
            }
          });
        });
      }
    }, {scope: 'public_profile,email', auth_type: 'reauthenticate'});
  });

  $(".btn-google").click(function() {
    $(".abcRioButtonLightBlue").trigger("click");
  });
});

// login google
function onSignIn(googleUser) {
  // Useful data for your client-side scripts:
  var profile = googleUser.getBasicProfile();
  $.post("gencode", {
    action: "glogin",
    id: profile.getId()
  }).done(function(data) {
    if (data.result == true) {
      window.location.href = "/payment";
    } else {
      swal(data.message, "", "warning");
    }
  });
};

// login facebook
window.fbAsyncInit = function() {
  FB.init({
    appId: appIdFb,
    // the session
    xfbml: true, // parse social plugins on this page
    version: 'v2.8' // use graph api version 2.8
  });
};

// Load the SDK asynchronously
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
