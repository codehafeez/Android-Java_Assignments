C:\Users\hafeez\AndroidStudioProjects\cropImage\app\build.gradle

    implementation 'com.github.yalantis:ucrop:2.2.6'
    implementation 'com.github.yalantis:ucrop:2.2.6-native'



C:\Users\hafeez\AndroidStudioProjects\cropImage\app\proguard-rules.pro

-dontwarn com.yalantis.ucrop**
-keep class com.yalantis.ucrop** { *; }
-keep interface com.yalantis.ucrop** { *; }



C:\Users\hafeez\AndroidStudioProjects\cropImage\settings.gradle


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        // Add by Hafeez
        jcenter()
        maven { url "https://jitpack.io" }
    }
}


Manifest

    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

        <activity
            android:name="com.yalantis.ucrop.UCropActivity"
            android:screenOrientation="portrait"
            android:theme="@style/Theme.AppCompat.Light.NoActionBar"
            tools:ignore="MissingClass" />
