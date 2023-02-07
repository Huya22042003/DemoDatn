window.DetailController = function ($scope, $http, $routeParams, $location) {
  $http.get(productAPI + "/" + $routeParams.id).then(
    function (response) {
      console.log(response.data);
      if (!response.data) {
        alert("Lỗi đường dẫn");
        $location.url("/home");
        return;
      }
      $scope.product = response.data;
    },
    function (response) {
      console.log(response);
    }
  );

  $scope.update = function () {
    let getFormData = {
      id: $routeParams.id,
      name: $scope.product.name,
      price: parseFloat($scope.product.price),
    };
    $http
      .put(productAPI + "/" + $routeParams.id, JSON.stringify(getFormData))
      .then(
        function (response) {
          if (!response.data) {
            alert(response.statusText);
            return;
          }
          alert("Sửa thành công");
          $location.url("/home");
        },
        function (response) {
          console.log(response.data);
        }
      );
  };

  $scope.delete = function () {
    $http.delete(productAPI + "/" + $routeParams.id).then(
      function (response) {
        if (!response.data) {
          alert(response.statusText);
          return;
        }
        alert("Xóa thành công");
        $location.url("/home");
      },
      function (response) {
        console.log(response.data);
      }
    );
  };
};
