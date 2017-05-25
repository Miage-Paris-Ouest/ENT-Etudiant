(function () {
    'use strict';

    angular
        .module('app')
        .controller('PromotionsController', PromotionsController);

    PromotionsController.$inject = ['$http'];

    function PromotionsController($http) {
        var vm = this;

        vm.promotions = [];
        // the chosen promotion by the user
        vm.promotion;
        vm.getAll = getAll;
        vm.getPromotion = getPromotion;
        // vm.getAffordable = getAffordable;
        // vm.deleteBooking = deleteBooking;
        // vm.createHotel = createHotel;

        init();

        function init() {
            getAll();
        }

        // function createHotel(name, price, nbNights) {
        //     var hotel = {
        //         "hotelName": name,
        //         "pricePerNight": price,
        //         "nbOfNights": nbNights
        //     };
        //     var url = "/promotions/create";
        //     $http.post(url, hotel).then(function (response) {
        //         vm.promotions = response.data;
        //     });
        // }

        function getAll() {
            var url = "/promotion/all";
            var promotionsPromise = $http.get(url);
            promotionsPromise.then(function (response) {
                vm.promotions = response.data;
            });
        }

        function getPromotion(id) {
            var url = '/promotion/' + id;
            var promotionsPromise = $http.get(url);
            promotionsPromise.then(function (response) {
                vm.promotion = response.data;
            })
        }

        // function getAffordable() {
        //     var url = "/promotions/affordable/" + 100;
        //     var promotionsPromise = $http.get(url);
        //     promotionsPromise.then(function (response) {
        //         vm.promotions = response.data;
        //     });
        // }
        //
        // function deleteBooking(id) {
        //     var url = "promotions/remove/" + id;
        //     $http.post(url).then(function (response) {
        //         vm.promotions = response.data;
        //     })
        // }
    }
})();