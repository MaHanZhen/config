var nowNode,cfgTable,dTree;
$(function () {
    loadCfgTree();
});


layui.use('table', function () {
    var table = layui.table;
    cfgTable = table.render({
        id: 'cfgTable',
        elem: '#cfgTable',
        url: BaseParam.rootPath + '/FactorDataGroupCfg/cfgPoint',
        method: "post",
        where: {},
        limit: 20,
        page: {curr: 1},
        cols: [[
            {field: 'name', title: '名称'},
            {field: 'uiControl', title: '控件'},
            {field: 'channelName', title: '信道名称'},
            {field: 'channelAddress', title: '信道地址'},
            {field: 'channelRate', title: '监测频率'},
            {field: 'handlerIdentify', title: '自定义监测方法'},
            {field: 'handlerFields', title: '自定义监测地址'},
            {field: 'handlerFieldRates', title: '自定义监测频率'},
        ]],
        page: true,
    });
});

function loadCfgTree() {
    layui.extend({
        dtree: BaseParam.rootPath + '/js/module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
    }).use(['dtree', 'layer', 'jquery'], function () {
        dTree = layui.dtree, layer = layui.layer, $ = layui.jquery;

        // 初始化树
        var cfgTree = dTree.render({
            elem: "#cfgTree",
            url: BaseParam.rootPath + "/FactorDataGroupCfg/cfgTree",
            dataFormat: "list",
            menubar:true,
            initLevel: "1",
            menubarTips:{
                freedom:[{menubarId:"add",handler:function(node){
                        addTreeNode(node);
                    }},
                    {menubarId:"change",handler:function(node){
                        changeTreeNode(node);
                        }},
                    {menubarId:"delete",handler:function(node){
                        deleteTreeNode(node);
                        }}
                ],
                group:[] // 按钮组制空
            }
        });

        // 绑定节点点击
        dTree.on("node('cfgTree')", function (obj) {
            nowNode = obj.param;
            reloadCfgTable();
        });
    });
}

function addTreeNode(node) {
    console.log(node);
    if(node.level>=3){
        layer.msg("禁止在此节点下继续添加子节点");
        return ;
    }

    layer.prompt({title: '请输入节点名称'},function(value, index, elem){
        var url = BaseParam.rootPath +"/FactorDataGroupCfg/addTreeNode";
        var data = {
            parentId:node.nodeId,
            name:value
        };
        $.post(url,data, function(data){
            layer.msg("添加成功");
            dTree.reload("cfgTree",{});
            layer.close(index);
        });
    });
}
function changeTreeNode(node) {

}
function deleteTreeNode(node) {

}

function reloadCfgTable() {
    cfgTable.reload({where: { //设定异步数据接口的额外参数，任意设
            parentId: nowNode.nodeId,
        }
    })
}