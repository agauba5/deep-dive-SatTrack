## Sat Track
#### Background

**Sat Track**  allows for a user to search for and tack near earth objects. The Search methods  
include the ability to track an object by Name/ID or by the objects Parameters. The parameters  
that are utilized in this application provide the ability to search by 2 or more parameters. the  
parameters of the object are the Mean Velocity, Orbit Period, Apogee position, Perigee position,
Eccentricity of the orbit and Inclination of the object.

### Motivations for SatTrack
The App was created to provide an outlet for space enthusiasts. For people that are understanding 
and tracking satellites. My motivations for creating this app are deep rooted in my desire to 
understand more physics and mathematics. I have been interested in space since I was a child and 
as an adult that interest led me to studying Mechanical Engineering. In my degree program I took
an elective course called small spacecraft design and wanted to combine my new skillset in 
programing with my understanding of astrodynamics. The goal for the app is for a user to be able
search for, track and to updated notes on an object that they are tracking.  An extension of the 
is to use the users current position and the current position of the object to output to the angle
at which the user must place a telescope to view the object. 


### Current state of compleation

The current state of the application is not complete with some major improvements necessary before
a minimum viable release. The first that needs to be done to complete the application is the search
functionality. The application contains two search methods, one being a search that can will allow
the user to reduce the list of satellites by picking the country and object type. The standard 
search method is functioning correctly. The Second search method is to allow the user to search 
by specific parameters, the parameters that the user can search are the Speed, Orbit Period, 
Apogee position, Perigee position, Eccentricity of the orbit and Inclination of the object. The 
parameter search is not yet functional. The next step is to take the information that is searched
for and connect it to the satellite display fragment and in that fragment; pull the live Altitude,
Latitude, Longitude and Velocity of the selected satellite. The next step is to update note log 
and have the user be able to save notes on a specific satellite. The next step is to create a list
of favorite satellites and a list of tracked satellites. The next step is to install the database 
of satellites on install of the application.The final step would be to update and create a more 
aesthetic user interface.

### Devices and Emulators

The application has been tested on my Samsung galaxy S7 with API 24 and an emulator that is set to 
be on a Nexus 5x with an API of 22. I set the application to be fixed to be used in a vertical/portrait
position.

### User Interface

Updates to the user interface that would most improve the appeal of the application are:

*	Update background with an image of the earth rotating
*	Make the search buttons transparent
*	Reformat and align elements of the UI.

### Stretch Goals

*	Incorporate Google Maps API
*	Use latitude and longitude to display current satellite position
*	Use parameters to calculate path of satellite
*	Use parameters to calculate the angle from user to satellite
*	Output the angles to an external device
