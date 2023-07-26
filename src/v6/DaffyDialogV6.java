package com.gordonlu.daffydialog;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
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
import android.view.WindowManager.LayoutParams;

import com.google.appinventor.components.runtime.util.YailList;
import java.util.Arrays;
import android.view.inputmethod.InputMethodManager;

import android.widget.ProgressBar;
import android.graphics.PorterDuff;
import android.R.attr;
import android.os.Build;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;

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
import com.google.appinventor.components.common.PropertyTypeConstants;

import android.text.Html;
import android.text.Spanned;

import android.os.Build;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.FileOutputStream;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import java.io.File;

import android.graphics.Canvas;
import android.graphics.drawable.PictureDrawable;
import java.io.InputStream;
import java.net.URL;

import android.webkit.URLUtil;
import java.lang.Exception;
import android.view.Window;

@DesignerComponent(
        version = 6,
        description = "A non-visible extension that provides additional tools to the built-in Notifier component.",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "images/notifier.png")

@SimpleObject(external = true)
//Libraries
@UsesLibraries(libraries = "")
//Permissions
@UsesPermissions(permissionNames = "")

public class DaffyDialog extends AndroidNonvisibleComponent {

  //Activity and Context
  private final Context context;
  private Activity activity;
  boolean html = false;
  boolean light = false;
  float dimAmount = 0.5f;
  boolean fullscreen = false;
  int selection = 0;
  boolean classic = false;
  AlertDialog dialog = null;
  ProgressBar bar = null;
  AlertDialog customDialog = null;
  View v = null;

  public DaffyDialog(ComponentContainer container){
      super(container.$form());
      this.activity = container.$context();
      this.context = container.$context();
  }

