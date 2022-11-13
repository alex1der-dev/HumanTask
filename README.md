# HumanTask 
### Task: Create a console application predicting the result of the relationship of two instances of Human class 
#### Description:
There are two genders of Human: Female and Male. They have the same set of characteristics with a few
exceptions and methods.
Let the following set of properties be defined:
- gender trait (boolean, true - male, false - female)
- name (String)
- last name (String)
- height (float)
- weight (float)
And there is a common set of methods that take an instance of a Human as an argument:
- speak (returns a boolean)
- tolerate/have company (returns boolean)
- spend time together (returns boolean)
- have a relationship (returns new instatnce of Human)
Female has an additional method - "give a birth" (returns an instance of a Human)
You need to write a console application where you first need to enter property values, for two instances of 
of people (Female(F) and Male(M) in random order, possible variants F&M, M&F, F&F and M&M).
Then the program has to do a compatibility test and give a prediction on the result of the relationship between the two given instances. 
The algorithm is as follows:
1. The "compatibility test" method accepts two instances of Human and should return an instance of a person or null.
2. Call the "have a relationship" method of the first instance of the person with the argument being the second instance.
3. The result of calling the "compatibility test" method should returned as a new instance of Human.
For Human, methods have the following implementation:
- "talk" (returns boolean).
The result is determined by the table, where the first column is the gender of the caller and the second column is the gender of the parameter: 

| Caller | Parameter | Result | 
| --- | --- | --- |
| Female | Female | always **true** | 
| Female | Male | always **true** | 
| Male | Female | always **true** | 
| Male | Male | **true** with probability 50% | 

- "tolerate/have society" (returns boolean)

| Caller | Parameter | Result | 
| --- | --- | --- |
| Female | Female | **true** with probability 5% | 
| Female | Male | **true** with probability 70% | 
| Male | Female | **true** with probability 70% | 
| Male | Male | **true** with probability 5.6% | 

- spend time together (returns boolean) 

*if the height of the instances differs by more than 10%, the method returns true with probability 85%*.  
*if the height of the instances differs by less than 10%, the method returns true with probability 95%*
- have a relationship (returns Human)
*if "talk" && "tolerate/have company" && "spend time together" is true and the "gender" properties of the caller and parameter are the same, then 
return null. Otherwise create an instance of a Human by calling the method "give a birth" from an instance with gender Female.

Female, as mentioned above, has an additional method "give a birth". 
It has the following implementation:
Create a new Female or Male instance with probability 50% with the following properties:
- name (String) - enter from the console
- last name (String) - taken from the Male instance
- height (float) - copied from the same gender + 0.1*(height of an instance of the opposite gender minus
height of the the same gender)
- weight (float) - similarly to the height
The result should be to displayed on the console: all properties of the new Human instance or "it didn't work out... got away" if null is returned. 

It is desirable results of calling methods of Female and Male class instances to be accompanied with messages on console.
