
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script src="${pageContext.request.contextPath}/resources/script/chart/highcharts.js"></script>
<script src="${pageContext.request.contextPath}/resources/script/chart/exporting.js"></script>
<script>
$(document).ready(function() {
        $('#container').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: 'Personal Monthly Claim Amount (Approved)'
            },
            subtitle: {
                text: 'Source: Travel Expense Reimbursement Application v2.0'
            },
            xAxis: {
            	// replaced by Java
                categories: [${requestScope.xAxisCategories}]
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Claim Amount ($)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} $</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
           	// replaced by Java
            series: [${requestScope.series}]
        });
    });
</script>