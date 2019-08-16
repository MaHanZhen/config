var BaseParam ;

$(function () {
    initBaseParam();
});

function initBaseParam() {
    BaseParam = {
        rootPath:$("#rootPath").attr("href"),
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