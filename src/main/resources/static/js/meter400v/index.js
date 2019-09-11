var meterTable,collTable;

$(function () {
   initTable();
});

function initTable() {
    initMeterTable();
    initCollTable()
}

function initMeterTable() {
    layui.use('table', function(){
        meterTable = layui.table;
        meterTable.render({
            id:'meterTable',
            elem: '#meterTable',
            url:'listMeter400V',
            toolbar:'#meterToolbar',
            method:"post",
            where:{},
            limit:20,
            page: {curr: 1},
            cols: [[
                {type: 'checkbox'},
                {field:'modelName', width:150,  title: '名称'},
                {field:'model',width:150,  title: '类型'},
                {field:'manufacturer',  title: '生产厂家'},
                {field:'ratedElectricity',  title: '额定电流'},
                {field:'ratedVolt',  title: '额定电压'},
            ]],
            page:true,
        });
        meterTable.on('toolbar(meterTable)', function(obj){
            var checkStatus = meterTable.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':
                    toAddMeter();
                    break;
                case 'change':
                    toChangeMeter();
                    break;
                case 'delete':
                    disableMeter();
                    break;
            }
        });

        meterTable.on('checkbox(meterTable)',function (obj) {
            changeTableToolbar(meterTable);
        })

        //监听行单击事件（单击事件为：rowDouble）
        meterTable.on('row(meterTable)', function(obj){
            //标注选中样式
            obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
        });
    });
}

function initCollTable() {

}


function disableMeter() {
    layer.confirm('确认删除监测表？', {
        btn: ['是','否'] //按钮
    }, function(){
        postDisableData(meterTable,'meterTable',"disable");
    }, function(){});
}

function toAddMeter() {
    layer.open({
        type: 2,
        area: ['600px', '400px'],
        shadeClose: true,
        content: 'toNew'
    });
}

function toChangeMeter() {
    var checkStatus = meterTable.checkStatus('meterTable');
    var id = checkStatus.data[0].id;
    layer.open({
        type: 2,
        area: ['600px', '400px'],
        shadeClose: true,
        content:'toEdit?id='+id
    });
}