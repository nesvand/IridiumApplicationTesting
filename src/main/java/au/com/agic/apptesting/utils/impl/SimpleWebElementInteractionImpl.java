package au.com.agic.apptesting.utils.impl;

import au.com.agic.apptesting.constants.Constants;
import au.com.agic.apptesting.exception.WebElementException;
import au.com.agic.apptesting.utils.GetBy;
import au.com.agic.apptesting.utils.SimpleWebElementInteraction;
import au.com.agic.apptesting.utils.ThreadDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Implementation of the SimpleWebElementInteraction service
 */
public class SimpleWebElementInteractionImpl implements SimpleWebElementInteraction {
	private static final GetBy GET_BY = new GetByImpl();

	@Override
	public CompletableFuture<WebElement> getClickableElementFoundBy(
			final boolean valueAlias,
			final String value,
			final ThreadDetails threadDetails) {

		return getClickableElementFoundBy(valueAlias, value, threadDetails, Constants.WAIT);
	}

	@Override
	public CompletableFuture<WebElement> getClickableElementFoundBy(
			final boolean valueAlias,
			final String value,
			final ThreadDetails threadDetails,
			final long wait) {

		final CompletableFuture<WebElement> retValue = new CompletableFuture<>();
		final AtomicInteger failures = new AtomicInteger(0);
		final List<Thread> threads = new CopyOnWriteArrayList<>();

		final By by = GET_BY.getBy("ID", valueAlias, value, threadDetails);
		final WebDriverWait waitId = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionId = ExpectedConditions.elementToBeClickable(by);
		final Thread byIDThread = new Thread(
			new GetElement(waitId, conditionId, failures, retValue, threads));
		threads.add(byIDThread);

		final By byXpath = GET_BY.getBy("xpath", valueAlias, value, threadDetails);
		final WebDriverWait waitXpath = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionXpath = ExpectedConditions.elementToBeClickable(byXpath);
		final Thread byXpathThread = new Thread(
			new GetElement(waitXpath, conditionXpath, failures, retValue, threads));
		threads.add(byXpathThread);

		final By byName = GET_BY.getBy("name", valueAlias, value, threadDetails);
		final WebDriverWait waitName = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionName = ExpectedConditions.elementToBeClickable(byName);
		final Thread byNameThread = new Thread(
			new GetElement(waitName, conditionName, failures, retValue, threads));
		threads.add(byNameThread);

		final By byClass = GET_BY.getBy("class", valueAlias, value, threadDetails);
		final WebDriverWait waitClass = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionClass = ExpectedConditions.elementToBeClickable(byClass);
		final Thread byClassThread = new Thread(
			new GetElement(waitClass, conditionClass, failures, retValue, threads));
		threads.add(byClassThread);

		final By bySelector = GET_BY.getBy("css selector", valueAlias, value, threadDetails);
		final WebDriverWait waitSelector = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionSelector =
			ExpectedConditions.elementToBeClickable(bySelector);
		final Thread bySelectorThread = new Thread(
			new GetElement(waitSelector, conditionSelector, failures, retValue, threads));
		threads.add(bySelectorThread);

		threads.stream().forEach(Thread::start);

		return retValue;
	}

	@Override
	public CompletableFuture<WebElement> getVisibleElementFoundBy(
			final boolean valueAlias,
			final String value,
			final ThreadDetails threadDetails) {

		return getVisibleElementFoundBy(valueAlias, value, threadDetails, Constants.WAIT);
	}

	@Override
	public CompletableFuture<WebElement> getVisibleElementFoundBy(
			final boolean valueAlias,
			final String value,
			final ThreadDetails threadDetails,
			final long wait) {

		final CompletableFuture<WebElement> retValue = new CompletableFuture<>();
		final AtomicInteger failures = new AtomicInteger(0);
		final List<Thread> threads = new CopyOnWriteArrayList<>();

		final By by = GET_BY.getBy("ID", valueAlias, value, threadDetails);
		final WebDriverWait waitId = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionId =
			ExpectedConditions.visibilityOfElementLocated(by);
		final Thread byIDThread = new Thread(
			new GetElement(waitId, conditionId, failures, retValue, threads));
		threads.add(byIDThread);

		final By byXpath = GET_BY.getBy("xpath", valueAlias, value, threadDetails);
		final WebDriverWait waitXpath = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionXpath =
			ExpectedConditions.visibilityOfElementLocated(byXpath);
		final Thread byXpathThread = new Thread(
			new GetElement(waitXpath, conditionXpath, failures, retValue, threads));
		threads.add(byXpathThread);

		final By byName = GET_BY.getBy("name", valueAlias, value, threadDetails);
		final WebDriverWait waitName = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionName =
			ExpectedConditions.visibilityOfElementLocated(byName);
		final Thread byNameThread = new Thread(
			new GetElement(waitName, conditionName, failures, retValue, threads));
		threads.add(byNameThread);

		final By byClass = GET_BY.getBy("class", valueAlias, value, threadDetails);
		final WebDriverWait waitClass = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionClass =
			ExpectedConditions.visibilityOfElementLocated(byClass);
		final Thread byClassThread = new Thread(
			new GetElement(waitClass, conditionClass, failures, retValue, threads));
		threads.add(byClassThread);

		final By bySelector = GET_BY.getBy("css selector", valueAlias, value, threadDetails);
		final WebDriverWait waitSelector = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionSelector =
			ExpectedConditions.visibilityOfElementLocated(bySelector);
		final Thread bySelectorThread = new Thread(
			new GetElement(waitSelector, conditionSelector, failures, retValue, threads));
		threads.add(bySelectorThread);

		threads.stream().forEach(Thread::start);

		return retValue;
	}

