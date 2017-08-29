angular.module("appModule")
	.factory("nightOutService", function($http) {
		var service = {};
		
//		var BASE_URL = "http://34.211.41.238:8080/NightOutREST/api/users/"
		var BASE_URL = "api/users"
		
		service.index = function() {
			return $http({
				method : "GET",
				url    : BASE_URL
			});
		};
		
		service.show = function(id) {
			return $http({
				method   :   "GET",
				url      : BASE_URL + "/" + id
			});
		};
		
		service.create = function(user) {
			return $http({
				method   :   "POST",
				url      :   BASE_URL,
				headers  : {
			        'Content-Type' : 'application/json'
			      },
			    data      : user
			});
		};
		
		service.update = function(id, user) {
			return $http({
				method   :   "PUT",
				url      :   BASE_URL + "/" + id,
				headers  : {
			        'Content-Type' : 'application/json'
			      },
			    data      : user
			});
		};
		
		service.destroy = function(id) {
			return $http({
				method    :   "DELETE",
				url       : BASE_URL + "/" + id
			});
		};
		
		return service;
	});


	