# KyoskApp

# About
Language : Java

Architecture : MVVM
 Model — View — ViewModel (MVVM) is an industry-recognized software architecture pattern.
 MVVM suggests separating the data presentation logic(Views or UI) from the core business logic part of the application. 

The separate code layers of MVVM are:
1.Model: This layer is responsible for the abstraction of the data sources. Model and ViewModel work together to get and save the data.
2.View: The purpose of this layer is to inform the ViewModel about the user’s action. This layer observes the ViewModel and does not contain any kind of application logic.
3.ViewModel: It exposes those data streams which are relevant to the View. Moreover, it servers as a link between the Model and the View.

# Libraries
1.Retrofit
Retrofit is a type-safe REST client for Android, Java and Kotlin developed by Square. The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with OkHttp.

2.Glide
Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.

3.Android Room Database
The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite. Used for offline persistence.

4.Adndroid DataBinding Library
The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
