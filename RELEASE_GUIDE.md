# Mobi Lab Components for Compose Library Release Guide

Disclaimer: This release guide assumes you are an employee of Mobi Lab and have access to the company's account in Codemagic CI.

Note: Every time you notice something in this guide is out-of-date or incorrect then fix it right away. Only then does this document have any value.

## Links

- Repository on GitHub: https://github.com/LabMobi/labcomponents-compose
- Sonatype OSSRH Nexus UI: [https://s01.oss.sonatype.org](https://s01.oss.sonatype.org/)
- Artifacts on Maven Central: https://repo1.maven.org/maven2/mobi/lab/labcomponents/labcomponents-compose/ (can take some time)
  - Artifacts on Sonatype OSSRH: https://s01.oss.sonatype.org/content/groups/public/mobi/lab/labcomponents/labcomponents-compose/ (available right away after publishing)
- Original Sonatype OSSRH JIRA issue: https://issues.sonatype.org/browse/OSSRH-66630
  - Can be used to add user access
- Project access Lab's internal Confluence: https://labmobi.atlassian.net/wiki/spaces/DEV/pages/15990951/Sonatype+Maven+Access+Credentials
- Codemagic CI: https://codemagic.io/app/652e729c5991ed8dfccbe3c3/settings
- OSSRH guide: https://central.sonatype.org/publish/publish-guide/

## Prerequisites

1. Access to Lab's accounts at Codemagic (https://codemagic.io/apps) and OSSRH https://s01.oss.sonatype.org/. For manual publishing access to credentials at https://confluence.lab.mobi/display/DEV/Sonatype+Maven+Access+Credentials

2. Make sure all the new features have been committed to `develop` branch.

3. Make sure all the functionality in the `develop` branch works.

4. Make sure the code in the `develop` builds correctly with the release build task:

   ```bash
   ./gradlew buildAllRelease
   ```

5. Make sure the "Compatible versions" list in the `README.md` is up-to-date

## Release process

1) Update the `CHANGELOG.md` document on the `develop` branch, add a section for this new release. If possible then follow https://keepachangelog.com/en/1.0.0/

Commit and push the change:

```bash
git add CHANGELOG.md
git commit -m "Add changelog for version X.Y.Z"
git push
```

2) Make sure the version code in the `develop` branch is correct. If needed then update the library version from the `build.gradle` file in the project root folder:

```groovy
ext {
    // Current version of the library
    libraryVersion = "X.Y.Z"
}
```

Commit and push the changes

```bash
git add build.gradle
git commit -m "Update the version code to X.Y.Z"
git push
```

2) Make sure the develop build (`develop-builds (Development builds)`) you just started at Codemagic CI is ok and everything is in green.

3) Merge the `develop` branch to `main`.

```bash
git checkout develop
git pull
git checkout main
git pull
git merge develop
git push
```

4) Start the release build (`release-builds (Release builds for verification (main branch only))`) at Codemagic CI from the `main` branch, make sure it builds fine and everything is in green.

5) Start the publish build (`publish-builds Publish to Maven builds (main branch only)`) at Codemagic CI from the `main` branch, make sure it builds fine and everything is in green.

6) Open up  https://s01.oss.sonatype.org/, navigate to Build Promotion -> Staging repositories, check the published repository there. 

- There should be a repository with the same version number
- Download the `labcomponents-compose-x.y.z.aar` artifact from there, make sure it is ok. 

7. Publish the staging repository at  https://s01.oss.sonatype.org/ as follows:

   - First mark it as `Closed`. This button triggers a validation process for your project. If the validation passes then proceed. Fix the issues otherwise 
     - If you need to remove the repo and start again then use `Drop`

   - Release the closed repository. Now the new artifact should be available shortly on the Maven Central at https://repo1.maven.org/maven2/mobi/lab/lab/labcomponents/labcomponents-compose/ 

- NOTE: Depending in the time of day this can take some time (wait up to 1h and then complain under the original JIRA issue)

8. Create a new release and a Git tag in GitHub as follows:
   - Open up the GitHub release page at https://github.com/LabMobi/labcomponents-compose/releases, create a new release `vX.Y.Z`. Don't write an additional changelog there, just link to the changelog document.
   - Let it automatically create a tag for the release, in the form of "release-X.Y.Z".

9) OPTIONAL: Update the library in at least one of the projects using it to make sure everything is in order.

## Post-release actions

1. In the `develop` branch update the library version code to a new version so the `develop` branch code and the released code does not have a matching version.


```
git checkout develop 
git pull 
```

  - Keep the release number in the style of X.Y.Z.


```groovy
ext {
    // Current version of the library
    libraryVersion = "X.Y.Z"
}
```

and commit and push the changes:

```bash
git add build.gradle
git commit -m "Update the version code to X.Y.Z"
git push
```

## EXTRA: Manual publishing

If for some reason CI can't be used for publishing then manual publishing process is overall the same as in CI, just skip the CI parts and

1) Rename the `publish.properties_TEMPLATE` and fill it with the correct values.

2) Check if the local publishing works by

```bash
./gradlew publishToMavenLocal
```

The artifacts should be available under your user folder at `~/.m2/repository/mobi/lab/labcomponents/labcomponents-compose/`

3) If everything is in order then publish to OSSRH:

```bash
./gradlew buildAndPublishRelease
```

After that follow the steps from OSSRH Nexus described above.

NOTE: To make the PGP private key to a single-line for props you can use the following command:

```bash
awk -v ORS='\\n' '1' mobi_lab_maven_artifact_PRIVATE_KEY.pgp > singlelinekey.txt
```

