package au.com.agic.apptesting.utils;

import au.com.agic.apptesting.profiles.configuration.UrlMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.constraints.NotNull;

/**
 * Represents the details required by a feature to run in a particular thread.
 */
public interface FeatureState {

	/**
	 *
	 * @return How long to sleep between steps
     */
	long getDefaultSleep();

	/**
	 *
	 * @param sleep How long to sleep between steps
     */
	void setDefaultSleep(final long sleep);

	/**
	 *
	 * @return the amount of time to wait for an element to be available before
	 * completing a step.
	 */
	long getDefaultWait();

	/**
	 * @param wait the amount of time to wait for an element to be available before
	 * completing a step.
	 */
	void setDefaultWait(final long wait);

	/**
	 * @return The url associated with this instance of the test
	 */
	UrlMapping getUrlDetails();

	/**
	 * @return The data set associated with this instance of the test
	 */
	Map<String, String> getDataSet();

	/**
	 * @param dataSet The data set associated with this instance of the test
	 */
	void setDataSet(Map<String, String> dataSet);

	/**
	 * @return true if there was a failed scenario, and false otherwise
	 */
	boolean getFailed();

	/**
	 * @param failed true if there was a failed scenario, and false otherwise
	 */
	void setFailed(final boolean failed);

	/**
	 * @return The directory where reports and other test output is saved
	 */
	String getReportDirectory();

	/**
	 *
	 * @return The optional details of the proxy being used
	 */
	List<ProxyDetails<?>> getProxyInterface();

	/**
	 *
	 * @param name The name of the proxy to find
	 * @return The proxy that matches the name, or an empty result
	 */
	Optional<ProxyDetails<?>> getProxyInterface(@NotNull final String name);

	/**
	 *
	 * @param proxies The optional details of the proxy being used
	 */
	void setProxyInterface(final List<ProxyDetails<?>> proxies);

	/**
	 *
	 * @return true if autoalias is enabled, and false otherwise
	 */
	boolean getAutoAlias();

	/**
	 *
	 * @param autoAlias true if autoalias is enabled, and false otherwise
	 */
	void setAutoAlias(final boolean autoAlias);

	/**
	 *
	 * @return true if all steps are to be skipped, false otherwise
	 */
	boolean getSkipSteps();

	/**
	 *
	 * @param skip true if all steps are to be skipped, false otherwise
	 */
	void setSkipSteps(final boolean skip);

	/**
	 *
	 * @return The default amount of time to wait between keypresses in textboxes
	 *			and other text input fields
	 */
	int getDefaultKeyStrokeDelay();

	/**
	 *
	 * @param defaultKeyStrokeDelay The default amount of time to wait between keypresses in textboxes
	 *			and other text input fields
	 */
	void setDefaultKeyStrokeDelay(final int defaultKeyStrokeDelay);

}
