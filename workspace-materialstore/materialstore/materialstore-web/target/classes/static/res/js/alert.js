function AlertResultBooks(cont, contentTitle, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = "<div class='resultBooks-contentText'>" +
        "<div class='resultBooks-contentTitle'>" + contentTitle + "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>未成交企业：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>测试投标人3</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>通知内容：</label>" +
        "<div class='form-textarea yui-col-8'>" +
        "<textarea class='textarea-control' placeholder='请填写评审内容'>经我公司仔细评审，很遗憾贵公司未成交！感谢贵公司对我公司本次xxxxxx项目工作的支持！对此深表感谢， 希望下次合作成功！</textarea>" +
        "</div>" +
        "</div>" +
        "</div>";
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        height: 350 - 105,
        okValue: "确定",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancelValue: "取消",
        cancel: true
    });

    D.showModal();
}

function onlineCaller(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = "<div class='resultBooks-contentText'>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>通知对象：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>所有参与项目供应商</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'><span class='zhu'>*</span>通知内容：</label>" +
        "<div class='form-textarea yui-col-8'>" +
        "<textarea class='textarea-control' placeholder='请录入回复内容'></textarea>" +
        "<span class='remainder'>" +
        "<span class='remainder-number'>0</span>/<span class='maxNumber'>250</span>" +
        "</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>附件：</label>" +

        "<div class='yui-upload yui-col-8'>" +
        "<input type='file' class='yui-file'>" +
        "<span class='yui-file-area'>" +
        "<i class='upload-icon'></i>" +
        "上传附件" +
        "</span>" +
        "</div>" +

        "</div>" +
        "</div>";
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        height: 350 - 105,
        okValue: "确定提交",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancelValue: "取消",
        cancel: true
    });

    D.showModal();
}


function askSupers(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = "<div class='askSupers-contentText'>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'><span class='zhu'>*</span>被提问供应商：</label>" +
        "<div class='yui-select-item yui-clearfix yui-skin-blue yui-col-8'>" +
        "<div class='yui-input-wrapper yui-fl'>" +
        "<select name='super'>" +
        "<option value='1'>测试供应商1</option>" +
        "<option value='2'>测试供应商2</option>" +
        "<option value='3'>测试供应商3</option>" +
        "</select>" +
        "</div>" +
        "</div>" +

        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'><span class='zhu'>*</span>通知内容：</label>" +
        "<div class='form-textarea yui-col-8'>" +
        "<textarea class='textarea-control' placeholder='请录入回复内容'></textarea>" +
        "<span class='remainder'>" +
        "<span class='remainder-number'>0</span>/<span class='maxNumber'>250</span>" +
        "</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>附件：</label>" +

        "<div class='yui-upload yui-col-8'>" +
        "<input type='file' class='yui-file'>" +
        "<span class='yui-file-area'>" +
        "<i class='upload-icon'></i>" +
        "上传附件" +
        "</span>" +
        "</div>" +

        "</div>" +
        "</div>";
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        height: 400 - 105,
        okValue: "确定提交",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancelValue: "取消",
        cancel: true
    });

    D.showModal();
}

/*查看提问*/
function watchProblem(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = "<div class='watchProblem-contentText'>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>提问企业名称：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name yui-bold'>安徽办公用品实业有限公司</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>提问时间：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>2016-5-4 16：00：00</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>问题内容：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>本产品型号为XSVB-1009，是否符合贵公司需求</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>附件：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>无</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>回复：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>需要进行前期考核</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>附件：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'><a href='#'>测试附件.jpg</a> <a href='' class='preview'>预览</a></span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>提问时间：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>2016-5-5 16：00：00</span>" +
        "</div>" +
        "</div>" +
        "</div>";
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        height: 400 - 105,
        okValue: "关闭",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancel: false
    });

    D.showModal();
}

