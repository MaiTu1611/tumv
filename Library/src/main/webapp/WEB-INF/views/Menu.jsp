<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Admin</title>
</head>
<body>
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

				<ul class="nav nav-list">
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> Library Manager </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="/Library/Admin">
									<i class="menu-icon fa fa-caret-right"></i>
									Grammar
								</a>
								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="ListVocabularyForward">
									<i class="menu-icon fa fa-caret-right"></i>
									Lập Thẻ Độc Giả
								</a>
								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="ListVocabularyForward">
									<i class="menu-icon fa fa-caret-right"></i>
									Lập Thẻ Độc Giả
								</a>
								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="ListVocabularyForward">
									<i class="menu-icon fa fa-caret-right"></i>
									Tiếp Nhận Sách Mới
								</a>
								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="/Library/Admin">
									<i class="menu-icon fa fa-caret-right"></i>
									Cho Mượn Sách
								</a>
								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="ListVocabularyForward">
									<i class="menu-icon fa fa-caret-right"></i>
									Nhận Trả Sách
								</a>
								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="ListVocabularyForward">
									<i class="menu-icon fa fa-caret-right"></i>
									Lập Phiếu Thu Tiền Phạt
								</a>
								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="ListVocabularyForward">
									<i class="menu-icon fa fa-caret-right"></i>
									Lập Báo Cáo
								</a>
								<b class="arrow"></b>
							</li>
						</ul>
					</li>
				</ul><!-- /.nav-list -->

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>
</body>
</html>