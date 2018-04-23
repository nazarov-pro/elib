/**
 * Created by Shahin on 5/21/2017.
 */
var app = angular.module("ElibApp", ["ngSanitize"]);

var backToTop = function () {
    $(window).scroll(function () {
        if ($(this).scrollTop() > 50) {
            $('#back-to-top').fadeIn();
        } else {
            $('#back-to-top').fadeOut();
        }
    });

    $('#back-to-top').click(function () {
        $('#back-to-top').tooltip('hide');
        $('body,html').animate({
            scrollTop: 0
        }, 800);
        return false;
    });

    $('#back-to-top').hide();
};


var initializeLanguage = function () {
    ///hover container lang menu
    $("#lang-menu").hover(
        function(){
            $(this).addClass("cls-border-lang");
            $(this).children().eq(0).addClass("cls-borderbottom-lang");
            $("#lang-menu ul").stop().slideToggle(100);
        },
        function(){
            $(this).removeClass("cls-border-lang");
            $(this).children().eq(0).removeClass("cls-borderbottom-lang");
            $("#lang-menu ul").stop().slideToggle(100);
        }
    );
    /// click languages
    $("#lang-menu ul li").on("click", function(){
        //select lang and apply changes
        $lang = $(this).text();
        $("#lang-menu div").text($lang);
    });
};

app.controller("BooksCtrl", ['$scope', '$http', '$window','$sce', function ($scope, $http, $window , $sce) {

    var feedback ={};

    var init = function () {
        $http.get("/books").then(function (response) {
            $scope.booksContent = $sce.trustAsHtml(response.data);
        });
        backToTop();
        initializeLanguage();
    };

    $scope.showContact = function () {
      $('#contact').modal();

    };

    $scope.sendFeedback = function () {
        $http.post('/contact',{
            "name":$scope.feedback.name,
            "email":$scope.feedback.email,
            "message":$scope.feedback.message
        }).then(function (response) {
          $scope.booksContent = $sce.trustAsHtml(response.data);
      });
    };

    init();
}]);