function watchAskedProblem(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = "<div class='watchProblem-contentText'>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>提问企业名称：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name yui-bold'>安徽办公用品实业有限公司</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>问题内容：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>本产品型号为XSVB-1009，是否符合贵公司需求</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>附件：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>无</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>提问时间：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>2016-5-4 16：00：00</span>" +
        "</div>" +
        "</div>" +
        "<hr style='height:1px;border:none;border-top:1px dashed #ddd;margin-top: 10px;'>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>回复内容：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>本产品型号为XSVB-1009，是否符合贵公司需求</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>附件：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'><a href='#'>测试附件.jpg</a> <a href='' class='preview'>预览</a></span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>回复时间：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>2016-5-5 16：00：00</span>" +
        "</div>" +
        "</div>" +
        "</div>";
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        height: 400 - 105,
        okValue: "关闭",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancel: false
    });

    D.showModal();
}

function answerProblem(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = "<div class='answerProblem-contentText'>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>提问企业名称：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name yui-bold'>安徽办公用品实业有限公司</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>提问时间：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>2016-5-4 16：00：00</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>问题内容：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>本产品型号为XSVB-1009，是否符合贵公司需求</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>附件：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>无</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'><span class='zhu'>*</span>回复：</label>" +
        "<div class='form-textarea yui-col-8'>" +
        "<textarea class='textarea-control' placeholder='请录入回复内容'></textarea>" +
        "<span class='remainder'>" +
        "<span class='remainder-number'>0</span>/<span class='maxNumber'>250</span>" +
        "</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row yui-pt10'>" +
        "<label class='form-name yui-col-4'>附件：</label>" +
        "<div class='yui-upload yui-col-8 '>" +
        "<input type='file' class='yui-file'>" +
        "<span class='yui-file-area'>" +
        "<i class='upload-icon'></i>" +
        "上传附件" +
        "</span>" +
        "</div>" +

        "</div>" +
        "</div>";
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        height: 440 - 105,
        okValue: "确认提交",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancelValue: "取消",
        cancel: true
    });

    D.showModal();
}

function answerSupers(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = "<div class='answerSupers-contentText'>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>提问企业名称：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name yui-bold'>安徽办公用品实业有限公司</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>问题内容：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>本产品型号为XSVB-1009，是否符合贵公司需求</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>附件：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>无</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>提问时间：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>2016-5-4 16：00：00</span>" +
        "</div>" +
        "</div>" +
        "<hr style='height:1px;border:none;border-top:1px dashed #ddd;margin-top: 10px;'>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>回复内容：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>本产品型号为XSVB-1009，是否符合贵公司需求</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>附件：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'><a href='#'>测试附件.jpg</a> <a href='' class='preview'>预览</a></span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'>回复时间：</label>" +
        "<div class='yui-col-8'>" +
        "<span class='company-name'>2016-5-5 16：00：00</span>" +
        "</div>" +
        "</div>" +
        "<hr style='height:1px;border:none;border-top:1px dashed #ddd;margin-top: 10px;margin-bottom: 10px;'>" +
        "<div class='form-block yui-row'>" +
        "<label class='form-name yui-col-4'><span class='zhu'>*</span>回复：</label>" +
        "<div class='form-textarea yui-col-8'>" +
        "<textarea class='textarea-control' placeholder='请录入回复内容'></textarea>" +
        "<span class='remainder'>" +
        "<span class='remainder-number'>0</span>/<span class='maxNumber'>250</span>" +
        "</span>" +
        "</div>" +
        "</div>" +
        "<div class='form-block yui-row yui-pt10'>" +
        "<label class='form-name yui-col-4'>附件：</label>" +
        "<div class='yui-upload yui-col-8 '>" +
        "<input type='file' class='yui-file'>" +
        "<span class='yui-file-area'>" +
        "<i class='upload-icon'></i>" +
        "上传附件" +
        "</span>" +
        "</div>" +
        "</div>" +
        "</div>";
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        height: 500 - 105,
        okValue: '确认提交',
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancelValue: '关闭',
        cancel: true
    });

    D.showModal();
}

