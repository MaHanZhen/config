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
        var meterTable = layui.table;
        meterTable.render({
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
                    toAdd();
                    break;
                case 'change':
                    var data = checkStatus.data;
                    break;
                case 'delete':
                    break;
            };
        });

        meterTable.on('checkbox(meterTable)',function (obj) {
            changeTableToolbar(meterTable);
        })
    });
}

function initCollTable() {

}

function toAdd() {
    layer.open({
        type: 2,
        area: ['600px', '400px'],
        shadeClose: true,
        content: 'toNew'
    });
}