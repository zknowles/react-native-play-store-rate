# react-native-play-store-rate

This is a package for opening the Play Store to write a review for a given app.

## Getting started

```
$ npm install react-native-play-store-rate --save
```
or
```
$ yarn add react-native-play-store
```

### Installation

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNPlayStoreRatePackage;` to the imports at the top of the file
  - Add `new RNPlayStoreRatePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-play-store-rate'
  	project(':react-native-play-store-rate').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-play-store-rate/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-play-store-rate')
  	```


## Usage
```javascript
import { rateApp } from 'react-native-play-store-rate';

...

const id = "com.example";
rateApp(id);
```
  