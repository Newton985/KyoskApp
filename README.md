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

# Project Structure
 Package - activities

 This Package Contains all views that are activities, If the Activity has fragments, there is a package for each fragment.
 The Fragment Packages contains the Fragment Java File and its View Model. Its the #View int the MVVM structure.

 The Fragment Java File is the one responsible for displaying data as well as triggering events.

   # View
   This is the Fragment/ Activity Java file, It represents a User Facing Interface. Each View is related to one or more XML layouts. The View is responsible for Triggering events, displaying data and updating displayed data via databinding.


   # ViewModel
   The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotation.

   In this Case , it gets Data from the Repository, and Stores it in MutableLiveData instances.
   The View Gets this MutableLiveData instances and 'observes' them for changes , Whenever there is a change in the instance , the 
   Event is triggered and the bindings responsible are updated in the View.
   Each View has at least One ViewModel.

   The ViewModel Passes data from the repository to the view, and has the logic to manipulate the data


Package - bindingadapter
  # Custom Binding Adapter
  This class is responsible for the Custom binding adapters. These are used to construct custom bindable attributes for views.


Package - Models
  # Models
  The package Contains The Entity Classes used in the app. It also represents an entity as it will be stored in the SQLite by room database

Package - repositories
 # Repositories

 The package has the Repository, which is the source of data for the ViewModel. It can get the data from room db , if available or fetch it from a network call via retrofit. 
 The data is stored in MutableLiveData instances which are Pased to the ViewModel and later to the View.

 It has the instances of the Service Classes (Details Below) and the Database Class (Also below) that are responsible for fetching data from network calls and SQLite respectively.

Package - Retrofit
 # Retrofit
 Has the Classes responsible for making network calls, and Retrofit Service Builder.
 The Service Builder returns an instance of the Service class passed to it.

 A servivce class in this case is an Interface that gives the skeleton fot the type of http verbs to use, which method to call when a particular type of data is requested anf the return type. The retun type id important for the Gson Converter to convert json to their respective Instance types (Models).

 # Services
 This contains the servivce interfaces mentioned above


# room
This package has Classes used to persist data into the room and SQLite implementation.
It has the Data Abstraction Objects and the Database Class


