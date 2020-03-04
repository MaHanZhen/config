var nowNode,pointTable,dTree;
$(function () {
    loadCfgTree();
});

layui.use('table', function () {
    var table = layui.table;
    pointTable = table.render({
        id: 'pointTable',
        elem: '#pointTable',
        toolbar: '#toolbar',
        url: BaseParam.rootPath + '/FactorDataGroupCfg/cfgPoint',
        method: "post",
        where: {},
        limit: 20,
        page: {curr: 1},
        cols: [[
            {type:'checkbox'},
            {field: 'name', title: '名称'},
            {field: 'uiControl', title: '控件'},
            {field: 'channelName', title: '信道名称'},
            {field: 'channelAddress', title: '信道地址'},
            {field: 'channelRate', title: '监测频率'},
            {field: 'handlerIdentify', title: '自定义监测方法'},
            {field: 'handlerFields', title: '自定义监测地址'},
            {field: 'handlerFieldRates', title: '自定义监测频率'},
            {fixed: 'right', title:'操作', align:'center', toolbar: '#bar', width:75}
        ]],
        page: true,
    });

    table.on('toolbar(pointTable)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'add':
                addConfigPoint();
                break;
            case 'delete':
                var data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
                break;
        };
    });

    //监听工具条
    table.on('tool(pointTable)', function(obj){
        var data = obj.data;
        if(obj.event === 'change'){
            layer.msg('ID：'+ data.id + ' 的查看操作');
        }
    });
});


function addConfigPoint() {
    layer.open({
        type: 2,
        title: '添加节点',
        shadeClose: true,
        shade: 0.8,
        area: ['750px', '500px'],
        content: BaseParam.rootPath + '/FactorDataGroupCfg/toNew' //iframe的url
    });
}

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
                            updateTreeNode(node);
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
            reloadPointTable();
        });
    });
}

function addTreeNode(node) {
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
function updateTreeNode(node) {
    if(node ==null || node.nodeId ==null){
        layer.msg("请选择节点");
        return ;
    }

    layer.prompt({title: '请输入节点名称',value:node.context},function(value, index, elem){
        var url = BaseParam.rootPath +"/FactorDataGroupCfg/updateTreeNode";
        var data = {
            id:node.nodeId,
            name:value
        };
        $.post(url,data, function(data){
            layer.msg("修改成功");
            dTree.reload("cfgTree",{});
            layer.close(index);
        });
    });
}

function deleteTreeNode(node) {
    if(node ==null || node.nodeId ==null){
        layer.msg("请选择节点");
        return ;
    }


    layer.confirm('确认删除该节点（节点下所有节点均会删除）?', {icon: 3, title:'提示'}, function(index){
        var url = BaseParam.rootPath +"/FactorDataGroupCfg/deleteTreeNode";
        var data = {
            id:node.nodeId
        };
        $.post(url,data, function(data){
            layer.msg("删除成功");
            dTree.reload("cfgTree",{});
            layer.close(index);
        });
        layer.close(index);
    });

}

function reloadPointTable() {
    pointTable.reload({where: { //设定异步数据接口的额外参数，任意设
            parentId: nowNode.nodeId,
        }
    })
}