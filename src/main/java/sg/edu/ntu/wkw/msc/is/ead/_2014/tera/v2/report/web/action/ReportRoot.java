package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.web.action;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.displaytag.decorator.MultilevelTotalTableDecorator;
import org.displaytag.decorator.TotalTableDecorator;

import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.web.action.BaseAction;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.dao.intf.ReportDao;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.facade.intf.ReportFacade;
import sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.report.model.Report;

/**
 * The Class ReportRoot.
 */
public abstract class ReportRoot extends BaseAction<Report, ReportDao, ReportFacade> {
	/** The Constant REPORTS. */
	public static final String[][] REPORTS = new String[][] { //
	{ Report.REPORT_INDIVIDUAL_CLAIM_SUM.toString(), Report.REPORT_NAMES.get(Report.REPORT_INDIVIDUAL_CLAIM_SUM) }, //
			{ Report.REPORT_INDIVIDUAL_CLAIM_ITEMS.toString(), Report.REPORT_NAMES.get(Report.REPORT_INDIVIDUAL_CLAIM_ITEMS) } //
	};

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8622950479081768432L;

	/** The action download. */
	protected final String ACTION_DOWNLOAD = "download";

	/** The ACTIO n_ edi t_1. */
	protected final String ACTION_EDIT_1 = "edit" + Report.REPORT_INDIVIDUAL_CLAIM_SUM;

	/** The ACTIO n_ edi t_2. */
	protected final String ACTION_EDIT_2 = "edit" + Report.REPORT_INDIVIDUAL_CLAIM_ITEMS;

	/** The report edit pages. */
	public final Map<String, String> reportEditPages = new HashMap<String, String>() {
		private static final long serialVersionUID = -5952307690652230301L;
		{
			put(Report.REPORT_INDIVIDUAL_CLAIM_SUM.toString(), ACTION_EDIT_1);
			put(Report.REPORT_INDIVIDUAL_CLAIM_ITEMS.toString(), ACTION_EDIT_2);
		}
	};

	/** The subtotal decorator. */
	protected final MultilevelTotalTableDecorator subtotalDecorator;

	/** The total decorator. */
	protected final TotalTableDecorator totalDecorator;

	/**
	 * Instantiates a new report root.
	 */
	public ReportRoot() {
		totalDecorator = new TotalTableDecorator();
		subtotalDecorator = new org.displaytag.decorator.MultilevelTotalTableDecorator();
		subtotalDecorator.setGrandTotalDescription("Total Across All Categories");
		subtotalDecorator.setSubtotalLabel("{0} Subtotal", Locale.ENGLISH);
	}
}
