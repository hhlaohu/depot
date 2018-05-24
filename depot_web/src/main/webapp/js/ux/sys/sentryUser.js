$package('YiYa.sentryUser');
YiYa.sentryUser = function(){
	var _box = null;
	var _this = {
		updatePwdAction:'updatePwd.do',
		editPwdForm:function(){
			return $("#pwdForm");
		},
		editPwdWin:function(){
			return $("#edit-pwd-win");
		},
		savePwd:function(){
			if(_this.editPwdForm().form('validate')){
				_this.editPwdForm().attr('action',_this.updatePwdAction);
				YiYa.saveForm(_this.editPwdForm(),function(data){
					_this.editPwdWin().dialog('close');
				});
			 }
		},
		initForm:function(){
			//修改密码
			_this.editPwdWin().find("#btn-pwd-submit").click(function(){
				_this.savePwd();
			});
			_this.editPwdWin().find("#btn-pwd-close").click(function(){	
				$.messager.confirm('确定','确定关闭窗口?',function(r){  
				    if (r){  
				     	_this.editPwdWin().dialog('close');
				    }  
				});
			});
		},
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
                idField: "sentry_user_id",
	   			url:'dataList.do',
	   			columns:[[
						{field:'sentry_user_id',checkbox:true},
						{field:'user_name',title:'用户名',align:'center',width:120,sortable:true},
						{field:'real_name',title:'真实姓名',align:'center',width:120,sortable:true},
						{field:'state',title:'状态',width:80,align:'center',sortable:true,styler:function(value,row,index){
							if(value == 1){
							  return 'color:red;';  
							}
						},
						formatter:function(value,row,index){
							if(value == 0){
								return "可用";
							}
							if(value == 1){
								return "禁用";
							}
						}},
						{field:'crete_time',title:'创建时间',align:'center',width:180,sortable:true},
						{field:'login_cnt',title:'登录总次数',align:'center',width:80,sortable:true},
						{field:'login_time',title:'最后登录时间',align:'center',width:180,sortable:true},
				]],
				toolbar:[
					{id:'btnadd',text:'新增',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btnedit',text:'修改密码',btnType:'editPwd',iconCls:'icon-edit',handler:function(){
							var selected = _box.utils.getCheckedRows();
							if ( _box.utils.checkSelectOne(selected)){
								_this.editPwdForm().resetForm();
								_this.editPwdForm().find("input[name='sentry_user_id']").val(selected[0].sentry_user_id);
								_this.editPwdForm().find("input[name='user_name']").val(selected[0].user_name);
								_this.editPwdWin().window('open'); 
							}
						}},
					{id:'btndelete',text:'删除',btnType:'remove',handler:function(){
						var selected = _box.utils.getCheckedRows();
						if ( _box.utils.checkSelectOne(selected)){
								_box.handler.remove();
						}
					}}
				]
			}
		},
		init:function(){
			_this.initForm();
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	YiYa.sentryUser.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){
		var minHeight = $(window).height()-$("#searchPanel").outerHeight()-60;
		minHeight=minHeight>200?minHeight:200;
		$("#data-list").datagrid('resize',{height:minHeight});
	}
});		