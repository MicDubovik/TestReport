(function () {
    'use strict';
    angular
        .module('app')
        .controller('BookCtrl', BookCtrl);

    BookCtrl.$inject = ['$http'];


    function BookCtrl($http) {
        var bc = this;

        bc.reports = [];
        bc.report =Object();
        bc.getAll = getAll;
        bc.getAllnow = getAllnow;
        bc.getByDate = getByDate;
        bc.setDate = setDate;
        // bc.filter = filter;


        bc.hello = "привет";

        bc.periods = [
            {action: "lastQtr"},
            {action: "lastMonth"},
            {action: "lastYear"},
            {action: "currMonth"},
            {action: "currYear"},
            {action: "currQtr"},
        ];


        init();

        function init() {
            getAll();

        }



        function getAll() {
            var url = "api/performers/all";
            var booksStore = $http.get(url);
            booksStore.then(function (response) {
                console.log(response);
                bc.reports = response.data;
                console.log(bc.reports);
            });
            getAllnow()
        }

        function getByDate(report) {

            var url = "api/performers/date/";
            console.log(report)

            var booksStore = $http.post(url, report);
            booksStore.then(function (response) {
                bc.reports = response.data;
            });
        }

        function getAllnow() {

            var url = "api/performers/all";
            var booksStore = $http.get(url);
            booksStore.then(function (response) {

                bc.performers = response.data;

            });
        }

        function setDate(period) {
            console.log(period)

            var now = new Date();
            // bc.std = new Date();
            // bc.ed = new Date();
              bc.report.startdate = null;
              bc.report.enddate = null;
            console.log(now.getMonth());
            if (period === "lastYear") {

                // var day = ("0" + now.getDate()).slice(-2);
                console.log(now.getDate());
                // var month = ("0" + (now.getMonth() + 1)).slice(-2);
                console.log(now.getMonth());

                bc.report.startdate = new Date((now.getFullYear() - 1),0,1);
                bc.report.enddate = new Date((now.getFullYear() - 1),11,31);
                console.log(bc.report.startdate);
                console.log( bc.report.enddate);

            } else if (period === "lastMonth") {
                bc.report.startdate = new Date(now.getFullYear(),now.getMonth()-1,1);
                bc.report.enddate = new Date(now.getFullYear(),now.getMonth()-1,31);
                console.log(bc.report.startdate);
                console.log( bc.report.enddate);
            } else if (period === "lastQtr") {
                if (now.getMonth() > 2 && now.getMonth() < 5) {
                    var smonth = 9;
                    var emonth = 11;
                }
                else if (now.getMonth() >= 5 && now.getMonth() < 8) {
                    var smonth = 0;
                    var emonth = 2;
                }
                else if (now.getMonth() >= 8 && now.getMonth() <= 11) {
                    var smonth = 3;
                    var emonth = 5;
                }
                else if (now.getMonth() > 0 && now.getMonth() < 2) {
                    var smonth = 6;
                    var emonth = 8;
                }

                bc.report.startdate = new Date(now.getFullYear(),smonth,1);
                bc.report.enddate = new Date(now.getFullYear(),emonth,31);
                console.log(bc.report.startdate + "lastQtr");
                console.log(bc.report.enddate+ "lastQtr");
            }

            else if (period === "currYear") {
                bc.report.startdate = new Date(now.getFullYear(),0,1);
                bc.report.enddate = new Date(now.getFullYear(),(now.getMonth()+1),now.getDate());
                console.log(bc.report.startdate);
                console.log( bc.report.enddate);
            }
            else if (period === "currQtr") {
                if (now.getMonth() > 2 && now.getMonth() < 5) {
                    var smonth = 0;

                }
                else if (now.getMonth() >= 5 && now.getMonth() < 8) {
                    var smonth = 3;

                }
                else if (now.getMonth() >= 8 && now.getMonth() <= 11) {
                    var smonth = 6;

                }
                else if (now.getMonth() > 0 && now.getMonth() < 2) {
                    var smonth = 9;

                }
                bc.report.startdate = new Date(now.getFullYear(),smonth,1);
                bc.report.enddate = new Date(now.getFullYear(),now.getMonth(),now.getDate());
                console.log(bc.report.startdate);
                console.log( bc.report.enddate);
            }

            else if (period === "currMonth"){
                bc.report.startdate =new Date( now.getFullYear(),now.getMonth(),1);
                bc.report.enddate =  new Date(now.getFullYear(),now.getMonth(),now.getDate());
                console.log(bc.report.startdate);
                console.log( bc.report.enddate);

            }

            else if (period === null){
                bc.report.startdate = null;
                bc.report.enddate =  null;
            }

        }

    }
})();
