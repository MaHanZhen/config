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