<!DOCTYPE html><!--@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${goods.title}</title>
    <link href="./layui/css/layui.css" rel="stylesheet">
    <script src="./layui/layui.all.js"></script>
    <style>
        .bb-info li {
            margin-top: 20px;
        }

        .bb-description img {
            width: 100%;
        }

        .bb-param td:first-child {
            background-color: #eeeeee;
        }
        .layui-this a{
            font-size: 18px;
        }
    </style>
</head>
<body style="background-color: #eeeeee">
<ul class="layui-nav layui-bg-green">
    <div class="layui-container">
        <li class="layui-nav-item" style="background-color: orange;margin-left: -14px"><a href="javascript:void(0)" style="font-size: 18px;color: white">宝宝团商城</a></li>
        <li class="layui-nav-item layui-this"><a href="">宝宝团</a></li>
        <li class="layui-nav-item"><a href="">全球购</a></li>
        <li class="layui-nav-item"><a href="">旗舰店</a></li>
        <li class="layui-nav-item"><a href="">宝宝社区</a></li>
    </div>
</ul>

<div class="layui-container" style="padding: 10px;border: 1px solid #ccc;background-color:white">
    <span class="layui-breadcrumb" style="visibility: visible;">
      <a href="/">首页</a><span lay-separator="">/</span>
      <a><cite>${goods.title}</cite></a>
    </span>
    <div class="layui-row" style="padding-top: 10px">
        <div class="layui-col-xs4">
            <div class="layui-carousel" id="test1">
                <div carousel-item>
                    <#list covers as c>
                    <div>
                        <img src="${c.gcPicUrl}" style="width:100%">
                    </div>
                    </#list>
                </div>
            </div>
        </div>
        <div class="layui-col-xs8" style="padding: 10px">
            <ul class="bb-info">
                <li>
                    <h2>${goods.title}</h2>
                </li>

                <li class="layui-bg-green" style="padding:10px;line-height: 30px">
                ${goods.subTitle}
                </li>

                <li style="color: darkgrey">
                    <span>宝宝团价：</span><span style="font-size: 26px;color: orange;font-weight: bold">${goods.currentPrice?string('¥0.00')}</span><span
                        style="text-decoration: line-through">¥${goods.originalCost?string('¥0.00')}</span>
                </li>

                <li>
                    <span>运费： 6.0元 <#if goods.isFreeDelivery == 1>满58.0元包邮</#if></span>
                </li>
                <li>
                    数量：
                    <div class="layui-btn-group">
                        <button class="layui-btn layui-btn-primary layui-btn-sm">
                            <span style="font-size: 18px">-</span></button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" style="width: 50px">1</button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm"><span style="font-size: 18px">+</span>
                        </button>
                    </div>
                </li>
                <li>
                    <button class="layui-btn layui-btn-radius layui-btn-normal">立即购买</button>
                    <button class="layui-btn layui-btn-radius layui-btn-danger">加入购物车</button>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-row">
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
            <ul class="layui-tab-title">
                <li class="layui-this">产品详情</li>
                <li>产品参数</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show bb-description layui-col-xs8 layui-col-xs-offset2">
                    <#list details as d>
                    <img src="${d.gdPicUrl}">
                    </#list>
                </div>
                <div class="layui-tab-item layui-col-xs8 layui-col-xs-offset2">
                    <table class="layui-table bb-param" lay-size="lg">
                        <colgroup>
                            <col width="30%">
                            <col width="70%">
                        </colgroup>
                        <tbody>
                        <#list params as p>
                        <tr>
                            <td>${p.gpParamName}</td>
                            <td>${p.gpParamValue}</td>
                        </tr>
                        </#list>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    //由于模块都一次性加载，因此不用执行 layui.use() 来加载对应模块，直接使用即可：
    ;!function () {
        var layer = layui.layer
            , form = layui.form;

    }();
</script>
<script>
    layui.use('carousel', function () {
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            , width: '380px' //设置容器宽度
            , height: '380px'
            , arrow: 'hover' //始终显示箭头
            , anim: 'fade' //切换动画方式
        });
    });
</script>

</body>
</html>
