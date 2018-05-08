<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="responsive photo gallery using colorbox" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="/Library/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/Library/font-awesome/4.5.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet" href="/Library/css/colorbox.min.css" />

<!-- text fonts -->
<link rel="stylesheet" href="/Library/css/fonts.googleapis.com.css" />
<link rel="stylesheet" href="/Library/font/font-awesome.min.css" />
<!-- ace styles -->
<link rel="stylesheet" href="/Library/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
<link rel="stylesheet" href="/Library/css/ace-skins.min.css" />
<link rel="stylesheet" href="/Library/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="/Library/js/ace-extra.min.js"></script>

<title>Trang Quản Trị</title>
</head>
<body class="no-skin">
	<!-- Add Header -->
	<jsp:include page="../Header.jsp"></jsp:include>
	<!-- Add Menu -->
	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
		<jsp:include page="../Menu.jsp"></jsp:include>
		<!-- Main -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
						</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="container">
								<h2>Vertical (basic) Form</h2>
								<form>
									<div class="form-group">
										<label for="email">Email:</label> <input type="email"
											class="form-control" id="email" placeholder="Enter email">
									</div>
									<div class="form-group">
										<label for="pwd">Password:</label> <input type="password"
											class="form-control" id="pwd" placeholder="Enter password">
									</div>
									<div class="checkbox">
										<label><input type="checkbox"> Remember me</label>
									</div>
									<button type="submit" class="btn btn-default">Submit</button>
								</form>
							</div>
							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->
		<!-- Add Footer -->
		<jsp:include page="../Footer.jsp"></jsp:include>

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->
	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="/Library/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='/Library/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
	<script src="/Library/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->
	<script src="/Library/js/jquery.colorbox.min.js"></script>

	<!-- ace scripts -->
	<script src="/Library/js/ace-elements.min.js"></script>
	<script src="/Library/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
			jQuery(function($) {
	var $overflow = '';
	var colorbox_params = {
		rel: 'colorbox',
		reposition:true,
		scalePhotos:true,
		scrolling:false,
		previous:'<i class="ace-icon fa fa-arrow-left"></i>',
		next:'<i class="ace-icon fa fa-arrow-right"></i>',
		close:'&times;',
		current:'{current} of {total}',
		maxWidth:'100%',
		maxHeight:'100%',
		onOpen:function(){
			$overflow = document.body.style.overflow;
			document.body.style.overflow = 'hidden';
		},
		onClosed:function(){
			document.body.style.overflow = $overflow;
		},
		onComplete:function(){
			$.colorbox.resize();
		}
	};

	$('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
	$("#cboxLoadingGraphic").html("<i class='ace-icon fa fa-spinner orange fa-spin'></i>");//let's add a custom loading icon


	$(document).one('ajaxloadstart.page', function(e) {
		$('#colorbox, #cboxOverlay').remove();
   });
})
		</script>
</body>
</html>