# Currency Selector Android Jetpack Compose

This is a simple currency selector component built using Jetpack Compose. It allows users to choose their preferred currency from a list of available currencies.

## Getting Started

To use the Currency Selector in your project, follow these steps:

1. Add the `CurrencyModalSelector` composable function to your project.

2. Call the `CurrencyModalSelector` function in your code to display the currency selector modal when needed.

```kotlin
CurrencyModalSelector(
    showModal = true, // Set to true to show the modal
    modalTitle = "Choose your currency", // Optional title for the modal
    closeModal = { selectedCurrency ->
        // Handle the selected currency here
        // The 'selectedCurrency' parameter contains the chosen currency data
    }
)
```

## Customize the Appearance

You can customize the appearance of the modal by adjusting the composable function's parameters and modifiers.

## Dependencies

This component uses the following dependencies:

- Jetpack Compose: The modern toolkit for building native UI in Android.

## Composable Function Overview

The main composable function in this code is `CurrencyModalSelector`, which creates a modal sheet with a list of currencies for the user to choose from.

### Parameters:

- `showModal`: A boolean value to indicate whether the modal should be shown. Set it to `true` to display the modal.

- `modalTitle`: An optional string parameter for setting the title of the modal. Leave it blank or pass `null` if no title is needed.

- `closeModal`: A callback function that will be invoked when the user selects a currency. The chosen `Currency` object will be passed as a parameter to this function.

## Preview

The code includes two preview functions, `ModalWithTitle` and `Modal`, that demonstrate how to use the `CurrencyModalSelector` in a preview mode with and without a title.

## License

This Currency Selector component is licensed under the [MIT License](LICENSE).

Feel free to use and modify it according to your project requirements. If you find any issues or improvements, contributions are welcome.

---

Note: The provided code snippet focuses on the implementation of the Currency Selector component. If you have any additional features or usage instructions, you can include them in the README to provide a comprehensive guide for developers using the component in their projects.
