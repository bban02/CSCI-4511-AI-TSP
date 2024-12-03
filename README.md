Artificial Intelligence Final
 Project
 Brady Bannick
 12.13.2023
 Introduction to Artificial Intelligence
 Abstract
 In this report, I have solved the traveling salesperson problem using a genetic
 algorithm and a simple neighbor algorithm. I discuss some related work and how
 it helped me design my experiment. My experiment involves comparing the
 runtimes and the optimality of the found solutions. I have also tested how each
 variable in the genetic algorithm affects the result. My results show that using a
 genetic algorithm results in a much more optimal solution than the simple
 neighbor algorithm. They also show that increasing the population size, number
 of generations, and mutation rate yields a more optimal solution.
 Introduction
 In this project, I will be attempting to solve the traveling salesperson problem
 using a genetic algorithm and a closest neighbor algorithm. The traveling
 salesperson problem is a problem that has puzzled computer scientists for years
 due to its exponential complexity. This problem consists of several cities that the
 salesperson would like to visit. The goal is to find the shortest path from a starting
 city to all other cities and back. For a short road trip, this might sound like an easy
 task, but as you increase the number of cities this problem gets extremely
 challenging. This is because the number of iterations needed to try every path
 grows exponentially. Luckily some algorithms can reduce the number of
 iterations needed by using previously learned information. This is the reason I am
 using a genetic algorithm to solve this problem. I will also be testing a neighboring
 algorithm that is mostly just to compare the optimality of the solution. Since I will
 be using a genetic algorithm to solve this problem it is important to understand
 what genetic algorithms are. Genetic algorithms are informed searches that select
 the best states best on a fitness variable. The algorithm starts by randomly
creating p individuals also known as the population. Then a certain number of
 individuals with the highest fitness value will become the parents for the next
 generation of individuals. Two parents with a high fitness level are then combined
 to make anewchild and amutation is applied. These steps repeat until specified
 by the number of generations. Now that we have gone through some of the
 background information needed to understand the project we shall move on to
 some of the more technical parts of the project.
 Genetic Algorithms
 Genetic algorithms are often used as a problem-solving method for problems
 muchlike our Traveling Salesperson Problem. These genetic algorithms are based
 on real genetics [1]. They are not exactly the same, but some of the main ideas like
 population size, mutations, and having children that are similar to their parents
 come from the idea of genetics. In each generation, a fitness value is applied to
 every individual, and this is what is compared to see which individuals will
 become parents [1]. This idea is also much like real-life genetics. Genetic
 algorithms use this fitness value much like the idea of survival of the fittest. The
 individuals with higher fitness values tend to survive longer and can repopulate.
 After many generations, the traits from these fit individuals will move on and
 become essentials to the individual’s ancestors in order to “survive”. This strategy
 works very well and commonly increases the fitness of later generations [1].
 Genetic algorithms have many different variables that can be changed to
 create an algorithm that best fits your problem. Population size is the number of
 individuals that are in a single generation. Increasing population size will also
 increase how long it will take to find a result, and decreasing it will increase the
 likelihood of every individual becoming the same [2]. The generation variable
 allows you to change how many times crossovers occur [2] or in other words the
 number of times that a population is produced. The mutation rate variable
 changes the chance that a child will undergo a mutation [2]. Not all children will
 undergo a mutation because then some of the best-fit individuals could get
 weeded out. The last variable that can be changed is the tournament size variable.
 Tournament size is the number of individuals that get picked from the population
 that have a chance to become a parent. Out of these individuals, the individual
 with the best fit becomes one of the parents. Then this process repeats one more
 time to find the other parent. Increasing this variable will yield a higher chance of
 finding the fittest individual and choosing that individual as a parent [2].
 However, it decreases the amount of variety because that same parent might keep
 getting chosen. You’d think that you always want the best fit as a parent, but this
 isn’t always the case. In some cases, there might be an individual that is better fit
 in the beginning, but as more cities are added it gets worse, and vice versa [2].
 1
