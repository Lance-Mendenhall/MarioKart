# MarioKart
I was playing MarioKart 8 awhile back. A random course was selected, and it was a course we had done perhaps 20 minutes ago.
I didn't like that. There are 48 courses. Why were we doing one we had just done? So, I wrote a program that simulates course
selection in MarioKart. 

It is heavily weighted towards providing courses that have not been done in awhile. The random course is always the course that 
is at the end of the course array, which means it hasn't been selected in the longest time. Any course that is selected is not
even an option within the next 5 course selections. 

I like my algorithm betther than Nintendo's. 

I then modified the program to simulate a race. Each racer is given a skill level, and the results are sorted by how they 
finished in the race. 

This was a fun little project. 
