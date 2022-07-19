package com.mahesh_prajapati.rxjavaexamples.utils

class DummyData {

    val listNum = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13)

    fun getLocation()= "Latitude: 28.6139,Longitude: 77.2090"

    val userList = mutableListOf<User>(
    User(1,"Sachin",32),
    User(2,"Ramesh",34),
    User(3,"Mohan",22),
    User(4,"Rakesh",14),
    User(5,"Rashmi",28),
    User(6,"Somya",30),
    User(7,"Pankaj",36),
    User(8,"Preeti",28),
    User(9,"Vivek",36),
    User(10,"Seema",31),
    User(11,"Sweta",25))

    val userListForGroupByOperator = mutableListOf<User>(
        User(1,"Sachin",32),
        User(2,"Ramesh",34),
        User(3,"Mohan",22),
        User(4,"Rakesh",14),
        User(5,"Rashmi",32),
        User(6,"Somya",30),
        User(7,"Pankaj",32),
        User(8,"Preeti",34),
        User(9,"Vivek",22),
        User(10,"Seema",30),
        User(11,"Sweta",32))

    val userProfileList = mutableListOf<UserProfile>(
        UserProfile(1,"Sachin",32,"https//example/rxjava/image1"),
        UserProfile(2,"Ramesh",34,"https//example/rxjava/image2"),
        UserProfile(3,"Mohan",22,"https//example/rxjava/image3"),
        UserProfile(4,"Rakesh",14,"https//example/rxjava/image4"),
        UserProfile(5,"Rashmi",28,"https//example/rxjava/image5"),
        UserProfile(6,"Somya",30,"https//example/rxjava/image6"),
        UserProfile(7,"Pankaj",36,"https//example/rxjava/image7"),
        UserProfile(8,"Preeti",28,"https//example/rxjava/image8"),
        UserProfile(9,"Vivek",36,"https//example/rxjava/image9"),
        UserProfile(10,"Seema",31,"https//example/rxjava/image10"),
        UserProfile(11,"Sweta",25,"https//example/rxjava/image11"))

    val blogList = mutableListOf<Blog>(
        Blog(1,1,"Title 1","Content 1"),
        Blog(2,2,"Title 2","Content 2"),
        Blog(3,1,"Title 3","Content 3"),
        Blog(4,4,"Title 4","Content 4"),
        Blog(5,4,"Title 5","Content 5"),
        Blog(6,6,"Title 6","Content 6"),
        Blog(7,2,"Title 7","Content 7")
        )

}