function watchChange(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="watchChange-contentText">' +
        '<div class="survey-details yui-row">' +
        '<div class="survey-left yui-col-6">' +
        '<div class="message">' +
        '<span class="message-name">原报价截止时间：</span>' +
        '<span class="message-text">2017-01-12 15：20：00</span>' +
        '</div>' +
        '<div class="message">' +
        '<span class="message-name">操作人：</span>' +
        '<span class="message-text">许苗苗</span>' +
        '</div>' +
        '</div>' +
        '<div class="survey-right yui-col-6">' +
        '<div class="message">' +
        '<span class="message-name">现报价截止时间：</span>' +
        '<span class="message-text">2017-10-11 09:46:55</span>' +
        '</div>' +
        '<div class="message">' +
        '<span class="message-name">操作时间：</span>' +
        '<span class="message-text">2017-10-11 09:46:55</span>' +
        '</div>' +
        '</div>' +
        '<div class="yui-row">' +
        '<div class="yui-col-12" style="padding-top: 0;">' +
        '<div class="message">' +
        '<span class="message-name">变更情况描述：</span>' +
        '<span class="message-text">由于报价时间不足三家，顾申请报价时间截止</span>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '<div class="record">审批记录：</div>' +
        '<table class="yui-table">' +
        '<colgroup>' +
        '<col width="15%">' +
        '<col width="15%">' +
        '<col width="15%">' +
        '<col width="15%">' +
        '<col width="15%">' +
        '<col width="20%">' +
        '</colgroup>' +
        '<thead>' +
        '<tr>' +
        '<th>审批步骤</th>' +
        '<th>处理人员</th>' +
        '<th>状态</th>' +
        '<th>处理步骤</th>' +
        '<th>处理时间</th>' +
        '<th>意见</th>' +
        '</tr>' +
        '</thead>' +
        '<tbody>' +
        '<tr>' +
        '<td>发起</td>' +
        '<td>张伟业</td>' +
        '<td>已发起</td>' +
        '<td>采购部门</td>' +
        '<td>2017-12-15  12：12：24</td>' +
        '<td>同意</td>' +
        '</tr>' +
        '<tr>' +
        '<td>发起</td>' +
        '<td>张伟业</td>' +
        '<td>已发起</td>' +
        '<td>采购部门</td>' +
        '<td>2017-12-15  12：12：24</td>' +
        '<td>同意</td>' +
        '</tr>' +
        '<tr>' +
        '<td>发起</td>' +
        '<td>张伟业</td>' +
        '<td>已发起</td>' +
        '<td>采购部门</td>' +
        '<td>2017-12-15  12：12：24</td>' +
        '<td>同意</td>' +
        '</tr>' +
        '</tbody>'
    '</table>'
    '</div>' +
    '</div>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 600,
        height: 470 - 105,
        okValue: "关闭",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancel: false
    });

    D.showModal();
}

function AlertAllMessage(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="allMessage">' +
        '<div class="AllMessageForm yui-clearfix">' +
        '<div class="yui-input-item yui-clearfix yui-skin-orange yui-fl">' +
        '<div class="yui-input-wrapper yui-fl">' +
        '<input class="yui-input" type="text" placeholder="请输入经营范围">' +
        '</div>' +
        '</div>' +
        '<div class="yui-upload yui-fl">' +
        '<input type="file" class="yui-file">' +
        '<span class="yui-file-area">' +
        '上传附件' +
        '</span>' +
        '</div>' +
        '</div>' +
        '<p class="template">只有下载<a href="">物资模板</a>按照平台格式才能成功导入报价</p>' +
        '</div>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 500,
        height: 300 - 105,
        okValue: "确认提交",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancelValue: '取消',
        cancel: true
    });

    D.showModal();
}

function watchBigPic(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="bigPic">' +
        '<images src="../images/super/credential.jpg" alt="" width="90%">' +
        '</div>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 800,
        height: 600 - 105,
        okValue: "关闭",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancelValue: false,
        cancel: false
    });

    D.showModal();
}


/* 仲来 */