TSP Solved With Genetic Algorithms
 Genetic algorithms work well when trying to solve the Traveling Salesperson
 problem because of how flexible it is [2]. This means that it is very easy to adjust a
 genetic algorithm to fit your problem’s needs. An important part of applying a
 genetic algorithm to the Traveling Salesperson Problem is how the algorithm does
 mutations and how the children are born. In the code that I used, a swap mutation
 was used to create mutants, and the crossover method was used to create child
 routes [3]. These are really important parts of the problem, because, for example,
 some other types of mutations may add or delete cities, but we do not want that
 [3]. Crossover is just an important aspect of genetic algorithms that is used to
 create new generations. Crossover is a technique used to create a child [3]. To do
 this it combines the two parents randomly to create the child [3]. It starts by
 taking a random number of cities from the first parent and creates the child with
 those cities in the exact same spots [3]. Next, it will fill in the rest of the cities with
 the other parent’s cities in order and not including the cities that have already
 been added by the other parent [3]. After the child is created a swap mutation
 occurs. In our case the swap mutation picks two random cities in the tour, not
 including the starting city, and swaps them in the tour [3]. This then creates a new
 mutant tour that is different from the original.
 Prediction
 After the background information that I have gathered, I predict that the genetic
 algorithm will find a substantially better average total distance for the tours.
 However, I think the runtime will be something to look into because I’m not sure
 howthat will be affected by the algorithm itself. For each variable, I think that
 increasing all of them will be beneficial for the solution, but I think that there will
 be acertain extent to which I can increase them. I think that increasing the
 number of generations, population size, and tournament size will increase the
 runtime substantially while the mutation rate won’t affect it quite as much. I am
 not sure what will be a good number for the mutation rate because we don’t want
 every child to get mutated because we need some of the individuals to stay the
 same. I also am not sure how much I can increase the tournament size because
 article [2] states that increasing it too much can cause less diversity in the system.
 I guess that a good tournament size will be about 25 percent of the population.
 2
Approach
 Whentrying to find an algorithm to solve the traveling salesperson problem most
 people’s mind probably goes right to the brute force method. This means that you
 try every possible path to all cities and pick the path with the shortest total
 distance. If you tried to find every single possible path and then find the shortest
 path then the number of iterations is (number of cities- 1)! and we divide that by
 two to get the number of possible routes. If you only have a couple of cities this
 isn’t too bad, but as you increase the number of cities this becomes nearly
 impossible to do this way. The table below shows the number of iterations needed
 whenthere are n cities.
 Numberof Cities
 3
 4
 5
 Formula
 (3-1)!
 (4-1)!
 (5-1)!
 Numberof iterations
 needed
 2
 6
 24
 6
 8
 10
 12
 15
 20
 (6-1)!
 (8-1)!
 (10-1)!
 (12-1)!
 (15-1)!
 (20-1)!
 120
 5040
 362,880
 39,916,800
 87,178,291,200
 60,822,550,204,420,000
 Clearly trying to solve the problem this way is extremely impractical unless you
 have eight or fewer cities. If the brute force method wasn’t so expensive it would
 be the best method to solve this problem because it will always find the optimal
 solution, but this is not the case. The closest neighbor algorithm is a step down
 from the brute force method in regards to optimality, but it is super inexpensive.
 It is nearly impossible for this method to find the optimal solution when there are
 a lot of cities in the problem, but it often finds a pretty reasonable path. This
 algorithm works by starting at the start city and then it simply picks the city
 closest to it as the next city in the path. Then it repeats the process from that city,
 and until all cities have been visited once. I will be using this algorithm to show
 howabasic strategy compares to a genetic algorithm. I will also be changing some
 of the values that affect the genetic algorithm. For example, I will compare how
 3
