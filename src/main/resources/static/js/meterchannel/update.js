var method = $("#method").val();
var oldName,oldAddress;
$(function () {
    initForm();
});

function initForm(){
    if("update" != method){
        return;
    }
    var id = $("#id").val();
    $.ajax({
        url:BaseParam.rootPath+"MeterChannel/getMeterChannel",
        data:{id:id},
        type:"post",
        success:function (result) {
            oldName = result.content.name;
            oldAddress= result.content.address;
            layui.use('form',function () {
                var form = layui.form;
                form.val('meterForm',result.content);
            })

        }
    })
}

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


    if("update" == method && (oldName == data.field.name && oldAddress == data.field.address)){
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

    var msg = "save" == method?"添加成功":"修改成功";

    var url = BaseParam.rootPath+"MeterChannel/save";
    $.ajax({
        url:url,
        type:'post',
        data:postData,
        async:false,
        success:function (data) {
            if(BaseParam.success == data.code){
                parent.layer.msg(msg);
                parent.meterTable.reload('meterTable');
                closeLayUiWindow();
            }
        }
    });
}