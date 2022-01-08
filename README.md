# SimplDo
An app to keep track of your Todo list

### Problem statement:
We find it challenging to keep focused on our tasks and complete our work efficiently when we are distracted by social media and other conveniently accessible online diversions. And while technology makes it easy to waste our time, it also gives us access to tools that can boost our productivity. 

### Proposed solution:
This project basically keeps a list of all your tasks in one place. It has a very simple and intuitive UI. The features include adding, checking, updating and removing your To-do list items. It uses View Model to store data and Shared Preferences to persist the data across sessions. 

![image](https://user-images.githubusercontent.com/45452035/148634168-6f1d3fb1-0078-4eba-993d-dbf3e1834c8d.png)
![image](https://user-images.githubusercontent.com/45452035/148634175-083d08f4-af2d-44c8-b4c4-90e8f3563ace.png)
![image](https://user-images.githubusercontent.com/45452035/148634178-35936631-07fc-4ebc-aeec-79e9c06f94ff.png)

### Functionality & Concepts used:
- The app has a simple interface that helps us to work with the To-do list
- Constraint Layout: The majority of the app's activities employ a flexible constraint layout that is simple to handle across various screen sizes.
- Recycler View: This is used to show all the user's pending todo. On tapping each item, it's content can be updated. 
- Jetpack Navigation: Two fragments are switched out in the main activity using this library. It handles all the navigation and passes arguments.
- Shared Preferences: This is used to store the list across sessions, so that the data is not lost when the app is closed. The todo list is converted into a Json string for storage and retrieval.

### Application link & Future scope:
GitHub repo link: https://github.com/Crazzygamerr/SimplDo
APK link: https://github.com/Crazzygamerr/SimplDo/blob/main/SimplDo.apk

While still in it's infancy, the app stays true to it's name for being straightforward and simple to use. Keeping this in mind, its future scope will include some useful features like multiple lists, deadlines, and notifications. Integrations to other platforms is also quite important as it will dramatically increase the ease of use.