changing the population, tournament size, mutation rate and number of
 generations affects how optimal the final solution is and the runtimes.
 Experiment Design
 Myexperiment consists of two different algorithms, a closest neighbor algorithm,
 and agenetic algorithm. For both algorithms, I used [4] which is a publicly
 available example of a genetic algorithm used for Traveling Salesperson
 Problems. I used this code but also made some tweaks to better fit how I wanted
 myexperiment to work. The code consists of 6 classes that include: City,
 TourManager, Tour, Population, GA, and TSP_GA. The City class is the basic class
 to create City objects. A City has a latitude and longitude coordinate, and a name.
 City also contains a distanceTo method which I had to tweak to work with
 Euclidean coordinates instead of regular cartesian coordinates that are in latitude
 and longitude. To do this I used the Haversine conversion algorithm that finds the
 distance between two Euclidean coordinates. The TourManager class simply adds
 cities to an array which is known as a tour. Now Tour uses TourManager to create
 a Tour. Tour has multiple methods inside of it that allow it to shuffle the tour, and
 find the total distance of the tour. Next, the Population class creates an array of
 tours also known as a population. These are all of the tours that are in the same
 generation. The GA class is where most of the genetic algorithm part takes place.
 GAtakes in a population and starts by creating a tournament of the indicated size.
 This randomly picks tournament-size tours and then the fittest of that group
 becomes parent 1. This means that the total distance is the lowest. Then parent 2
 is created using the same process. Next, a child is created using the crossover
 method. After that, the child is mutated. I had to change this part of the code so
 that when the child is being mutated the swap mutation never occurs to the
 starting location. Finally the TSP_GA class is like our main class. It creates 20 total
 cities across the United States and adds them all to a tour using the TourManager
 class. A population is then created and creates population size random tours. Next,
 a loop is created which uses the GA class to evolve the population over the
 specified number of generations. Finally, after the specified number of
 generations, the best tour and its distance will be printed out. I also created a
 closest-neighbor algorithm that uses the City class. I started by creating an array
 of 20 cities. Then I find the distance from the starting city to every other city by
 using the distanceTo method once again. The closest city to the starting city then
 gets compared to the remaining cities. This is all done in two nested loops. Finally,
 the total distance of the tour and the tour itself are printed out. Both of these
 algorithms’ starting cities are my hometown, Albertville, Minnesota. For all of my
 tests, I used the same 20 cities that include: Albertville, MN; Underwood, MN; St.
 Cloud, MN; Oak Creek, WI; Wisconsin Dells, WI; Louisville, KY; Indianapolis, IN;
 Nashville, TN; Durham, NC; Philadelphia, PA; Buffalo, NY; Detroit, MI; Kansas City,
 4
MO; Denver, CO; Phoenix, AZ; Las Vegas, NV; San Diego, CA; Portland, OR; Austin,
 TX; Orlando, FL.
 Now, using these classes I will run an experiment. I will start by running
 the closest neighbor algorithm 1 time because the answer will always be the same.
 I will create a table displaying my results which will include the distance of the
 solution, the tour itself, and the runtime. Next, I will run the genetic algorithm 20
 times with the following values: Population, 50; Generations, 100; MutationRate,
 .015; TournamentSize, 5. I will then create a table just like the closest neighbor
 algorithm with a couple of tweaks to better display the data. Next, I will change
 each specific variable and compare how they affect the solution. Finally, I will
 change all of the variables and see how good of a solution I can find.
 Experiment Results
 5
