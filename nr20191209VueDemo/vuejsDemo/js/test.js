var vue = new Vue({
    el: "#app",
    data: {
        user: {
            id: "",
            username: "",
            password: "",
            age: "",
            sex: "",
            email: ""
        },
        userList: []
    },
    methods: {
        findAll: function () {
            var _this = this;
            axios.get("http://localhost:8888/user/findAll", {params: {}})
                .then(
                    function (value) {
                        console.dir(value.data.list)
                        _this.userList = value.data.list;
                    }
                )
                .catch(
                    function (reason) {
                        alert(reason);
                    }
                );
        },
        findById: function (userId) {
            var _this = this;
            axios.get("http://localhost:8888/user/findById", {params: {id:userId}})
                .then(function (value) {
                    _this.user = value.data.t;
                    console.dir(value.data.t);
                    $("#myModal").modal("show");
                })
                .catch(function (reason) {
                    alert(reason)
                })
        },
        update: function () {
            var _this = this;
            axios.post("http://localhost:8888/user/updateUser",this.user)
                .then(function (value) {
                    _this.findAll();
                })
                .catch(
                    function (reason) {
                        alert(value);
                        _this.findAll();
                    }
                )
        }
    },
    created:function () {
        console.dir(111);
        this.findAll();
    }
})