/*
** 建档页面
添加部门弹框 */
function addDepartment(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = "<div class='addDepartment'><div class='yui-input-item yui-clearfix yui-skin-blue'><div class='yui-input-wrapper yui-fl'><input class='yui-input' type='text' placeholder='请输入搜索部门名称'></div></div><button class='yui-btn yui-btn-default yui-skin-blue'><i class='yui-icon icon-search'></i>搜索</button></div>";
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        height: 416,
        okValue: "确定",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancelValue: "关闭",
        cancel: true
    });
    D.showModal();
}

/* 添加项目组成员 */
function addProjectMember(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = "<div class='addProjectMember'><form><div class='yui-select-item yui-clearfix yui-skin-blue'><label class='yui-label-left yui-fl' for='input1'>常用成员</label><div class='yui-input-wrapper yui-fl'><select name='' id=''><option value=''>快捷选择常用成员</option><option value=''>1、徐苗苗、张建新、吴建立</option><option value=''>2、徐苗苗、钟灵达、吴建立</option><option value=''>3、徐苗苗、张建军、李莲娜</option><option value=''>4、徐苗苗、张建新、吴建立</option></select></div></div><div class='yui-input-item yui-clearfix yui-skin-blue'><span class='yui-label-left yui-fl' for='input1'><span class='requiredStar'>*</span>项目组成员</span><span class='formVal'>徐苗苗 (建项人员)</span></div><div class='yui-input-item yui-clearfix yui-skin-blue'><label class='yui-label-left yui-fl' for='input1'>需求部门</label><div class='yui-input-wrapper yui-fl'><input class='yui-input' type='text' value='张建军  陈伟杰  李莲娜'></div><a class='addBtn yui-fl' onclick='addMember('添加部门','')'>+ 添加成员</a></div></form></div><script src='js/selectordie.js'><\/script><script>$('select').selectOrDie();<\/script>";
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        height: 216,
        okValue: "确定",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancelValue: "关闭",
        cancel: true
    });
    D.showModal();
}

/* 修改建档信息弹框 */
function reviseArchiveInfo(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="reviseArchiveInfo"><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购项目编号：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="2017121214852188"></div></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购项目名称：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="询价管件采购一批"></div></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl">需求部门：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="招标部"></div><a class="addBtn">添加</a></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>项目组成员：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="徐苗苗"></div><a class="addBtn">添加</a></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>项目类型：</label><div class="yui-radio-item yui-skin-blue"><input name="" id="" type="radio"></div><label class="yui-label-right">货物</label><div class="yui-radio-item yui-skin-blue"><input name="" id="" type="radio"></div><label class="yui-label-right" >工程</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right" >服务</label></div><div class="yui-input-item yui-clearfix yui-skin-blue">' +
        '<label class="yui-label-left yui-fl"><span class="requiredStar">*</span>货物类型：</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">设备与备品备件</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">办公用品</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">劳保用品</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">大宗物资</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">其他</label></div><div class="yui-input-item yui-clearfix yui-skin-blue">' +
        '<label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购方式：</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">公开直接报价</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">公开预审后报价</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">邀请采购</label></div></div>' +
        '<script src="js/iCheck.min.js"><\/script><script>$("input").iCheck({checkboxClass: "yui-checkbox", radioClass: "yui-radio", checkedClass: "yui-checked"});<\/script>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 840,
        okValue: "保存草稿",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancelValue: "确定修改",
        cancel: true
    });
    D.showModal();
}

/* 批量导入物资弹框 */
function batchImport(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="batchImport"><h5>批量导入物资</h5>' +
        '<div class="yui-input-item yui-clearfix yui-skin-blue"><div class="yui-input-wrapper yui-fl"><input class="yui-input" type="text"></div><button class="yui-btn yui-btn-default yui-skin-blue">选择附件</button></div>' +
        '<div class="inputTip yui-fcolor-9">建议下载 <a href="">物资模板</a> 按招平台格式上传物资</div>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        okValue: "确定",
        ok: function () {
            if (fun) {
                fun();
            }
        },
        cancelValue: "返回",
        cancel: true
    });
    D.showModal();
}

