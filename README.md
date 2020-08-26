Root work sample README

- com.website.compare
  - NumberComparator.java
    - Learning how to use the .sort() method in Java took a lot of work since there are so many different ways that you can write it. I originally planned to have it all on one line since the method seemed easy enough. However, I eventually learned I was dead wrong and that in order to use .compare() or .compareTo() in Java you need to wrap it in it's respective wrapper class. I was also happy that I had used BigDecimal in a previous mini-capstone since the results of comparisons are either -1, 1, or 0 which I was familiar with. Once I had this working it dawned on me that you could make a few simple changes to the code to sort by any data that you would like (well at least the way I have it written you can only compare names, hours traveled, and miles traveled). However, I would have to re-write some of the tests which is not really too big of a change.
  - NumberComparatorTests.java
    - .sort() was probably one of the last big change I made to this kata before submission and one of the only things I regretted was not making a method that created either trips or drivers instead of having all of the hard-coded values in each test.
- com.website.driver
  - Driver.java
    - When I first started hacking away at this kata, I had both trips and drivers as separate java objects. This caused me some problems and headache when I eventually got to the point of reducing the trips. When reducing them it became immediately apparent that just nesting the objects within each other would make my life a lot easier. This was the first major refactoring I undertook on this kata and it made the rest of it a lot easier.
  - DriverDao.java
  - DriverService.java
    - getDrivers()
      - towards the end of the kata when I was thinking about different fringe cases, I realized that a user would potentially forget to add a name so I added the length check on the array. Additionally, it wasn't specified in the prompt how we were supposed to deal with duplicate data. So I decided for now to ignore duplicate names with the below method hasDubplicateDriver().
  - DriverTests.java
- com.website.helpers
  - HelperServices.java
    - reduceTrips()
      - after refactoring from two to one java object, this method became a lot easier to work with and this is just a standard loop and add method now. If I were to make any more changes to this, I would first move around the arguments to: if .size() == 0, 1, 2+. Next, I would remove the no longer necessary arraylist that was passed into the function from memory to optimize the program.
    - sortDriversBasedOnMiles()
      - this method originally was a confusing sorting algorithm until I figured out how to use the .sort() method. I spent a lot of time trying to get it to work on one line of code. However, I needed to use wrapper classes to compare them with the method. This ultimately made me create a new package for the sole purpose of comparing miles which helps with readability.
  - HelperServicesDao.java
  - HelperServicesTests.java
- com.website.report
  - ReportService.java
    - Nothing too special about this function. Just had to make sure that there was a check for a trip's size to avoid null pointer exceptions. Well I guess there was one thing that I did that was different for this. That being the fact that I left all values as doubles until I went to print them where I just used Math.round(). I did this to get the most accurate data possible and not truncate data early making the data not as accurate. I guess that really does not matter too much for this kata.
  - ReportServiceDao.java
- com.website.root\_work\_sample.java
  - app.java
- com.website.trip
  - Trip.java
    - When I first approached this problem, I made the trip object with a start and end time and stored the values as times. However, I figured why not just store the value that I'm going to be calculating anyways when I verify whether the trip will be discarded or not. So that is exactly what I ended up doing.
   - TripDao.java
   - TripService.java
     - setTrips()
       - There used to be an additional tripBuilder() method I had written. However, this became problematic towards the end of the kata when I needed to handle the fringe cases. The tripBuilder() was building trips of null because of the way I had it written when the mph was over 100 or less than 5 which was causing problems when trying to print the results since you cannot print null. So I had to move the check for the mph as well as the trip building functionality back into the setTrips() method. I had not used localtime before, so it was fun learning how to use it even at a basic level and just knowing it exists helps.

Post-thoughts

I originally wanted to write this with TDD, but I had too much fun hacking away at the problem that this ended up not happening. I really enjoyed this kata and the journey it took me on from learning localdate in java to how to program at a production level. I've provided my raw thoughts I had when coding that I took down below. They are not professional, but I figured it would be useful to see some of my thoughts during this exercise.

Since the code will take an input file, I want to prompt the user to indicate which file they want to use to avoid to make this application re-usable. There are two possible commands which are indicated with the first word of each line so I will create two objects for each type and handle that data in their respective ways. I think the best way to handle this will be to register the user and then search the rest of the file for the any instance of that user and then process the data from there. Those are my first thoughts just looking at the prompt. I want to do this problem as TDD so hopefully there will be lots of commits and I will be aiming for 100% test coverage.

