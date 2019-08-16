layui.use('form', function(){
    var form = layui.form;
    //监听提交
    form.on('submit(submit)', function(data){
        saveData(data);
        return false;
    });
});

function saveData(data) {

    var postData = clearArray(data.field);

    var url = BaseParam.rootPath+"Meter400V/save";
    $.ajax({
        url:url,
        type:'post',
        data:postData,
        async:false,
        success:function (data) {
            if(BaseParam.success == data.code){
                parent.layer.msg("添加成功");
                parent.initTable();
                closeLayUiWindow();
            }
        }
    });
}