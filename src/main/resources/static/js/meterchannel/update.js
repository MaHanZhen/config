var method = $("#method").val();

$(function () {
    
});


layui.use('form', function(){
    var form = layui.form;
    //监听提交
    form.on('submit(submit)', function(data){
        saveData(data);
        return false;
    });
});



function saveData(data) {
    var checkFlag = false;
    $.ajax({
        url:BaseParam.rootPath+"MeterChannel/checkSaveData"
        ,type:"post"
        ,data:data.field
        ,async:false
        ,success:function (result) {
            if(BaseParam.success == result.code){
                checkFlag = true;
            }
        }
    });

    if(checkFlag){
        postSaveData(data);
        return;
    }

    layer.confirm('存在相同的地址或名称,是否继续？', {
        btn: ['是','否'] //按钮
    }, function(){
        postSaveData(data);
    }, function(){});

}


function postSaveData(data) {
    var postData={};

    $.each(data.field,function (key,value) {
        if(isNotEmpty(value)){
            postData[key] = value;
        }
    });


    var url = BaseParam.rootPath+"MeterChannel/save";
    $.ajax({
        url:url,
        type:'post',
        data:postData,
        async:false,
        success:function (data) {
            if(BaseParam.success == data.code){
                parent.layer.msg('添加成功');
                closeLayUiWindow();
            }
        }
    });
}