# Changelog for Mobi Lab Components for Compose

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/). This project does not use semantic versioning.

## 0.0.9 - [UNRELEASED]

### Changed

- ..

## 0.0.8 - 2025.05.22

### Changed

- Allow to specify the Material `ColorScheme` and `Typography` when creating `LabTheme`. Useful in cases when setting the debug-colors and fonts there has unintended effects.

## 0.0.7 - 2025.05.16

### Changed

- Changed the medium size button (Filled, Tonal, Outlined and Text buttons) text style token from “body-large”→“label-large”. (Figma 2025, May 13)

- Changed the medium size (Filled, Tonal, Outlined and Text) button leading and trailing icon (+loader) sizes from 24px→20px. (Figma 2025, May 13)

- Changed the way the minimum sizes are handled for buttons. Button size is determined mainly by the contents. But this does not always give the same result as in Figma. So buttons also have minimum width and height values defined. This way the button will not resize when changing to loading mode and back. As in the primary case you want to change minimums for all the buttons in one go, then the values are now attached to `LabTheme.constants` and can be easily overridden for the whole when defining the app theme:

  ```kotlin
  @Composable
  fun AppTheme(
      content: @Composable () -> Unit,
  ) {
      LabTheme(
          typography = LabThemeDefaults.typography(fontFamily = defaultFontFamily()),
          content = content,
          constants = LabThemeDefaults.constants(buttonMediumMinHeight = 48.dp)
      )
  }
  ```

  Alternatively, the `CompositionLocalProvider` can also be used to override these for specific button instances:

  ```kotlin
  val constantsOverride = LabThemeDefaults.constants(
      buttonMediumMinHeight = 60.dp,
      buttonSmallMinHeight = 28.dp,
  )
  // Use the CompositionLocalProvider to provide a different set of LocalLabConstants for this composable
  CompositionLocalProvider(LocalLabConstants provides constantsOverride) {
      LabFilledButton(
          text = "Click!",
          onClick = {},
      )
  }
  ```

  

## 0.0.6 -2025.05.13

### Changed

- Added an override that supports setting a different text style for all button types
- Added an override that supports setting different minimum size for all button types

## 0.0.5 - 2025.05.09

### Changed

- Added an experimental `LabSwitch` support. `LabSwitch` is not yet fully specified in the design system and will likely change in the future.
- Updated compose BOM to `compose-bom:2025.05.00`

## 0.0.4 - 2025.05.05

### Changed

- Added support for `LabTopAppBar` and `LabLargeTopAppBar`.
- Renamed `LabIndeterminateProgressDefaults` to `LabIndeterminateCircularIndicatorDefaults`.

## 0.0.3 - 2025.04.30

### Changed

- Renamed the `LabIndeterminateProgress` to `LabIndeterminateCircularIndicator` and updated the animation to follow the same style as in the design template.
- Buttons now allow to specify a custom progress indicator. See the examples in the sample app.
- Added `LabTextField` support.
- Defined `LabDimensions` to provide `maxContentWidth` which can be used to limit layout width on large screens

## 0.0.2 - 2025.04.25

### Changed

- Added proper support for Filled, Toned, Outline and Icon buttons
- Added indeterminate progress support
- Updated Material BOM to 2025.04.01

## 0.0.1 - 2025.04.14

### Changed

- < Test release, do not use! >
