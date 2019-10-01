
$(function () {
    initMeterTable();
    loadCfgTree();
});

function initMeterTable() {
    layui.use('table', function(){
        meterTable = layui.table;
        meterTable.render({
            id:'meterTable',
            elem: '#meterTable',
            url:BaseParam.rootPath+'/Meter400V/listMeter400V',
            method:"post",
            where:{},
            limit:20,
            page: {curr: 1},
            cols: [[
                {field:'modelName',   title: '名称'},
                {field:'model', title: '类型'}
            ]],
            page:true,
            done: function(res, curr, count){
                if(count == 0){
                    return;
                }
                $("div[lay-id='meterTable'] tr[data-index='0']").click();
            }
        });

        //监听行单击事件（单击事件为：rowDouble）
        meterTable.on('row(meterTable)', function(obj){
            //标注选中样式
            obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
            loadCollTable(obj.data.id)
        });
    });
}

function loadCfgTree() {
    var data1 = [{
        title: '江西'
        ,id: 1
        ,children: [{
            title: '南昌'
            ,id: 1000
            ,children: [{
                title: '青山湖区'
                ,id: 10001
            },{
                title: '高新区'
                ,id: 10002
            }]
        },{
            title: '九江'
            ,id: 1001
        },{
            title: '赣州'
            ,id: 1002
        }]
    },{
        title: '广西'
        ,id: 2
        ,children: [{
            title: '南宁'
            ,id: 2000
        },{
            title: '桂林'
            ,id: 2001
        }]
    },{
        title: '陕西'
        ,id: 3
        ,children: [{
            title: '西安'
            ,id: 3000
        },{
            title: '延安'
            ,id: 3001
        }]
    }];

    //开启节点操作图标
    layui.use('tree', function(){
        var tree = layui.tree;

        tree.render({
            elem: '#cfgTree'
            ,data: data1
            ,edit: ['add', 'update', 'del'] //操作节点的图标
            ,click: function(obj){
                layer.msg(JSON.stringify(obj.data));
            }
        });
    });
}