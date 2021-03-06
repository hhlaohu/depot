(function ($) {
    var Module = {
        base: function (param) {
            param = param || {};
            var pickID = param.pickID || "imgFileBtn",
                objID = param.objID || "fileList",
                $list = $("#" + objID),
                pic_desc = param.pic_desc || '',
                pic_type = param.pic_type || '',
                order_sn = param.order_sn || '',
                usr_order_id = param.usr_order_id || '',
                sequence = param.sequence || '',
                app_id = param.app_id || '',
                storage = param.storage || "temp";
            seajs.use("webuploader/webuploader", function () {
                if (!WebUploader.Uploader.support()) {
                    layer.alert('Web Uploader 不支持您的浏览器！如果你使用的是IE浏览器，请尝试升级 flash 播放器');
                    return;
                    throw new Error('WebUploader does not support the browser you are using.');
                }
                var isSingle = param.isSingle || false,
                    isCover = param.isCover || false,
                    isBanner = param.isBanner || false,
                    // 优化retina, 在retina下这个值是2
                    ratio = window.devicePixelRatio || 1,
                    // 缩略图大小
                    thumbnailWidth = (param.thumbnailWidth ) * ratio,
                    thumbnailHeight = (param.thumbnailHeight ) * ratio,
                    fileSizeLimit = param.fileSizeLimit || 50,
                    fileSingleSizeLimit = param.fileSingleSizeLimit || 20,
                    accept = param.accept || {
                            title: "请选择正确类型图片",
                            extensions: "gif,jpg,jpeg,png",
                            mimeTypes: "image/*"
                        };
                if (isSingle) {
                    var fileNumLimit = 100;
                } else {
                    var fileNumLimit = param.fileNumLimit || 5;
                }
                var uploader = WebUploader.create({
                    pick: {
                        id: "#" + pickID
                    },
                    formData: {
                        pic_type: pic_type,
                        pic_desc: pic_desc,
                        usr_order_id: usr_order_id,
                        order_sn: order_sn,
                        app_id: app_id
                    },
                    auto: true, // 自动上传
                    compress: false,
                    swf: "/Style/Js/webuploader/Uploader.swf", //swf文件路径
                    prepareNextFile: true,
                    //chunked: true,
                    //chunkSize: 512 * 1024,
                    accept: accept,
                    thumb: {
                        width: thumbnailWidth,
                        height: thumbnailHeight,
                        quality: 100,
                        allowMagnify: true,
                        crop: true,
                        type: "image/jpeg"
                    },
                    fileNumLimit: fileNumLimit,
                    fileSizeLimit: fileSizeLimit * 1024 * 1024, // 50 M
                    fileSingleSizeLimit: fileSingleSizeLimit * 1024 * 1024 // 20 M
                });
                // 当有文件添加进来的时候
                uploader.on("fileQueued", function (file) {
                    if (isSingle) { //单个图片
                        if (pickID == "signageFileBtn") {
                            var $panel = '<p class="file-panel"><a class="icon-view js-viewImg" title="预览"></a><a class="icon-cancel js-cancel" title="删除"></a></p>';
                        } else {
                            var $panel = '<p class="file-panel"><a class="icon-view js-viewImg" title="预览"></a></p>';
                        }
                        var $li = $(
                                '<div id="' + file.id + '" class="file-item thumbnail">' + $panel +
                                '<img width="100%" height="100%" />' +
                                '</div>'
                            ),
                            $img = $li.find('img');
                        $list.html($li);
                    } else {
                        if ($(".file-item", $list).length >= fileNumLimit) {
                            $.wrongMsg("最多只能上传" + fileNumLimit + "张图片");
                            return;
                        }
                        var $li = $(
                                '<div id="' + file.id + '" class="file-item thumbnail">' +
                                '<p class="file-panel">' +
                                '<a class="icon-view js-viewImg" title="预览"></a>' +
                                '<a class="icon-cancel js-cancel" title="删除"></a>' +
                                '</p>' +
                                '<img width="100%" height="100%" />' +
                                '</div>'
                            ),
                            $img = $li.find('img');
                        $list.append($li);
                    }
                    if (file.type == "application/pdf") {
                        $li.html('<p class="file-panel"><a class="icon-download js-download" title="下载" target="_blank"></a></p><img width="200" height="200" src="/Styles/H/images/doc/psf.png" /><p class="info"></p>')
                    }
                    // 创建缩略图
                    uploader.makeThumb(file, function (error, src) {
                        if (error) {
                            return;
                        }
                        $.post(
                            "/depot_background/user/uploadPicture3.do", {
                                src: src,
                                pic_desc: pic_desc,
                                pic_type: pic_type,
                                order_sn: order_sn,
                                usr_order_id: usr_order_id,
                                sequence: sequence
                            },
                            function (data) {
                                // var data = JSON.parse(data);
                                if (data.code == 0) {
                                    var src = data.return_param.pic_path;
                                    $img.attr("src", src);
                                } else {
                                    $img.replaceWith('<p style="font-size:14px;text-align:center;">预览出错</p>');
                                }
                            }
                        );

                    }, 140, 140);

                    /*删除图片*/
                    $list.on("click", ".js-cancel", function () {
                        uploader.removeFile(file, true);
                    });
                });

                // 文件上传过程中创建进度条实时显示。
                uploader.on("uploadProgress", function (file, percentage) {
                    var $li = $("#" + file.id),
                        $percent = $li.find('.file-progress span');
                    // 避免重复创建
                    if (!$percent.length) {
                        $percent = $('<p class="file-progress"><span></span></p>').appendTo($li).find('span');
                    }
                    $percent.css('width', percentage * 100 + '%');
                });

                // 文件上传成功，把文件上传记录到html，等表单上传再统一处理。
                uploader.on("uploadSuccess", function (file, ret) {
                    if ($("#data_pic").length > 0) {
                        $("#data_pic").html();
                        var pic_addr = ret.return_param.pic_path;
                        var pic = {
                            pic_desc: pic_desc,
                            pic_type: pic_type,
                            order_sn: order_sn,
                            usr_order_id: usr_order_id,
                            sequence: sequence,
                            app_id: app_id,
                            pic_addr: pic_addr
                        };
                        var src = JSON.stringify(pic);
                        var data_pic_html = ("<input name='data_pic_list' hidden='hidden' value='" + src + "'>");
                        $("#data_pic").append(data_pic_html);
                    }
                });

                // 文件上传失败，现实上传出错。
                uploader.on('uploadError', function (file) {
                    var $li = $('#' + file.id),
                        $error = $li.find('div.error');
                    // 避免重复创建
                    if (!$error.length) {
                        $error = $('<div class="file-error"></div>').appendTo($li);
                    }
                    $error.text('上传失败');
                });

                // 接收服务器数据
                uploader.on('uploadAccept', function (object, ret) {
                    if (ret.code != 0) {
                        $("#fileList .file-item:last").remove();
                        layer.alert("不支持该图片格式!");
                    } else {
                        var rel_src = ret.return_param.pic_path;
                        var file_type = ret.file_type || "";
                        if (file_type == "pdf") {
                            $("#" + ret.id).find(".js-download").attr("href", rel_src);
                        } else {
                            $("#" + ret.id).find("img").attr("data-rel", rel_src);
                        }
                    }
                });

                // 完成上传完了，成功或者失败，先删除进度条
                uploader.on('uploadComplete', function (file) {
                    $("#" + file.id).find(".file-progress").remove();
                    if (isCover) {
                        $("#" + file.id).append('<p class="info"><label><input type="radio" name="cover" class="ver-2" value="1" /> 设为封面</label></p>');
                        $(".file-item:eq(0)", $list).find(".info input").attr("checked", true);
                    } else if (isBanner) {
                        var adv_html = $('.js-goods-select').html();

                        $("#" + file.id).append('<p class="info"><label><input type="radio" name="cover" class="ver-2" value="1" /> 设为首图</label></p><p class="chained">链接到商品：' + adv_html + '</p>');

                        $(".file-item:eq(0)", $list).find(".info input").attr("checked", true);
                    } else {
                        $("#" + file.id).find(".info").html(file.name);
                    }
                });
                // 错误信息
                uploader.onError = function (code) {
                    console.log(code)
                    if (code == "Q_EXCEED_NUM_LIMIT") {
                        $.wrongMsg("最多只能上传" + fileNumLimit + "张图片");
                    }
                    if (code == "F_EXCEED_SIZE") {
                        $.wrongMsg("图片大小不能超过" + fileSingleSizeLimit + "M");
                    }
                    if (code == "F_DUPLICATE") {
                        $.wrongMsg("图片已经重复");
                    }
                    if (code == "Q_TYPE_DENIED") {
                        $.wrongMsg("图片格式不支持");
                    }
                };
            });
            //图片悬停/离开
            $($list).on("mouseenter", ".file-item", function () {
                $(".file-panel", this).stop().animate({height: 25});
            }).on("mouseleave", ".file-item", function () {
                $(".file-panel", this).stop().animate({height: 0});
            })
            /*
             *删除上传图片
             */
            $($list).on("click", ".js-cancel", function () {
                $(this).closest(".file-item").remove();
            });
            //图片预览
            $($list).on("click", ".js-viewImg", function () {
                var sImg = $(this).closest(".file-item").find("img"),
                    src = sImg.data("rel"),
                    bImg = '<img src="' + src + '" style="max-width:800px;max-height:600px;vertical-align:middle;" />';
                layer.open({
                    type: 1,
                    title: false,
                    area: ['auto', 'auto'],
                    //closeBtn: 0,
                    shadeClose: true,
                    content: '<p style="min-width:300px;min-height:300px;line-height:280px;padding:20px;text-align:center;">' + bImg + '</p>'
                });
            });
        }
    }
    //$.getCss("/Style/Js/webuploader/style.css");
    define("webuploader/upload", function (require, exports, module) {
        module.exports = Module;
    });
})(jQuery);