	@Override
	public CompletableFuture<WebElement> getPresenceElementFoundBy(
			final boolean valueAlias,
			final String value,
			final ThreadDetails threadDetails) {
		return getPresenceElementFoundBy(valueAlias, value, threadDetails, Constants.WAIT);
	}

	@Override
	public CompletableFuture<WebElement> getPresenceElementFoundBy(
			final boolean valueAlias,
			final String value,
			final ThreadDetails threadDetails,
			final long wait) {
		final CompletableFuture<WebElement> retValue = new CompletableFuture<>();
		final AtomicInteger failures = new AtomicInteger(0);
		final List<Thread> threads = new CopyOnWriteArrayList<>();

		final By by = GET_BY.getBy("ID", valueAlias, value, threadDetails);
		final WebDriverWait waitId = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionId =
			ExpectedConditions.presenceOfElementLocated(by);
		final Thread byIDThread = new Thread(
			new GetElement(waitId, conditionId, failures, retValue, threads));
		threads.add(byIDThread);

		final By byXpath = GET_BY.getBy("xpath", valueAlias, value, threadDetails);
		final WebDriverWait waitXpath = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionXpath =
			ExpectedConditions.presenceOfElementLocated(byXpath);
		final Thread byXpathThread = new Thread(
			new GetElement(waitXpath, conditionXpath, failures, retValue, threads));
		threads.add(byXpathThread);

		final By byName = GET_BY.getBy("name", valueAlias, value, threadDetails);
		final WebDriverWait waitName = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionName =
			ExpectedConditions.presenceOfElementLocated(byName);
		final Thread byNameThread = new Thread(
			new GetElement(waitName, conditionName, failures, retValue, threads));
		threads.add(byNameThread);

		final By byClass = GET_BY.getBy("class", valueAlias, value, threadDetails);
		final WebDriverWait waitClass = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionClass =
			ExpectedConditions.presenceOfElementLocated(byClass);
		final Thread byClassThread = new Thread(
			new GetElement(waitClass, conditionClass, failures, retValue, threads));
		threads.add(byClassThread);

		final By bySelector = GET_BY.getBy("css selector", valueAlias, value, threadDetails);
		final WebDriverWait waitSelector = new WebDriverWait(threadDetails.getWebDriver(), wait);
		final ExpectedCondition<WebElement> conditionSelector =
			ExpectedConditions.presenceOfElementLocated(bySelector);
		final Thread bySelectorThread = new Thread(
			new GetElement(waitSelector, conditionSelector, failures, retValue, threads));
		threads.add(bySelectorThread);

		threads.stream().forEach(Thread::start);

		return retValue;
	}

	/**
	 * Represents a thread that is running trying to find an element. The first one to succeed
	 * will set the value of a CompletableFuture, while the last one to fail after all others
	 * have failed will set the CompletableFuture to throw an exception.
	 */
	private static class GetElement implements Runnable {
		private final WebDriverWait wait;
		private final AtomicInteger failures;
		private final CompletableFuture<WebElement> returnValue;
		private final List<Thread> threads;
		private final ExpectedCondition<WebElement> expectedCondition;

		GetElement(
			final WebDriverWait wait,
			final ExpectedCondition<WebElement> expectedCondition,
			final AtomicInteger failures,
			final CompletableFuture<WebElement> returnValue,
			final List<Thread> threads) {

			checkNotNull(wait);
			checkNotNull(expectedCondition);
			checkNotNull(failures);
			checkNotNull(returnValue);
			checkNotNull(threads);

			this.wait = wait;
			this.expectedCondition = expectedCondition;
			this.failures = failures;
			this.returnValue = returnValue;
			this.threads = threads;
		}

		@Override
		public void run() {
			try {
				final WebElement element = wait.until(expectedCondition);
				/*
					The first thread to succeed will be the value that is returned
				 */
				synchronized (returnValue) {
					if (!returnValue.isDone()) {
						/*
							All of the other threads no longer need to keep running
						 */
						threads.stream().forEach(Thread::interrupt);
						/*
							Return the element
						 */
						returnValue.complete(element);
					}
				}
			} catch (final Exception ex) {
				/*
					If all threads failed, throw an exception
				 */
				final int failureCount = failures.incrementAndGet();
				if (failureCount >= threads.size()) {
					synchronized (returnValue) {
						if (!returnValue.isDone()) {
							returnValue.completeExceptionally(
								new WebElementException(
									"All attempts to find element failed"));
						}
					}
				}
			}
		}
	}
}