6
Analysis
 After many tests, I have come to a few conclusions. First of all, when comparing
 the genetic algorithm with some low-quality input values with the closest
 neighbor algorithm the genetic algorithm is still significantly better. On average
 the genetic algorithm was able to find a total distance 800 miles shorter than the
 closest neighbor algorithm with low-quality input values. The run time was also
 very similar for the two algorithms. When comparing the closest neighbor
 algorithm with the genetic algorithm using much more favorable input values the
 results are even more shocking. On average the genetic algorithm was able to find
 a total distance 1700 miles shorter this time. The best values that I found for the
 genetic algorithm were: population, 1000; generations, 2500; mutation rate, 0.04;
 tournament size, 5. With these values, I technically got a higher average total
 distance found than with some much larger values, but the difference is so
 minuscule that it is not worth the six times longer runtime.
 Nowlooking at how some of the individual variables affected the average
 total distance found and the run time. I started by first increasing the mutation
 rate from 0.015 to 0.035 to see how that would affect the results. Doing this
 decreased the total distance found on average by around 260 miles. This fits with
 myprediction. I also found that 0.04 for the mutation rate was the sweet spot for
 the variable. Increasing or decreasing the variable from 0.04 would increase the
 total distance found. The runtime was also hardly affected by changing the
 mutation rate variable. Next, I changed the population size from 50 to 200. This
 madethe average total distance found to decrease by approximately 450 miles
 which is quite a substantial amount considering we only increased the population
 by 150. I expected the total distance to decrease, but this much was shocking to
 me. What’s also surprising is that it never even found the best possible route.
 Quadrupling the population doubled the run time of the algorithm which was
 expected. Then I increased the number of generations from 100 to 500. This
 caused the total distance found to decrease by about 260 which is very similar to
 the results from changing the mutation rate. As I expected though the total
 distance found decreased and the runtime nearly tripled. Finally, I tested the
 tournament size which yielded some interesting results. I predicted that
 increasing the tournament size would decrease the total distance found to an
 extent. This held for my first tests where all the other values were low, but as I
 increased all of the other values it started to increase the total distance found even
 whenit was only 10 percent of the population. When running my experiments I
 was puzzled because I increased all of the values and I felt like I should be getting
 better results, so I started playing around with all of the variables individually
 again. That is how I concluded that increasing the tournament size too much was
 hurting my results. I then also went back and tried decreasing the tournament
 7
size and only had it set at 10, but those both also hurt the results. Thus 5 seems to
 be the perfect tournament size.
 CONCLUSION
 In Conclusion, using a genetic algorithm to solve the Traveling Salesman Problem
 is a great idea. When compared to other methods of solving the problem like the
 brute force method and the closest neighbor algorithm it performs much better.
 The brute force method will always find the most optimal solution, but it is
 impractical to use in large problems. The closest neighbor algorithm produced a
 decent result, but when compared to the genetic algorithm with even inefficient
 values it underperforms. The results also showed how each of the variables
 affects the average total distance found. Increasing the number of generations,
 increasing the population size, and increasing the mutation rate all produced a
 lower average distance, but increasing them had their trade-offs. Increasing
 population size and the number of generations both drastically increase the run
 time while increasing the mutation rate and tournament size too much causes the
 average distance found to decrease. The best values that I found for the variables
 are 1000 for population size, 2500 for number of generations, 0.04 for mutation
 rate, and 5 for tournament size. I can only say how these variables and this
 algorithm will work for a route that consists of 20 or fewer cities. If there were
 more cities these values could cause the run time to be drastically higher. After
 these extensive tests, I can conclude that this genetic algorithm works extremely
 well when trying to solve the Traveling Salesman Problem.
 REFERENCES
 [1] Forrest, Stephanie. "Genetic algorithms." ACM computing surveys (CSUR) 28.1
 (1996): 77-80.
 [2] Geetha, Ramani R., Nishaa Bouvanasilan, and Vasumathy Seenuvasan. "A
 perspective view on Travelling Salesman Problem using genetic algorithm."
 2009 World Congress on Nature & Biologically Inspired Computing (NaBIC).
 IEEE, 2009.
 [3] Jacobson, Lee. “Applying a Genetic Algorithm to the Traveling Salesman
 Problem.” The Project Spot,
 www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-trav
 elling-salesman-problem/5. Accessed 12 Dec. 2023.
 8