    @SimpleProperty(description = "This property specifies whether the dialog should be fullscreen displayed or not.")
    public boolean Fullscreen() {
        return fullscreen;
    }
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN, defaultValue = "false")
    @SimpleProperty (description = "This property specifies whether the dialog should be fullscreen displayed or not.")
    public void Fullscreen(boolean e) {
        fullscreen = e;
    }
    @SimpleFunction(description = "Show whatever you want in a dialog. You can use as example arrangements, or images or whatever you want." + 
    " Your chosen layout will be then removed from the screen and only visible in custom dialog. Please make sure the layout you want to use is visible.")
    public void CreateCustomDialog(AndroidViewComponent component) {
        View view = component.getView();
        v = view;
        ((ViewGroup) view.getParent()).removeView(view);
    }
    @SimpleFunction(description = "Shows the custom dialog that you have created.")
    public void ShowCustomDialog() {
        int number = 0;
        if (classic) {
            number = 16974374;
        } else {
            if (!light) {
                if (fullscreen) {
                    number = 16974122;
                } else {
                    number = 16974545;
                }
            } else {
                if (fullscreen) {
                    number = 16974125;
                } else {
                    number = 16974546;
                }
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context, number);
        View newView = v;
        builder.setView(newView);
        customDialog = builder.create();
        Window window = customDialog.getWindow();
        if(window != null){
            window.addFlags(2);
            window.setDimAmount(dimAmount);
        }
        customDialog.show();
    }
    @SimpleFunction (description = "Dismisses the custom progress dialog.")
    public void DismissCustomDialog(){
        if (customDialog == null){
            Error("The custom dialog has not been created yet.", "DismissCustomDialog");
        } else {
            customDialog.dismiss();
            CustomDialogDismissed();
        }
    }
    @SimpleEvent(description = "This event is called when the custom dialog has been dismissed.")
    public void CustomDialogDismissed() {
        EventDispatcher.dispatchEvent(this, "CustomDialogDismissed");
    }
    
    @SimpleProperty(description = "Set the amount of dim behind the dialog window. Use '0.0' for no dim and '1.0' for full dim.")
    public float DimAmount() {
        return dimAmount;
    }
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_FLOAT, defaultValue = "0.5")
    @SimpleProperty (description = "Set the amount of dim behind the dialog window. Use '0.0' for no dim and '1.0' for full dim.")
    public void DimAmount(float e) {
        dimAmount = e;
    }
    @SimpleFunction(description = "Shows a progress dialog with a horizontal progress bar. Can be dismissed by user if 'cancelable' is set to true." + 
    " If indeterminate is true, maxValue and the 'UpdateProgress' method will have no effect.")
    public void ShowLinearProgressDialog(String title, String message, String iconPath, boolean useIcon, boolean indeterminate, int maxValue, int color,
    boolean cancelable, String cancelButtonText) {
        bar = new ProgressBar(activity, null, android.R.attr.progressBarStyleHorizontal);
        bar.setIndeterminate(indeterminate);
        bar.setPadding(20, 20, 20, 20);
        if (indeterminate) {
            bar.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        } else {
            bar.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
            bar.setMax(maxValue);
        }
        int number = 0;
        if (classic) {
            number = 16974374;
        } else {
            if (!light) {
                if (fullscreen) {
                    number = 16974122;
                } else {
                    number = 16974545;
                }
            } else {
                if (fullscreen) {
                    number = 16974125;
                } else {
                    number = 16974546;
                }
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context, number);
        if (html) {
            builder.setTitle(getHtml(title));
        } else {
            builder.setTitle(title);
        }
        if (html) {
            builder.setMessage(getHtml(message));
        } else {
            builder.setMessage(message);
        }
        builder.setCancelable(false);
        if (useIcon) {
            builder.setIcon(icon(iconPath));
        }
        builder.setView(bar);
        String butText = cancelButtonText;
        if (html) {
            butText = getHtml(butText).toString();
        }
        if (cancelable) {
            builder.setPositiveButton(butText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LinearProgressDismissed();
            }
        });
      }
        dialog = builder.create();
        Window window = dialog.getWindow();
        if(window != null){
            window.addFlags(2);
            window.setDimAmount(dimAmount);
        }
        dialog.show();
    }

    @SimpleFunction (description = "Dismisses the linear progress dialog.")
    public void DismissLinearProgressDialog(){
        if (dialog == null){
            Error("The linear progress dialog has not been created yet.", "DismissLinearProgressDialog");
        } else {
            dialog.dismiss();
            LinearProgressDismissed();
        }
    }
    @SimpleEvent(description = "This event is called when the linear progress dialog has been dismissed.")
    public void LinearProgressDismissed() {
        EventDispatcher.dispatchEvent(this, "LinearProgressDismissed");
    }

    @SimpleFunction(description = "Sets the current progress of the linear progress dialog to the specified value. Does not do anything if the progress bar is in indeterminate mode.")
    public final void UpdateProgress(int progress) {
        if (dialog == null){
            Error("The linear progress dialog has not been created yet.", "DismissLinearProgressDialog");
        } else {
            if (Build.VERSION.SDK_INT >= 24) {
                bar.setProgress(progress, true);
            } else {
                bar.setProgress(progress);
            }
        }
    }
  @SimpleFunction(description = "Shows a text input dialog. The id parameter is an ID to specify the notifier, in case you want to show two dialogs" + 
  " with the same extension. The title parameter is for specifying the title of this dialog. defaultText is the default text for the input" + 
  " in which the user will first see in the textbox when they open the dialog, and hint is the hint of that textbox." + 
  " Use inputBold, inputItalic, hintColor and inputColor to customize the textbpx, and use the property blocks to specify inputFont." + 
  " buttonText is the text of the OK button, while cancelButtonText is the text of the cancel button.") 
  public void ShowTextInputDialog(final int id, String title, String message, String defaultText, String hint, boolean inputBold, boolean inputItalic, String inputFont,
  int hintColor, int inputColor, String buttonText, String cancelButtonText, String iconPath, boolean useIcon, boolean cancelable, int inputType) {
    int number = 0;
        if (classic) {
            number = 16974374;
        } else {
            if (!light) {
                if (fullscreen) {
                    number = 16974122;
                } else {
                    number = 16974545;
                }
            } else {
                if (fullscreen) {
                    number = 16974125;
                } else {
                    number = 16974546;
                }
            }
        }
      AlertDialog.Builder builder = new AlertDialog.Builder(this.context, number);
        if (html) {
            builder.setTitle(getHtml(title));
        } else {
            builder.setTitle(title);
        }
      if (html) {
          builder.setMessage(getHtml(message));
      } else {
          builder.setMessage(message);
      }
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
      if (useIcon) {
          builder.setIcon(icon(iconPath));
      }
      edit.setInputType(inputType);
      builder.setView(edit);
        String but1Text = buttonText;
        if (html) {
            but1Text = getHtml(but1Text).toString();
        }
        String but2Text = cancelButtonText;
        if (html) {
            but2Text = getHtml(but2Text).toString();
        }
      builder.setPositiveButton(but1Text, new DialogInterface.OnClickListener() { 
      @Override
      public void onClick(DialogInterface dialog, int which) {
      GotTextInputDialog(id, edit.getText().toString());
      InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(edit.getWindowToken(), 0);
      }
  });
      if (cancelable) {
      builder.setNegativeButton(but2Text, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
      TextInputDialogCanceled(id);
      InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(edit.getWindowToken(), 0);
  }
});
      }
        AlertDialog log = builder.create();
        Window window = log.getWindow();
        if(window != null){
            window.addFlags(2);
            window.setDimAmount(dimAmount);
        }
        log.show();
}
  @SimpleProperty(description = "This property specifies whether HTML format" + 
  " should be enabled for the titles, messages and button texts of all dialogs.")
  public boolean HTMLFormat() {
      return html;
  }
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN, defaultValue = "false")
  @SimpleProperty (description = "This property specifies whether HTML format should be enabled for the titles, messages and button texts of all dialogs.")
  public void HTMLFormat(boolean HTML) {
      html = HTML;
  }
  @SimpleProperty(description = "This property specifies whether light theme should be enabled for the dialogs.")
  public boolean LightTheme() {
      return light;
  }
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN, defaultValue = "false")
  @SimpleProperty (description = "This property specifies whether light theme should be enabled for the dialogs.")
  public void LightTheme(boolean LIGHT) {
      light = LIGHT;
  }
  @SimpleFunction(description = "Shows a custom message dialog.")
  public void CustomMessageDialog(final int id, String title, String message, String iconPath, boolean useIcon, String buttonText) {
    int number = 0;
        if (classic) {
            number = 16974374;
        } else {
            if (!light) {
                if (fullscreen) {
                    number = 16974122;
                } else {
                    number = 16974545;
                }
            } else {
                if (fullscreen) {
                    number = 16974125;
                } else {
                    number = 16974546;
                }
            }
        }
      AlertDialog.Builder builder = new AlertDialog.Builder(this.context, number);
        if (html) {
            builder.setTitle(getHtml(title));
        } else {
            builder.setTitle(title);
        }
      builder.setCancelable(false);
      if (html) {
          builder.setMessage(getHtml(message));
      } else {
          builder.setMessage(message);
      }
      if (useIcon) {
        if (isUrl(iconPath)) {
            try {
                InputStream is = (InputStream) new URL(iconPath).getContent();
                Drawable d = Drawable.createFromStream(is, null);
                builder.setIcon(d);
            } catch (Exception e) {
                Error(e.getMessage(), "CustomMessageDialog");
            }
        } else {
            builder.setIcon(icon(iconPath));
        }
      }
        String butText = buttonText;
        if (html) {
            butText = getHtml(butText).toString();
        }
      builder.setPositiveButton(butText, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
      CustomMessageDialogClosed(id);
      }
      });
        AlertDialog log = builder.create();
        Window window = log.getWindow();
        if(window != null){
            window.addFlags(2);
            window.setDimAmount(dimAmount);
        }
        log.show();
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
  public void ShowNumberPickerDialog(final int id, String title, String iconPath, boolean useIcon, String buttonText, String cancelButtonText, String message, int minValue, int maxValue,
  boolean cancelable) {
    int number = 0;
        if (classic) {
            number = 16974374;
        } else {
            if (!light) {
                if (fullscreen) {
                    number = 16974122;
                } else {
                    number = 16974545;
                }
            } else {
                if (fullscreen) {
                    number = 16974125;
                } else {
                    number = 16974546;
                }
            }
        }
      final NumberPicker numberPicker = new NumberPicker(this.context);
      numberPicker.setMaxValue(maxValue);
      numberPicker.setMinValue(minValue);
      AlertDialog.Builder builder = new AlertDialog.Builder(this.context, number);
      builder.setView(numberPicker);    
      builder.setCancelable(false);
        if (html) {
            builder.setTitle(getHtml(title));
        } else {
            builder.setTitle(title);
        }
      if (html) {
          builder.setMessage(getHtml(message));
      } else {
          builder.setMessage(message);
      }
      if (useIcon) {
          builder.setIcon(icon(iconPath));
      }
        String butText = buttonText;
        if (html) {
            butText = getHtml(butText).toString();
        }
        String but2Text = cancelButtonText;
        if (html) {
            but2Text = getHtml(but2Text).toString();
        }
      builder.setPositiveButton(butText, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
      GotNumberPickerDialog(id, numberPicker.getValue());
      }
      });
      if (cancelable) {
      builder.setNegativeButton(but2Text, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
      NumberPickerDialogCanceled(id);
      }
  });
      }
        AlertDialog log = builder.create();
        Window window = log.getWindow();
        if(window != null){
            window.addFlags(2);
            window.setDimAmount(dimAmount);
        }
        log.show();
}
  @SimpleFunction(description = "Displays an image in a dialog. This requires an absolute path pointing to the image location." + 
  " All supported file types are PNG, JPEG and JPG. After the user has pressed the button, the extension will fire the ImageDialogClosed event.")
  public void ShowImageDialog(final int id, String title, String message, String imagePath, String buttonText, String iconPath, boolean useIcon) {
    int number = 0;
        if (classic) {
            number = 16974374;
        } else {
            if (!light) {
                if (fullscreen) {
                    number = 16974122;
                } else {
                    number = 16974545;
                }
            } else {
                if (fullscreen) {
                    number = 16974125;
                } else {
                    number = 16974546;
                }
            }
        }
      AlertDialog.Builder builder = new AlertDialog.Builder(this.context, number);
      builder.setCancelable(false);
        if (html) {
            builder.setTitle(getHtml(title));
        } else {
            builder.setTitle(title);
        }
      if (html) {
          builder.setMessage(getHtml(message));
      } else {
          builder.setMessage(message);
      }
      if (useIcon) {
          builder.setIcon(icon(iconPath));
      }
      final ImageView image = new ImageView(this.context);
      Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
      image.setImageBitmap(bitmap);
      builder.setView(image);
        String butText = buttonText;
        if (html) {
            butText = getHtml(butText).toString();
        }
      builder.setPositiveButton(butText, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
      ImageDialogClosed(id);
      }
      });
        AlertDialog log = builder.create();
        Window window = log.getWindow();
        if(window != null){
            window.addFlags(2);
            window.setDimAmount(dimAmount);
        }
        log.show();
  }
  @SimpleEvent(description = "This event is fired when the user has pressed the button in an image dialog.")
  public void ImageDialogClosed(int id) {
      EventDispatcher.dispatchEvent(this, "ImageDialogClosed", id);
  }
  @SimpleFunction(description = "Shows a custom choose dialog. The id parameter is an ID to specify the notifier, in case you want to show two dialogs"
  + " with the same extension. The title and message parameter are for specifying the title and message of this dialog respectively. " + 
  " When the user has tapped button1 or button2 in this dialog, the extension fires the GotCustomChooseDialog event. " + 
  "If it is canceled, the extension will call the CustomChooseDialogCanceled event.") 
  public void CustomChooseDialog(final int id, String message, String title, String iconPath, boolean useIcon, final String button1Text, final String button2Text, String cancelButtonText, 
  boolean cancelable) {
    int number = 0;
        if (classic) {
            number = 16974374;
        } else {
            if (!light) {
                if (fullscreen) {
                    number = 16974122;
                } else {
                    number = 16974545;
                }
            } else {
                if (fullscreen) {
                    number = 16974125;
                } else {
                    number = 16974546;
                }
            }
        }
      final int ABC = id;
      AlertDialog.Builder builder = new AlertDialog.Builder(this.context, number);
        if (html) {
            builder.setTitle(getHtml(title));
        } else {
            builder.setTitle(title);
        }
      builder.setCancelable(false);
      if (html) {
          builder.setMessage(getHtml(message));
      } else {
          builder.setMessage(message);
      }
      if (useIcon) {
          builder.setIcon(icon(iconPath));
      }
        String but1Text = button1Text;
        if (html) {
            but1Text = getHtml(but1Text).toString();
        }
        String but2Text = button2Text;
        if (html) {
            but2Text = getHtml(but2Text).toString();
        }
        String but3Text = cancelButtonText;
        if (html) {
            but3Text = getHtml(but3Text).toString();
        }
      builder.setPositiveButton(but1Text, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int id) {
              GotCustomChooseDialog(ABC, button1Text);
          }
      });
      builder.setNeutralButton(but2Text, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int id) {
              GotCustomChooseDialog(ABC, button2Text);
          }
      });
      if (cancelable) {
          builder.setNegativeButton(but3Text, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int id) {
              CustomChooseDialogCanceled(ABC);
          }
      });
      }
        AlertDialog log = builder.create();
        Window window = log.getWindow();
        if(window != null){
            window.addFlags(2);
            window.setDimAmount(dimAmount);
        }
        log.show();
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
  int hintColor, int inputColor, String buttonText, String cancelButtonText, String iconPath, boolean useIcon, boolean cancelable) {
    int number = 0;
        if (classic) {
            number = 16974374;
        } else {
            if (!light) {
                if (fullscreen) {
                    number = 16974122;
                } else {
                    number = 16974545;
                }
            } else {
                if (fullscreen) {
                    number = 16974125;
                } else {
                    number = 16974546;
                }
            }
        }
      AlertDialog.Builder builder = new AlertDialog.Builder(this.context, number);
        if (html) {
            builder.setTitle(getHtml(title));
        } else {
            builder.setTitle(title);
        }
      if (html) {
          builder.setMessage(getHtml(message));
      } else {
          builder.setMessage(message);
      }
      if (useIcon) {
          builder.setIcon(icon(iconPath));
      }
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
        String but1Text = buttonText;
        if (html) {
            but1Text = getHtml(but1Text).toString();
        }
      builder.setPositiveButton(but1Text, new DialogInterface.OnClickListener() { 
      @Override
      public void onClick(DialogInterface dialog, int which) {
      GotPasswordInputDialog(id, edit.getText().toString());
      InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(edit.getWindowToken(), 0);
      }
  });
        String but2Text = cancelButtonText;
        if (html) {
            but2Text = getHtml(but2Text).toString();
        }
      if (cancelable) {
      builder.setNegativeButton(but2Text, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
      PasswordInputDialogCanceled(id);
      InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(edit.getWindowToken(), 0);
  }
});
      }
        AlertDialog log = builder.create();
        Window window = log.getWindow();
        if(window != null){
            window.addFlags(2);
            window.setDimAmount(dimAmount);
        }
        log.show();
  }
  public Drawable icon(String path) {
      Bitmap bitmap = BitmapFactory.decodeFile(path);
      Drawable d = new BitmapDrawable(context.getResources(), bitmap);
      return d;
  }
  public Spanned getHtml(String src) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      return Html.fromHtml(src, Html.FROM_HTML_MODE_COMPACT);
  } else { 
      return Html.fromHtml(src);
  }
  }

  @SimpleEvent(description = "This event is fired when an error has occurred with the given block of this extension.")
  public void Error(String error, String block){
    EventDispatcher.dispatchEvent(this, "Error", error, block);
  }

  public Bitmap drawableToBitmap(PictureDrawable pd) {
    Bitmap bm = Bitmap.createBitmap(pd.getIntrinsicWidth(), pd.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bm);
    canvas.drawPicture(pd.getPicture());
    return bm;
}

  public boolean isUrl(String url) {
    return URLUtil.isValidUrl(url);
  }
}
