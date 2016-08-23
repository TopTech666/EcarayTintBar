Android System Bar Tint

Apply background tinting to the Android system UI when using KitKat translucent modes.

screenshot

Android 4.4 (KitKat) introduced translucent system UI styling for status and navigation bars. These styles are great for wallpaper based activities like the home screen launcher, but the minimal background protection provided makes them less useful for other types of activity unless you supply your own backgrounds inside your layout. Determining the size, position and existence of the system UI for a given device configuration can be non-trivial.

This library offers a simple way to create a background "tint" for the system bars, be it a color value or Drawable. By default it will give you a semi-opaque black background that will be useful for full-bleed content screens where persistent system UI is still important - like when placed over a map or photo grid.

Usage

You must first enable translucency in your Activity - either by using or inheriting from one of the various *.TranslucentDecor themes, by setting the android:windowTranslucentNavigation or android:windowTranslucentStatus theme attributes to true or by applying the FLAG_TRANSLUCENT_NAVIGATION or FLAG_TRANSLUCENT_STATUS flags to your Activity window in code.

If translucency is not enabled or your app is running on a platform version earlier than API 19, the system UI will appear as normal. You should not enable tinting when using fullscreen or immersive window modes. You can safely use this library on Android versions back to API 10.

To enable the tint:

 @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              setContentView(R.layout.activity_base);
              TintHelper.initStatusBar(this,R.color.actionbar_color);
    }
To provide custom tint color values or drawables:

// set a custom tint color for all system bars
tintManager.setTintColor(Color.parseColor("#99000FF"));
// set a custom navigation bar resource
tintManager.setNavigationBarTintResource(R.drawable.my_tint);
// set a custom status bar drawable
tintManager.setStatusBarTintDrawable(MyDrawable);
SystemBarConfig

Developers should not need to concern themselves with the size or positioning of the system UI. Use android:fitsSystemWindows="true" in conjunction with android:clipToPadding="false" to achieve the optimal layout for full bleed content screens that need to be padded within the system UI bounds. However, certain elements like the GoogleMap provided by Google Play Services may force you to determine the pixel insets for the system bars in order to provide the appropriate layout effect.

Use the SystemBarConfig class provided by SystemBarTintManager to access those inset values:

SystemBarConfig config = tintManager.getConfig();
map.setPadding(0, config.getPixelInsetTop(), config.getPixelInsetRight(), config.getPixelInsetBottom());
Setup

Download and include the JAR in your project, or add the dependency in your build.gradle:

dependencies {
     compile 'com.github.goEcar:EcarayTintBar:1.0.0'
}
android:fitsSystemWindows="true"
sample：
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:android_custom="http://schemas.android.com/apk/res-auto"
    android:id="@+id/rlay_welcome"
    style="@android:style/Theme.NoTitleBar"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/white"
    android:fitsSystemWindows="true"
    android:orientation="vertical">
    
This repository also includes a sample app which you can download from Google Play:

 Android app on Google Play

Credits

Author: Jeff Gilfelt

Sample app uses Android-Color-Picker by chiralcode
