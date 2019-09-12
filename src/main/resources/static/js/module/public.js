var BaseParam ;

$(function () {
    initBaseParam();
});

function initBaseParam() {
    BaseParam = {
        rootPath:"/cfg",
        success:200,
        error:400
    };
}

function closeLayUiWindow() {
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}

function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}

function isNotEmpty(obj) {
    return !isEmpty(obj);
}


function clearArray(arr) {
    var postData={};

    $.each(arr,function (key,value) {
        if(isNotEmpty(value)){
            postData[key] = value;
        }
    });
    return postData;
}


function postDisableData(table,status,url) {
    var checkStatus = table.checkStatus(status);
    var ids = "";
    checkStatus.data.forEach(function (meter) {
        ids+=meter.id+",";
    });

    $.ajax({
        url:url,
        type:"post",
        data:{ids:ids},
        success:function (result) {
            layer.msg("删除成功");
            table.reload(status);
        }
    })
}

function changeTableToolbar(table) {
    var checkStatus = table.checkStatus('meterTable');
    var length = checkStatus.data.length;
    if(length == 0){
        $("#option button[lay-event='delete']").addClass("layui-btn-disabled");
        $("#option button[lay-event='change']").addClass("layui-btn-disabled");
    }else if (length == 1){
        $("#option button[lay-event='delete']").removeClass("layui-btn-disabled");
        $("#option button[lay-event='change']").removeClass("layui-btn-disabled");
    }else if(length >1){
        $("#option button[lay-event='delete']").removeClass("layui-btn-disabled");
        $("#option button[lay-event='change']").addClass("layui-btn-disabled");
    }
}