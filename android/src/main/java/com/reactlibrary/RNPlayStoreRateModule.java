
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.net.Uri;
import android.content.Intent;

public class RNPlayStoreRateModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNPlayStoreRateModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod
  public void rateApp(final String id) {
      Uri uri = Uri.parse("market://details?id=" + id);
      Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
      // To count with Play market backstack, After pressing back button, 
      // to taken back to our application, we need to add following flags to intent. 
      goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                      Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                      Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
      try {
          startActivity(goToMarket);
      } catch (ActivityNotFoundException e) {
          startActivity(new Intent(Intent.ACTION_VIEW,
                  Uri.parse("http://play.google.com/store/apps/details?id=" + id)));
      }
  }

  @Override
  public String getName() {
    return "RNPlayStoreRate";
  }
}