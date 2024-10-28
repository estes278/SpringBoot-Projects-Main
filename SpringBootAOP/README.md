In this project, I demonstrated the concept of Aspect Oriented Programming (AOP) through the use of various Advisors. The first was BeforeAdvice, which will run before a target method. The target of this advice is determined by a Pointcut expression, which is to be written above the method header inside an @Before annotation. We can match on return type, method name, a specific method of a specific class, etc. The access modifier (public, etc) of the match expression is optional, but the return type is not - it must match the return type we are searching for or the pointcut expression will not pick it up. We can also use wildcard * to match on anything, including return type or method name. 

Next, we controlled the order in which our Aspects would be called using the @Order annotation. Lower numbers in @Order(1) have higher precedence (would be higher than @Order(2). 

Additionally, we used JoinPoints in combination with beforeAdvice to print the signature and parameters of methods that were being called. JoinPoints have meta data about method calls.

We also applied this tactic to return the results of a method call using @AfterReturning, which allowed us to not only see the signature and parameters of the method call, but the return result as well. Additionally, we “post processed” the return value of the method using @AfterReturning to modify the value of the data returned by the method call. This should be used with caution because it can cause erratic results if not wielded carefully. 

We achieved similar results with @AfterThrowing, where we intentionally caused an exception and triggered this advice (which only executes upon an exception being thrown). And, “finally” (but not quite), we used the simple @After annotation, which executes upon method completion regardless of success/failure/exceptions being thrown, which is certainly most useful for logging but has other applications as well. 

Lastly, we implemented @Around advice, which executes both before and after a method is called. This works like a combination of @Before and @After, but it gives more fine grain control over how to handle it. We also used Around to catch an exception and prevent it from going back to the main application, which could be useful in preventing crashes or lockups. We also “re-threw” the exception after we caught it, which is another use case scenario (in case we want the main app to know about it!).