First problem, getting the file.

So I kinda didn't stick with TDD. I was just having too much fun coding it haha...

Anyways I've got the data reading and processing correctly, I'm just now running into problems where I need to reduce the objects into one value but when looping through it I'm having trouble adding the correct objects to the ArrayList I'm using to calculate the MPH. I definitely wasn't expecting the reduction to be the hardest part of this code sample.

Once I have the code working the way I want it to I'm going to go back and refactor along with lots of tests.

After waking up the next day, I've been trying to reduce the Trip object without abstracting them to each of their respective drivers which is probably causing all my problems... I'm going to put the Trip in the Driver object to see if that makes anything easier, because it should allow me to iterate through the trips without fear of adding duplicates of something I've already sorted through.

After brute forcing my way through the sorting method I've finished solving it. Now I've started refactoring by breaking down the long methods into smaller ones to allow for easier testing and easier readability. I think I'm going to need to create a few more packages and rename some stuff to make it easier to read.

I feel that I could optimize the speed of my sorting/reading algorithms perhaps though... Not sure how, but I think that would be the final step I think.

I'm glad that I wrote some tests for mostly everything. During testing I found that my code wouldn't sort something with an ArrayLength of only two drivers.

Now, let's explain why I did everything before I forget...

com.website.driver

\*Driver.java --

When I started hacking out this kata I initially started by only taking the name out of the &quot;Driver Dan&quot; line for example. This caused problems for me when I had to reduce the trips down to just one in order to ultimately sort them by miles. I figured it would be easier to skip the name validation for the trips and immediately create all the trips for the registered user when constructing the object.

\*DriverDao.java --

\*HelperServicesDao.java

\*TripDao.java

I chose to create service classes and Dao's in order to abstract away some of the functionality of the getDriver's method for example (used to be like 40 lines now is around 20). This allowed me to test the methods separately and much MUCH easier.

\*DriverService.java --

Almost just psuodo-coded the only method in this class haha... It does what it does and I had to abstract away some of the functionality to make the code easier to read and test. I used to have almost identical code for first getting the registered drivers and then the trips for said drivers. But in the spirit of the lazy programmer/never duplicating code/making the objects easier to work with, I ended up nesting an ArrayList in the driver object. I've really been wanting to do this for awhile and almost ended up doing it for our final-capstone, but it proved to be really difficult with complex JSON objects. BUT, I'm really glad I got to use nested objects for this kata since it is something I haven't really done much of or only seen in example code during classes. After thinking through some more fringe-cases that would break the program I realized with the provided prompt for this program there was no way to properly identify drivers with only a first name. Because of this I had to write a method to check whether or not the name being parsed through is in the Drivers arraylist.

\*DriverTests.java --

I found that testing this wasn't as hard as I though it was going to be. I thought it would be easy to check the size of the ArrayList after processing some data. This is how I actually ended up testing my code for the rest of the kata.

\*HelperServices.java -- reduceTrips() -- This was the biggest challenge I had during this kata. This is because I ended up having to refactor both the driver and trip objects since I was having too much difficulty working with two separate objects and comparing too much stuff in if statements. Once I nested the objects in each other it made reducing the values so much easier.

\*HelperServices.java -- sortDriversBasedOnMiles() -- This method wasn't really too hard, but since I just brute forced this problem instead of thinking about what I was doing, I probably spent most of my time on this one method (this README is getting pretty long though haha...). I really wanted to use the .sort method, but it was proving to be a little too difficult and time consuming to learn how to use. So I just ended up looking up a sorting algorithm online and adapting it to work with the object I ended up feeding to it. This is also where my if statements were getting a little bit long and hard to read so I ended up creating the getMiles() method to make the code more readable for myself. This however was later changed since I figured out how to use the .sort method properly and I've since deleted the getMiles() method.

\*HelperServicesTests.java -- As I mentioned above, I'm really glad that I was able to find a bug in my code when testing. For the sort\_places\_driver\_with\_most\_miles\_at\_top() test, I only added two objects to the drivers. In my code, the for loop in sortDriversBasedOnMiles() previously included if(sortList.get(j).size()){break;} I think it was... I'm really regretting not commiting all my progress to GitHub right about now... Anyways, it was breaking the loop prematurely which meant it wasn't sorting anything. I thought I was writing a bad test, but yeah my code was the problem so I was able to fix it.

\*ReportServices.java --