/* 常用地址弹框 */
function commonAddress(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="commonAddress">' +
        '<table class="yui-table"><colgroup><col width="12%"><col width="76%"><col width="12%"></colgroup><thead><tr><th>序号</th><th>常用地址</th><th>操作</th></tr>' +
        '</thead><tbody><tr><td>1</td><td>安徽省合肥市蜀山区包河大道236号</td><td><a href="#">使用</a></td></tr>' +
        '<tr><td>1</td><td>安徽省合肥市蜀山区包河大道236号</td><td><a href="#">使用</a></td></tr><tr><td>1</td><td>安徽省合肥市蜀山区包河大道236号</td>' +
        '<td><a href="#">使用</a></td></tr><tr><td>1</td><td>安徽省合肥市蜀山区包河大道236号</td><td><a href="#">使用</a></td></tr>' +
        '</tbody></table>' +
        '<button class="yui-btn yui-btn-lineColor yui-skin-blue yui-mt20 yui-fr">+ 添加物资</button></div>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        okValue: "返回",
        ok: function () {
            if (fun) {
                fun();
            }
        }
    });
    D.showModal();
}

/* 常用付款方式弹框 */
function commonPayMethod(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="commonAddress">' +
        '<table class="yui-table"><colgroup><col width="12%"><col width="76%"><col width="12%"></colgroup><thead><tr><th>序号</th><th>常用地址</th><th>操作</th></tr>' +
        '</thead><tbody><tr><td>1</td><td>预付10%，货到付款70%，一年后补齐全款</td><td><a href="#">使用</a></td></tr>' +
        '<tr><td>1</td><td>预付10%，货到付款70%，一年后补齐全款</td><td><a href="#">使用</a></td></tr>' +
        '</tbody></table>' +
        '<button class="yui-btn yui-btn-lineColor yui-skin-blue yui-mt20 yui-fr">+ 常用付款方式</button></div>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        okValue: "返回",
        ok: function () {
            if (fun) {
                fun();
            }
        }
    });
    D.showModal();
}

/* 确认公告发布渠道弹框 */
function confirmBulletinChannel(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="commonAddress">' +
        '<table class="yui-table"><colgroup><col width="40%"><col width="40%"><col width="20%"></colgroup><thead><tr><th>发布网站</th><th>网址</th><th>操作</th></tr>' +
        '</thead><tbody><tr><td>优质采电子交易平台</td><td>http://www.youzhicai.com</td><td><div class="yui-checkbox-item yui-skin-blue"><input id="" type="checkbox"></div></td></tr>' +
        '<tr><td>安徽招标投标信息网</td><td>http://www.ahtba.org.cn</td><td><div class="yui-checkbox-item yui-skin-blue"><input id="" type="checkbox"></div></td></tr>' +
        '<tr><td>中国采购与招标网</td><td>http://www.chinabidding.com</td><td><div class="yui-checkbox-item yui-skin-blue"><input id="" type="checkbox"></div></td></tr>' +
        '</tbody></table>' +
        '<div class="yui-checkbox-item yui-skin-blue"><input id="" type="checkbox"></div><label class="yui-label-right">我已经阅读并同意《优质采采购公告发布规范》</label>' +
        '<script src="js/iCheck.min.js"><\/script><script>$("input").iCheck({checkboxClass: "yui-checkbox", radioClass: "yui-radio", checkedClass: "yui-checked"});<\/script>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        okValue: "返回",
        ok: function () {
            if (fun) {
                fun();
            }
        }
    });
    D.showModal();
}

