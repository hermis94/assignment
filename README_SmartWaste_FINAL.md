
# Smart Waste Collection Reminder

Author: Hermis Makawa
Student ID: 21313351018
Course: BSC351 - Mobile Application Development

Project: Notify users of waste collection days by area.
Outcome: Room (SQLite) schedule + RecyclerView list + weekly scheduled notifications.

Repository name: MobileApp_Assignment2_HermisMakawa_BSC351
Upload: /app folder (complete project), README.md, Presentation.pptx
Commit often with clear messages.

Package name: com.example.smartwaste
Notification logic: weekly (day of week + time)


## Continuous Integration (GitHub Actions)

This repo includes a GitHub Actions workflow that:
- Builds the project and runs unit tests.
- Starts an Android emulator and runs instrumented tests (connectedAndroidTest).

Push to the `main` branch to trigger CI. The workflow file is located at `.github/workflows/android-ci.yml`.

## Running tests locally
- Unit tests: `./gradlew test`
- Instrumented tests (requires emulator/device): `./gradlew connectedAndroidTest`
