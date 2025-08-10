# Cucumber + JUnit + Maven with ONE shared WebDriver (multiple roles via .env)

This template runs **one browser instance for the entire test run** (suite) and lets you **switch roles** using a single Gherkin step.

> Adjust selectors in `LoginPage`/`HomePage` for your real app (Business Central may require different IDs or SSO handling).

## Quick start
1. Install Java 17+ and Maven.
2. Edit `.env` with your app URL and role credentials.
3. Run:
   ```bash
   mvn clean test
   ```

Reports: `target/cucumber-report.html`, `target/cucumber.json`.
