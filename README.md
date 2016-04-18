# Happy Tourist Reykjavík


###How do I get this?
Your IDE ([Android studio](http://developer.android.com/sdk/index.html), [Eclipse](https://eclipse.org/)) should be able to clone a project from Github. It should be easy to find information regarding how to do that for your chosen IDE. It's also possible to download the project as a [.zip] (https://github.com/hraldur/HappyTourist/archive/master.zip)

###How do I run this?
This project is setup using [gradle](http://gradle.org/) as dependency manager. In this project it is required to use gradle 2.10 or higher. 
This project uses [Google API for android](https://developers.google.com/android/guides/api-client). You have to get your own [API key](https://console.developers.google.com/), enable for Google Places API for Android  and Google+ API. Then place your key into google_maps_api.xml under values.
When the dependencies are downloaded and API key installed, you can run the project ‘run/app’ on an android device or [android virtual device](http://developer.android.com/tools/devices/index.html) (AVD).

###Database Connection
We used [Firebase](https://www.firebase.com/), a cloud database that syncs to all connected clients in realtime, so you don't have to worry about setting that up. 


