
var meterTable;
var meterTableOptions={
    id:"meterTable"
    ,elem: '#meterTable'
    ,url:'listMeterChannel'
    ,toolbar: '#toolbar'
    ,method:"post"
    ,where:{}
    ,page: {
        curr: 1
    }
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
};
$(function(){
    loadMeterTable();
});

function loadMeterTable(){
    layui.use('table', function(){
        meterTable = layui.table;
        meterTable.render(meterTableOptions);
        meterTable.on('toolbar(meterTable)', function(obj){
            var checkStatus = meterTable.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':
                    toAdd();
                    break;
                case 'delete':
                    disable();
                    break;
                case 'change':
                    toChange();
                    break;
                case 'search':
                    search();
                    break;
            }
        });
        
        meterTable.on('checkbox(meterTable)',function (obj) {
            changeTableToolbar(meterTable);
        })
    });
}

function disable() {
    layer.confirm('确认删除信道？', {
        btn: ['是','否'] //按钮
    }, function(){
        postDisableData(meterTable,'meterTable',"disable");
    }, function(){});
}







function search() {
    var keyWord = $("#keyWord").val();
    meterTableOptions.where.keyWord = keyWord;
    loadMeterTable(meterTableOptions);
}


function toChange() {
    var checkStatus = meterTable.checkStatus('meterTable');
    var id = checkStatus.data[0].id;
    layer.open({
        type: 2,
        area: ['700px', '450px'],
        shadeClose: true,
        content:'toEdit?id='+id
    });
}


function toAdd() {
    layer.open({
        type: 2,
        area: ['700px', '450px'],
        shadeClose: true,
        content: 'toNew'
    });
}