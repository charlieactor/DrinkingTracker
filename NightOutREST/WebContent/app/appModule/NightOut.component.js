angular.module("appModule")
	.component("nightOut", {
		templateUrl  :  "app/appModule/nightOut.component.html",
		controller   : function(nightOutService) {
			var vm = this;

			vm.nightsOut = [];
			
			vm.selected = null;
			
			vm.showCreateForm = false;
			
			vm.showStats = false;
			
			vm.edit = null;
			
			vm.reload = function() {
				nightOutService.index()
					.then(function(result) {
						vm.nightsOut = result.data;
				});
			};
			
			vm.show = function(id) {
				nightOutService.show(id)
					.then(function(result) {
						vm.selected = result.data;
					})
			}
			
			vm.create = function(user) {
				nightOutService.create(user)
					.then(function(result) {
						vm.showCreateForm = false;
						vm.reload();
					});
			};
			
			vm.update = function(id, updated) {
				console.log(id);
				nightOutService.update(id, updated)
					.then(function(result) {
						console.log(result.data);
						vm.edit = null;
						vm.selected = result.data;
						vm.reload();
					});
			}
			
			vm.delete = function(id) {
				nightOutService.destroy(id)
					.then(function() {
						vm.selected = null;
						vm.reload();
					})
			}
			
			vm.reload();
			
			vm.averageDrinksHad = function() {
				var avg = 0;
				var num = 0;
				vm.nightsOut.forEach(function(val) {
					avg += val.numberOfDrinks;
					num++;
				})
				avg = avg/num;
				return avg;
			}
			vm.averageHoursSpent = function() {
				var avg = 0;
				var num = 0;
				vm.nightsOut.forEach(function(val) {
					avg += val.numberOfHours;
					num++;
				})
				avg = avg/num;
				return avg;
			}
			vm.averageCaloriesConsumed= function() {
				var avg = 0;
				var num = 0;
				vm.nightsOut.forEach(function(val) {
					avg += val.totalCalories;
					num++;
				})
				avg = avg/num;
				return avg;
			}
			vm.averageNumberOfHookups= function() {
				var avg = 0;
				var num = 0;
				vm.nightsOut.forEach(function(val) {
					avg += val.numberOfHookups;
					num++;
				})
				avg = avg/num;
				return avg;
			}
			
		},
		controllerAs :  "vm"
	});