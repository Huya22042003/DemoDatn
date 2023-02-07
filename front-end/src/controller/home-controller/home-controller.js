window.HomeController = function ($scope, $http) {
  $http.get(productAPI).then(
    function (response) {
      console.log(response.data);
      $scope.listSanPham = response.data;
    },
    function (response) {
      console.log(response);
    }
  );

  $scope.add = function () {
    let getFormData = {
      id: $scope.listSanPham[$scope.listSanPham.length - 1].id,
      name: $scope.name,
      price: parseFloat($scope.price),
    };

    $http.post(productAPI, JSON.stringify(getFormData)).then(
      function (response) {
        if (response.data) {
          $scope.listSanPham.push(getFormData);
        } else {
          alert(response.statusText);
        }
      },
      function (response) {
        console.log(response.data);
      }
    );
  };
};