/* 修改建档信息弹框 */
function reviseArchiveInfo(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="reviseArchiveInfo"><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购项目编号：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="2017121214852188"></div></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购项目名称：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="询价管件采购一批"></div></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl">需求部门：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="招标部"></div><a class="addBtn">添加</a></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>项目组成员：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="徐苗苗"></div><a class="addBtn">添加</a></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>项目类型：</label><div class="yui-radio-item yui-skin-blue"><input name="" id="" type="radio"></div><label class="yui-label-right">货物</label><div class="yui-radio-item yui-skin-blue"><input name="" id="" type="radio"></div><label class="yui-label-right">工程</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">服务</label></div><div class="yui-input-item yui-clearfix yui-skin-blue">' +
        '<label class="yui-label-left yui-fl"><span class="requiredStar">*</span>货物类型：</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">设备与备品备件</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">办公用品</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">劳保用品</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">大宗物资</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">其他</label></div><div class="yui-input-item yui-clearfix yui-skin-blue">' +
        '<label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购方式：</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">公开直接报价</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">公开预审后报价</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">邀请采购</label></div></div>' +
        '<script src="js/iCheck.min.js"><\/script><script>$("input").iCheck({checkboxClass: "yui-checkbox", radioClass: "yui-radio", checkedClass: "yui-checked"});<\/script>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 840,
        okValue: "确定修改",
        ok: function() {
            if (fun) {
                fun();
            }
        },
        cancelValue: "保存草稿",
        cancel: true
    });
    D.showModal();
}
/* 批量导入物资弹框 */
function batchImport(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="batchImport"><h5>批量导入物资</h5>' +
        '<div class="yui-input-item yui-clearfix yui-skin-blue"><div class="yui-input-wrapper yui-fl"><input class="yui-input" type="text"></div><button class="yui-btn yui-btn-default yui-skin-blue">选择附件</button></div>' +
        '<div class="inputTip yui-fcolor-9">建议下载 <a href="">物资模板</a> 按招平台格式上传物资</div>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        okValue: "确定",
        ok: function() {
            if (fun) {
                fun();
            }
        },
        cancelValue: "返回",
        cancel: true
    });
    D.showModal();
}
/* 常用地址弹框弹框 */
function commonAddress(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="commonAddress">' +
        '<table class="yui-table"><colgroup><col width="12%"><col width="76%"><col width="12%"></colgroup><thead><tr><th>序号</th><th>常用地址</th><th>操作</th></tr>' +
        '</thead><tbody><tr><td>1</td><td>安徽省合肥市蜀山区包河大道236号</td><td><a href="#">使用</a></td></tr>' +
        '<tr><td>1</td><td>安徽省合肥市蜀山区包河大道236号</td><td><a href="#">使用</a></td></tr><tr><td>1</td><td>安徽省合肥市蜀山区包河大道236号</td>' +
        '<td><a href="#">使用</a></td></tr><tr><td>1</td><td>安徽省合肥市蜀山区包河大道236号</td><td><a href="#">使用</a></td></tr>' +
        '</tbody></table>' +
        '<button class="yui-btn yui-btn-lineColor yui-skin-blue yui-mt20 yui-fr">+ 添加物资</button></div>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        okValue: "返回",
        ok: function() {
            if (fun) {
                fun();
            }
        }
    });
    D.showModal();
}
/* 常用付款方式弹框 */
function commonPayMethod(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="commonAddress">' +
        '<table class="yui-table"><colgroup><col width="12%"><col width="76%"><col width="12%"></colgroup><thead><tr><th>序号</th><th>常用付款方式</th><th>操作</th></tr>' +
        '</thead><tbody><tr><td>1</td><td>预付10%，货到付款70%，一年后补齐全款</td><td><a href="#">使用</a></td></tr>' +
        '<tr><td>1</td><td>预付10%，货到付款70%，一年后补齐全款</td><td><a href="#">使用</a></td></tr>' +
        '</tbody></table>' +
        '<button class="yui-btn yui-btn-lineColor yui-skin-blue yui-mt20 yui-fr">+ 常用付款方式</button></div>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        okValue: "返回",
        ok: function() {
            if (fun) {
                fun();
            }
        }
    });
    D.showModal();
}

