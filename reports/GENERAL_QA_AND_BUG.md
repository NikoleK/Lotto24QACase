# Lotto24 QA Case – Exploratory Testing & Bug Report

## 1. Exploratory Testing

During exploratory testing, the application was evaluated under various real-world conditions to assess stability, resilience, and usability.

### Devices: 
- Physical device: Samsung Galaxy A32 5G (Android 11)
- Android Emulator (multiple screen sizes)

### Exploratory Tours Performed: 
- New User Tour
- Resilience / Network Tour
- Accessibility Tour

# Most Critical Bug

## Title
Application crashes on launch when no internet connection is available

## Severity

Critical – Crash on startup (blocking usage)

## Environment

* Device: Galaxy A32 5G
* Android Version: Android 11
* App Version: 1.0 (commit ca15068, main branch as of 29.01.2026)
* Network: Airplane mode enabled

## Steps to Reproduce

Preconditions: Application was not installed yet or is fully closed.

1. Enable Airplane Mode (disable Wi-Fi and mobile data).
2. Launch the application

## Actual Result

* The application crashes immediately on launch.
* No error screen or fallback UI is displayed.
* User is returned to the device home screen.

## Expected Result

* The application should not crash.
* A user-friendly error state should be displayed.
* The screen should clearly communicate:
    * That data could not be loaded.
    * That the issue is related to network connectivity.

* Ideally a retry mechanism should be available (button try again or pull-to-refresh).
* Optionally, previously cached results should be shown if available with a note indicating 
* that the data may be outdated.

## Other issues (Ordered by Severity):

* 1.No Data Refresh When Returning from Background
* After the application is sent to background and reopened, no new network request is triggered.
* Expected: Application should refresh data when returning to foreground or provide a manual refresh mechanism(button or pull-to-refresh).)

* 2.Layout Issues on Small Screens 
* On small screen devices, number rows appear compressed and spacing becomes tight, increasing the risk of content clipping.
* Expected: Adaptive layout behavior. Consider horizontal scrolling or dynamic spacing.

* 3.Accessibility – Number Circles Lack Semantic Context
* When TalkBack is enabled: Circles are announced only as raw numbers. No indication whether a number is regular or super.Order of numbers is unclear.
  Red color is the only visual distinction for super numbers.
* Expected: Clearly structure numbers for screen readers. For example with Semantics.

* 4.In EuroJackpot, special numbers are not visually differentiated from regular numbers.
* In 6aus49, super numbers are displayed in red circles. In EuroJackpot, super numbers are rendered the same as regular numbers (dark gray).
* Expected: Consistent visual distinction.

* 5.Mixed Language Usage in UI
* Some strings (e.g., "Last Draw", "Next Draw") appear hardcoded in English.
* Expected: All user-facing strings should use string resources

* 6.In portrait mode, no visible scroll indicator is shown. While scrolling is functional, discoverability of additional content may be reduced.
* When the device is in portrait mode, there is no visible scroll bar on the right side
* Expected: A visible scroll bar should be present to indicate scrollability.

### Additional architectural observations and UX improvement suggestions are documented in a separate file.


