(function () {
    'use strict';

    angular
        .module('app')
        .controller('EtudiantsController', EtudiantsController);

    EtudiantsController.$inject = ['$http'];

    function EtudiantsController($http) {
        var vm = this;

        vm.user;
        vm.getAll = getAll;
        vm.getEtudiant = getEtudiant;
        vm.createEtudiant = createEtudiant;
        // vm.getAffordable = getAffordable;
        // vm.deleteBooking = deleteBooking;
        // vm.createHotel = createHotel;

        init();

        function init() {
            getAll();
        }

        function getAll() {
            var url = "/etudiant/all";
            var etudiantsPromise = $http.get(url);
            etudiantsPromise.then(function (response) {
                vm.etudiants = response.data;
            });
        }

        function getEtudiant(id) {
            var url = '/etudiant/' + id;
            var etudiantsPromise = $http.get(url);
            etudiantsPromise.then(function (response) {
                vm.etudiant = response.data;
            })
        }

        // function getAffordable() {
        //     var url = "/etudiants/affordable/" + 100;
        //     var etudiantsPromise = $http.get(url);
        //     etudiantsPromise.then(function (response) {
        //         vm.etudiants = response.data;
        //     });
        // }
        //
        // function deleteBooking(id) {
        //     var url = "etudiants/remove/" + id;
        //     $http.post(url).then(function (response) {
        //         vm.etudiants = response.data;
        //     })
        // }
    }
})();