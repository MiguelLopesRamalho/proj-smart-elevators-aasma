# Autonomous Agents and Multi-Agent Systems
### Instituto Superior Técnico
Project from the course of Autonomous Agents and Multi-Agent Systems

## Introduction
We propose as our project, in the context of AAMAS, a system of smart elevators, where the elevators are the agents in a multi-agent system with focus on the communication between the agents to improve the efficiency of the system and some experience based learning. With the implementation of our project, we expect to achieve an improvement in reducing the wait time for the users of this system, since that in tall buildings, at some times of the day, the affluence of the elevators largely increases, and we believe we can mitigate this by teaching the elevators where is most efficient to be at each time of the day and by making the elevators efficiently communicate in order to send the one elevator that believes is going to make the route faster.

## Collaborators || Group 35
* Tiago Taveira, 77941, MEIC-T
* Vasco Pombo, 78029, MEIC-T --> [@vascopombo](https://github.com/vascopombo)
* Miguel Ramalho,	81948, MEIC-T --> [@MiguelLopesRamalho](https://github.com/MiguelLopesRamalho)

## Project Description
This a generic solution to the default problem described above. The number of agents may change depending on the size of the building, but for our demonstration we believe 4 elevators is a reasonable size to demonstrate how to deal with the problems. We also believe that choosing an even number might be good for our demonstration so we can train our elevators to deal with ”tie situations” and one of the elevators needs to assume the responsibility and handle the request. 

In our first design, we believe each elevator must be prepared to receive in the input a lot more information then the usual, where someone in a floor requests an elevator. We believe the elevator also needs to receive the desired destination and the amount of people its going to carry (not the exact amount but only if there are few people or many people). 

Thinking in the elevator as an agent, it should be able to save, gather information and communicate with the other agents the following: The state, which can be described just as ”waiting” and ”in movement” (the in movement state may be divided in two, as we might need to separate two different movement states: ”attending request” or ”busy”); The max capacity of each elevator; the number of requests attended and some informations about each request (high/low capacity, time of request, duration of the trip); estimated time to attend each request. The last aspect to take in mind, is the autonomy of each elevator and the ability to make decisions. 

These decisions can be separated in two kinds: ”Availability”, that gives the elevator the power to decide if he must attend a request, because he is the one who can reach there faster (for example) or to decide that he should refuse the request, because he is busy or he is aware there are other agents able to reach the destination faster. The next decision the agent must take is about his ”resting point” as he can learn where to be depending on the needs of the environment, regarding the time of the day and the position of the other agents.

