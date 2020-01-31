<!DOCTYPE html><!--@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>继续等待</title>
    <script src="https://cdn.bootcss.com/limonte-sweetalert2/7.21.1/sweetalert2.all.min.js"></script>
</head>
<body>
    <script>
        swal({
            title: "正在创建订单，请稍候...",
            timer : 3000,
            confirmButtonText: "刷新",
            type: "info"
        }).then(function (result) {
            window.location.href = "/checkorder?orderNo=${orderNo}";
        });
    </script>
</body>
</html>