# DaffyDialog
An App Inventor non-visible extension that provides additional tools to the built-in Notifier component. It has:

- features for Show Text Input Dialog and Show Number Picker Dialog in Kodular's Notifier.

- features for Custom Choose Dialog in Kodular's Notifier.

- input password dialog!

:package: **Package name:** com.gordonlu.daffydialog

**:clock8: Version:** 3

:DATE: **Release date:** 20:30:00, Asia/Hong_Kong time.

:open_book: **Documentation**

***Event blocks***

>
> **CustomChooseDialogCanceled**
> 
> ![image](https://user-images.githubusercontent.com/88015331/160325463-09ba81c7-a01b-45ec-a958-a1830f93d1a3.png)
> 
> This event is fired when the user has pressed the cancel button in a custom choose dialog.
> 
> *Parameters:* id = number (int)

>
> **GotCustomChooseDialog**
> 
>![image](https://user-images.githubusercontent.com/88015331/160325472-efa818e1-405e-469d-999b-a8b949f6cba7.png)
> 
> This event is fired when the user has pressed button1 or button2 in a custom choose dialog.
> 
> *Parameters:* id = number (int), choice = text

>
>**GotNumberPickerDialog**
>
>![image](https://user-images.githubusercontent.com/88015331/160325478-9a758062-fa8b-4efa-a491-51defe40e953.png)
>
>This event is fired when the user has pressed the OK button in a number picker dialog.
>
>*Parameters:* id = numbr (int), number = number (int)

>
> **GotPasswordInputDialog**
> 
>![image](https://user-images.githubusercontent.com/88015331/160325489-e336fa55-3a2f-4a04-b40d-99f7bb867c12.png)
> 
> This event is fired when the user has pressed the OK button in a password input dialog.
> 
> *Parameters:* id = number (int), password = text

>
>**GotTextInputDialog**
>
>![image](https://user-images.githubusercontent.com/88015331/160325496-0362fdb4-e81a-4e5e-a413-8b9864a13bb1.png)
>
>This event is fired when the user has pressed the OK button in a text input dialog.
>
>*Parameters:* id = number (int), input = text

>
>**NumberPickerDialogCanceled**
>
>![image](https://user-images.githubusercontent.com/88015331/160325508-1d6848cb-b655-4adf-8439-3e0e972c5710.png)
>
>This event is fired when the user has pressed the cancel button in a number picker dialog.
>
>*Parameters:* id = number (int)

>
> **PasswordInputDialogCanceled**
> 
>![image](https://user-images.githubusercontent.com/88015331/160325524-160327a1-2ca0-4153-bda5-b1fbe6262ae1.png)
> 
> This event is fired when the user has pressed the cancel button in a password input dialog.
> 
> *Parameters:* id = number (int)

>
>**TextInputDialogCanceled**
>
>![image](https://user-images.githubusercontent.com/88015331/160325537-50d11012-e9dc-4f5e-bffc-397de862c868.png)
>
>This event is fired when the user has pressed the cancel button in a text input dialog.
>
>*Parameters:* id = number (int)

***Method blocks***

>
> **CustomChooseDialog**
> 
>![image](https://user-images.githubusercontent.com/88015331/160325544-9afaae67-deac-419d-9dc8-827972238ef5.png)
> 
> Shows a custom choose dialog. The id parameter is an ID to specify the notifier, in case you want to show two dialogs with the same extension. The title and message parameter are for specifying the title and message of this dialog respectively. When the user has tapped button1 or button2 in this dialog, the extension fires the GotCustomChooseDialog event. If it is canceled, the extension will call the CustomChooseDialogCanceled event.
> 
> *Parameters:* id = number (int), message = text, title = text, button1Text = text, button2Text = text, cancelButtonText = text, cancelable = boolean

>
> **ShowPasswordInputDialog**
> 
>![image](https://user-images.githubusercontent.com/88015331/160325551-c122f3a2-8a06-4044-9f41-7f207006ece2.png)
> 
> Shows a password input dialog. The id parameter is an ID to specify the notifier, in case you want to show two dialogs with the same extension. The title parameter is for specifying the title of this dialog. defaultText is the default text for the input in which the user will first see in the textbox when they open the dialog, and hint is the hint of that textbox. Use inputBold, inputItalic, hintColor and inputColor to customize the textbpx, and use the property blocks to specify inputFont. buttonText is the text of the OK button, while cancelButtonText is the text of the cancel button.
> 
> *Parameters:* id = number (int), title = text, defaultText = text, hint = text, inputBold = boolean, inputItalic = boolean, inputFont = text, hintColor = color, inputColor = color, buttonText = text, cancelButtonText = text, cancelable = boolean

>
>**ShowNumberPickerDialog**
>
>![image](https://user-images.githubusercontent.com/88015331/160325558-5e9e01b8-3e84-4472-862a-3bf59bf96c35.png)
>
>Displays a number picker dialog that enables the user to select a number from a predefined range.
>
>*Parameters:* id = number (int), title = text, buttonText = text, cancelButtonText = text, message = text, minValue = number (int), maxValue = number (int), cancelable = boolean


>
>**ShowTextInputDialog**
>
>![image](https://user-images.githubusercontent.com/88015331/160325566-0a7d27f5-5ab9-49f5-a112-4792a93a41f6.png)
>
>Shows a text input dialog. The id parameter is an ID to specify the notifier, in case you want to show two dialogs with the same extension. The title parameter is for specifying the title of this dialog. defaultText is the default text for the input in which the user will first see in the textbox when they open the dialog, and hint is the hint of that textbox. Use inputBold, inputItalic, hintColor and inputColor to customize the textbpx, and use the property blocks to specify inputFont. buttonText is the text of the OK button, while cancelButtonText is the text of the cancel button.
>
>*Parameters:* id = number (int), title = text, defaultText = text, hint = text, inputBold = boolean, inputItalic = boolean, inputFont = text, hintColor = color, inputColor = color, buttonText = text, cancelButtonText = text, cancelable = boolean, inputType = number 
(boolean)

For what to fill in in the inputType parameter, here are some examples.

1. plain old normal text - 0.

2. number - 2.

3. phone number - 3.

4. date/time - 4.

5. email address - 32.

For more, see the Android Developers documentation.

https://developer.android.com/reference/android/text/InputType

Plus, 4 property blocks for fonts.

![image](https://user-images.githubusercontent.com/88015331/160325578-12701dff-19f2-4d59-aa73-339eaeb8fc99.png)

This is the output for the ShowNumberPickerDialog block in **Classic** mode (left/top) and **Device Default** (right/bottom).

![image](https://user-images.githubusercontent.com/88015331/160325588-50a614f7-a002-44de-9a4f-4d703d8e0cf6.png) ![image](https://user-images.githubusercontent.com/88015331/160325598-082a24b1-1b40-40ae-8756-7813b4accb6c.png)

This is the output for the ShowTextInputDialog block in **Classic** mode (left/top) and **Device Default** (right/bottom).

![image](https://user-images.githubusercontent.com/88015331/160325627-223aace2-78f5-4aa8-a714-9844f9aa6ff3.png) ![image](https://user-images.githubusercontent.com/88015331/160325631-73c6e067-1a00-42ab-b49a-325141d89152.png)

This is the output for the CustomChooseDialog block in **Classic** mode (left/top) and **Device Default** (right/bottom).

![image](https://user-images.githubusercontent.com/88015331/160325660-1ff5c43f-9665-40c8-9daf-3305ac740757.png) ![image](https://user-images.githubusercontent.com/88015331/160325667-8b717c82-b501-4a55-b98b-d17fabcf5ac1.png)

This is the output for the ShowPasswordInputDialog block in **Classic** mode (left/top) and **Device Default** (right/bottom).

![image](https://user-images.githubusercontent.com/88015331/160325697-4a1da0a6-e0e5-4ded-90f8-c46ed8ff04ac.png) ![image](https://user-images.githubusercontent.com/88015331/160325702-5b82f4d8-59a3-41ed-9452-64c6d721c732.png)

**🔗 External links**

- https://community.appinventor.mit.edu/t/free-daffydialog-additional-features-for-the-notifier-component/54317?u=gordon_lu

- https://community.niotron.com/t/f-os-daffydialog-additional-tools-to-the-notifier-component/7975?u=gordon_lu

**+1: Acknowledgements**

My thanks to Salman for his Original Toast extension, which inspired me to make this extension.

https://community.appinventor.mit.edu/t/originaltoast-extension-free-open-source/19695
