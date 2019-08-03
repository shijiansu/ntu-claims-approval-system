package sg.edu.ntu.wkw.msc.is.ead._2014.tera.v2.infr.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class ResultSetPojo.
 */
public class ResultSetPojo implements Serializable {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6318049976821303980L;

	/** The value. */
	private List<Object> value = new ArrayList<Object>();

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public List<Object> getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(List<Object> value) {
		this.value = value;
	}
}
