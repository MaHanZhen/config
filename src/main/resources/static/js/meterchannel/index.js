layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#meterTable'
        ,url:'listMeterChannel'
        ,toolbar: '#toolbar'
        ,method:"post"
        ,cols: [[
            {type: 'checkbox'}
            ,{field:'id', title:'ID',hide:true}
            ,{field:'name', title:'名称'}
            ,{field:'address', title:'地址'}
            ,{field:'type', title:'类型'}
            ,{field:'dataLenght', title:'数据长度',hide:true}
            ,{field:'dataType', title:'数据类型'}
            ,{field:'rate', title:'采集频率'}
            ,{field:'method', title:'计算方式'}
            ,{field:'acc', title:'acc',hide:true}
            ,{field:'unit', title:'单位'}
            ,{field:'valueType', title:'值类型'}
            ,{field:'valueRange', title:'值范围'}
            ,{field:'hilo', title:'hilo'}
            ,{field:'canvirtualCount', title:'是否可以进行虚拟计算'}
        ]]
        ,page: true
    });
    table.on('toolbar(meterTable)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'add':
                toAdd();
                break;
            case 'delete':
                var data = checkStatus.data;
                break;
            case 'change':
                break;
            case 'search':
                break;
        }
    });
});


function toAdd() {
    layer.open({
        type: 2,
        area: ['700px', '450px'],
        shadeClose: true,
        content: 'toNew'
    });

}