/* 修改建档信息弹框 */
function reviseArchiveInfo(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="reviseArchiveInfo"><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购项目编号：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="2017121214852188"></div></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购项目名称：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="询价管件采购一批"></div></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl">需求部门：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="招标部"></div><a class="addBtn">添加</a></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>项目组成员：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="徐苗苗"></div><a class="addBtn">添加</a></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>项目类型：</label><div class="yui-radio-item yui-skin-blue"><input name="" id="" type="radio"></div><label class="yui-label-right">货物</label><div class="yui-radio-item yui-skin-blue"><input name="" id="" type="radio"></div><label class="yui-label-right">工程</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">服务</label></div><div class="yui-input-item yui-clearfix yui-skin-blue">' +
        '<label class="yui-label-left yui-fl"><span class="requiredStar">*</span>货物类型：</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">设备与备品备件</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">办公用品</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">劳保用品</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">大宗物资</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">其他</label></div><div class="yui-input-item yui-clearfix yui-skin-blue">' +
        '<label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购方式：</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">公开直接报价</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">公开预审后报价</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">邀请采购</label></div></div>' +
        '<script src="js/iCheck.min.js"><\/script><script>$("input").iCheck({checkboxClass: "yui-checkbox", radioClass: "yui-radio", checkedClass: "yui-checked"});<\/script>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 840,
        okValue: "保存草稿",
        ok: function() {
            if (fun) {
                fun();
            }
        },
        cancelValue: "确定修改",
        cancel: true
    });
    D.showModal();
}
/* 批量导入物资弹框 */
function batchImport(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="batchImport"><h5>批量导入物资</h5>'+
        '<div class="yui-input-item yui-clearfix yui-skin-blue"><div class="yui-input-wrapper yui-fl"><input class="yui-input" type="text"></div><button class="yui-btn yui-btn-default yui-skin-blue">选择附件</button></div>'+
        '<div class="inputTip yui-fcolor-9">建议下载 <a href="">物资模板</a> 按招平台格式上传物资</div>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        okValue: "确定",
        ok: function() {
            if (fun) {
                fun();
            }
        },
        cancelValue: "返回",
        cancel: true
    });
    D.showModal();
}

/* 修改建档信息弹框 */
function reviseArchiveInfo(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="reviseArchiveInfo"><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购项目编号：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="2017121214852188"></div></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购项目名称：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="询价管件采购一批"></div></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl">需求部门：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="招标部"></div><a class="addBtn">添加</a></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>项目组成员：</label><div class="yui-input-wrapper yui-fl"><input class="yui-input w360" type="text" value="徐苗苗"></div><a class="addBtn">添加</a></div><div class="yui-input-item yui-clearfix yui-skin-blue"><label class="yui-label-left yui-fl"><span class="requiredStar">*</span>项目类型：</label><div class="yui-radio-item yui-skin-blue"><input name="" id="" type="radio"></div><label class="yui-label-right">货物</label><div class="yui-radio-item yui-skin-blue"><input name="" id="" type="radio"></div><label class="yui-label-right">工程</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">服务</label></div><div class="yui-input-item yui-clearfix yui-skin-blue">' +
        '<label class="yui-label-left yui-fl"><span class="requiredStar">*</span>货物类型：</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">设备与备品备件</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">办公用品</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">劳保用品</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">大宗物资</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">其他</label></div><div class="yui-input-item yui-clearfix yui-skin-blue">' +
        '<label class="yui-label-left yui-fl"><span class="requiredStar">*</span>采购方式：</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">公开直接报价</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">公开预审后报价</label><div class="yui-radio-item yui-skin-blue">' +
        '<input name="" id="" type="radio"></div><label class="yui-label-right">邀请采购</label></div></div>' +
        '<script src="js/iCheck.min.js"><\/script><script>$("input").iCheck({checkboxClass: "yui-checkbox", radioClass: "yui-radio", checkedClass: "yui-checked"});<\/script>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 840,
        okValue: "保存草稿",
        ok: function() {
            if (fun) {
                fun();
            }
        },
        cancelValue: "确定修改",
        cancel: true
    });
    D.showModal();
}
/* 批量导入物资弹框 */
function batchImport(cont, fun) {
    var title = "<div class='title'>" + cont + "</div>";
    var contentText = '<div class="batchImport"><h5>批量导入物资</h5>'+
        '<div class="yui-input-item yui-clearfix yui-skin-blue"><div class="yui-input-wrapper yui-fl"><input class="yui-input" type="text"></div><button class="yui-btn yui-btn-default yui-skin-blue">选择附件</button></div>'+
        '<div class="inputTip yui-fcolor-9">建议下载 <a href="">物资模板</a> 按招平台格式上传物资</div>';
    var D = dialog({
        title: title,
        content: contentText,
        width: 540,
        okValue: "确定",
        ok: function() {
            if (fun) {
                fun();
            }
        },
        cancelValue: "返回",
        cancel: true
    });
    D.showModal();
}

