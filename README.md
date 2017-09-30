
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 09/15/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Arraylist for storing results. O(1) time complexity for insertion and O(N) for reading as we are reading 1 by 1 
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

1) Iterating over arraylist to check if course is already present:
https://stackoverflow.com/questions/8284936/java-see-if-arraylist-contains-string?rq=1

2) Get all keys from HashMap:
https://stackoverflow.com/questions/10462819/get-keys-from-hashmap-in-java

3) Motivation to use LinkedHashMap over HashMap and it's implementation:
https://stackoverflow.com/questions/10710193/how-to-preserve-insertion-order-in-hashmap
http://docs.oracle.com/javase/6/docs/api/java/util/LinkedHashMap.html