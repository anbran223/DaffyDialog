package com.gordonlu.daffydialog;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Typeface;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.AttributeSet;

import com.google.appinventor.components.runtime.util.YailList;
import java.util.Arrays;
import android.view.inputmethod.InputMethodManager;

import java.util.List;
import java.lang.Object;
import java.util.ArrayList;
import android.widget.NumberPicker;
import android.text.method.HideReturnsTransformationMethod;

import android.text.method.PasswordTransformationMethod;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.PermissionResultHandler;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;

@DesignerComponent(
        version = 4,
        description = "A non-visible extension that provides additional tools to the built-in Notifier component.<br><br>Made by Gordon Lu (AICODE).",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "https://docs.google.com/drawings/d/e/2PACX-1vQCI87PHLBF0jb8QWyYmIRQSjjNW3EFXf-qpsWCvBYkUQ9vEgPAB8SpxcMpblxNpbIYrjCjLrRLIU2c/pub?w=16&h=16")

@SimpleObject(external = true)
//Libraries
@UsesLibraries(libraries = "")
//Permissions
@UsesPermissions(permissionNames = "")

public class DaffyDialog extends AndroidNonvisibleComponent {

    //Activity and Context
    private final Context context;
    private Activity activity;

    public DaffyDialog(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleFunction(description = "Shows a text input dialog. The id parameter is an ID to specify the notifier, in case you want to show two dialogs" + 
    " with the same extension. The title parameter is for specifying the title of this dialog. defaultText is the default text for the input" + 
    " in which the user will first see in the textbox when they open the dialog, and hint is the hint of that textbox." + 
    " Use inputBold, inputItalic, hintColor and inputColor to customize the textbpx, and use the property blocks to specify inputFont." + 
    " buttonText is the text of the OK button, while cancelButtonText is the text of the cancel button.") 
    public void ShowTextInputDialog(final int id, String title, String message, String defaultText, String hint, boolean inputBold, boolean inputItalic, String inputFont,
    int hintColor, int inputColor, String buttonText, String cancelButtonText, String iconPath, boolean cancelable, int inputType) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);
        final EditText edit = new EditText(this.context);
        Typeface t = Typeface.DEFAULT;
        String font = inputFont;
        if (font == "DEFAULT") {
            t = Typeface.DEFAULT;
        } else if (font == "SERIF") {
            t = Typeface.SERIF;
        } else if (font == "SANS SERIF") {
            t = Typeface.SANS_SERIF;
        } else if (font == "MONOSPACE") {
            t = Typeface.MONOSPACE;
        }
        boolean bold = inputBold;
        boolean italic = inputItalic;
        if (bold && italic) {
            edit.setTypeface(t, Typeface.BOLD_ITALIC);
        } else if (bold && !italic) {
            edit.setTypeface(t, Typeface.BOLD);
        } else if (italic && !bold) {
            edit.setTypeface(t, Typeface.ITALIC);
        } else {
            edit.setTypeface(t, Typeface.NORMAL);
        }
        edit.setText(defaultText);
        edit.setHintTextColor(hintColor);
        edit.setTextColor(inputColor);
        edit.setHint(hint);
        builder.setIcon(icon(iconPath));
        edit.setInputType(inputType);
        builder.setView(edit);
        builder.setPositiveButton(buttonText, new DialogInterface.OnClickListener() { 
        @Override
        public void onClick(DialogInterface dialog, int which) {
        GotTextInputDialog(id, edit.getText().toString());
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edit.getWindowToken(), 0);
        }
    });
        if (cancelable) {
        builder.setNegativeButton(cancelButtonText, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        TextInputDialogCanceled(id);
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }
});
        }
        builder.show();
}
    @SimpleFunction(description = "Shows a custom message dialog.")
    public void CustomMessageDialog(final int id, String title, String message, String iconPath, String buttonText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setIcon(icon(iconPath));
        builder.setPositiveButton(buttonText, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        CustomMessageDialogClosed(id);
        }
        });
        builder.show();
    }
    @SimpleEvent(description = "This event is fired when the user has pressed the button in a custom message dialog.")
    public void CustomMessageDialogClosed(int id) {
        EventDispatcher.dispatchEvent(this, "CustomMessageDialogClosed", id);
    }
    @SimpleProperty(description = "A font block.")
    public String DefaultFont() {
        return "DEFAULT";
    }
    @SimpleProperty(description = "A font block.")
    public String Serif() {
        return "SERIF";
    }
    @SimpleProperty(description = "A font block.")
    public String SansSerif() {
        return "SANS SERIF";
    }
    @SimpleProperty(description = "A font block.")
    public String Monospace() {
        return "MONOSPACE";
    }
    @SimpleEvent(description = "This event is fired when the user has pressed the OK button in a text input dialog.")
    public void GotTextInputDialog(int id, String input) {
        EventDispatcher.dispatchEvent(this, "GotTextInputDialog", id, input);
    }
    @SimpleEvent(description = "This event is fired when the user has pressed the cancel button in a text input dialog.")
    public void TextInputDialogCanceled(int id) {
        EventDispatcher.dispatchEvent(this, "TextInputDialogCanceled", id);
    }
    @SimpleEvent(description = "This event is fired when the user has pressed the OK button in a number picker dialog.")
    public void GotNumberPickerDialog(int id, int number) {
        EventDispatcher.dispatchEvent(this, "GotNumberPickerDialog", id, number);
    }
    @SimpleEvent(description = "This event is fired when the user has pressed the cancel button in a number picker dialog.")
    public void NumberPickerDialogCanceled(int id) {
        EventDispatcher.dispatchEvent(this, "NumberPickerDialogCanceled", id);
    }
    @SimpleFunction(description = "Displays a number picker dialog that enables the user to select a number from a predefined range.")
    public void ShowNumberPickerDialog(final int id, String title, String iconPath, String buttonText, String cancelButtonText, String message, int minValue, int maxValue,
    boolean cancelable) {
        final NumberPicker numberPicker = new NumberPicker(this.context);
        numberPicker.setMaxValue(maxValue);
        numberPicker.setMinValue(minValue);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setView(numberPicker);    
        builder.setCancelable(false);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(icon(iconPath));
        builder.setPositiveButton(buttonText, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        GotNumberPickerDialog(id, numberPicker.getValue());
        }
        });
        if (cancelable) {
        builder.setNegativeButton(cancelButtonText, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        NumberPickerDialogCanceled(id);
        }
    });
        }
        builder.show();
}
    @SimpleFunction(description = "Displays an image in a dialog. This requires an absolute path pointing to the image location." + 
    " All supported file types are PNG, JPEG and JPG. After the user has pressed the button, the extension will fire the ImageDialogClosed event.")
    public void ShowImageDialog(final int id, String title, String message, String imagePath, String buttonText, String iconPath) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setCancelable(false);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(icon(iconPath));
        final ImageView image = new ImageView(this.context);
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        image.setImageBitmap(bitmap);
        builder.setView(image);
        builder.setPositiveButton(buttonText, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        ImageDialogClosed(id);
        }
        });
        builder.show();
    }
    @SimpleEvent(description = "This event is fired when the user has pressed the button in an image dialog.")
    public void ImageDialogClosed(int id) {
        EventDispatcher.dispatchEvent(this, "ImageDialogClosed", id);
    }
    @SimpleFunction(description = "Shows a custom choose dialog. The id parameter is an ID to specify the notifier, in case you want to show two dialogs"
    + " with the same extension. The title and message parameter are for specifying the title and message of this dialog respectively. " + 
    " When the user has tapped button1 or button2 in this dialog, the extension fires the GotCustomChooseDialog event. " + 
    "If it is canceled, the extension will call the CustomChooseDialogCanceled event.") 
    public void CustomChooseDialog(final int id, String message, String title, String iconPath, final String button1Text, final String button2Text, String cancelButtonText, 
    boolean cancelable) {
        final int ABC = id;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setIcon(icon(iconPath));
        builder.setPositiveButton(button1Text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                GotCustomChooseDialog(ABC, button1Text);
            }
        });
        builder.setNeutralButton(button2Text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                GotCustomChooseDialog(ABC, button2Text);
            }
        });
        if (cancelable) {
            builder.setNegativeButton(cancelButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                CustomChooseDialogCanceled(ABC);
            }
        });
        }
        builder.show();
    }
    @SimpleEvent(description = "This event is fired when the user has pressed button1 or button2 in a custom choose dialog.")
    public void GotCustomChooseDialog(int id, String choice) {
        EventDispatcher.dispatchEvent(this, "GotCustomChooseDialog", id, choice);
    }
    @SimpleEvent(description = "This event is fired when the user has pressed the cancel button in a custom choose dialog.")
    public void CustomChooseDialogCanceled(int id) {
        EventDispatcher.dispatchEvent(this, "CustomChooseDialogCanceled");
    }
    @SimpleEvent(description = "This event is fired when the user has entered a password in a password input dialog.")
    public void GotPasswordInputDialog(int id, String password) {
        EventDispatcher.dispatchEvent(this, "GotPasswordInputDialog", id, password);
    }
    @SimpleEvent(description = "This event is fired when the user has pressed the cancel button in a password input dialog.")
    public void PasswordInputDialogCanceled(int id) {
        EventDispatcher.dispatchEvent(this, "PasswordInputDialogCanceled", id);
    }
    @SimpleFunction(description = "Shows a password input dialog. The id parameter is an ID to specify the notifier, in case you want to show two dialogs" + 
    " with the same extension. The title parameter is for specifying the title of this dialog. defaultText is the default text for the input" + 
    " in which the user will first see in the textbox when they open the dialog, and hint is the hint of that textbox." + 
    " Use inputBold, inputItalic, hintColor and inputColor to customize the textbpx, and use the property blocks to specify inputFont." + 
    " buttonText is the text of the OK button, while cancelButtonText is the text of the cancel button.") 
    public void ShowPasswordInputDialog(final int id, String title, String message, String defaultText, String hint, boolean inputBold, boolean inputItalic, String inputFont,
    int hintColor, int inputColor, String buttonText, String cancelButtonText, String iconPath, boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(icon(iconPath));
        builder.setCancelable(false);
        final EditText edit = new EditText(this.context);
        Typeface t = Typeface.DEFAULT;
        String font = inputFont;
        if (font == "DEFAULT") {
            t = Typeface.DEFAULT;
        } else if (font == "SERIF") {
            t = Typeface.SERIF;
        } else if (font == "SANS SERIF") {
            t = Typeface.SANS_SERIF;
        } else if (font == "MONOSPACE") {
            t = Typeface.MONOSPACE;
        }
        boolean bold = inputBold;
        boolean italic = inputItalic;
        if (bold && italic) {
            edit.setTypeface(t, Typeface.BOLD_ITALIC);
        } else if (bold && !italic) {
            edit.setTypeface(t, Typeface.BOLD);
        } else if (italic && !bold) {
            edit.setTypeface(t, Typeface.ITALIC);
        } else {
            edit.setTypeface(t, Typeface.NORMAL);
        }
        edit.setText(defaultText);
        edit.setHintTextColor(hintColor);
        edit.setTextColor(inputColor);
        edit.setHint(hint);
        edit.setTransformationMethod(new PasswordTransformationMethod());
        builder.setView(edit);
        builder.setPositiveButton(buttonText, new DialogInterface.OnClickListener() { 
        @Override
        public void onClick(DialogInterface dialog, int which) {
        GotPasswordInputDialog(id, edit.getText().toString());
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edit.getWindowToken(), 0);
        }
    });
        if (cancelable) {
        builder.setNegativeButton(cancelButtonText, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        PasswordInputDialogCanceled(id);
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edit.getWindowToken(), 0);
    }
});
        }
        builder.show();
    }
    public Drawable icon(String path) {
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        Drawable d = new BitmapDrawable(context.getResources(), bitmap);
        return d;
    }
}
