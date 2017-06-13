
(function () {
    'use strict';
    angular
        .module('app')
        .controller('BookCtrl', BookCtrl);

    BookCtrl.$inject = ['$http'];

    function BookCtrl($http) {
        var bc = this;

        bc.reports = [];
        bc.getAll = getAll;
        bc.getAllnow = getAllnow;
        bc.getByDate = getByDate;




        init();

        function init(){
            getAll();

        }

        function getAll(){
            var url = "api/performers/all";
            var booksStore = $http.get(url);
            booksStore.then(function(response){
                console.log(response);
                bc.reports = response.data;
                console.log(bc.reports);
            });
            getAllnow()
        }

        function getByDate(report){

            var url = "api/performers/date/";
            console.log(report)

            var booksStore = $http.post(url,report);
            booksStore.then(function(response){
                bc.reports = response.data;
            });
        }

        function getAllnow() {

            var url = "api/performers/all";
            var booksStore = $http.get(url);
            booksStore.then(function(response){

                bc.performers = response.data;

            });
        }
    }
})();
