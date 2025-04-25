![Mobi Lab](docs/assets/mobilab-header-logo.png)

# Mobi Lab Components for Compose

Mobi Lab Components for Compose (`LabComponentsCompose`) help developers execute our internal design system's components on the Android platform.

Maven Central artifact available from https://central.sonatype.com/search?q=mobi.lab.labcomponents:labcomponents-compose

```groovy
implementation 'mobi.lab.labcomponents:labcomponents-compose:0.0.2' // Check the latest version from Maven Central
```

The components provide implementations for [Mobi Lab's design system](https://www.figma.com/file/gxt4iyWGyliILJSOCLXonl/P42-design-system-template?type=design&node-id=1652-14713&mode=design&t=j4TbnOpahS3korsT-0).

These components are based on [Material Components for Android](https://github.com/material-components/material-components-android).

## Compatible versions

| Lab Components for Compose | Material Compose BOM |
|----------------------------|:---------------------|
| 0.0.2                      | 2025.04.01           |
| 0.0.1                      | 2025.04.01           |

## Description

The library contains a ready-to-use Compose implementation of the components from Mobi Lab's design system. Mobi Lab's design system allows teams to focus on solving business problems instead of reinventing basic design system and UI components at the design and implementation phases.

The project consists of the component library in `lib` module and the components demo application in `app-demo` module.

## Buttons

Supported:

- Filled button

  ```kotlin
  // Medium
  LabFilledButton(
      text = "Click Me!",
      onClick = {},
      enabled = enabled.value
  )
  ```

  ```kotlin
  // Small
  LabFilledSmallButton(
      text = "Click Me!",
      onClick = {},
  )
  ```

- Toned button

  ```kotlin
  // Medium
  LabTonedButton(
      text = "Click Me!",
      onClick = {},
  )
  ```

  ```kotlin
  // Small
  LabTonedSmallButton(
      text = "Click Me!",
      onClick = {},
  )
  ```

- Outlined button

  ```kotlin
  // Medium
  LabOutlinedButton(
      text = "Click Me!",
      onClick = {},
  )
  ```

  ```kotlin
  // Small
  LabOutlinedSmallButton(
      text = text = "Click Me!",
      onClick = {},
  )
  ```

- Text button

  ```kotlin
  // Medium
  LabTextButton(
      text = "Click Me!",
      onClick = {},
  )
  ```

  ```kotlin
  // Small
  LabTextSmallButton(
      text = "Click Me!",
      onClick = {},
  )
  ```

- Icon button

  ```kotlin
  // Medium
  LabIconButton(
      icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
      contentDescription = "Like",
      onClick = {},
  )
  ```
  
  ```kotlin
  // Small
  LabIconSmallButton(
      icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
      contentDescription = "Like",
      onClick = {},
  )
  ```

See usage examples at https://github.com/LabMobi/labcomponents-compose/blob/main/app-demo/src/main/java/mobi/lab/components/compose/demo/button/ButtonDestination.kt

## Colors

See usage examples at https://github.com/LabMobi/labcomponents-compose/blob/main/app-demo/src/main/java/mobi/lab/components/compose/demo/color/ColorsDestination.kt

## Typography

See usage examples at https://github.com/LabMobi/labcomponents-compose/blob/main/app-demo/src/main/java/mobi/lab/components/compose/demo/typography/TypographyDestination.kt

## Progress indicators

- Indeterminate progress

  ```kotlin
  LabIndeterminateProgress(modifier = Modifier.size(40.dp))
  ```

See usage examples at https://github.com/LabMobi/labcomponents-compose/blob/main/app-demo/src/main/java/mobi/lab/components/compose/demo/progress/ProgressDestination.kt

## Links

- [Changelog](CHANGELOG.md)
- [Upcoming tasks](docs/upcoming_tasks.md)
- [Directory Structure](docs/directory_structure.md)
- [Resource Visibility](docs/resource_visibility.md)
- [Contributing](docs/contributing.md)
- [Release Guide](RELEASE_GUIDE.md)
- [Material Components for Android](https://github.com/material-components/material-components-android) (external)

