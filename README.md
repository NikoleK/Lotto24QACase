# Lotto24 QA Candidate Case Study

Welcome! This is a simple Android application that displays lottery results. The app fetches data from a network API and shows a list of lottery drawings.

Your task is to perform a quality assurance review of the application. Please read the instructions for each task carefully and document your findings in a clear and structured manner.

## Application Overview

The app consists of a single screen that displays a list of lottery results. Each result is presented on a card showing:
- The lottery name (e.g., "6aus49", "EuroJackpot").
- The date of the last draw.
- The winning numbers from the last draw.
- The date of the next upcoming draw.

The project is built with modern Android technologies, including Kotlin, Jetpack Compose for the UI, Hilt for dependency injection, and Retrofit for network calls.

## Task 1: UI Test Creation (Technical Skill)

Your first task is to demonstrate your ability to write automated UI tests for Jetpack Compose. We need to ensure the `LottoResultItem` composable is reliable and renders data correctly.

**Instructions:**

Please write UI tests using Jetpack Compose's testing framework to verify the following two scenarios for a '6aus49' lottery result:

1.  **Test 1: Correct Data Display**
    - Verify that when given a sample `LottoDomain` object, the composable correctly displays the lottery name, the formatted last draw date, and the formatted next draw date.
    - *Hint: The date format is handled by the `DateFormatter` utility.*

2.  **Test 2: Correct Number Rendering**
    - Verify that the composable renders the correct number of circles for the main numbers and the special "super" number.
    - *Hint: For a '6aus49' result, you should expect to find 6 regular number circles and 1 special "super" number circle.*
3. **Bonus:** Come with a new idea for testing.

**What we're looking for:**
- Correct test setup using `createComposeRule()`.
- Proper use of `onNodeWithText`, `onAllNodesWith...`, and other finders.
- Clear assertions (`assertIsDisplayed`, `assertCountEquals`, etc.).
- Well-named and readable test functions.
- **Bonus:** Making the UI components more testable (e.g., by adding semantics or a `testTag`).

## Task 2: General QA and Bug Reporting

This task assesses your core QA skills: finding bugs, thinking about different device types, and writing clear bug reports.

**Instructions:**

1.  **Exploratory Testing:**
    - Perform exploratory testing on the app. Try to "break" it or find unexpected behavior.
    - Consider different device configurations and user settings, such as:
        - Small screen sizes.
        - Screen rotation (portrait to landscape).
        - Large font sizes (accessibility settings).
        - Unstable or no network connection.

2.  **Write a Bug Report:**
    - Choose the **most critical** bug you found during your exploratory testing.
    - Write a formal bug report that is clear enough for a developer to understand and reproduce the issue without any follow-up questions.

**Your bug report should include:**
- A clear, concise title.
- Exact steps to reproduce the bug.
- The expected result (what should have happened).
- The actual result (what did happen).
- Details about the environment (e.g., Device model, Android OS version, app version).

## Task 3: UI/UX and Usability Review

Finally, we want to see your eye for design, user empathy, and attention to detail.

**Instructions:**

Please review the application from a user's perspective and provide feedback on the following points.

1.  **First Impressions & Onboarding:**
    - When you first open the app, is its purpose immediately clear?
    - Is there any information missing that would help a new user understand the content? What would you add or change?

2.  **Visual Polish & Consistency:**
    - Review the visual layout of the result cards. Are there any inconsistencies or areas for improvement in alignment, spacing, or color usage?
    - How would you improve the visual hierarchy to better guide the user's attention to the most important information?

3.  **Error States & Edge Cases:**
    - Imagine the app fails to load data from the network. What should the user see?
    - Please sketch or describe an ideal "error screen" that is both informative and user-friendly.

---

**Note**
Please provide your test code, bug report, and UI/UX feedback in separate, clearly-labeled documents on the forked GitHub repository version from this repository. Good luck!
