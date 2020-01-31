<!DOCTYPE html><!--@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>哇爱 孕产妇入院专用待产包【尖叫升级】12件套送8件升级为20件套待产包【专家型】</title>
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
      <a><cite>确认订单 </cite></a>
    </span>
    <div class="layui-row" style="padding-top: 10px">
        <div class="layui-col-xs4">
            <div class="layui-carousel" id="test1">
                <div carousel-item>
                    <div>
                        <img src="http://img04.meituncdn.com/group1/M00/9A/41/d7e5412c253b43a69f95f099a581f448.jpg?imageView2/2/w/450/h/450"
                             style="width:100%">
                    </div>
                    
                </div>
            </div>
        </div>
        <div class="layui-col-xs8" style="padding: 10px">
            <ul class="bb-info">
				
				<li>
                    <h1 >确认订单</h1>
                </li>
                <li>
                    <h2>哇爱 孕产妇入院专用待产包【尖叫升级】12件套送8件升级为20件套待产包【专家型】</h2>
                </li>

                <li class="layui-bg-green" style="padding:10px;line-height: 30px">
                    收件人：李明<span  style="margin-left:30px">联系电话：139XXXXXXXX</span><br/>
					收货地址：北京市海淀区XXX路XXX号<br/>
					
					<span>商品单价：¥19.80</span><span  style="margin-left:30px">购买数量：1包</span><br/>
					<span>商品总价：¥19.80</span><span  style="margin-left:30px">邮费：¥0.00</span><br/>
					
					实付款：<span style="font-size: 26px;color: orange;font-weight: bold">¥19.80</span><br/>
                </li>
                
                <li>
                    <button class="layui-btn layui-btn-normal layui-bg-red">支付</button>
                </li>
            </ul>
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

<script>
layui.use('util', function(){
  var util = layui.util;
  
  //示例
  var endTime = new Date().getTime() + (3600 * 1000 * 24) //假设为结束日期
  ,serverTime = new Date().getTime(); //假设为当前服务器时间，这里采用的是本地时间，实际使用一般是取服务端的
   
  util.countdown(endTime, serverTime, function(date, serverTime, timer){
    var str = date[0] + '天' + date[1] + '时' +  date[2] + '分' + date[3] + '秒';
    layui.$('#ds').html(str);
  });
});
</script>


</body>
</html>
