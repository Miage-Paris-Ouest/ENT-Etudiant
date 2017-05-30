(function () {
    'use strict';

    angular
        .module('app')
        .controller('CoursController', CoursController);

    CoursController.$inject = ['$http'];

    function CoursController($http) {
        var vm = this;

        vm.cours = [];
        vm.getAll = getAll;
        /*vm.getAffordable = getAffordable;
        vm.deleteBooking = deleteBooking;*/

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/etudiant/getmatieres";
            var coursPromise = $http.get(url);
            coursPromise.then(function(response){
                vm.cours = response.data;
            });
        }

        /*function getAffordable(){
            var url = "/bookings/affordable/" + 100;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.bookings = response.data;
            });
        }*/

        /*function deleteBooking(id){
            var url = "/bookings/delete/" + id;
            $http.post(url).then(function(response){
                vm.bookings = response.data;
            });
        }*/
    }
})();
