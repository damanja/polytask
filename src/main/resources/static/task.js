

angular.module('PolyTask',[]).controller('MainController', function($scope, $http){
    $http.get("/taskSet").then(function(response){
        $scope.tasks = response.data;
        console.log($scope.tasks);
    });

    $scope.ajouter = function(){
        $http.post("/addTask", $scope.formData).then(function(){
            $scope.formData = {};
            location.reload();
        })
    };

    $scope.modifier = function(task_id,content){
        $http.put("/modifyTask/" + task_id,content)
            .then(function(data){
                console.log(data);
                location.reload();
            })
    };

    $scope.supprimer = function(task_id){
        $http.delete("/deleteTask/" + task_id)
            .then(function(){
                console.log("ok");
                location.reload();
            })
    };

    $scope.deconnecter = function(){
        window.location.href='/logout';
    }
})
