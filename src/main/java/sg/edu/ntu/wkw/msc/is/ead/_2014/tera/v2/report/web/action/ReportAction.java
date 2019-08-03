package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.web.action;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.displaytag.decorator.TableDecorator;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.common.DateUtil;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.facade.FacadeServiceLocator;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.facade.intf.ReportFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.helper.ReportHelper;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.helper.ReportHelperFactory;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.model.Report;
import au.com.bytecode.opencsv.CSVWriter;

/**
 * The Class ReportAction.
 */
public class ReportAction extends ReportRoot {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3499231484069155330L;

	/**
	 * Construct report.
	 *
	 * @return the report
	 */
	private Report constructReport() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String reportId = request.getParameter("inputReportId");
		Report report = getNewEntity();
		report.setId(new Long(reportId));
		String reportType = request.getParameter("selectReportType");
		report.setReportType(reportType);
		if (Report.REPORT_INDIVIDUAL_CLAIM_SUM.toString().equalsIgnoreCase(reportId) || Report.REPORT_INDIVIDUAL_CLAIM_ITEMS.toString().equalsIgnoreCase(reportId)) {
			String userId = request.getParameter("selectUser");
			String year = request.getParameter("selectYear");
			String month = request.getParameter("selectMonth");
			String formStatusId = request.getParameter("selectFormStatus");
			List<Object> reportParams = new ArrayList<Object>();
			reportParams.add("".equalsIgnoreCase(userId) ? null : new Long(userId));
			reportParams.add("".equalsIgnoreCase(year) ? null : new Long(year));
			reportParams.add("".equalsIgnoreCase(month) ? null : month);
			reportParams.add("".equalsIgnoreCase(formStatusId) ? null : new Integer(formStatusId));
			report.setReportParams(reportParams);
		}
		report = getFacade().getReport(report);
		return report;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetCreate()
	 */
	@Override
	public String doGetCreate() {
		// do nothings
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetDelete()
	 */
	@Override
	public String doGetDelete() {
		// do nothings
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetEdit()
	 */
	@Override
	public String doGetEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		String reportId = null;
		Report report = (Report) request.getAttribute("report");
		// first entry
		if (report == null) {
			report = getNewEntity();
			reportId = request.getParameter("inputReportId");
			report.setId(new Long(reportId));
		}
		// from doPostEdit(), return back with report content
		else {
			reportId = String.valueOf(report.getId());
		}
		if (Report.REPORT_INDIVIDUAL_CLAIM_SUM.toString().equalsIgnoreCase(reportId) || Report.REPORT_INDIVIDUAL_CLAIM_ITEMS.toString().equalsIgnoreCase(reportId)) {
			setYears(request);
			setMonths(request);
			setFormStatuses(request);
			setUsers(request);
		}
		request.setAttribute("report", report);
		TableDecorator myDecorator = totalDecorator;
		if ("C".equalsIgnoreCase(report.getReportType())) {
			myDecorator = subtotalDecorator;
		}
		request.setAttribute("myDecorator", myDecorator);
		return reportEditPages.get(reportId);
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetList()
	 */
	@Override
	public String doGetList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		request.setAttribute("reports", REPORTS);
		return ACTION_LIST;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doGetView()
	 */
	@Override
	public String doGetView() {
		// do nothings
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doPostCreate()
	 */
	@Override
	public String doPostCreate() {
		// do nothings
		return null;
	}

	/**
	 * Do post download.
	 *
	 * @return the string
	 */
	public String doPostDownload() {
		HttpServletResponse response = ServletActionContext.getResponse();
		//
		try {
			Report report = constructReport();
			String exportName = report.getReportShortName() + "_" + DateUtil.TIME_FORMATOR.format(report.getGenerateTime());
			response.setContentType("text/plain");
			response.setHeader("Content-Disposition", "attachment;filename=" + exportName + ".csv");
			OutputStream os = response.getOutputStream();
			CSVWriter writer = new CSVWriter(new OutputStreamWriter(os));
			ReportHelper helper = ReportHelperFactory.getHelper(report.getId());
			if (helper != null) {
				List<List<String>> contentList = helper.getReportContentList(report.getContent());
				for (List<String> row : contentList) {
					writer.writeNext(row.toArray(new String[] {}));
				}
				writer.close();
				os.flush();
				try {
					os.close();
				} catch (Exception ex) {
					// do nothings
					ex.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return doGetEdit();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#doPostEdit()
	 */
	@Override
	public String doPostEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//
		Report report = constructReport();
		request.setAttribute("report", report);
		if (report.getContent() == null || report.getContent().size() == 0) {
			setMessage(request, "No Result Returned as Selected Parameters");
		}
		return doGetEdit();
	}

	/**
	 * Do post edit1.
	 *
	 * @return the string
	 */
	public String doPostEdit1() {
		return doPostEdit();
	}

	/**
	 * Do post edit2.
	 *
	 * @return the string
	 */
	public String doPostEdit2() {
		return doPostEdit();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#getFacade()
	 */
	@Override
	public ReportFacade getFacade() {
		return FacadeServiceLocator.getInstance().getReportFacade();
	}

	/*
	 * (non-Javadoc)
	 * @see sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.BaseServlet#getNewEntity()
	 */
	@Override
	public Report getNewEntity() {
		return new Report();
	}
}
