# Fetch Project

**Fetch Project** is a coding challenge provided by Fetch to create an Android application that retrieves the data from https://fetch-hiring.s3.amazonaws.com/hiring.json, which also display this list of items to the user based on the following requirements:
* Display all the items grouped by "listId"
* Sort the results first by "id" then by "name" when displaying.
* Filter out any items where "name" is blank or null.
* The final result should be displayed to the user in an easy-to-read list.


<p align="center">
  <img src="https://i.imgur.com/92ENyUN.png" width="200" height="400" />
</p>

# Technical Concepts
  * MVVM Design
  * API call using: Retrofit, Gson, Corountines
  * UI Design: Jetpack Compose

FYI: https://fetch-hiring.s3.amazonaws.com/mobile.html