/* 修改建档信息弹框 */
function inviteSuccess(cont, fun) {
    var ErrorCont = "<div class='warnIcon'><i></i></div><div class='warnTest'>" + cont+"</div><div class=''></div>";
    var D = dialog({
        title: "提示信息",
        content: ErrorCont,
        fixed:true,
        Icon: 'IconWrong',
        width: 540,
        height: 350-105,
        cancelValue: "关闭",
        cancel: true,
    });
    D.showModal();
}


/* 邹尚志 */
// dialog弹窗
//
// dialogTitle 弹窗标题
// contentId  内容DOM的id
// dialogWidth  弹窗宽度
// okText  确定按钮的文字
// cancelText 取消按钮的文字，为空则只有一个按钮
// fun 回调函数
//询价、比价、总价、展开页面
function alertMessage(dialogTitle, contentId, dialogWidth, okText, cancelText, fun) {
    if (cancelText){
        var showCancel = true
    }else{
        var showCancel = false
    }
    var title = '<div class="title">'+dialogTitle+'</div>';
    var contentText = $('#'+contentId+' .dialog-content').html();
    var D = dialog({
        title: title,
        content: contentText,
        width: dialogWidth,
        okValue: okText,
        ok: function() {
            if (fun) {
                fun();
            }
        },
        cancelValue: cancelText,
        cancel: showCancel
    });
    D.showModal();
}

//询价比价-时间截止
function alertMessage(dialogTitle, contentId, dialogWidth, okText, cancelText, fun) {
    if (cancelText){
        var showCancel = true
    }else{
        var showCancel = false
    }
    var title = '<div class="title">'+dialogTitle+'</div>';
    var contentText = $('#'+contentId+' .dialog-content').html();
    var D = dialog({
        title: title,
        content: contentText,
        width: dialogWidth,
        okValue: okText,
        ok: function() {
            if (fun) {
                fun();
            }
        },
        cancelValue: cancelText,
        cancel: showCancel
    });
    D.showModal();
}

// 询价比价2-未展示总价2
function alertMessage(dialogTitle, contentId, dialogWidth, okText, cancelText, fun) {
    if (cancelText){
        var showCancel = true
    }else{
        var showCancel = false
    }
    var title = '<div class="title">'+dialogTitle+'</div>';
    var contentText = $('#'+contentId+' .dialog-content').html();
    var D = dialog({
        title: title,
        content: contentText,
        width: dialogWidth,
        okValue: okText,
        ok: function() {
            if (fun) {
                fun();
            }
        },
        cancelValue: cancelText,
        cancel: showCancel
    });
    D.showModal();
}

// 询价比价-未展示总价
function alertMessage(dialogTitle, contentId, dialogWidth, okText, cancelText, fun) {
    if (cancelText){
        var showCancel = true
    }else{
        var showCancel = false
    }
    var title = '<div class="title">'+dialogTitle+'</div>';
    var contentText = $('#'+contentId+' .dialog-content').html();
    var D = dialog({
        title: title,
        content: contentText,
        width: dialogWidth,
        okValue: okText,
        ok: function() {
            if (fun) {
                fun();
            }
        },
        cancelValue: cancelText,
        cancel: showCancel
    });
    D.showModal();
}
