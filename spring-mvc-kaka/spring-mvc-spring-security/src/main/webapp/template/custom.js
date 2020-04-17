
$("#btnDeleteBuildings").click(function(e) {
    e.preventDefault();
    var data = {};
    var buildingIds = $("#buildingList").find('tbody input[type=checkbox]:checked').map(function() {
        return $(this).val();
    }).get();
    if (buildingIds.length < 1) {
        alert("bạn chưa chọn toà nhà");
        return 0;
    }
    data['ids'] = buildingIds;
    var thongbao = confirm("Bạn có chắc chắn muốn xoá ");
    if (thongbao == true) {
        //gọi ajax xoá toà nhà
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/admin/building/delete",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function(response) {
                console.log("sucess");
            },
            error: function(response) {
                console.log("fail");
            }
        });
        var i;
        for (i = 0; i < buildingIds.length; i++) {
            document.getElementById(`tr_${buildingIds[i]}`).remove();
        }
    }

});

$("#btnCapNhatToaNha").click(function(e) {	
    e.preventDefault();
   
    var data = {};
    var buildingTypes = [];
    var formData = $("#formedit").serializeArray(); 

    $.each(formData, function(index, v) {
        if (v.name == 'buildingTypes') {
            buildingTypes.push(v.value);
        } else {
            data[v.name] = v.value;
        }
    });
    data['buildingTypes'] = buildingTypes;
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/admin/building/edit",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        success: function(response) {
            console.log("sucess");
            Swal.fire({
                icon: 'success',
                title: 'Cập nhật toà nhà thành công',
                timer: 1000
            })

            console.log(response);
        },
        error: function(response) {
            console.log("fail");
            console.log(response);
        }
    });
});