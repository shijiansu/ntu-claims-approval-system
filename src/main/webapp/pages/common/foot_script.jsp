<script src="${pageContext.request.contextPath}/resources/script/common/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/common/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/common/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/common/additional-methods.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/common/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/common/docs.js"></script>
<script>
	function setActiMenu() {
		var menu = $('li#menu${sessionScope.activeMenu}');
		if (menu.length != 0) {
			menu.addClass("active");
		}
	}
	$(document).ready(function() {
		setActiMenu();
	});
</script>
