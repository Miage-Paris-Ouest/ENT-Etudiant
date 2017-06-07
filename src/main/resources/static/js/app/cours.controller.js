(function () {
    'use strict';

    angular
        .module('app')
        .controller('CoursController', CoursController);

    CoursController.$inject = ['$http'];

    function CoursController($http) {
        var vm = this;

        vm.matieres = [];
        vm.currentMatiereId = 0;
        vm.cours = [];
        vm.commentaires = [];
        vm.getAll = getAll;
        vm.getAllCoursOfMatiere = getAllCoursOfMatiere;
        vm.voteForFile = voteForFile;
        vm.getComment = getComment;
        vm.ajouterCommentaire = ajouterCommentaire;

        init();

        function init() {
            getAll();
        }

        function getAll() {
            var url = "/etudiant/getmatieres";
            var coursPromise = $http.get(url);
            coursPromise.then(function (response) {
                vm.matieres = response.data;
            });
        }

        function getAllCoursOfMatiere(id_matiere) {
            var url = "/etudiant/getcours/" + id_matiere;
            var coursPromise = $http.get(url);
            coursPromise.then(function (response) {
                vm.cours = response.data;
                for (var i = 0; i < vm.cours.length; i++) {
                    vm.cours[i].positiveNote = 0;
                    vm.cours[i].negativeNote = 0;
                    for (var j = 0; j < vm.cours[i].notes.length; j++) {
                        vm.cours[i].notes[j].evaluation_fichier === 1 ? ++vm.cours[i].positiveNote
                            : --vm.cours[i].negativeNote;
                    }
                }
                vm.currentMatiereId = id_matiere;
            })
        }

        function voteForFile(idFichier, idEtudiant, vote) {
            var url = "/fichier/voter";
            var noteFichier = {
                "etudiant": {
                    "user": {
                        "id": idEtudiant
                    }
                },
                "fichier": {
                    "id": idFichier
                },
                "evaluation_fichier": vote
            };
            $http.post(url, noteFichier).then(function () {
                getAllCoursOfMatiere(vm.currentMatiereId);
            });
        }

        function getComment(idFichier) {
            var url = "/commentaire/get/" + idFichier;
            $('#commentaires_fichiers').show();
            $http.get(url).then(function (response) {
                vm.commentaires = response.data;
            });
        }

        function ajouterCommentaire(idFichier, idUser, commentaire) {
            var url = "/commentaire/save";
            var objetCommentaire = {
                "fichier": {
                    "id": idFichier
                },
                "user": {
                    "id": idUser
                },
                "commentaire": commentaire
            };
            $http.post(url, objetCommentaire).then(function (response) {
                vm.commentaires = response.data;
                $('#commentaireInput').val('');
            });
        }
    }
})();
