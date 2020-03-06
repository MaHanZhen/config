var id = $("#id").val();
layui.use(['form','laytpl'],function () {
    var form = layui.form;


    form.on('select(meter400V)', function(data){
        loadTransformFormula(data.value);
    });

    form.on('select(channelId)', function(data){
        setChannelInfo(data.value);
    });


    form.on('submit(submit)', function(data){
        console.log(data.field);
        submitData(data.field);
        return false;
    });


    if("" != id ){
        $("#uiControl").attr("disabled","disabled");
    }

    loadMeter400V();
    loadTransformFormula(null);

});

function submitData(field) {
    var url = BaseParam.rootPath +"/FactorDataGroupCfg/saveCfgPoint";
    if("" != id){
        url = BaseParam.rootPath +"/FactorDataGroupCfg/updateCfgPoint"
    }
    $.post(url,field,function (result) {
        if(BaseParam.error == result.code){
            layer.msg(result.content);
            return;
        }

        parent.layer.msg("执行成功");
        parent.reloadPointTable();

        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    })
}

function setChannelInfo(channelId) {

    $.ajax({
        url:BaseParam.rootPath+"/MeterChannel/getMeterChannel",
        data:{id:channelId},
        type:"post",
        success:function (result) {
            console.log(result);
            $("#channelName").val(result.content.channelName);
            $("#channelAddress").val(result.content.channelAddress);
            $("#rate").val(result.content.rate);
        }
    })
}


function loadTransformFormula(meterId) {
    var url = BaseParam.rootPath +"/TransformFormula/listTransformFormula";
    if(null == meterId || "" == meterId){
        url = BaseParam.rootPath +"/MeterChannel/listMeterChannel"
    }
    $.post(url,{"meterId":meterId,page: 1,limit: 300},function (result) {
        var channelIdTemp = $("#channelIdTemp").html();

        layui.laytpl(channelIdTemp).render(result.data, function(html){
            $("#channelId").html(html);
            layui.form.render();
        });

    });
}

function loadMeter400V() {
    var url = BaseParam.rootPath +"/Meter400V/listMeter400V";
    $.post(url,{page: 1,limit: 300},function (result) {
        var meter400VTemp = $("#meter400VTemp").html();
        layui.laytpl(meter400VTemp).render(result.data, function(html){
            $("#meter400V").html(html);
            layui.form.render();
        });
    });
}

