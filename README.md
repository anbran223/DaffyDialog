# DaffyDialog
An App Inventor non-visible extension that provides additional tools to the built-in Notifier component. It has:

- features for Show Text Input Dialog and Show Number Picker Dialog in Kodular's Notifier.

- features for Custom Choose Dialog in Kodular's Notifier.

- input password dialog!

:package: **Package name:** com.brandonang.daffydialog 

**:clock8: Version:** 6

:date: **Release date:** 4:52PM (UST)

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
>**CustomMessageDialogClosed**
>
>![image](https://user-images.githubusercontent.com/88015331/160748544-9a161bfe-feda-4399-8918-1b515234021c.png)
>
>This event is fired when the user has pressed the dismiss button in a custom message dialog.
>
>*Parameters:* id = number (int)

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
>**ImageDialogClosed**
>
>![image](https://user-images.githubusercontent.com/88015331/160748595-d23faef3-419f-409d-8920-afb9973cd1b1.png)
>
>This event is fired when the user has pressed the dismiss button in an image dialog.
>
>*Parameters:* id = number (int)

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
>![image](https://user-images.githubusercontent.com/88015331/160747821-9c59fead-2a60-443d-8ba8-bf73fb8d33a1.png)
> 
> Shows a custom choose dialog. The id parameter is an ID to specify the notifier, in case you want to show two dialogs with the same extension. The title and message parameter are for specifying the title and message of this dialog respectively. When the user has tapped button1 or button2 in this dialog, the extension fires the GotCustomChooseDialog event. If it is canceled, the extension will call the CustomChooseDialogCanceled event.
> 
> *Parameters:* id = number (int), message = text, title = text, iconPath = text, useIcon = boolean, button1Text = text, button2Text = text, cancelButtonText = text, cancelable = boolean

>
>**CustomMessageDialog**
>
>![image](https://user-images.githubusercontent.com/88015331/160748100-38e56516-3bc6-492d-a9c9-59015efbc116.png)
>
>Displays a custom message dialog.
>
>*Parameters:* id = number (int), title = text, message = text, iconPath = text, useIcon = boolean, buttonText = text

>
>**ShowImageDialog**
>
>![image](https://user-images.githubusercontent.com/88015331/160748136-6d6812f9-dfb2-4801-b4ed-6309de08d8d8.png)
>
>Displays an image in a dialog. This requires an absolute path pointing to the image location. All supported file types are PNG, JPEG and JPG. After the user has pressed the button, the extension will fire the ImageDialogClosed event.
>
>*Parameters:* id = number (int), title = text, message = text, imagePath = text, buttonText = text, iconPath = text, useIcon = boolean

>
>**ShowNumberPickerDialog**
>
>![image](https://user-images.githubusercontent.com/88015331/160748157-410e026e-4e6a-4c9e-bfc9-191e39abda2b.png)
>
>Displays a number picker dialog that enables the user to select a number from a predefined range.
>
>*Parameters:* id = number (int), title = text, iconPath = text, useIcon = boolean, buttonText = text, cancelButtonText = text, message = text, minValue = number (int), maxValue = number (int), cancelable = boolean

>
> **ShowPasswordInputDialog**
> 
>![image](https://user-images.githubusercontent.com/88015331/160748220-d8453893-97ab-430e-a73e-c321e69e7c7a.png)
> 
> Shows a password input dialog. The id parameter is an ID to specify the notifier, in case you want to show two dialogs with the same extension. The title parameter is for specifying the title of this dialog. defaultText is the default text for the input in which the user will first see in the textbox when they open the dialog, and hint is the hint of that textbox. Use inputBold, inputItalic, hintColor and inputColor to customize the textbpx, and use the property blocks to specify inputFont. buttonText is the text of the OK button, while cancelButtonText is the text of the cancel button.
> 
> *Parameters:* id = number (int), title = text, defaultText = text, hint = text, inputBold = boolean, inputItalic = boolean, inputFont = text, hintColor = color, inputColor = color, buttonText = text, cancelButtonText = text, iconPath = text, useIcon = boolean, cancelable = boolean


>
>**ShowTextInputDialog**
>
>![image](https://user-images.githubusercontent.com/88015331/160748297-25870db9-fd0c-4a5e-b9bd-d619e7c356a8.png)
>
>Shows a text input dialog. The id parameter is an ID to specify the notifier, in case you want to show two dialogs with the same extension. The title parameter is for specifying the title of this dialog. defaultText is the default text for the input in which the user will first see in the textbox when they open the dialog, and hint is the hint of that textbox. Use inputBold, inputItalic, hintColor and inputColor to customize the textbpx, and use the property blocks to specify inputFont. buttonText is the text of the OK button, while cancelButtonText is the text of the cancel button.
>
>*Parameters:* id = number (int), title = text, defaultText = text, hint = text, inputBold = boolean, inputItalic = boolean, inputFont = text, hintColor = color, inputColor = color, buttonText = text, cancelButtonText = text, cancelable = boolean, inputType = number, iconPath = text, useIcon = boolean
(boolean)

For what to fill in in the inputType parameter, here are some examples.

1. plain old normal text - 1.

2. number - 2.

3. phone number - 3.

4. date/time - 4.

5. email address - 32.

For more, see the Android Developers documentation.

https://developer.android.com/reference/android/text/InputType

***Property blocks***

>
>**HtmlMessage** (read, write, designer, blocks)
>
>![image](https://user-images.githubusercontent.com/88015331/160748713-debdc293-5b86-4503-a82c-2986e09f4629.png)
>
>![image](https://user-images.githubusercontent.com/88015331/160748717-f6ab912c-2cf5-4744-8c55-dc7f2ddde1c6.png)
>
>![image](https://user-images.githubusercontent.com/88015331/160748733-ae8a7859-ce17-4a2a-a692-08158afdca80.png)
>
>This property specifies whether HTML format should be enabled for the messages of all dialogs in this extension.
>
>*Requires:* boolean

Plus, 4 property blocks for fonts.

![image](https://user-images.githubusercontent.com/88015331/160325578-12701dff-19f2-4d59-aa73-339eaeb8fc99.png)

**🔗 External links**

- https://community.appinventor.mit.edu/t/free-daffydialog-additional-features-for-the-notifier-component/54317?u=gordon_lu

- https://community.niotron.com/t/f-os-daffydialog-additional-tools-to-the-notifier-component/7975?u=gordon_lu

**:+1: Acknowledgements**

My thanks to Salman for his Original Toast extension, which inspired me to make this extension.

https://community.appinventor.mit.edu/t/originaltoast-extension-free-open-source/19695

Credits to Gordon Lu's DaffyDialog 
(If Gordon Lu is reading this i just want to make the v6 to release advance so i decided to create my own AIX)
