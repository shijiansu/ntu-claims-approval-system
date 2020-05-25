package sg.edu.ntu.tera.v2.common;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Class DateUtil.
 */
public class DateUtil {
	/** The Constant DATE_FORMATOR. */
	public static final SimpleDateFormat DATE_FORMATOR = new SimpleDateFormat("yyyy-MMM-dd");

	/** The Constant MONTHS. */
	public static final Map<String, String> MONTHS = new LinkedHashMap<String, String>() {
		private static final long serialVersionUID = -7143856268556127421L;
		{
			put("01", "January");
			put("02", "February");
			put("03", "March");
			put("04", "April");
			put("05", "May");
			put("06", "June");
			put("07", "July");
			put("08", "August");
			put("09", "September");
			put("10", "October");
			put("11", "November");
			put("12", "December");
		}
	};

	/** The Constant SHORT_MONTHS. */
	public static final Map<String, String> SHORT_MONTHS = new LinkedHashMap<String, String>() {
		private static final long serialVersionUID = -7143856268556127421L;
		{
			put("01", "Jan");
			put("02", "Feb");
			put("03", "Mar");
			put("04", "Apr");
			put("05", "May");
			put("06", "Jun");
			put("07", "Jul");
			put("08", "Aug");
			put("09", "Sep");
			put("10", "Oct");
			put("11", "Nov");
			put("12", "Dec");
		}
	};

	/** The Constant TIME_FORMATOR. */
	public static final SimpleDateFormat TIME_FORMATOR = new SimpleDateFormat("yyyyMMddHHmmss");

	/** The Constant YEAR_MONTH_FORMATOR. */
	public static final SimpleDateFormat YEAR_MONTH_FORMATOR = new SimpleDateFormat("yyyyMM");
}
